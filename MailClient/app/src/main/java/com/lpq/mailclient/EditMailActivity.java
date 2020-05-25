package com.lpq.mailclient;

import android.content.Intent;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.lpq.mailclient.entity.MailAccountInfo;
import com.lpq.mailclient.entity.MailInfo;
import com.lpq.mailclient.http.MailRequest;
import com.lpq.mailclient.http.UserRequest;
import com.lpq.mailclient.result.BaseResult;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class EditMailActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private Spinner spinnerSelectSendAccount;
    private String[] items;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mail);
        Objects.requireNonNull(getSupportActionBar()).setTitle("写信");

        final EditText editMailReceiver = findViewById(R.id.mail_receiver);
        spinnerSelectSendAccount = findViewById(R.id.select_send_account);
        final EditText editMailSubject = findViewById(R.id.mail_subject);
        final EditText editMailContent = findViewById(R.id.mail_content);
        Button buttonMailSend = findViewById(R.id.mail_send);

        buttonMailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> bodyMap = new HashMap<>();
                        bodyMap.put("from",spinnerSelectSendAccount.getSelectedItem().toString());
                        bodyMap.put("to",editMailReceiver.getText().toString());
                        bodyMap.put("subject",editMailSubject.getText().toString());
                        bodyMap.put("content",editMailContent.getText().toString());
                        MailRequest request  = new MailRequest();
                        BaseResult<Void> voidBaseResult = request.sendMail(bodyMap);
                        if(voidBaseResult.getCode() == 200){
                            Looper.prepare();
                            Toast.makeText(EditMailActivity.this, "发送成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EditMailActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                            Looper.loop();
                        }else {
                            Looper.prepare();
                            Toast.makeText(EditMailActivity.this, "发送失败",Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }
                    }
                }).start();
            }
        });
        bindSpinner();
    }

    /**
     * 绑定 spinner
     */
    private void bindSpinner() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                UserRequest request = new UserRequest();
                BaseResult<List<MailAccountInfo>> accounts = request.userMailInfos();
                items = new String[accounts.getData().size()];
                if (accounts.getCode() == 200) {
                    if(accounts.getData().size() == 0){
                        items = new String[1];
                        items[0] = "该账户未绑定邮箱";
                    }else {
                        for (int i = 0; i < accounts.getData().size(); i++) {
                            items[i] = accounts.getData().get(i).getMailAccount();
                        }
                    }
                    ArrayAdapter<String> starAdapter = new ArrayAdapter<String>(EditMailActivity.this, android.R.layout.simple_list_item_1, items);
                    // 设置下拉框的数组适配器
                    spinnerSelectSendAccount.setAdapter(starAdapter);
                }
            }
        });
        thread.start();
        // 数据
        // 声明一个下拉列表的数组适配器
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(EditMailActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}
