package shk.jumana.jumanataskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
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
                CheckAndSave();
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

        }


    }
}