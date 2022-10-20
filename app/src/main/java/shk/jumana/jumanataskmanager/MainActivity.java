package shk.jumana.jumanataskmanager;

import static shk.jumana.jumanataskmanager.R.id.btnAdd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    private ImageButton btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this,AddTask.class);
                startActivity(i);

            }
        });
    }

    //دالة مسؤولة عن فحص و تشغيل ال menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);//بتحط المحل الي الها يعني اللا R هو اللا res يعني resourse
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        if (item.getItemId() == R.id.itmSettings) {
            Intent i = new Intent(MainActivity.this, settings.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itmHistory)
        {
            Intent i = new Intent(MainActivity.this, History.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itmSignOut)
        {
            //تسجيل خروج
            //FirebaseAuth.getInstance().signOut();
            //finish();

            //تجهيز بناء ديالوج
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("sign out");
            builder.setMessage("are you sure");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    //اخفاء ديالوج
                    dialogInterface.dismiss();
                    //تسجيل خروج من الشاشة
                    FirebaseAuth.getInstance().signOut();
                    //الخروج من الشاشة
                    finish();
                }
            });
            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.cancel();

                }
            });
            //بناء ديالوج
            AlertDialog dialog=builder.create();
            dialog.show();

        }
            return true;
    }
}



