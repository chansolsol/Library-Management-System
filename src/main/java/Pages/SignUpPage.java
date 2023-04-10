package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import Res.*;



public class SignUpPage extends JFrame implements ActionListener {

    GsonMethod gson = new GsonMethod();
    JTextField textID;
    JPasswordField textPassword;
    JTextField textName;

    public SignUpPage() {

        setSize(1280, 720); //JFrame 크기 설정
        setLayout(null);    //컴포넌트를 자유롭게 배치
        setLocationRelativeTo(null);    //JFrame 생성시 화면 중앙에 배치
        setVisible(true);   //JFrame 시각화
        setTitle("Library Management System : Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을시 JFrame 메모리 자원 회수
        setResizable(false);    //JFrame 사이즈 조절 제한

        java.awt.Font mainFont50 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 50);   //폰트 설정
        java.awt.Font mainFont40 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 40);
        java.awt.Font mainFont30 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 30);
        java.awt.Font mainFont20 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 20);
        java.awt.Font inputBoxFont = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD,20);

        Color mainBlue = new Color(1, 108, 205);    //메인 색상 설정


        JPanel panelMainBlue = new JPanel();    //"도서관 시스템" 라벨이 위치할 메인 패널
        panelMainBlue.setBounds(0, 0, 1280, 80);
        panelMainBlue.setBackground(mainBlue);
        add(panelMainBlue);
        panelMainBlue.setLayout(null);

        JLabel labelMain = new JLabel("도서관 시스템");   //"도서관 시스템" 메인 라벨
        labelMain.setBounds(382, 0, 500, 80);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont50);
        labelMain.setForeground(Color.white);
        panelMainBlue.add(labelMain);

        JPanel panelSignUpBlue = new JPanel();  //회원가입 컴포넌트 패널이 위치할 패널
        panelSignUpBlue.setBounds(355, 200, 570, 320);
        panelSignUpBlue.setBackground(mainBlue);
        add(panelSignUpBlue);
        panelSignUpBlue.setLayout(null);

        JPanel panelSignUpWhite = new JPanel(); //회원가입 컴포넌트가 위치할 패널
        panelSignUpWhite.setBounds(6, 8, 558, 304);
        panelSignUpWhite.setBackground(Color.white);
        panelSignUpBlue.add(panelSignUpWhite);
        panelSignUpWhite.setLayout(null);

        JLabel labelSignUp = new JLabel("회원 가입");   //"회원 가입" 메인 라벨
        labelSignUp.setBounds(169, 20, 220, 50);
        labelSignUp.setHorizontalAlignment(JLabel.CENTER);
        labelSignUp.setFont(mainFont40);
        panelSignUpWhite.add(labelSignUp);

        JLabel labelID = new JLabel("아이디"); //"아이디" 로그인 라벨
        labelID.setBounds(60, 75, 120, 35);
        labelID.setHorizontalAlignment(JLabel.CENTER);
        labelID.setFont(mainFont20);
        panelSignUpWhite.add(labelID);

        JLabel labelPW = new JLabel("비밀번호");    //"비밀번호" 로그인 라벨
        labelPW.setBounds(60, 130, 120, 35);
        labelPW.setHorizontalAlignment(JLabel.CENTER);
        labelPW.setFont(mainFont20);
        panelSignUpWhite.add(labelPW);

        JLabel labelName = new JLabel("이름");    //"이름" 이름 라벨
        labelName.setBounds(60, 185, 120, 35);
        labelName.setHorizontalAlignment(JLabel.CENTER);
        labelName.setFont(mainFont20);
        panelSignUpWhite.add(labelName);

        textID = new JTextField();   //아이디가 입력될 JTextField
        textID.setBounds(185,75,200,35);
        textID.setFont(inputBoxFont);
        textID.setBorder(null);
        textID.setLayout(null);
        panelSignUpWhite.add(textID);

        JPanel panelIDLine = new JPanel();  //아이디 입력 구분선 라벨
        panelIDLine.setBounds(180, 115, 210, 2);
        panelIDLine.setBackground(mainBlue);
        panelSignUpWhite.add(panelIDLine);

        textPassword = new JPasswordField(); //비밀번호가 입력될 JPasswordField
        textPassword.setBounds(185,130,200,35);
        textPassword.setFont(inputBoxFont);
        textPassword.setBorder(null);
        textPassword.setLayout(null);
        panelSignUpWhite.add(textPassword);

        JPanel panelPasswordLine = new JPanel();    //비밀번호 입력 구분선 라벨
        panelPasswordLine.setBounds(180, 170, 210, 2);
        panelPasswordLine.setBackground(mainBlue);
        panelSignUpWhite.add(panelPasswordLine);

        textName = new JTextField(); //이름이 입력될 JTextField
        textName.setBounds(185,185,200,35);
        textName.setFont(inputBoxFont);
        textName.setBorder(null);
        textName.setLayout(null);
        panelSignUpWhite.add(textName);

        JPanel panelIDName = new JPanel();  //비밀번호 입력 구분선 라벨
        panelIDName.setBounds(180, 225, 210, 2);
        panelIDName.setBackground(mainBlue);
        panelSignUpWhite.add(panelIDName);


        RoundedButton ButtonSignUp = new RoundedButton("회원가입"); //회원가입 버튼, (계정정보 확인 후 계정 생성)
        ButtonSignUp.setBounds(410,110,125,85);
        ButtonSignUp.setFont(mainFont30);
        ButtonSignUp.setBackground(mainBlue);
        ButtonSignUp.setForeground(Color.white);
        ButtonSignUp.setActionCommand("Register");
        ButtonSignUp.addActionListener(this);
        panelSignUpWhite.add(ButtonSignUp);

        JButton ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼, (LoginPage 생성)
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
        JOptionPane alert = new JOptionPane();  //알림 패널 생성

        String ID = textID.getText();   //아이디 문자열 가져오기
        String password = new String(textPassword.getPassword());   //비밀번호 문자열 가져오기
        String username = textName.getText();

        if (event.equals("Register")) {
            if (textID.getText().equals("") || textPassword.getText().equals("")) { //아이디나 비밀번호, 이름 미입력시 에러 메시지박스
                JOptionPane.showMessageDialog(null, "ID 또는 비밀번호를 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
            } else if (!textID.getText().equals("") && !textPassword.getText().equals("") && textName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "이름을 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
            } else {
                gson.signup(ID, password, username);    //signup 메소드 실행

                LoginPage loginPage = new LoginPage();
                this.setVisible(false);
                dispose();
                System.out.print("ㅇㅇ");
            }
        }

        if (event.equals("BackPage")) {
            LoginPage LP = new LoginPage(); //로그인 페이지 생성, (JFrame LoginPage 생성)
            this.setVisible(false);
            dispose();


        }

    }
}