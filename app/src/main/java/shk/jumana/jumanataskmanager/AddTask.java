package shk.jumana.jumanataskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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




    }
}