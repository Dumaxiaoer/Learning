package com.yangcc.linkedlist;

public class SingleLinkedList {

    public static void main(String[] args) {
        // 进行测试
        // 先创建结点
        HeroNode heroNode1=new HeroNode(1,"宋琴","小女孩");
        HeroNode heroNode2=new HeroNode(2,"张涵","slime");
        HeroNode heroNode3=new HeroNode(3,"丁银","丁根");
        // 创建单向链表
        SingleLinkedListManager singleLinkedListManager =new SingleLinkedListManager();
        // 加入
        singleLinkedListManager.add(heroNode1);
        singleLinkedListManager.add(heroNode2);
        singleLinkedListManager.add(heroNode3);
        singleLinkedListManager.list();
    }


}
// 定义SingleLinkedList 管理HeroNode
class SingleLinkedListManager{
    // 先初始化一个头结点 不能动 且不存放具体的数据
    private  HeroNode head =new HeroNode(0,"","");
    // 添加结点到单向链表
    // 思路：不考虑编号顺序时
    // 1.找到当前链表的最后结点
    // 2.将最后结点的next 指向新的结点
    public  void  add (HeroNode heroNode){
        // 辅助变量遍历temp
        HeroNode temp =head;
        // 遍历链表 找到最后
        while (true){
            if (temp.next==null){
                break;
            }
            // 没有找到 就将temp后移
            temp=temp.next;
        }
        // 退出循环时，temp指向了最后
        temp.next=heroNode;
    }
    // 显示链表
    public void  list(){
        // 判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //
        HeroNode temp =head.next;
        while (true){
            if (temp ==null){
                break;
            }
            // 输出结点信息
            System.out.println(temp);
            // 将next后移
            temp=temp.next;
        }
    }
}

// 定义node，每个node对象就是一个结点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    // 构造器
    public HeroNode(int no,String name,String nickname ){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }


}