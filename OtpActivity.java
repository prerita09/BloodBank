package com.example.adi18.blood;

import android.arch.core.executor.TaskExecutor;
import android.content.Intent;
import android.icu.util.Freezable;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {

    private String verificationid;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

    mAuth=FirebaseAuth.getInstance();
    progressBar=findViewById(R.id.progressbar);
    editText=findViewById(R.id.editTextCode);

    String phonenumber=getIntent().getStringExtra("phonenumber");
    sendVerificationCode(phonenumber);

    findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String code= editText.getText().toString().trim();

            if(code.isEmpty()||code.length()<6)
            {
                editText.setError("Enter code again");
                editText.requestFocus();
                return;
            }
            verifyCode(code);
        }
    });

    }

    private void verifyCode(String code)
    {

        PhoneAuthCredential credential =PhoneAuthProvider.getCredential(verificationid,code);
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Intent intent=new Intent(OtpActivity.this, First.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(OtpActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendVerificationCode(String number)
    {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60,TimeUnit.SECONDS,TaskExecutors.MAIN_THREAD,mCallBack);
    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        public void onCodeSent(String s,PhoneAuthProvider.ForceResendingToken forceResendingToken){

            super.onCodeSent(s,forceResendingToken);
            verificationid=s;
        }
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        String code=phoneAuthCredential.getSmsCode();
        if(code!=null)
        {
            progressBar.setVisibility(View.VISIBLE);
            verifyCode(code);
        }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(OtpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    };
}
