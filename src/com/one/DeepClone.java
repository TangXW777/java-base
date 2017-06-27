package com.one;

import java.io.*;

/**
 * Created by TangXW on 2017/6/27.
 */
// 深克隆必须实现Serializable接口
public class DeepClone implements Serializable{
    private int a;
    private String b;
    private int[] c;

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public int[] getC() {
        return c;
    }
    public void setC(int[] c) {
        this.c = c;
    }

    // 用序列化和发序列化实现深克隆
    public static Object deepClone(Object src){
        Object o = null;
        try{
            if(src != null){
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(src);
                oos.close();
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                o = ois.readObject();
                ois.close();
            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return o;
    }

    public static void main(String[] args) {
        DeepClone dc1 = new DeepClone();
        // 对dc1赋值
        dc1.setA(100);
        dc1.setB("clone1");
        dc1.setC(new int[] { 1000 });
        System.out.println("克隆前: dc1.a=" + dc1.getA());
        System.out.println("克隆前: dc1.b=" + dc1.getB());
        System.out.println("克隆前: dc1.c[0]=" + dc1.getC()[0]);
        System.out.println("-----------");
        DeepClone dc2 = (DeepClone) deepClone(dc1);
        // 对c2进行修改
        dc2.setA(50);
        dc2.setB("clone2");
        int[] a = dc2.getC();
        a[0] = 500;
        dc2.setC(a);
        System.out.println("克隆修改前: dc1.a=" + dc1.getA());
        System.out.println("克隆修改前: dc1.b=" + dc1.getB());
        System.out.println("克隆修改前: dc1.c[0]=" + dc1.getC()[0]);
        System.out.println("-----------");
        System.out.println("克隆后: dc2.a=" + dc2.getA());
        System.out.println("克隆后: dc2.b=" + dc2.getB());
        System.out.println("克隆后: dc2.c[0]=" + dc2.getC()[0]);
    }
}
