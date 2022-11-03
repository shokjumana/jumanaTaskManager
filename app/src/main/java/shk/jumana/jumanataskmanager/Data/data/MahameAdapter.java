package shk.jumana.jumanataskmanager.Data.data;

import static shk.jumana.jumanataskmanager.R.id.tvTitle;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import shk.jumana.jumanataskmanager.R;





//بدنا ال adapter بس لنوع واحد المهمات ,maham
public class MahameAdapter extends ArrayAdapter <Mahame>
{
    public MahameAdapter(@NonNull Context context)
    {
        super(context, R.layout.task_item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //بناء واجهة لعرض المهمة- ال item
        View vItem= LayoutInflater.from(getContext()).inflate(R.layout.task_item,parent,false);



        TextView tvTitle=vItem.findViewById(R.id.tvTitle);
        TextView tvSubject=vItem.findViewById(R.id.tvSubject);
        RatingBar rbImportance=vItem.findViewById(R.id.rbImportance);
        CheckBox checkBox2=vItem.findViewById(R.id.checkBox2);
        ImageButton ivInfo=vItem.findViewById(R.id.ivInfo);

        //كائن من نوع مهمة وبدنا نستخرج القيمة منوالitem
        final Mahame mahame=getItem(position);

        //استخراج قيم الحقول وتحديثها
        tvTitle.setText(mahame.getTitle());
        tvSubject.setText(mahame.getSubject());
        rbImportance.setRating(mahame.getImportance());
        checkBox2.setChecked(false);


        return vItem;



    }
}
