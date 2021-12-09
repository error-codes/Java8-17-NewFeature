package com.young.lambda;

/**
 * <h1>Lambda 表达式的语法格式如下：</h1>
 * <blockquote><pre>
 *     (parameters) -> expression
 *     (parameters) ->{ statements; }
 * </pre></blockquote>
 * <li>以下是 Lambda 表达式的重要特征:</li>
 * <ul>   可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。</ul>
 * <ul>   可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。</ul>
 * <ul>   可选的大括号：如果主体包含了一个语句，就不需要使用大括号。</ul>
 * <ul>   可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值。</ul>
 *
 * <li>Lambda 表达式实例</li>
 *      <ul>// 1. 不需要参数,返回值为 5<br/>
 *      () -> 5</ul>
 *
 *      <ul>// 2. 接收一个参数(数字类型),返回其2倍的值<br/>
 *      x -> 2 * x</ul>
 *
 *      <ul>// 3. 接受2个参数(数字),并返回他们的差值<br/>
 *      (x, y) -> x – y</ul>
 *
 *      <ul>// 4. 接收2个int型整数,返回他们的和<br/>
 *      (int x, int y) -> x + y</ul>
 *
 *      <ul>// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)<br/>
 *      (String s) -> System.out.print(s)</ul>
 *
 * @author      error-codes【BayMax】
 * @since       2021/12/8 14:45
 * @see
 */
public class LambdaExpression {

    public static void main(String[] args) {
        LambdaExpression lambdaExpression = new LambdaExpression();

        // 加法运算，【类型说明】
        MathOperation addition = (int a, int b) -> a + b;

        // 减法运算，【不用类型说明】
        MathOperation subtraction = (a, b) -> a - b;

        // 乘法运算，【类型说明，大括号中编写处理逻辑】
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 除法运算，【类型说明，没有大括号及返回语句】
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("12 + 7 = " + lambdaExpression.operate(10, 7, addition));
        System.out.println("12 - 7 = " + lambdaExpression.operate(10, 7, subtraction));
        System.out.println("12 * 7 = " + lambdaExpression.operate(10, 7, multiplication));
        System.out.println("12 / 7 = " + lambdaExpression.operate(10, 7, division));

        // 不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello, " + message);

        // 用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hi, " + message);

        greetingService1.sayMessage("Young.NET");
        greetingService2.sayMessage("Young.Net");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
