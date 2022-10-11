package shk.jumana.jumanataskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.google.android.material.textfield.TextInputEditText;

public class AddTask extends AppCompatActivity {

    private TextInputEditText etTittleTask;
    private TextInputEditText etSubjectTask;
    private SeekBar skImportant;
    private ImageButton imageTask;
    private Button btnCancelTask;
    private Button btnSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTittleTask= findViewById(R.id.etTittleTask);
        etSubjectTask= findViewById(R.id.etSubjectTask);
        skImportant= findViewById(R.id.skImportant);
        imageTask= findViewById(R.id.imageTask);
        btnCancelTask= findViewById(R.id.btnCancelTask);
        btnSaveTask= findViewById(R.id.btnSaveTask);


        btnCancelTask.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(AddTask.this,MainActivity.class);
                startActivity(i);

            }
        });
        btnSaveTask.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(AddTask.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}