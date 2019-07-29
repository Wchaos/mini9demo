package com.netease.mini9demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.netease.mini9demo.adapter.RemindListAdapter;
import com.netease.mini9demo.entity.Remind;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


public class RemindListActivity extends AppCompatActivity {


    private Button bt;

    //private String[] data = { "Apple", "Banana", "Orange", "Watermelon","Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        //setContentView(R.layout.fist);

       setContentView(R.layout.activity_remind_list);
        List<Remind> remindList =  LitePal.order("remindtime ASC").find(Remind.class);

        RemindListAdapter remindListAdapter = new RemindListAdapter(RemindListActivity.this, R.layout.remind_item, remindList);
       ListView listView = (ListView) findViewById(R.id.remind_list);
       listView.setAdapter(remindListAdapter);

        //点击每个item的监听事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Toast.makeText(RemindListActivity.this, "点击了第一个item，可以跳转到下一个页面啦", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
    public void turnAddRemind(View view){
        Intent intent = new Intent(RemindListActivity.this, AddRemindActivity.class);
        startActivity(intent);
    }






}
