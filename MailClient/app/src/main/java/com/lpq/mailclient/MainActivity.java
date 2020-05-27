package com.lpq.mailclient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import com.lpq.mailclient.adapter.MailInfoAdapter;
import com.lpq.mailclient.entity.MailInfo;
import com.lpq.mailclient.http.MailRequest;
import com.lpq.mailclient.result.BaseResult;
import com.lpq.mailclient.result.CodeMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private List<MailInfo> mails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ListView homeListView = findViewById(R.id.home_list_view);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("收件箱");

        FloatingActionButton floatingActionButton = findViewById(R.id.float_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditMailActivity.class);
                startActivity(intent);
                finish();
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
        initData();

        final MailInfoAdapter adapter = new MailInfoAdapter(MainActivity.this,mails);
        homeListView.setAdapter(adapter);

        homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MailInfo info = (MailInfo) adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this,MailDetailsActivity.class);
                intent.putExtra("mailId", info.getId().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initData(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MailRequest mailRequest = new MailRequest();
                BaseResult<List<MailInfo>> listBaseResult = mailRequest.receiveMails();
                if(listBaseResult.getCode() == 200){
                    mails.addAll(listBaseResult.getData());
                }else {
                    mails = new ArrayList<>();
                    Looper.prepare();
                    Toast.makeText(MainActivity.this, listBaseResult.getMessage(),Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }
        });

        thread.start();
        // 数据
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

}
