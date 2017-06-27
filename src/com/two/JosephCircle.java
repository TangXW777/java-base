package com.two;

/**
 * Created by TangXW on 2017/6/27.
 */
public class JosephCircle {
    public void josephCircle(int n, int k){
        int flag = 0;
        boolean[] kick = new boolean[n];  // 初始值都为false

        int counter = 0;
        int accumulate = 0;
        while (true){
            if(!kick[flag]){  // 如果这个人还在环中，没被踢出
                accumulate++;
                if(counter == n - 1){ // 如果是最后一个人
                    System.out.println("the last kick person ===" + (flag + 1));
                    break;
                }
                if(accumulate == k){  // 如果是3，则踢出
                    kick[flag] = true;
                    System.out.println("the kick person ===" + (flag + 1));
                    accumulate = 0; // 重置
                    counter++;  // 踢出人数+1
                }
            }
            flag = (flag + 1) % n;
        }
    }

    public static void main(String[] args) {
        JosephCircle j = new JosephCircle();
        j.josephCircle(20, 3);
    }
}