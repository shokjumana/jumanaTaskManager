package shk.jumana.jumanataskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //دالة مسؤولة عن فحص و تشغيل ال menu

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);//بتحط المحل الي الها يعني اللا R هو اللا res يعني resourse
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.itmSettings) {
            Intent i = new Intent(MainActivity.this, settings.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itmHistory)
        {
            Intent i = new Intent(MainActivity.this, History.class);
            startActivity(i);
        }

            return true;


    }





}



