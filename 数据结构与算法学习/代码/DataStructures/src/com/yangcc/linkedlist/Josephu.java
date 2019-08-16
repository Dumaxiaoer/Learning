package com.yangcc.linkedlist;

import java.nio.file.FileStore;

public class Josephu {
    public static void main(String[] args) {
        // 测试
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        // 加入5个节点
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        // 出圈测试
        circleSingleLinkedList.countBoy(1,2,5);
    }

}
// 创建环形单链表
class CircleSingleLinkedList{
    // 创建头节点 当前无编号
    private Boy first=null;
    // 添加节点，构建环形链表,nums代表加几个节点
    public void addBoy(int nums){
        // 校验 nums
        if (nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;//辅助节点
        for(int i=1;i<=nums;i++){
            //根据编号，创建小孩节点
            Boy boy=new Boy(i);
            // 如果是第一个
            if (i==1){
                first=boy;
                first.next=first;
                curBoy=first;
            }else{
                curBoy.next=boy;
                boy.next=first;
                curBoy=curBoy.next;
            }
        }
    }
    /*

     */
    // 遍历环形链表
    public  void showBoy(){
        // 判断链表是否为空
        if (first==null){
            System.out.println("链表为空");
            return;
        }
        // 辅助指针
        Boy curBoy=first;
        while (true){
            System.out.printf("小孩的编号 %d \n",curBoy.no);
            if (curBoy.next==first){//遍历完毕
                break;
            }
            curBoy=curBoy.next;
        }
    }
    // 出队列  根据用户的输入，计算出出圈的顺序
    /*
        startNo 表示从第几个开始数
        countNum 表示数几下
        nums 表示有几个小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        // 先对数据进行校验
        if (first==null||startNo<1||startNo>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 辅助节点
        Boy helper=first;
        // 创建一个helper，事先指向环形链表最后节点
        while (true){
            if (helper.next==first){ //最后小孩节点
                break;
            }
            helper=helper.next;
        }
        // 移动 k-1次，到k
        for (int i=1;i<startNo;i++){
            first=first.next;
            helper=helper.next;
        }
        // 报数 循环操作 直到圈中只有一个节点
        while (first!=helper){
            // 先移动报的数值-1次
            for (int j =1;j<countNum;j++){
                first=first.next;
                helper=helper.next;
            }
            // 出队列
            System.out.printf("小孩%d出圈\n",first.no);
            helper.next=first.next;
            first=first.next;
            // 方法2
            // first=first.next;
            // helper.next=first;
        }
        System.out.printf("最后留在圈中的小孩编号%d \n",first.no);
    }
}



// 先创建一个boy类，表示一个节点
class Boy{
    public   int no;
    public Boy next;
    //构造方法
    public Boy(int no){
        this.no=no;
    }

}