package com.lpq.mailclient.Exception;

import com.lpq.mailclient.result.CodeMessage;

/**
 * @author lgq
 * @date 2020/1/19
 */
public class GlobalException extends Exception {

    private static final long serialVersionUID = -3655264493408473309L;

    private CodeMessage codeMessage;

    public CodeMessage getCodeMessage() {
        return codeMessage;
    }

    public GlobalException(CodeMessage codeMessage) {
        super(codeMessage.getMessage());
        this.codeMessage = codeMessage;
    }

}

