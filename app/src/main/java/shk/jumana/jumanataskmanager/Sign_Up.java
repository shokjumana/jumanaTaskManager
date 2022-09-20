package shk.jumana.jumanataskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Sign_Up extends AppCompatActivity {

    private TextInputEditText etEmail2;
    private TextInputEditText etPassword2;
    private TextInputEditText etPasswordConfirm;
    private Button BtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        etEmail2=findViewById(R.id.etEmail2);
        etPassword2=findViewById(R.id.etPassword2);
        etPasswordConfirm=findViewById(R.id.etPasswordConfirm);
        BtnSave=findViewById(R.id.BtnSave);




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}