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

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        final EditText EditNewPassword = findViewById(R.id.new_password);
        final EditText EditOldPassword = findViewById(R.id.old_password);
        Button submitButton = findViewById(R.id.password_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String,String> body = new HashMap<>();
                        body.put("newPassword" , EditNewPassword.getText().toString());
                        body.put("oldPassword" , EditOldPassword.getText().toString());
                        UserRequest request = new UserRequest();
                        try{
                            BaseResult<Void> changePassword = request.changePassword(body);
                            if(changePassword.getCode() == 200){
                                Looper.prepare();
                                Toast.makeText(ChangePasswordActivity.this, "修改成功",Toast.LENGTH_SHORT).show();
                                finish();
                                Looper.loop();
                            }else{
                                Looper.prepare();
                                Toast.makeText(ChangePasswordActivity.this, "修改失败",Toast.LENGTH_SHORT).show();
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
