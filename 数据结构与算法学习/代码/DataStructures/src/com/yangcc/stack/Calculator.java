package com.yangcc.stack;

public class Calculator {
    public static void main(String[] args) {
        // 根据思路完成表达式的运算
        String expression = "30+2*16-26";
        // 先创建2个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0;// 用于扫描
        int num1;
        int num2;
        int oper = 0;
        int res = 0;
        char ch = ' ';// 将每次扫描得到的char保存到ch
        String keepNum="";// 用于拼接多位数
        // 开始while循环的扫描expression
        while (true) {
            // 依次得到expression每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) {
                // 判断当前的符号栈是否为空,为空直接入栈
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    // 不为空 ，则进行比较，如果当前操作符优先级小于或者等于栈中操作符，需要从栈中pop出两个数，
                    // 从符号栈中pop出一个符号，进行运算，将得到的结果入数栈，并且将当前的符号入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 把运算的结果入数栈
                        numStack.push(res);
                        // 将当前的操作符入符号站
                        operStack.push(ch);
                    } else {  // 优先级大于前者，直接入符号栈
                        operStack.push(ch);
                    }
                }
            } else {
                // 如果是数，直接入数栈（因为扫描到的是字符，字符数字与真实数字相差48）
                // numStack.push(ch - 48);  不能直接入数栈，因为可能是多位数
                // 因此，在处理数时，需要向expression表达式的index后再看一位，如果是数就继续扫描，如果是符号，就入符号站
                // 因为定一个字符串变量进行拼接
                keepNum+=ch;
                // 如果ch是最后一位，直接入栈
                if (index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    // 判断下一个字符是否为数字，如果为数字则继续扫描，运算符则入栈
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        // 如果后一位是运算符，入栈
                        numStack.push(Integer.parseInt(keepNum));
                        // 重要！！！！，将keepNum清空
                        keepNum="";
                    }
                }
            }
            // 让index+1 并判断是否扫描到最后
            index++;
            if (index >= expression.length()) {
                // 到最后了
                break;
            }
        }
        // 当表达式扫描完毕，就顺序从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            // 如果符号栈为空，则计算到最后的结果，数栈中只有一个数值
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        // 将数栈的最后一个数pop出来
        System.out.printf("表达式%s =%d", expression, numStack.pop());

    }
}

// 先创建一个栈   复制上一个，并扩展功能
class ArrayStack2 {
    private int maxSize;
    private int[] stack;//数组模拟栈，数据放在该数组中
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 返回当前栈顶的值
    public int peek() {
        return stack[top];
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了，无法再存放数据");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            // 因为有返回值，所以这儿用抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        // 先取得栈顶的值
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈  从栈顶往下遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    // 功能扩展1，返回运算符的优先级，由编码人确定，优先级使用数字表示，数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    // 判断是否时运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;// 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }
}