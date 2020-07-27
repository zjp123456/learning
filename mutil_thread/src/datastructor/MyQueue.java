package datastructor;

import java.util.Scanner;

public class MyQueue {
    //头指针
    public int front=0;
    //尾指针
    public int tail=0;
    //队列的大小，实际能存储的大小为maxSize-1
    public int maxSize;

    public int[]  container;
    public MyQueue(int maxSize){
        this.maxSize=maxSize;
        this.container=new int[maxSize];
    }


    public boolean put(int num){
        if(!this.isFull()){
            container[tail]=num;
            tail=(tail+1)%maxSize;
            return true;
        }
        System.out.println("队列已满");
        return false;
    }

    private boolean isFull() {
        // 简单队列
        //return this.tail==maxSize-1;
        //环形队列
        return (this.tail+1)%maxSize==front;
    }

    public int getSize(){
        return (tail-front+maxSize)%maxSize;
    }

    public int get(){
        if(!isEmpty()){
            int val=container[this.front];
            this.front=(this.front+1)%maxSize;
            return val;
        }else{
            throw new RuntimeException("队列数据为空");
        }

    }


    public void showHead(){
        if(!isEmpty()){
            System.out.println(this.container[front]);
        }else{
            throw new RuntimeException("队列数据为空");
        }

    }

    public void showQueue(){
        for(int i=front;i<front+getSize();i++){
            System.out.print(this.container[i%maxSize]+"\t");
        }
    }

    public boolean isEmpty(){
        //简单队列，环形队列的判断空的方法都是这样
        return this.front==this.tail;
    }

    public static void printHelp(){
        System.out.println("输入's' 查看队列");
        System.out.println("输入'a' 添加队列元素");
        System.out.println("输入'g' 从队列中获取元素");
        System.out.println("输入'h' 查看队列头部元素");
        System.out.println("输入'e' 退出程序");
    }

    public static void main(String[] args) {
        MyQueue q=new MyQueue(4);

        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        printHelp();
        while(loop){

            char c= scanner.next().charAt(0);
            switch (c){
                case 's':
                    q.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入入队数字:");
                    int n=scanner.nextInt();
                    q.put(n);
                    break;
                case 'g':
                    try{
                        System.out.println(q.get());
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                case 'h':
                    try{
                        q.showHead();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'l':
                    try{
                        System.out.println(q.getSize());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("退出程序");
                    scanner.close();
                    loop=false;
                    break;
                default:
                    printHelp();
                    break;
            }

        }

    }





}
