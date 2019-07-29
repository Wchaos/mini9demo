package com.netease.mini9demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.netease.mini9demo.entity.Remind;
import com.netease.mini9demo.utils.ToastUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AddRemindActivity extends AppCompatActivity {
    private TextView tvTimeStep;
    private static final String TAG = "AddRemindActivity";
    private static final SimpleDateFormat SDF =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remind);

    }

    public void subOne(View view){
        tvTimeStep=findViewById(R.id.tv_add_time_step);
        Integer timeStep =Integer.parseInt(tvTimeStep.getText().toString());
        if(timeStep>1){
            timeStep-=1;
        }

        tvTimeStep.setText(Integer.toString(timeStep));

    }
    public void addOne(View view){
        tvTimeStep=(TextView)findViewById(R.id.tv_add_time_step);
        Integer timeStep=Integer.parseInt(tvTimeStep.getText().toString());
        if(timeStep<999){
            timeStep+=1;
        }

        tvTimeStep.setText(Integer.toString(timeStep));

    }

    public void back(View view){
        finish();
    }
    public void savaInfo(View view){
        String plantName = ((EditText)findViewById(R.id.add_remind_plant_name)).getText().toString();
        String remindType = ((Spinner)findViewById(R.id.add_remind_type)).getSelectedItem().toString();
        String remindTime = ((EditText)findViewById(R.id.add_remind_time)).getText().toString();
        int timeStep = Integer.parseInt(((TextView)findViewById(R.id.tv_add_time_step)).getText().toString());
        String extraInfo = ((EditText)findViewById(R.id.add_extra_info)).getText().toString();
        if(plantName.isEmpty() || remindType == null || remindType.isEmpty() || remindTime.isEmpty()){
            ToastUtil.showToast(AddRemindActivity.this,"植物名称|提醒类型|提醒时间，必填");
        }
        try {
            Date remindTimeDate = SDF.parse(remindTime);
            Date now = new Date();
            //如果提醒时间设定在当前时间前面，则以timeStep为步长平移
            while(remindTimeDate != null &&timeStep > 0 && remindTimeDate.before(now)){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(remindTimeDate);
                calendar.add(Calendar.DATE,timeStep);
                remindTimeDate = calendar.getTime();
            }
            if(remindTimeDate == null){
                throw new Exception("日期为null");
            }

            Remind remind = new Remind();
            remind.setPlantName(plantName);
            remind.setRemindType(remindType);
            remind.setRemindTime(remindTimeDate.getTime());
            remind.setRemindStep(timeStep);
            remind.setExtraInfo(extraInfo);
            remind.save();
        } catch (ParseException e) {
            ToastUtil.showToast(AddRemindActivity.this,"时间格式填写错误");
            e.printStackTrace();
        } catch (Exception e){
            Log.e(TAG, "savaInfo: ",e );
            e.printStackTrace();
        }
        ToastUtil.showToast(AddRemindActivity.this,"保存数据成功");
        Log.i(TAG, "savaInfo: 保存数据成功");
        //跳转上一页面
        finish();
    }




}
