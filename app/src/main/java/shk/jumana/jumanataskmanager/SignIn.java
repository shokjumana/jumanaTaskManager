package shk.jumana.jumanataskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnContextClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSignIn;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);//يبني واجهة المستعمل بحيث تبني كل الكائنات الموجودة في ملف التنسيق ال xml


        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(SignIn.this,Sign_Up.class);
                startActivity(i);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                CheckAndSave();


            }
        });


    }

    private void CheckAndSave()
    {
        String Email=etEmail.getText().toString();
        String PassWord=etPassword.getText().toString();
        boolean isOk=true;

        if (Email.length()==0)
        {
            etEmail.setError("please enter your email");
            isOk=false;
        }

        if (PassWord.length()==0)
        {
            etPassword.setError("please enter your Password");
            isOk=false;
        }

        if (Email.indexOf("@")<=0)
        {
            etEmail.setError("your emailn is wrong");
            isOk=false;
        }
        if (PassWord.length()<7)
        {
            etPassword.setError("your password should be at least 7 characters");
            isOk=false;
        }
        if (isOk)
        {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(Email,PassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                        {
                            Toast.makeText(SignIn.this, "Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignIn.this,MainActivity.class);
                            startActivity(i);
                            finish();



                }
                    else
                    {
                        Toast.makeText(SignIn.this, "Not Successful"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();



                    }

                }
            });


        }


    }
}
