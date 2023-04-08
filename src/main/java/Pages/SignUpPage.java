package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import Res.*;



public class SignUpPage extends JFrame implements ActionListener {


    public SignUpPage() {

        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        setTitle("Library Management System : SignUp");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        java.awt.Font mainFont50 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 50);   //폰트 설정
        java.awt.Font mainFont40 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 40);
        java.awt.Font mainFont30 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 30);
        java.awt.Font mainFont20 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 20);
        java.awt.Font inputBoxFont = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD,20);

        Color mainBlue = new Color(1, 108, 205);

        JPanel panelMainBlue1 = new JPanel();
        panelMainBlue1.setBounds(0, 0, 1280, 80);
        panelMainBlue1.setBackground(mainBlue);
        add(panelMainBlue1);

        JLabel labelMain1 = new JLabel("도서관 시스템");
        labelMain1.setBounds(382, 0, 500, 80);
        labelMain1.setHorizontalAlignment(JLabel.CENTER);
        labelMain1.setFont(mainFont50);
        labelMain1.setForeground(Color.white);
        panelMainBlue1.add(labelMain1);

        JPanel panelSignUpBlue = new JPanel();
        panelSignUpBlue.setBounds(355, 200, 570, 320);
        panelSignUpBlue.setBackground(mainBlue);
        add(panelSignUpBlue);
        panelSignUpBlue.setLayout(null);

        JPanel panelSignUpWhite = new JPanel();
        panelSignUpWhite.setBounds(6, 8, 558, 304);
        panelSignUpWhite.setBackground(Color.white);
        panelSignUpBlue.add(panelSignUpWhite);
        panelSignUpWhite.setLayout(null);

        JLabel labelSignUp = new JLabel("회원 가입");
        labelSignUp.setBounds(169, 20, 220, 50);
        labelSignUp.setHorizontalAlignment(JLabel.CENTER);
        labelSignUp.setFont(mainFont40);
        panelSignUpWhite.add(labelSignUp);

        JLabel labelID = new JLabel("아이디");
        labelID.setBounds(60, 75, 120, 35);
        labelID.setHorizontalAlignment(JLabel.CENTER);
        labelID.setFont(mainFont20);
        panelSignUpWhite.add(labelID);

        JLabel labelPW = new JLabel("비밀번호");
        labelPW.setBounds(60, 130, 120, 35);
        labelPW.setHorizontalAlignment(JLabel.CENTER);
        labelPW.setFont(mainFont20);
        panelSignUpWhite.add(labelPW);

        JLabel labelName = new JLabel("이름");
        labelName.setBounds(60, 185, 120, 35);
        labelName.setHorizontalAlignment(JLabel.CENTER);
        labelName.setFont(mainFont20);
        panelSignUpWhite.add(labelName);

        JTextField textID = new JTextField();
        textID.setBounds(185,75,200,35);
        textID.setFont(inputBoxFont);
        textID.setBorder(null);
        textID.setLayout(null);
        panelSignUpWhite.add(textID);

        JPanel panelIDLine = new JPanel();
        panelIDLine.setBounds(180, 115, 210, 2);
        panelIDLine.setBackground(mainBlue);
        panelSignUpWhite.add(panelIDLine);

        JPasswordField textPassword = new JPasswordField();
        textPassword.setBounds(185,130,200,35);
        textPassword.setFont(inputBoxFont);
        textPassword.setBorder(null);
        textPassword.setLayout(null);
        panelSignUpWhite.add(textPassword);

        JPanel panelPasswordLine = new JPanel();
        panelPasswordLine.setBounds(180, 170, 210, 2);
        panelPasswordLine.setBackground(mainBlue);
        panelSignUpWhite.add(panelPasswordLine);

        JTextField textName = new JTextField();
        textName.setBounds(185,185,200,35);
        textName.setFont(inputBoxFont);
        textName.setBorder(null);
        textName.setLayout(null);
        panelSignUpWhite.add(textName);

        JPanel panelIDName = new JPanel();
        panelIDName.setBounds(180, 225, 210, 2);
        panelIDName.setBackground(mainBlue);
        panelSignUpWhite.add(panelIDName);


        RoundedButton ButtonSignUp = new RoundedButton("회원가입");
        ButtonSignUp.setBounds(410,110,125,85);
        ButtonSignUp.setFont(mainFont30);
        ButtonSignUp.setBackground(mainBlue);
        ButtonSignUp.setForeground(Color.white);
        ButtonSignUp.setActionCommand("login");
        ButtonSignUp.addActionListener(this);
        panelSignUpWhite.add(ButtonSignUp);

        JButton ButtonBackPage = new JButton("뒤로가기");
        ButtonBackPage.setBounds(219,240,120,40);
        ButtonBackPage.setFont(mainFont20);
        //ButtonBackPage.setBorderPainted(false);
        ButtonBackPage.setContentAreaFilled(false);
        ButtonBackPage.setFocusPainted(false);
        ButtonBackPage.setActionCommand("BackPage");
        ButtonBackPage.addActionListener(this);
        panelSignUpWhite.add(ButtonBackPage);

        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();

        if (event.equals("Register")) {

        }
        if (event.equals("BackPage")) {
            LoginPage LP = new LoginPage();
            this.setVisible(false);
            dispose();


        }

    }
}