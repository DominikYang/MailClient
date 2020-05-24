package com.lpq.mailclient;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.lpq.mailclient.entity.MailInfo;
import com.lpq.mailclient.http.MailRequest;
import com.lpq.mailclient.result.BaseResult;

import java.util.HashMap;
import java.util.Map;

public class MailDetailsActivity extends AppCompatActivity {

    String mailId;

    TextView fromView;
    TextView toView;
    TextView subjectView;
    TextView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        mailId=intent.getStringExtra("mailId");
        setContentView(R.layout.activity_mail_details);
         fromView = findViewById(R.id.mail_from);
         toView = findViewById(R.id.mail_to);
         subjectView = findViewById(R.id.mail_subject);
         contentView = findViewById(R.id.mail_content);
        initData();
    }

    private void initData() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MailRequest request = new MailRequest();
                Map<String, String> body = new HashMap<>();
                body.put("id", mailId);
                BaseResult<MailInfo> mailInfoBaseResult = request.mailDetails(body);
                if (mailInfoBaseResult.getCode() == 200) {
                    fromView.setText(mailInfoBaseResult.getData().getFrom());
                    toView.setText(mailInfoBaseResult.getData().getTo());
                    subjectView.setText(mailInfoBaseResult.getData().getSubject());
                    contentView.setText(mailInfoBaseResult.getData().getContent());
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
