package com.young.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>VariableScope</h1>
 * <pre>Lambda 表达式只能引用标记了 final 的局部变量，或全局成员变量，这就是说不能在 Lambda 内部修改定义在域外的局部变量，否则会编译错误</pre>
 * <pre>Lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）</pre>
 * <pre>在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。</pre>
 *
 * @author error-codes【BayMax】
 * @see
 * @since 2021/12/8 16:02
 */
public class VariableScope {

    private static final String salutation = "Hello";
//    private static String salutation = "Hello";

    public static void main(String[] args) {
        final String part = "Thanks";
//        String part = "Thanks";
//        salutation = "xxxx";
        GreetingService greetingService1 = message -> System.out.println(salutation + message);
        GreetingService greetingService2 = message -> System.out.println(part + message);
        greetingService1.sayMessage("Young.Net");
//        part = "xxxx";
        greetingService2.sayMessage("Young.Net");
    }


    protected interface GreetingService {
        void sayMessage(String message);
    }
}
