package com.lpq.mailclient;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText registerUserName = findViewById(R.id.regi_username);
        final EditText registerPassword = findViewById(R.id.regi_password);
        Button regiButton = findViewById(R.id.btn_regi);

        regiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserRequest request = new UserRequest();
                        Map<String,String> body = new HashMap<>();
                        body.put("username",registerUserName.getText().toString());
                        body.put("password",registerPassword.getText().toString());
                        BaseResult<Void> result = request.register(body);
                        if(result.getCode() == 200){
                            Looper.prepare();
                            Toast.makeText(RegisterActivity.this, "注册成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                            Looper.loop();
                        }else {
                            Looper.prepare();
                            Toast.makeText(RegisterActivity.this, "注册失败",Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }
                    }
                }).start();
            }
        });
    }
}
