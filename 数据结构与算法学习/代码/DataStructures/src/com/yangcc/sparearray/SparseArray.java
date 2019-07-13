package com.yangcc.sparearray;

import java.awt.*;

// 稀疏数组
public class SparseArray {
    public static void main(String[] args) {
        // 先创建原始的二维数组  11*11
        // 0表示没有棋子  1表示黑子 2表示蓝色子
        int cheesArr1[][] = new int[11][11];
        cheesArr1[1][2] = 1;
        cheesArr1[2][3] = 2;
        cheesArr1[5][6] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : cheesArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转化为稀疏数组
        // 1.得到非0 数组的个数
        int sum = 0;
        for (int[] row : cheesArr1) {
            for (int a : row) {
                if (a != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        // 2.创建对应的稀疏数租
        int sparseArr[][] = new int[sum + 1][3];
        // 3.给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 4.遍历二维数组，将二维数组的值存入到稀疏数组当中
        int count = 0;// 用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (cheesArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = cheesArr1[i][j];
                }
            }
        }
        // 5.输出稀疏数组
        System.out.println("得到的稀疏数组");
        for (int[] arr : sparseArr) {
            for (int a : arr) {
                System.out.printf("%d\t", a);
            }
            System.out.println();
        }


        // 将稀疏数组恢复为原始数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 依次读取稀疏数组的行
        for (int i = 1; i <= sparseArr[0][2]; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int arr[] : chessArr2) {
            for (int a : arr) {
                System.out.printf("%d\t", a);
            }
            System.out.println();
        }

    }

}
