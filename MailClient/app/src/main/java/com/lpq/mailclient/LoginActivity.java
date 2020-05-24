package com.lpq.mailclient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import com.lpq.mailclient.api.Api;
import com.lpq.mailclient.dto.LoginDTO;
import com.lpq.mailclient.http.UserRequest;
import com.lpq.mailclient.result.BaseResult;
import com.lpq.mailclient.result.CodeMessage;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText EditTetUsername = findViewById(R.id.username);
        final EditText EditTextPassword = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.btn_login);
        TextView registerButton = findViewById(R.id.btn_register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String username = EditTetUsername.getText().toString();
                        String password = EditTextPassword.getText().toString();
                        UserRequest request = new UserRequest();
                        try {
                            BaseResult<LoginDTO> login = request.login(Api.LOGIN, username, password);
                            if(login.getCode() == 200){
                                Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent2);
                            }else {
                                Looper.prepare();
                                Toast.makeText(LoginActivity.this, login.getMessage(),Toast.LENGTH_SHORT).show();
                                finish();
                                Looper.loop();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Looper.prepare();
                            Toast.makeText(LoginActivity.this, CodeMessage.JSON_PARSE_ERROR.getMessage(),Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }
                    }
                }).start();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}
