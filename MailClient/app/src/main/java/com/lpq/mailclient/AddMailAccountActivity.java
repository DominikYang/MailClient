package com.lpq.mailclient;

import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.lpq.mailclient.http.UserRequest;
import com.lpq.mailclient.result.BaseResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AddMailAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mail_account);
        Objects.requireNonNull(getSupportActionBar()).setTitle("添加邮箱账号POP3/SMTP");

        final EditText EditAccount = findViewById(R.id.add_account);
        final EditText EditPsw = findViewById(R.id.add_pwd);
        final EditText EditPopServer = findViewById(R.id.pop_server);
        final EditText EditPopPort = findViewById(R.id.pop_port);
        final EditText EditSmtpServer = findViewById(R.id.smtp_server);
        final EditText EditSmtpPort = findViewById(R.id.smtp_port);
        Button submitButton = findViewById(R.id.account_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> map = new HashMap<>();
                        map.put("mail_account" , EditAccount.getText().toString());
                        map.put("mail_password" , EditPsw.getText().toString());
                        map.put("mail_pop_address" , EditPopServer.getText().toString());
                        map.put("mail_pop_port" ,EditPopPort.getText().toString() );
                        map.put("mail_smtp_address" , EditSmtpServer.getText().toString());
                        map.put("mail_smtp_port" , EditSmtpPort.getText().toString());
                        UserRequest request = new UserRequest();
                        try{
                            BaseResult<Void> addAccount = request.addAccount(map);
                            if(addAccount.getCode()==200){
                                Looper.prepare();
                                Toast.makeText(AddMailAccountActivity.this, "增加成功",Toast.LENGTH_SHORT).show();
                                finish();
                                Looper.loop();
                            }else{
                                Looper.prepare();
                                Toast.makeText(AddMailAccountActivity.this, "增加失败",Toast.LENGTH_SHORT).show();
                                Looper.loop();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
