package com.wei.oj.judge.codesandbox.impl;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.wei.oj.common.ErrorCode;
import com.wei.oj.exception.BusinessException;
import com.wei.oj.judge.codesandbox.CodeSandBox;
import com.wei.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.wei.oj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteCodeSandBox implements CodeSandBox {
    /**
     * 定义鉴权请求头和密钥(实现比较简单，适合内部系统之间相互调用，缺点不够灵活，如果key泄露或变更，需要重启代码)
     */
    // todo 远程代码沙箱鉴权
    private static final String AUTH_REQUEST_HEADER = "auth";
    private static final String AUTH_REQUEST_SECRETKEY = "secretkey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");

        // todo 远程代码沙箱地址
        //String url = "http://192.168.200.142:8081/api/executeCode";
        String url = "http://127.0.0.1:8105/api/executeCode";
        String jsonStr = JSONUtil.toJsonStr(executeCodeRequest);
        HttpResponse httpResponse = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRETKEY)
                .body(jsonStr)
                .execute();
        String responseStr = httpResponse.body();
        if (httpResponse.getStatus() != HttpStatus.HTTP_OK) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "远程代码沙箱请求失败：" + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
