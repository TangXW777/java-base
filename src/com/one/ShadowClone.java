package com.one;

/**
 * Created by TangXW on 2017/6/27.
 */
public class ShadowClone implements Cloneable{
    // 基本类型
    private int a;
    // 非基本类型
    private String b;
    // 非基本类型
    private int[] c;

    @Override
    public Object clone(){
        ShadowClone sc = null;
        try{
            sc = (ShadowClone)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return sc;
    }
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

    // 测试
    public static void main(String[] args) throws CloneNotSupportedException{
        ShadowClone c1 = new ShadowClone();
        c1.setA(100) ;
        c1.setB("clone1") ;
        c1.setC(new int[]{1000}) ;

        System.out.println("克隆前: c1.a="+c1.getA() );
        System.out.println("克隆前: c1.b="+c1.getB() );
        System.out.println("克隆前: c1.c[0]="+c1.getC()[0]);
        System.out.println("-----------") ;

        // 克隆对象c2,并对c2的属性A,B,C进行修改
        ShadowClone c2 = (ShadowClone) c1.clone();
        // 对c2进行修改
        c2.setA(50) ;
        c2.setB("clone2");
        int []a = c2.getC() ;
        a[0]=500 ;
        c2.setC(a);

        System.out.println("克隆修改后: c1.a="+c1.getA() );
        System.out.println("克隆修改后: c1.b="+c1.getB() );
        System.out.println("克隆修改后: c1.c[0]="+c1.getC()[0]);
        System.out.println("---------------") ;

        System.out.println("克隆后: c2.a=" + c2.getA());
        System.out.println("克隆后: c2.b=" + c2.getB());
        System.out.println("克隆后: c2.c[0]=" + c2.getC()[0]);
    }
}
