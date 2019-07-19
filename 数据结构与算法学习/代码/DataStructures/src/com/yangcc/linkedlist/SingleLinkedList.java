package com.yangcc.linkedlist;

import java.time.temporal.Temporal;
import java.util.Stack;

public class SingleLinkedList {

    public static void main(String[] args) {
        // 进行测试
        // 先创建结点
        HeroNode heroNode1=new HeroNode(1,"宋琴","小女孩");
        HeroNode heroNode2=new HeroNode(2,"张涵","slime");
        HeroNode heroNode3=new HeroNode(3,"丁银","丁根");
        HeroNode heroNode4=new HeroNode(4,"无名","天剑");
        HeroNode heroNode5=new HeroNode(5,"步惊云","霸剑");
        // 创建单向链表
        SingleLinkedListManager singleLinkedListManager =new SingleLinkedListManager();
        // 加入
        singleLinkedListManager.add(heroNode1);
        singleLinkedListManager.add(heroNode2);
        singleLinkedListManager.add(heroNode3);
        singleLinkedListManager.add(heroNode4);
        singleLinkedListManager.add(heroNode5);
        System.out.println("有效的链表个数"+getLength(singleLinkedListManager.getHead()));
        singleLinkedListManager.list();
        // 测试反转链表
//        System.out.println("-------------------------------------");
//        singleLinkedListManager.changeHead(reverseNode(singleLinkedListManager.getHead()));
//        singleLinkedListManager.list();
        // 测试逆序打印单链表
        System.out.println("测试逆序打印单链表");
        reversePrint(singleLinkedListManager.getHead());

    }
    // ------面试题方法-------
    // 1.获取到单链表有效节点的个数（不统计头节点）
    /*
        head 链表的头节点
        return 返回的就是有效节点个数
     */
    public static int getLength(HeroNode head){
        if (head.next==null){
            return 0;
        }
        int length=0;
        HeroNode cur=head.next;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }

    // 2.查找单链表的倒数第k个节点
    /*
    思路：
     */
    public  static  HeroNode findLastIndexNode(HeroNode head,int index){
        // 链表未空 返回nul
        if (head.next==null){
            return null;
        }
        int size =getLength(head);
        // 第二次遍历
        // 校验
        if(index<=0||index>=size){
            return null;
        }
        // 定义辅助变量
        HeroNode cur =head.next;
        for(int i=0;i<=size-index;i++){
            cur=cur.next;
        }
        return cur;
    };

    // 3.实现单链表的反转(自己做)
    public static HeroNode reverseNode(HeroNode node){
        // 旧链表的temp
        HeroNode temp=node.next;
        // 新链表头节点
        HeroNode reverseNode = new HeroNode(0,"","");
        // 新链表虚拟temp
        HeroNode newTemp=null;
        int i=0;
        // 遍历旧链表，如果不为空，则将节点加到新链表头节点和头节点的next之间
        while (temp!=null){
//            newTemp=temp;
//            newTemp.next=reverseNode.next;
//            reverseNode.next=newTemp;
            /*
                newTemp发生变化，temp也会发生变化
             */
            newTemp=temp.next;
            temp.next=reverseNode.next;
            reverseNode.next=temp;
            temp=newTemp;
        }

        return reverseNode;
    }

    // 3.1 将单链表进行反转
    public static void reverseList(HeroNode head){
        // 如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next==null|| head.next.next==null){
            return;
        }
        // 定义一个辅助指针。帮助遍历原来链表
        HeroNode cur =head.next;
        HeroNode next =null;// 指向当前节点的下一个节点
        HeroNode reverseHead =new HeroNode(0,"","");
        // 遍历原来链表，每遍历一个，将起去除并放在新的链表中
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;//将cur的下一个节点指向链表最前端
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }

    // 4 从尾到头打印链表
    // 方式一：先将单链表进行反转，再遍历（问题是会破坏原来的单链表结构，不可取）
    // 方式二：利用栈这个数据结构，将各个节点压入到栈中，利用栈的先进后出的特点就实现逆序打印效果
    public static  void reversePrint(HeroNode head){
        if (head.next==null){
            return;
        }
        // 创意一个栈，将各个节点压入栈中
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode cur=head.next;
        // 循环将链表所有节点压入栈中
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());// stack特点是先进后出
        }
    }


}
// 定义SingleLinkedList 管理HeroNode
class SingleLinkedListManager{
    // 先初始化一个头结点 不能动 且不存放具体的数据
    private  HeroNode head =new HeroNode(0,"","");
    // 获取链表
    public  HeroNode getHead(){
        return head;
    }

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
    // 第二种顺序添加
    public void addByOrder(HeroNode heroNode){
        // head头节点不能动，需要通过辅助指针来遍历
        // 因为是单链表，因此temp是位于添加位置前一个节点
        HeroNode temp =head;
        boolean flag =false;// 标识添加的编号是否存在
        while (true){
            if(temp.next==null){  //已经位于最后一个节点了
                break;
            };
            if(temp.next.no>heroNode.no){ //位置找到，就在
                break;
            }else if(temp.next.no==heroNode.no){// 说明编号存在
                flag=true;
                break;
            }
            temp= temp.next; // 后移，相当于遍历当前链表

        }
        // 判断flag的值
        if(flag){
            // 不能添加，编号已存在
            System.out.println("不能添加");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }
    // 删除节点
    public void delNode(HeroNode node){
        // 虚拟头节点
        HeroNode temp=head;
        // 表示
        boolean flag=false;
        while (true){
            // 没有找到要删除的节点
            if (temp.next==null){
                flag=true;
                break;
            }
            // 如果相等 找到节点
            if(temp.next.no==node.no){
                break;
            }
            temp=temp.next;
        }

        if (flag){
            System.out.println(node.no+"未找到");
        }else {
            temp.next=temp.next.next;
        }

    }


    // 显示链表
    public void  list(){
        // 判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
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

    // 改变头节点
    public void changeHead(HeroNode node){
        head=node;
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