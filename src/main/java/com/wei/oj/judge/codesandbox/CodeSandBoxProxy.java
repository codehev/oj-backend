package com.wei.oj.judge.codesandbox;

import com.wei.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.wei.oj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 代理模式，静态代理，用代理类拓展管理沙箱实例，例如：日志
 * 代理类和被代理类实现同一个接口（CodeSandBox接口），实例化时传要被代理的对象，生成代理对象
 *
 */
@Slf4j
public class CodeSandBoxProxy implements CodeSandBox {
    //相当于常量，只改变一次，初始值
    private final CodeSandBox codeSandBox;

    //有参构造方法
    public CodeSandBoxProxy(CodeSandBox codeSandBox) {
        this.codeSandBox = codeSandBox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息：" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息：" + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
