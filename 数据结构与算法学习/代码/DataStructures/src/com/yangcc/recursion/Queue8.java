package com.yangcc.recursion;
// 八皇后问题

import java.util.concurrent.CountDownLatch;

/**
 * 该数组类似于
 * 1 2 3 4 5 6 7 8
 * 1 2 3 4 5 6 7 8
 * 1 2 3 4 5 6 7 8
 * 1 2 3 4 5 6 7 8
 * 1 2 3 4 5 6 7 8
 * 1 2 3 4 5 6 7 8
 * 1 2 3 4 5 6 7 8
 * 1 2 3 4 5 6 7 8
 */
// 纵向为1-n  横向为array[1]-array[n]

public class Queue8 {
    // 定义一个max表示共有多少个皇后
    int max =8;
    // 定义数组array，保存皇后放置位置的结果，
    int [] array =new int[max];
    static int count =0;
    public static void main(String[] args) {
        // 测试8皇后是否正确
        Queue8 queue8 =new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法",count);
    }

    // 编写一个方法 放置第n个皇后
    private void check(int n){
        if (n==8){   // 八个皇后已经放好了
            print();
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i=0;i<max;i++){
            // 先把当前这个皇后放在该行的第一列
            array[n]=i;/*注意：该赋值确定了数组值的范围   */
            // 判断当放置第n个皇后 到i列时，是否冲突，如果找到不冲突的，则调用本方法进行递归
            // 如果遍历完所有列全冲突，则回溯到上一行，继续遍历至不冲突为止，继续递归，直到满足放好的条件
            if (jugde(n)){   // 不冲突
                check(n+1);
            }
            // 如果冲突，则继续执行array[n]=i;即将第n个皇后放置再本行的后一个位置
        }
    }
    // 查看当我们放置第n个皇后，就去检查该皇后是否和前面已经摆放的皇后冲突
    private boolean jugde (int n){   // n表示放置的第n个皇后
        for (int i=0;i<n;i++){
            // 1.array[i]==array[n]  表示第n个和第i个皇后是否是同一列
            // 2.Math.abs(n-i)==Math.abs(array[n]-array[i])  是否同一斜线
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){  // 同一列 与同一斜线
                return  false;
            }
        }
        return  true;
    }


    // 将皇后摆放的位置打印出来
    private void print(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();
    }
}
