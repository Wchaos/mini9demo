package com.netease.mini9demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.netease.mini9demo.entity.Album;
import com.netease.mini9demo.entity.Image;
import com.netease.mini9demo.entity.Remind;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Connector.getDatabase();
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(MainActivity.this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(MainActivity.this,fmt.format(date) , Toast.LENGTH_SHORT).show();
            }
        }).build();

    }

    public void addAlbum(View view){
        Album album = new Album();
        album.setName("test");
        album.setPlant_tag("兰花");
        album.save();
    }
    public void addImages(View view){
        Album album = LitePal.findFirst(Album.class);
        Image image1 = new Image();
        image1.setAlbum_id(album.getId());
        image1.setMood("hahaha");
        image1.save();
        Log.d(TAG, "addImages:save image1");

        Image image2 = new Image();
        image2.setAlbum_id(album.getId());
        image2.setMood("wuwuwu");
        image2.save();
        Log.d(TAG, "addImages: save image2");

    }
    public void queryAlbum(View view){
        Album album = LitePal.findFirst(Album.class);
        List<Image> imageList = LitePal.findAll(Image.class);
        Log.d(TAG,"image num = "+imageList.size());
        for (Image image : imageList){
            Log.d(TAG, "queryAlbum: "+image.getMood());
        }
    }

    public void addRemind(View view){
        Remind remind = new Remind();
        remind.setPlantName("芭蕉叶");
        remind.setRemindStep(3);
        long curTime = new Date().getTime();
        remind.setRemindTime(curTime);
    }
}
