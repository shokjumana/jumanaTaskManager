package shk.jumana.jumanataskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_Up extends AppCompatActivity {

    private TextInputEditText etEmail2;
    private TextInputEditText etPassword2;
    private TextInputEditText etPasswordConfirm;
    private Button BtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        etEmail2=findViewById(R.id.etEmail2);
        etPassword2=findViewById(R.id.etPassword2);
        etPasswordConfirm=findViewById(R.id.etPasswordConfirm);
        BtnSave=findViewById(R.id.BtnSave);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                CheckAndSave();//the purpose of check and save is to go to the sign in page
                //توثيق خاص : used for signing in and signing out
            }




        });

    }

    private void CheckAndSave()
    {
        String Email=etEmail2.getText().toString();
        String PassWord=etPassword2.getText().toString();
        String ConfirmPassword=etPasswordConfirm.getText().toString();
        boolean isOk=true;// بمشي على كل الفحوصات ويفحصهن

        if (Email.length()*PassWord.length()*ConfirmPassword.length()==0)
        {
            etEmail2.setError("one of the files are empty");
            isOk=false;
        }

        if (PassWord.equals(ConfirmPassword)==false)
        {
            etPasswordConfirm.setError("your password does not match");
            isOk=false;
        }

        if (isOk)
        {
            FirebaseAuth auth=FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(Email,PassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                /**
                 * when the mission of this task-is complete
                 * @param task    info about the event
                 */
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())   //check if creating account is complete and successful
                    {
                        Toast.makeText(Sign_Up.this, "creation successful", Toast.LENGTH_SHORT).show();// checks if the email is there and gives a text
                        finish();//when it completes it finishes and goes to the sign in page,close current activity
                    }
                    else
                    {
                        Toast.makeText(Sign_Up.this, "creation failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        //gives a text that its not working



                    }
                }
            });
        }

//توثيق فئات ودوال منستعمل/**
    }
}