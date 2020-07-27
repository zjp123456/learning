package datastructor;

import java.util.LinkedList;

public class MySingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList l=new SingleLinkedList();
        HeroNode h1=new HeroNode(1,"林冲","豹子头");
        HeroNode h2=new HeroNode(5,"宋江","及时雨");
        HeroNode h3=new HeroNode(7,"吴用","玉麒麟");
        HeroNode h4=new HeroNode(10,"鲁智深","花和尚");

        l.add2(h3);
        l.add2(h2);
        l.add2(h1);
        l.add2(h4);


        SingleLinkedList r=new SingleLinkedList();
        HeroNode h5=new HeroNode(2,"林冲","豹子头");
        HeroNode h6=new HeroNode(3,"宋江","及时雨");
        HeroNode h7=new HeroNode(4,"吴用","玉麒麟");
        HeroNode h8=new HeroNode(5,"鲁智深","花和尚");

        r.add2(h5);
        r.add2(h6);
        r.add2(h7);
        r.add2(h8);


        SingleLinkedList.mergeListByOrdered(l,r);
        l.list();


//        HeroNode h5=new HeroNode(1,"鲁智深1","花和尚1");
//        l.update(h5);
//        l.delete(h5);


//        l.list();
//        SingleLinkedList.reverse(l);
//        l.list();

//        System.out.println("-----------------");
//        l.reversePrint();
    }

}



class SingleLinkedList{
    private HeroNode head=new HeroNode(-1,null,null);


    public void add(HeroNode hero){
        HeroNode tmp=head;
        while(true){
            if(tmp.next==null){
                tmp.next=hero;
                break;
            }else{
                tmp=tmp.next;
            }
        }

    }

    // 头插法
    public static  void reverse(SingleLinkedList list){
        HeroNode cur=list.head.next;
        HeroNode reverseHead=new HeroNode(-1,null,null);
        HeroNode next=null;
        System.out.println("---------------");
        while(cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        list.head.next=reverseHead.next;
    }


    // 头插法
    public static  SingleLinkedList mergeListByOrdered(SingleLinkedList l,SingleLinkedList r){
        if (l.head.next==null && r.head.next==null){
            System.out.println("传入的链表为空");
            return null;
        }
        if (l.head.next==null && r.head.next!=null){
            return r;
        }

        if (l.head.next!=null && r.head.next==null){
            return l;
        }

        HeroNode newHead=new HeroNode(-1,null,null);
        HeroNode lCur=l.head.next;
        HeroNode rCur=r.head.next;

        HeroNode lastNewNode=null;
        int i=0;
        HeroNode lNext=null;
        HeroNode rNext=null;
        while(lCur!=null || rCur!=null){
            if(lCur!=null){
                lNext=lCur.next;
            }
            if (rCur!=null){
                rNext=rCur.next;
            }
            if (lCur!=null && rCur!=null){
                HeroNode minNode=null;
                if(lCur.no<rCur.no){
                    minNode=lCur;
                    lCur=lNext;
                }else{
                    minNode=rCur;
                    rCur=rNext;
                }
                System.out.println(minNode.no);
                if(i==0){ // 首次对比，是把当前第一个最小的节点加到新链表的头节点的后一个
                    lastNewNode=minNode;
                    newHead.next=lastNewNode;
                    i++;
                }else{  //后续的每次迭代都是将最小的节点放到最后一个节点的后面，并把最后一个节点后移
                    lastNewNode.next=minNode;
                    lastNewNode=lastNewNode.next;
                }

            }else if(lCur==null && rCur!=null){
                lastNewNode.next=rCur;
                break;
            }else if(lCur!=null && rCur==null){
                lastNewNode.next=lCur;
                break;
            }
        }
        l.head=newHead;
        return l;
    }

    public void add2(HeroNode hero){
        HeroNode tmp=head;
        while(true){
            if(tmp.next==null){
                tmp.next=hero;
                break;
            }else if(tmp.no==hero.no){
                System.out.println("该编号的英雄已经存在");
                System.out.println(tmp+"->"+hero);
                break;
            }else if(tmp.no<hero.no && tmp.next.no>hero.no){
                hero.next=tmp.next;
                tmp.next=hero;
                break;
            }
            else{
                tmp=tmp.next;
            }
        }
    }

    public void delete(HeroNode hero){
        HeroNode tmp=head;
        while(tmp.next!=null){
            if(tmp.next.no==hero.no){
                tmp.next=tmp.next.next;
                return ;
            }else{
                tmp=tmp.next;
            }
        }
        System.out.println("未找到编号为:"+hero.no+"的英雄");
    }


    public void update(HeroNode hero){
        HeroNode oldNode=findHeryById(hero.no);
        if (oldNode!=null){
            oldNode.name=hero.name;
            oldNode.nickName=hero.nickName;
        }else{
            System.out.println("没有编号为:"+hero.no+"的英雄存在");
        }
    }

    private HeroNode findHeryById(int no) {
        HeroNode tmp=head;
        while(tmp!=null){
            if(tmp.no==no){
                return tmp;
            }else{
                tmp=tmp.next;
            }
        }
        return null;
    }


    public void list(){
        HeroNode tmp=head.next;
        while(tmp!=null){
            System.out.println(tmp);
            tmp=tmp.next;
        }
    }

    public void reversePrint(){
        reversePrint(head);
    }

    public void reversePrint(HeroNode node){
        if(node!=null){
            reversePrint(node.next);
        }
        if(node!=null && node.no>0){
            System.out.println(node);
        }



    }



}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int hNo,String hName,String hNickName){
        this.no=hNo;
        this.name=hName;
        this.nickName=hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}