package datastructor;

public class MyDoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList l=new DoubleLinkedList();
        HeroNode2 h1=new HeroNode2(1,"林冲","豹子头");
        HeroNode2 h2=new HeroNode2(5,"宋江","及时雨");
        HeroNode2 h3=new HeroNode2(7,"吴用","玉麒麟");
        HeroNode2 h4=new HeroNode2(10,"鲁智深","花和尚");

        l.add2(h4);
        l.add2(h2);
        l.add2(h1);
        l.add2(h3);


        l.list();

        HeroNode2 h5=new HeroNode2(10,"张三","校长");
        l.update(h5);
        System.out.println("-----");
        l.list();

        l.delete(h1);
        System.out.println("-----");
        l.list();



    }

}


class DoubleLinkedList{
    private HeroNode2 head=new HeroNode2(-1,null,null);


    public void add(HeroNode2 hero){
        HeroNode2 tmp=head;
        while(true){
            if(tmp.next==null){
                tmp.next=hero;
                hero.pre=tmp;
                break;
            }else{
                tmp=tmp.next;
            }
        }

    }


    public void add2(HeroNode2 hero){
        HeroNode2 tmp=head;
        while(true){
            if(tmp.next==null){
                tmp.next=hero;
                hero.pre=tmp;
                break;
            }else if(tmp.no==hero.no){
                System.out.println("该编号的英雄已经存在");
                System.out.println(tmp+"->"+hero);
                break;
            }else if(tmp.no<hero.no && tmp.next.no>hero.no){
                HeroNode2 next=tmp.next;
                tmp.next=hero;
                hero.pre=tmp;

                hero.next=next;
                next.pre=tmp;

                break;
            }
            else{
                tmp=tmp.next;
            }
        }
    }

    public void delete(HeroNode2 hero){
        HeroNode2 tmp=head.next;
        while(tmp!=null){
            if(tmp.no==hero.no){
                tmp.pre.next=tmp.next;
                if(tmp.next!=null){
                    tmp.next.pre=tmp.pre;
                }
                return ;
            }else{
                tmp=tmp.next;
            }
        }
        System.out.println("未找到编号为:"+hero.no+"的英雄");
    }


    public void update(HeroNode2 hero){
        HeroNode2 oldNode=findHeryById(hero.no);
        if (oldNode!=null){
            oldNode.name=hero.name;
            oldNode.nickName=hero.nickName;
        }else{
            System.out.println("没有编号为:"+hero.no+"的英雄存在");
        }
    }

    private HeroNode2 findHeryById(int no) {
        HeroNode2 tmp=head;
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
        HeroNode2 tmp=head.next;
        while(tmp!=null){
            System.out.println(tmp);
            tmp=tmp.next;
        }
    }




}

class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int hNo,String hName,String hNickName){
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