package com.wei.oj.judge.codesandbox;

import com.wei.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.wei.oj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 定义代码沙箱的接口，提高代码的可重用性，如诺修改直接修改代码沙箱的实现类即可
 */
public interface CodeSandBox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
