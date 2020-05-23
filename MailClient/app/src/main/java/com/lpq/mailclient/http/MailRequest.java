package com.lpq.mailclient.http;

import com.lpq.mailclient.api.Api;
import com.lpq.mailclient.entity.MailInfo;
import com.lpq.mailclient.response.EmptyResponse;
import com.lpq.mailclient.response.MailListResponse;
import com.lpq.mailclient.result.BaseResult;
import com.lpq.mailclient.result.CodeMessage;
import com.lpq.mailclient.utils.FastJsonUtils;
import com.lpq.mailclient.utils.OkHttpUtil;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Wei yuyaung
 * @date 2020.05.20 17:18
 */
public class MailRequest {

    /**
     * description: 发送邮件 <br>
     * version: 1.0 <br>
     * date: 2020.05.21 19:05 <br>
     * author: Dominikyang <br>
     *
     * @param body
     * @return com.lpq.mailclient.result.BaseResult<java.lang.Void>
     */
    public BaseResult<Void> sendMail(Map<String,String> body){
        EmptyResponse emptyResponse = new EmptyResponse();
        try {
            Response response = OkHttpUtil.getInstance().postData(Api.SEND_EMAIL, body, UserRequest.token);
            String result = response.body().string();
            emptyResponse = FastJsonUtils.jsonToObject(result, EmptyResponse.class);
            if (emptyResponse.getCode()== 200){
                return BaseResult.success(null);
            }else {
                return BaseResult.fail(new CodeMessage(emptyResponse.getCode(),emptyResponse.getMessage()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.MAIL_SEND_ERROR);
        }
    }

    /**
     * description: 接收邮件 <br>
     * version: 1.0 <br>
     * date: 2020.05.23 22:22 <br>
     * author: Dominikyang <br>
     *
     * @param
     * @return com.lpq.mailclient.result.BaseResult<java.util.List<com.lpq.mailclient.entity.MailInfo>>
     */
    public BaseResult<List<MailInfo>> receiveMails(){
        MailListResponse response = new MailListResponse();

        Response data = OkHttpUtil.getInstance().getData(Api.RECEIVE_MAIL, UserRequest.token);
        try {
            String result = data.body().string();
            response = FastJsonUtils.jsonToObject(result,MailListResponse.class);
            if(response.getCode() == 200){
                return BaseResult.success(response.getData());
            }else {
                return BaseResult.fail(new CodeMessage(500,response.getMessage()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResult.fail(CodeMessage.ANDROID_NET_ERROR);
        }

    }
}
