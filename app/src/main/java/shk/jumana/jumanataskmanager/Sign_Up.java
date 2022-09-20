package shk.jumana.jumanataskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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
                CheckAndSave();
            }




        });

    }

    private void CheckAndSave()
    {
        String Email=etEmail2.getText().toString();
        String PassWord=etPassword2.getText().toString();
        String ConfirmPassword=etPasswordConfirm.getText().toString();
        boolean isOk=true;

        if (Email.length()==0)
        {
            etEmail2.setError("please enter your email");
            isOk=false;
        }

        if (PassWord.length()==0)
        {
            etPassword2.setError("please enter your Password");
            isOk=false;
        }

        {
            etPasswordConfirm.setError("your password does not match");
            isOk=false;
        }


        if (Email.indexOf("@")<=0)
        {
            etEmail2.setError("your emailn is wrong");
            isOk=false;
        }
        if (PassWord.length()<7)
        {
            etPassword2.setError("your password should be at least 7 characters");
            isOk=false;
        }


    }
}