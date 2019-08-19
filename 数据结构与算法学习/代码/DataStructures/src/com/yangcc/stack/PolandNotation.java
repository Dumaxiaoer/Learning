
// 1.中缀表达式转后缀表达式
// 2.后缀表达式实现运算


package com.yangcc.stack;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转成后最表达式的功能
        // 说明
        // 1.将1+ ((2+3)*4 )-5  => 1 2 3 + 4 * + 5
        // 2.说明，将str转化为arrayList
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpression(expression);
        System.out.println("中缀对应list"+infixExpressionList);

        // 3.将得到的中缀表达式List转为后缀表达式List
        List<String >parseSuffixExpressionList=parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀对应表达式"+parseSuffixExpressionList);
        System.out.printf("expression=%d",calculate(parseSuffixExpressionList));
        // 先定义一个逆波兰表达式
        // 为了方便，表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        // 1.先将suffix'Expression 放到ArrayList中
        // 2.将ArrayList 传递给一个方法，配合栈完成计算
//        List<String> rpnList=getListString(suffixExpression);
//        System.out.println("rpnList="+rpnList);
//
//        int res =calculate(rpnList);
//        System.out.println("计算的结果是="+res);

    }

    // 中缀list转为后缀list
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<String>(); //符号栈
        // 因为s2再整个转换中无pop操作，因此比较麻烦，则改用为list替代
        List<String> s2 = new ArrayList<String>();
        // 遍历ls
        for (String item : ls) {
            // 如果是一个数，加入到list
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号，则依次弹出s1栈顶的运算符，并压入S2,直到遇到左括号为止
                while (!s1.peek().equals("(")) { //只要S1中没看到左括号
                    s2.add(s1.pop());
                }
                s1.pop();// 消除小括号
            } else {
                //当item的优先级小于或者等于栈顶运算符的优先级时，将s1栈顶的运算符弹出并加入到s2中，并再次转到（4.1）与S1中新的栈顶符号进行匹配
                // 缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 将当前扫描到的item压入到s1
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符依次弹出加入到S2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;//按顺序输出即为对应表达式
    }


    // 将中缀表达式转为对应的list
    public static List<String> toInfixExpression(String s) {
        List<String> ls = new ArrayList<String>();
        // 指针用于遍历s
        int i = 0;
        // 定义str，用于作为对多位数拼接
        String str;
        // 每遍历一个字符，就放入到c
        char c;
        do {
            // 如果c是一个非数字，则将其加入到ls中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);// 转成字符串并加入到集合
                i++;
            } else {  //是数字则拼接，考虑多位数
                // 先将string置为空字符串
                str = "";
                // 在这儿直接扫描，将符合条件的数据进行处理
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < s.length());
        return ls;
    }


    // 将逆波兰表达式，依次将数据和运算符，放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        // 将suffix分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(split));
        return list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        // 创建一个栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历list
        for (String item : ls) {
            // 使用正则表达式取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // 如果是运算符，则pop2个进行运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                // 把res入栈
                stack.push("" + res);
            }
        }
        // 最后留在stack中的数据为运算结果
        return Integer.parseInt(stack.pop());
    }

}

// 编写一个类，Operation ，可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 写一个方法，返回对应的优先级数字
    public static int getValue(String Operation) {
        int res = 0;
        switch (Operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return res;
    }


}
