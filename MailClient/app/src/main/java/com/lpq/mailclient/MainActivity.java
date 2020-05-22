package com.lpq.mailclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import com.lpq.mailclient.adapter.MailInfoAdapter;
import com.lpq.mailclient.entity.MailInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MailInfo> mails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ListView homeListView = findViewById(R.id.home_list_view);
        setSupportActionBar(toolbar);
        toolbar.setTitle("收件箱");

        initData();

        FloatingActionButton floatingActionButton = findViewById(R.id.float_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditMailActivity.class);
                startActivity(intent);
            }
        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.btn_setting) {
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });

        MailInfoAdapter adapter = new MailInfoAdapter(MainActivity.this, R.layout.mail_item,mails);
        homeListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initData(){
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));
        mails.add(new MailInfo(1,1,"主题","18652736319@qq.com","18652736319@163.com","content",new Date()));


    }

}
