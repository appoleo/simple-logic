package com.ami.study.awt;

import java.awt.*;

/**
 * @author wangchendong
 * @date 2021/08/17
 */
public class DrawFrame extends Frame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DrawFrame fr = new DrawFrame("First container!!");
        fr.setSize(240, 240);    // 设置Frame的大小
        fr.setBackground(Color.yellow);      // 设置Frame的背景色
        fr.setVisible(true);         // 设置Frame为可见

    }

    public DrawFrame(String str) {
        super(str); // 调用父类的构造方法
    }
}
