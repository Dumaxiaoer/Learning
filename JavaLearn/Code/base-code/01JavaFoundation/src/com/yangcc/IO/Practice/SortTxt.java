package com.yangcc.IO.Practice;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.HashMap;

public class SortTxt {
    public static void main(String[] args) throws IOException {
        //sortTxt();
        test();
    }

    private static void  sortTxt() throws IOException {
        // 创建hashMap
        HashMap<String,String> map=new HashMap<>();
        // 输入流
        BufferedReader br=new BufferedReader(new FileReader("D:\\myfile\\test02\\sort.txt"));
        // 输出
        BufferedWriter bw =new BufferedWriter(new FileWriter("D:\\myfile\\test02\\sortOver.txt"));
        // 逐行读取
        String line ;
//        char [] cs=new char[30];
//        br.read(cs);
//        System.out.println(cs);
//
        while ((line=br.readLine())!=null){
            String [] arr=line.split("\\.");
            map.put(arr[0],arr[1]);
        }

        // 遍历
        for (String  key:map.keySet()){
            String value =map.get(key);
            line =key +"."+value;
            // 写入
            bw.write(line);
            bw.newLine();// 写入换行
        }
        bw.close();
    }
    private static void test() throws IOException {
        FileReader fr=new FileReader("D:\\myfile\\test\\b.txt");
        int len =0;
        while ((len=fr.read())!=-1){
            System.out.println(len+"="+(char)len);
        }
    }
}
