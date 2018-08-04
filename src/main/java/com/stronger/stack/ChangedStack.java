package com.stronger.stack;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  15:50 2018/6/8
 * @ModefiedBy:
 */
public class ChangedStack {
    /*public static void main(String[] args) {
        PostfixEvaluate postfixEvaluate = new PostfixEvaluate();
        String expression = "3 4 * 2 5 + - 4 * 2 /";
        String sec = "34*25+-4*2/";
        System.out.println(postfixEvaluate.getResult(sec.split("")));
        System.out.println(postfixEvaluate.getResult(expression.split(" ")));
    }
    */
    public static void main(String[] args) {

        String expr = "1+2+3*(4+5)";
        PostfixEvaluate postfixEvaluate = new PostfixEvaluate();
        List<String> stringList = postfixEvaluate.reverseAfterExpr(expr.split(""));
        for (String str:stringList){
            System.out.print("  "+str);
        }
        System.out.println();
        System.out.println("  val "+postfixEvaluate.getResult());

    }


}
