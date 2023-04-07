package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import Res.*;


public class LoginPage extends JPanel implements ActionListener {

    public LoginPage() {

        setSize(1280, 720);
        setVisible(true);
        setLayout(null);

        java.awt.Font mainFont50 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 50);   //폰트 설정
        java.awt.Font mainFont40 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 40);
        java.awt.Font mainFont30 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 30);
        java.awt.Font mainFont20 = new java.awt.Font("배달의민족 도현", java.awt.Font.PLAIN, 20);
        java.awt.Font inputBoxFont = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD,25);

        Color mainBlue = new Color(1, 108, 205);
        Color mainGray = new Color(192,192,192);

        JPanel panelMainBlue = new JPanel();
        panelMainBlue.setBounds(0, 0, 1280, 80);
        panelMainBlue.setBackground(mainBlue);


        JLabel labelMain = new JLabel("도서관 시스템");
        labelMain.setBounds(382, 0, 500, 90);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont50);
        labelMain.setForeground(Color.white);

        JLabel labelLogin = new JLabel("회원 로그인");
        labelLogin.setBounds(530, 230, 220, 50);
        labelLogin.setHorizontalAlignment(JLabel.CENTER);
        labelLogin.setFont(mainFont40);

        JLabel labelID = new JLabel("아이디");
        labelID.setBounds(420, 300, 120, 40);
        labelID.setHorizontalAlignment(JLabel.CENTER);
        labelID.setFont(mainFont20);

        JLabel labelPW = new JLabel("비밀번호");
        labelPW.setBounds(420, 360, 120, 40);
        labelPW.setHorizontalAlignment(JLabel.CENTER);
        labelPW.setFont(mainFont20);

 /*       JTextField textID = new JTextField();
        textID.setBounds(550,300,200,35);
        textID.setFont(inputBoxFont);
        textID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textID.setLayout(null);

        JPasswordField textPassword = new JPasswordField(10);
        textPassword.setBounds(550,360,200,35);
        textPassword.setFont(inputBoxFont);
        textPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textPassword.setLayout(null);
*/ //텍스트필드 에러


        RoundedButton ButtonLogin = new RoundedButton("로그인");
        ButtonLogin.setBounds(780,320,105,85);
        ButtonLogin.setFont(mainFont30);
        ButtonLogin.setBackground(mainBlue);
        ButtonLogin.setForeground(Color.white);
        ButtonLogin.setActionCommand("login");
        ButtonLogin.addActionListener(this);

        JButton ButtonSignUp = new JButton("회원가입");
        ButtonSignUp.setBounds(490,430,150,50);
        ButtonSignUp.setFont(mainFont20);
        ButtonSignUp.setBorderPainted(false);
        ButtonSignUp.setContentAreaFilled(false);
        ButtonSignUp.setFocusPainted(false);
        ButtonSignUp.setActionCommand("signUp");
        ButtonSignUp.addActionListener(this);

        JButton ButtonNonMemLogin = new JButton("비회원 로그인");
        ButtonNonMemLogin.setBounds(640,430,170,50);
        ButtonNonMemLogin.setFont(mainFont20);
        ButtonNonMemLogin.setBorderPainted(false);
        ButtonNonMemLogin.setContentAreaFilled(false);
        ButtonNonMemLogin.setFocusPainted(false);
        ButtonNonMemLogin.setActionCommand("guest");
        ButtonNonMemLogin.addActionListener(this);

        JPanel panelLoginLine = new JPanel();
        panelLoginLine.setBounds(540, 340, 210, 2);
        panelLoginLine.setBackground(mainBlue);

        JPanel panelPasswordLine = new JPanel();
        panelPasswordLine.setBounds(540, 400, 210, 2);
        panelPasswordLine.setBackground(mainBlue);


        JPanel panelLoginBlue = new JPanel();
        panelLoginBlue.setBounds(355, 200, 570, 320);
        panelLoginBlue.setBackground(mainBlue);

        JPanel panelLoginWhite = new JPanel();
        panelLoginWhite.setBounds(361, 208, 558, 304);
        panelLoginWhite.setBackground(Color.white);


        add(labelMain);


        add(labelLogin);
        add(labelID);
        add(labelPW);

        //add(textID);         //텍스트필드 에러
        //add(textPassword);

        add(ButtonLogin);
        add(ButtonSignUp);
        add(ButtonNonMemLogin);

        add(panelLoginLine);
        add(panelPasswordLine);

        add(panelLoginWhite);
        add(panelLoginBlue);

        add(panelMainBlue);
    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();


        if (event.equals("login")) {

        } else if (event.equals("signUp")) {
            //this.setVisible(false);
            SignUpPage SP = new SignUpPage();
        } else if (event.equals("guest")){
            //this.setVisible(false);
        }

    }
}
