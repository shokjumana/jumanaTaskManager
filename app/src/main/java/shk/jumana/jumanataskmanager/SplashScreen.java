package shk.jumana.jumanataskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);




//start next activity screen auto after of time
        Handler H = new Handler();
        Runnable r= new Runnable() {
            @Override
            public void run() {
                // to open new activity and move from current page to the next one
                Intent i= new Intent(SplashScreen.this,SignIn.class);
                startActivity(i);
                        //to close current page
                      finish();

            }
        };
                H.postDelayed(r,3000);




    }
}