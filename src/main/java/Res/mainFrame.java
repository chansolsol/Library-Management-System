package Res;

import Pages.LoginPage;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame {
    public mainFrame(){

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        setTitle("Library Management System");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        setBackground(Color.white);

        java.awt.Font mainFont50 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 50);   //폰트 설정
        java.awt.Font mainFont40 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 40);
        java.awt.Font mainFont30 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 30);
        java.awt.Font mainFont20 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 20);
        java.awt.Font inputBoxFont = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD,25);

        Color mainBlue = new Color(1, 108, 205);

        JPanel panelMainBlue = new JPanel();
        panelMainBlue.setBounds(0, 0, 1280, 80);
        panelMainBlue.setBackground(mainBlue);
        add(panelMainBlue);

        JLabel labelMain = new JLabel("도서관 시스템");
        labelMain.setBounds(382, 0, 500, 90);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont50);
        labelMain.setForeground(Color.white);
        panelMainBlue.add(labelMain);



        LoginPage LP = new LoginPage();
        add(LP);

    }

}
