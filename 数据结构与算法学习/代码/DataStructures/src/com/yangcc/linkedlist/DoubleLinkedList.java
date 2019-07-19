package com.yangcc.linkedlist;

import org.w3c.dom.NodeList;

import java.util.concurrent.RecursiveTask;

public class DoubleLinkedList {
    public static void main(String[] args) {

    }


}

class DoubleLinkedListManager{
    private HeroNode2 head=new HeroNode2(0,"","");
    // 返回头节点
    public HeroNode2 getHead(){
        return head;
    }
    // 1.遍历链表
    public  void list (){
        HeroNode2 temp=head.next;
        if (temp==null){
            System.out.println("链表为空");
        }
        while (temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }
    // 2.普通添加
    public void add(HeroNode2 node){
        HeroNode2 temp=head;
        while (temp.next!=null){
            if(temp.next.no==node.no){
                System.out.println("已存在该节点，不能添加");
                return;
            }
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }
    // 3.顺序添加
    public  void addByOrder(HeroNode2 node){
        HeroNode2 temp =head;
        while (temp.next!=null){
            if (temp.next.no>node.no){
                break;
            }else if(temp.next.no==node.no){
                System.out.println("节点号："+node.no+"已存在，不能新增该节点");
                return;
            }
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next.pre=node;
        temp.next= node;
        node.pre=temp;
    }

    // 修改



    // 删除节点 找到后，删除即可
    public void del(int no){
        if (head.next==null){
            System.out.println("空链表");
            return;
        }
        HeroNode2 temp=head;
        while (true){
            if (temp==null){ //一直未找到节点
                System.out.println("未找到节点");
                return;
            }
            // 找到节点
            if(temp.no==no){
                break;
            }
            temp=temp.next;
        }
        temp.pre.next=temp.next;
        if (temp.next!=null){ // 如果是最后一个节点则不应该删除，否则出现空指针异常
            temp.next.pre=temp.pre;
        }

    }


}


class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    // 构造器
    public HeroNode2(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}