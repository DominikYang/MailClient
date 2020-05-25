package com.lpq.mailclient;

import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.lpq.mailclient.api.Api;
import com.lpq.mailclient.http.UserRequest;
import com.lpq.mailclient.result.BaseResult;

import java.util.Objects;

public class ChangeNicknameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nickname);
        Objects.requireNonNull(getSupportActionBar()).setTitle("修改昵称");

        final EditText EditNickname = findViewById(R.id.new_nickname);
        Button submitButton = findViewById(R.id.nickname_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String nickname = EditNickname.getText().toString();
                        UserRequest request = new UserRequest();
                        try{
                            BaseResult<Void> changeNick = request.changeNickname(nickname);
                            if(changeNick.getCode() == 200){
                                Looper.prepare();
                                Toast.makeText(ChangeNicknameActivity.this, "修改成功",Toast.LENGTH_SHORT).show();
                                finish();
                                Looper.loop();
                            }else{
                                Looper.prepare();
                                Toast.makeText(ChangeNicknameActivity.this, "修改失败",Toast.LENGTH_SHORT).show();
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
