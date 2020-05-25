package com.lpq.mailclient;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.lpq.mailclient.http.UserRequest;

import java.util.Objects;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Objects.requireNonNull(getSupportActionBar()).setTitle("设置");

        Button changeNick = findViewById(R.id.setting_change_nickname);
        Button changePsw = findViewById(R.id.setting_change_password);
        Button addAccount = findViewById(R.id.setting_add_mail_account);
        Button quit = findViewById(R.id.logout);

        changeNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ChangeNicknameActivity.class);
                startActivity(intent);
            }
        });

        changePsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this , ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this , AddMailAccountActivity.class);
                startActivity(intent);
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRequest request = new UserRequest();
                request.clearToken();
                Intent intent = new Intent(SettingActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
