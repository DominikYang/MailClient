package com.lpq.mailclient.result;
/**
 * @author Wei yuyaung
 * @date 2020.05.19 12:18
 */
public class BaseResult<T> {
    private Integer code;
    private String message;
    private T data;

    private BaseResult(T data){
        this.code = CodeMessage.CODE_SUCCESS;
        this.data = data;
    }

    private BaseResult(CodeMessage codeMessage){
        this.code = codeMessage.getCode();
        this.message = codeMessage.getMessage();
    }

    public static <T> BaseResult<T> success(T data){
        return new BaseResult<>(data);
    }

    public static <T> BaseResult<T> fail(CodeMessage codeMessage){
        return new BaseResult<>(codeMessage);
    }

    public BaseResult() {
    }

    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
