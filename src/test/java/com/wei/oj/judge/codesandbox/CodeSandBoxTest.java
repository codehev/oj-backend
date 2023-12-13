package com.wei.oj.judge.codesandbox;

import com.wei.oj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.wei.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.wei.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.wei.oj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CodeSandBoxTest {
    @Test
    void executeCode() {
        ExampleCodeSandBox exampleCodeSandBox = new ExampleCodeSandBox();
        String code = "int main(){}";
        String language = QuestionSubmitLanguageEnum.C.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();
        ExecuteCodeResponse executeCodeResponse = exampleCodeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);//判断不为空
    }

    //:example是给默认值
    @Value("${codeSandBox.type:example}")
    private String codeSandBoxType;

    @Test
    void executeCodeByValue() {
        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(codeSandBoxType);
        String code = "int main(){}";
        String language = QuestionSubmitLanguageEnum.C.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);//判断不为空
    }

    @Test
    void executeCodeByProxy() {
        //返回具体的代码沙箱实例
        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(codeSandBoxType);
        //把沙箱实例作为参数，生成一个代理类，也是CodeSandBox类型，直接覆盖codeSandBox
        codeSandBox = new CodeSandBoxProxy(codeSandBox);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int var1 = Integer.parseInt(args[0]);\n" +
                "        int var2 = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果:\" + (var1 + var2));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .inputList(inputList)
                .language(language)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        System.out.println("executeCodeResponse："+executeCodeResponse);
        //如果为null，则会抛出AssertionError异常。不为null，则断言不会执行任何操作。
        Assertions.assertNotNull(executeCodeResponse);//判断不为空
    }
}
