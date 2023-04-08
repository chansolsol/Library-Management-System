package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import Res.*;


public class LoginPage extends JFrame implements ActionListener {

    public LoginPage() {

        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        setTitle("Library Management System");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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

        JPanel panelLoginBlue = new JPanel();
        panelLoginBlue.setBounds(355, 200, 570, 320);
        panelLoginBlue.setBackground(mainBlue);
        add(panelLoginBlue);

        JPanel panelLoginWhite = new JPanel();
        panelLoginWhite.setBounds(6, 8, 558, 304);
        panelLoginWhite.setBackground(Color.white);
        panelLoginBlue.add(panelLoginWhite);

        JLabel labelLogin = new JLabel("회원 로그인");
        labelLogin.setBounds(169, 22, 220, 50);
        labelLogin.setHorizontalAlignment(JLabel.CENTER);
        labelLogin.setFont(mainFont40);
        panelLoginWhite.add(labelLogin);

        JLabel labelID = new JLabel("아이디");
        labelID.setBounds(59, 100, 120, 40);
        labelID.setHorizontalAlignment(JLabel.CENTER);
        labelID.setFont(mainFont20);
        panelLoginWhite.add(labelID);

        JLabel labelPW = new JLabel("비밀번호");
        labelPW.setBounds(59, 160, 120, 40);
        labelPW.setHorizontalAlignment(JLabel.CENTER);
        labelPW.setFont(mainFont20);
        panelLoginWhite.add(labelPW);

        JTextField textID = new JTextField();
        textID.setBounds(180,100,200,35);
        textID.setFont(inputBoxFont);
        textID.setBorder(null);
        textID.setLayout(null);
        panelLoginWhite.add(textID);

        JPanel panelIDLine = new JPanel();
        panelIDLine.setBounds(180, 140, 210, 2);
        panelIDLine.setBackground(mainBlue);
        panelLoginWhite.add(panelIDLine);

        JPasswordField textPassword = new JPasswordField();
        textPassword.setBounds(180,155,200,35);
        textPassword.setFont(inputBoxFont);
        textPassword.setBorder(null);
        textPassword.setLayout(null);
        panelLoginWhite.add(textPassword);

        JPanel panelPasswordLine = new JPanel();
        panelPasswordLine.setBounds(180, 195, 210, 2);
        panelPasswordLine.setBackground(mainBlue);
        panelLoginWhite.add(panelPasswordLine);

        RoundedButton ButtonLogin = new RoundedButton("로그인");
        ButtonLogin.setBounds(410,110,105,85);
        ButtonLogin.setFont(mainFont30);
        ButtonLogin.setBackground(mainBlue);
        ButtonLogin.setForeground(Color.white);
        ButtonLogin.setActionCommand("login");
        ButtonLogin.addActionListener(this);
        panelLoginWhite.add(ButtonLogin);

        JButton ButtonSignUp = new JButton("회원가입");
        ButtonSignUp.setBounds(120,220,150,50);
        ButtonSignUp.setFont(mainFont20);
        ButtonSignUp.setBorderPainted(false);
        ButtonSignUp.setContentAreaFilled(false);
        ButtonSignUp.setFocusPainted(false);
        ButtonSignUp.setActionCommand("signUp");
        ButtonSignUp.addActionListener(this);
        panelLoginWhite.add(ButtonSignUp);

        JButton ButtonNonMemLogin = new JButton("비회원 로그인");
        ButtonNonMemLogin.setBounds(270,220,170,50);
        ButtonNonMemLogin.setFont(mainFont20);
        ButtonNonMemLogin.setBorderPainted(false);
        ButtonNonMemLogin.setContentAreaFilled(false);
        ButtonNonMemLogin.setFocusPainted(false);
        ButtonNonMemLogin.setActionCommand("guest");
        ButtonNonMemLogin.addActionListener(this);
        panelLoginWhite.add(ButtonNonMemLogin);

        getContentPane().setBackground(Color.white);

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("login")) {

        } else if (event.equals("signUp")) {
            setVisible(false);
            dispose();
            SignUpPage SP = new SignUpPage();
        } else if (event.equals("guest")){
            //this.setVisible(false);
        }

    }
}
