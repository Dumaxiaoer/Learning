package com.yangcc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        // 为了方便，表达式的数字和符号使用空格隔开
        String suffixExpression="3 4 + 5 * 6 -";
        // 1.先将suffix'Expression 放到ArrayList中
        // 2.将ArrayList 传递给一个方法，配合栈完成计算
        List<String> rpnList=getListString(suffixExpression);
        System.out.println("rpnList="+rpnList);

        int res =calculate(rpnList);
        System.out.println("计算的结果是="+res);

    }
    // 将逆波兰表达式，依次将数据和运算符，放入到ArrayList中
    public static List<String> getListString (String suffixExpression){
        // 将suffix分割
        String [] split =suffixExpression.split(" ");
        List<String > list =new ArrayList<String>();
        for (String ele:split){
            list.add(ele);
        }
        return  list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
        // 创建一个栈，只需要一个栈即可
        Stack<String> stack=new Stack<String>();
        // 遍历list
        for (String item :ls){
            // 使用正则表达式取出数
            if (item.matches("\\d+")){ // 匹配的是多位数
                // 入栈
                stack.push(item);
            }else {
                // 如果是运算符，则pop2个进行运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res =0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if (item.equals("-")){
                    res=num1-num2;
                }else if (item.equals("*")){
                    res=num1*num2;
                }else if (item.equals("*")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                // 把res入栈
                stack.push(""+res);
            }
        }
        // 最后留在stack中的数据为运算结果
        return  Integer.parseInt(stack.pop());
    }


}
