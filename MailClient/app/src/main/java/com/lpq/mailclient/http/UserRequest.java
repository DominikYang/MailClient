package com.lpq.mailclient.http;

import com.lpq.mailclient.api.Api;
import com.lpq.mailclient.dto.LoginDTO;
import com.lpq.mailclient.entity.MailAccountInfo;
import com.lpq.mailclient.entity.MailInfo;
import com.lpq.mailclient.response.EmptyResponse;
import com.lpq.mailclient.response.HelloResponse;
import com.lpq.mailclient.response.LoginResponse;
import com.lpq.mailclient.response.MailAccountInfoResponse;
import com.lpq.mailclient.result.BaseResult;
import com.lpq.mailclient.result.CodeMessage;
import com.lpq.mailclient.utils.FastJsonUtils;
import com.lpq.mailclient.utils.OkHttpUtil;
import okhttp3.Response;

import javax.xml.transform.OutputKeys;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wei yuyaung
 * @date 2020.05.20 17:17
 */
public class UserRequest {
    public static String token = "";

    /**
     * description: 用户登录 <br>
     * version: 1.0 <br>
     * date: 2020.05.20 17:21 <br>
     * author: Dominikyang <br>
     *
     * @param username
     * @param password
     * @return com.lpq.mailclient.result.BaseResult<java.lang.String>
     */
    public BaseResult<LoginDTO> login(String url, String username, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        LoginResponse loginResponse = new LoginResponse();
        Response response = OkHttpUtil.getInstance().postData(Api.LOGIN, map);
        System.out.println(response);
        try {
            String result = response.body().string();
            loginResponse = FastJsonUtils.jsonToObject(result, LoginResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.JSON_PARSE_ERROR);
        }
        token = loginResponse.getData().getToken();
        System.out.println(loginResponse.getData().getToken());
        return BaseResult.success(loginResponse.getData());
    }

    public BaseResult<String> hello() {
        HelloResponse helloResponse = new HelloResponse();
        Response data = OkHttpUtil.getInstance().getData(Api.HELLO + "/android");
        System.out.println(data);
        try {
            String json = data.body().string();
            helloResponse = FastJsonUtils.jsonToObject(json, HelloResponse.class);
            System.out.println(helloResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.JSON_PARSE_ERROR);
        }
        return BaseResult.success(helloResponse.getData());
    }

    public BaseResult<List<MailAccountInfo>> userMailInfos() {
        MailAccountInfoResponse response = new MailAccountInfoResponse();
        Response data = OkHttpUtil.getInstance().getData(Api.USER_MAIL_ACCOUNT, UserRequest.token);
        System.out.println(data);
        try {
            String json = data.body().string();
            if (json == null) {
                List<MailAccountInfo> list = new ArrayList<>();
                return BaseResult.success(list);
            }
            response = FastJsonUtils.jsonToObject(json, MailAccountInfoResponse.class);
            if (response != null && response.getCode() == CodeMessage.CODE_SUCCESS) {
                return BaseResult.success(response.getData());
            } else if (response == null) {
                return BaseResult.fail(CodeMessage.ANDROID_NET_ERROR);
            } else {
                return BaseResult.fail(new CodeMessage(response.getCode(), response.getMessage()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.JSON_PARSE_ERROR);
        }
    }

    public BaseResult<Void> changeNickname(String nickname){
        EmptyResponse response = new EmptyResponse();
        Map<String,String> map = new HashMap<>();
        map.put("nick_name" , nickname);
        Response data = OkHttpUtil.getInstance().postData(Api.CHANGE_NICK,map,UserRequest.token);
        System.out.println(data);
        try{
            String result = data.body().string() ;
            response = FastJsonUtils.jsonToObject(result,EmptyResponse.class);
            if(response.getCode()==200){
                return BaseResult.success(null);
            }else {
                return BaseResult.fail(new CodeMessage(response.getCode(),response.getMessage()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.JSON_PARSE_ERROR);
        }
    }

    public BaseResult<Void> changePassword(Map<String,String> map){
        EmptyResponse response = new EmptyResponse();
        Response data = OkHttpUtil.getInstance().postData(Api.CHANGE_PSW,map,UserRequest.token);
        System.out.println(data);
        try{
            String result = data.body().string();
            response = FastJsonUtils.jsonToObject(result,EmptyResponse.class);
            if(response.getCode()==200){
                return BaseResult.success(null);
            }else{
                return BaseResult.fail(new CodeMessage(response.getCode(),response.getMessage()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.JSON_PARSE_ERROR);
        }
    }

    public BaseResult<Void> addAccount(Map<String,String> body){
        EmptyResponse response = new EmptyResponse();
        Response data = OkHttpUtil.getInstance().postData(Api.ADD_ACCOUNT,body,UserRequest.token);
        System.out.println(data);
        try{
            String result = data.body().string();
            response = FastJsonUtils.jsonToObject(result,EmptyResponse.class);
            if(response.getCode()==200){
                return BaseResult.success(null);
            }else{
                return BaseResult.fail(new CodeMessage(response.getCode(),response.getMessage()));
            }
        }catch (IOException e){
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.JSON_PARSE_ERROR);
        }
    }

    public void clearToken() {

    }






}
