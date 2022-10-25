package shk.jumana.jumanataskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import shk.jumana.jumanataskmanager.Data.data.Mahame;

public class AddTask extends AppCompatActivity
{
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
             CheckAndSave();
            }

            private void CheckAndSave()
            {
                //استخراج القيم من صفحة الاضافة
                String Title=etTittleTask.getText().toString();
                String Subject=etSubjectTask.getText().toString();
                int important=skImportant.getProgress();
                // بناء كائن واعطاؤه قيم الصفات
                Mahame m= new Mahame();
                m.setTitle(Title);
                m.setSubject(Subject);
                m.setImportance(important);

                //استخراج رقم المميز للمستعمل
                //uid - universal
                //user that signed before , مستخدم دخل مسبقا

                String owner = FirebaseAuth.getInstance().getCurrentUser().getUid();
                m.setOwners(owner);

                String key =FirebaseDatabase.getInstance().getReference()
                        .child("mahamat")//جذر جديد تحته يتم تخزين المعلومات
                        .child(owner)
                        .push()// add new مستخدم
                        .getKey();//استخراج الرقم المميز من المهمة التي سيتم اضافتها
                m.setKey(key);

                //جذر شجرة المعطيات , عنوان جذر شجرة المعطيات

                FirebaseDatabase.getInstance().getReference().child("mahamat").child(owner).child(key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            finish();
                            Toast.makeText(AddTask.this,"added successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(AddTask.this,"added failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }


                    }

                });

            }
        });
    }
}