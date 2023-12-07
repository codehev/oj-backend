package com.wei.oj.judge.codesandbox;

import com.wei.oj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.wei.oj.judge.codesandbox.impl.RemoteCodeSandBox;
import com.wei.oj.judge.codesandbox.impl.ThirdPartyCodeSandBox;

/**
 * 工厂模式，静态工厂（根据字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandBoxFactory {
    /**
     * 创建代码沙箱实例
     *
     * @param type 沙箱类型
     * @return CodeSandBox接口
     */
    public static CodeSandBox newInstance(String type) {
        //return的是CodeSandBox的实现类，但是是CodeSandBox类型
        switch (type) {
            case "example":
                return new ExampleCodeSandBox();
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                return new ExampleCodeSandBox();
        }
    }
}
