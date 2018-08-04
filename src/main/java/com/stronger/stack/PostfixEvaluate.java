package com.stronger.stack;

import java.util.*;
public class PostfixEvaluate {

    private final static char ADD = '+';
    private final static char SUBSTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';
    private List<String> stringList = new ArrayList<String>();
    private Stack<String> stack;

    public PostfixEvaluate() {
        stack = new Stack<String>();
    }

    public int getResult() {
        int result = 0, op1, op2;
        for (String str : stringList) {
            if (isOperand(str)) {
                char oper = str.charAt(0);
                op2 = Integer.valueOf(stack.pop());
                op1 = Integer.valueOf(stack.pop());
                result = evaulateOperator(oper, op1, op2);
                stack.push(String.valueOf(result));
            } else {
                stack.push(str);
            }
        }
        return result;
    }

    private boolean isOperand(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    private boolean isNumber(String token) {
        return token.matches("^[0-9]*$");
    }

    private boolean isDivideNote(String token) {
        return (token.equals("(") || token.equals(")"));
    }

    private int evaulateOperator(char token, int op1, int op2) {
        int result = 0;
        switch (token) {
            case ADD:
                result = op1 + op2;
                break;
            case SUBSTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
                break;
        }
        return result;
    }

    private Stack<String> containOperand = new Stack<String>();

    /**
     * 　　* @Description:这里是把中缀表达式转化为后缀表达式
     * 　　* @param ${tags}
     * 　　* @return ${return_type}
     * 　　* @throws
     * 　　* @author 付风松
     * 　　* @date 2018/6/8 21:10
     */
    public List<String> reverseAfterExpr(String[] expr) {
       /*定义Map用来存储操作符号优先级*/
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("*", 2);
        map.put("/", 2);
        map.put("+", 1);
        map.put("-", 1);
        for (int i = 0; i < expr.length; i++) {
            if (isNumber(expr[i])) {
                stringList.add(expr[i]);
            } else if (isOperand(expr[i])) {
                while (!containOperand.isEmpty() && isOperand(containOperand.peek()) && map.get(expr[i]) <= map.get(containOperand.peek())) {
                    stringList.add(containOperand.pop());
                }
                containOperand.push(expr[i]);
            } else if (isDivideNote(expr[i])) {
                if (expr[i].equals("(")) {
                    containOperand.push(expr[i]);
                } else {
                    while (!containOperand.isEmpty() && !containOperand.peek().equals("(")) {
                        stringList.add(containOperand.pop());
                    }
                    /*最后把"("也弹出去*/
                    if (!containOperand.isEmpty()) {
                        containOperand.pop();
                    }
                }
            }
        }
        /*如果还有元素，依次追加到List里*/
        while (!containOperand.isEmpty()) {
            stringList.add(containOperand.pop());
        }
        return stringList;
    }
}
