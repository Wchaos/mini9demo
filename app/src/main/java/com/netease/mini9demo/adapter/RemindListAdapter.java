package com.netease.mini9demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.mini9demo.R;
import com.netease.mini9demo.entity.Remind;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RemindListAdapter extends ArrayAdapter {
    private static final String DEFAULT_REMIND_TYPE = "浇水";
    private static final SimpleDateFormat SDF =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );

    private int resourceId;

    public RemindListAdapter(Context context, int textViewResourceId, List<Remind> objects){
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Remind remind = (Remind) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        ImageView plantImg = (ImageView) view.findViewById(R.id.plant_img);
        ImageView remindTypeIcon = (ImageView) view.findViewById(R.id.remind_type_icon);
        TextView plantName = (TextView) view.findViewById(R.id.remind_plant_name);
        TextView remindType = (TextView) view.findViewById(R.id.remind_type);
        TextView remindTime = (TextView) view.findViewById(R.id.remind_time);


        if(remind == null){
            return view;
        }
        plantName.setText(remind.getPlantName());
        remindType.setText(remind.getRemindType());
        if(DEFAULT_REMIND_TYPE.equals(remind.getRemindType())){
            remindTypeIcon.setImageResource(R.drawable.water);
        }else {
            remindTypeIcon.setImageResource(R.drawable.manure);
        }
        remindTime.setText(SDF.format(new Date(remind.getRemindTime())));

        return view;

    }
}
