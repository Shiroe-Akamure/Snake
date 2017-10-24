package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

  JFrame obj= new JFRame();
  Gameplay gameplay=new Gameplay();


      obj.setBounds(10, 10, 990, 655);
      obj.setBackground(Color.DARK_GRAY);
      obj.setResizable(false);
      obj.setVisible(true);
      obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      obj.add(gameplay);



    }
}