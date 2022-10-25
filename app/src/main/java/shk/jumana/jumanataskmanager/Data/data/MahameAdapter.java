package shk.jumana.jumanataskmanager.Data.data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import shk.jumana.jumanataskmanager.R;

public class MahameAdapter extends ArrayAdapter
{
    public MahameAdapter(@NonNull Context context)
    {
        super(context, R.layout.task_item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        return super.getView(position, convertView, parent);

    }
}
