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
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import shk.jumana.jumanataskmanager.Data.data.Mahame;
import shk.jumana.jumanataskmanager.Data.data.MahameAdapter;

public class MainActivity extends AppCompatActivity
{

    //بناء وسيط,ملائم mahmatAdapter
    private ImageButton btnAdd;
    //تجهيز الوسيط (حسب الورقة3.1)
    MahameAdapter mahameAdapter;
    //قائمة عرض مهمات
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //بناء شاشة التنسيق وكل الكائنات التي تحويه

        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.btnAdd);
        //3.2 بناء الوسيط
        mahameAdapter =new MahameAdapter(getApplicationContext());
        //تجهيز مؤشر لقائمة العرض
        listView=findViewById(R.id.lvTask);

        listView.setAdapter(mahameAdapter);

        //downloading and working مراقب listener for every change on قاعدة البيانات and cleans the المعطيات الموجودة (delete) and downloads new info.
        readMahamatFromFirebase();

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.itmSettings) {
            Intent i = new Intent(MainActivity.this, settings.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itmHistory) {
            Intent i = new Intent(MainActivity.this, History.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itmSignOut) {
            //تسجيل خروج
            //FirebaseAuth.getInstance().signOut();
            //finish();

            //تجهيز بناء ديالوج
            //A dialog is a small window that prompts the user to make a decision or enter additional information.
            // A dialog does not fill the screen and is normally used for modal events-
            // that require users to take an action before they can proceed.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("sign out");
            builder.setMessage("are you sure");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
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
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();

                }
            });
            //بناء ديالوج
            AlertDialog dialog = builder.create();
            dialog.show();

        }
        return true;
    }

    /**
     * downloading and working مراقب listener for every change on قاعدة البيانات and cleans the المعطيات الموجودة (delete) and downloads new info.
     */
    private void readMahamatFromFirebase()
    {
        //مؤشر لجذر قاعدة البيانات التابعة للمشروع
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //listener لمراقبة اي تغيير يحدث تحت الجذر المحدد
        //اي تغيير بقيمة صفة او حذف او اضافة كائن يتم اعلام ال listener
        //عندها يتم تنزيل,تحميل كل المعطيات الموجودة تحت الجذر
        //كل معالجي الحدث ببدو ب on
        reference.child("mahamat").addValueEventListener(new ValueEventListener()
        {
            /**
             *             دالة معالجة حدث عند تغيير اي قيمة في ال firebase
             * @param snapshot  يحوي نسخة عن كل المعطيات تحت العنوان المراقبل يعني الي محطوط علي listener
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                // تغيير معطيات بال firebase
                //بعطي معطيات
                //الكائن الي فيو بحوي معيطيات الي بكونو تحت الجذر
                //remove all tasks from adapter
                mahameAdapter.clear();

                for (DataSnapshot d:snapshot.getChildren())//the d يمر على جميع قيم مبنى المعطيات,d من نوع snapshot
                {
                    Mahame m=d.getValue(Mahame.class);//استخرجت الابن , جميع الابناء, استخراج الكائن المحفوظ
                    mahameAdapter.add(m);//اضافة الكائن للوسيط
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });


    }

}



