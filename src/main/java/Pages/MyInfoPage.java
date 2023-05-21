package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

import Res.*;

public class MyInfoPage extends JFrame implements ActionListener {

    GsonMethod gson = new GsonMethod();
    JTextField textUserName;
    JPasswordField textPassword;
    JPasswordField textNewPassword;
    JPasswordField textCheckNewPassword;

    public MyInfoPage() {

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


        JPanel panelMenuWhite = new JPanel(); //마이페이지 메뉴 컴포넌트 패널이 위치할 패널
        panelMenuWhite.setBounds(240, 150, 200, 400);
        panelMenuWhite.setBackground(Color.white);
        add(panelMenuWhite);
        panelMenuWhite.setLayout(null);

        JPanel panelMenuBlue = new JPanel();  //마이페이지 메뉴 컴포넌트가 위치할 패널
        panelMenuBlue.setBounds(0, 0, 200, 100);
        panelMenuBlue.setBackground(mainBlue);
        panelMenuWhite.add(panelMenuBlue);
        panelMenuBlue.setLayout(null);

        JLabel labelMenu = new JLabel("마이페이지");
        labelMenu.setBounds(0, 0, 200, 100);
        labelMenu.setHorizontalAlignment(JLabel.CENTER);
        labelMenu.setFont(mainFont30);
        labelMenu.setForeground(Color.white);
        panelMenuBlue.add(labelMenu);

        JButton ButtonMyInfo = new JButton("회원정보");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonMyInfo.setBounds(0,100,200,51);
        ButtonMyInfo.setFont(mainFont20);
        ButtonMyInfo.setHorizontalAlignment(JButton.LEFT);
        //ButtonMyInfo.setBorderPainted(false);
        ButtonMyInfo.setContentAreaFilled(false);
        ButtonMyInfo.setFocusPainted(false);
        ButtonMyInfo.setActionCommand("MyInfoPage");
        ButtonMyInfo.addActionListener(this);
        panelMenuWhite.add(ButtonMyInfo);

        JButton ButtonMyBook = new JButton("대출도서조회");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonMyBook.setBounds(0,150,200,51);
        ButtonMyBook.setFont(mainFont20);
        ButtonMyBook.setHorizontalAlignment(JButton.LEFT);
        //ButtonMyBook.setBorderPainted(false);
        ButtonMyBook.setContentAreaFilled(false);
        ButtonMyBook.setFocusPainted(false);
        ButtonMyBook.setActionCommand("MyBookPage");
        ButtonMyBook.addActionListener(this);
        panelMenuWhite.add(ButtonMyBook);

        JButton ButtonRequestBook = new JButton("희망도서내역");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonRequestBook.setBounds(0,200,200,51);
        ButtonRequestBook.setFont(mainFont20);
        ButtonRequestBook.setHorizontalAlignment(JButton.LEFT);
        //ButtonRequestBook.setBorderPainted(false);
        ButtonRequestBook.setContentAreaFilled(false);
        ButtonRequestBook.setFocusPainted(false);
        ButtonRequestBook.setActionCommand("RequestedBookPage");
        ButtonRequestBook.addActionListener(this);
        panelMenuWhite.add(ButtonRequestBook);

        JPanel panelMainWhite = new JPanel(); //마이페이지 메뉴 컴포넌트가 위치할 패널
        panelMainWhite.setBounds(440, 150, 400, 500);
        panelMainWhite.setBackground(Color.white);
        add(panelMainWhite);
        panelMainWhite.setLayout(null);

        JLabel labelMyInfo = new JLabel("회원 정보 수정");
        labelMyInfo.setBounds(0, 0, 400, 50);
        labelMyInfo.setHorizontalAlignment(JLabel.CENTER);
        labelMyInfo.setFont(mainFont30);
        panelMainWhite.add(labelMyInfo);

        JLabel labelUserID = new JLabel("아이디 :");
        labelUserID.setBounds(0, 80, 180, 40);
        labelUserID.setHorizontalAlignment(JLabel.RIGHT);
        labelUserID.setFont(mainFont20);
        panelMainWhite.add(labelUserID);

        JLabel labelUserName = new JLabel("이름 :");
        labelUserName.setBounds(0, 130, 180, 40);
        labelUserName.setHorizontalAlignment(JLabel.RIGHT);
        labelUserName.setFont(mainFont20);
        panelMainWhite.add(labelUserName);

        JLabel labelPassWord = new JLabel("현재 비밀번호 :");
        labelPassWord.setBounds(0, 180, 180, 40);
        labelPassWord.setHorizontalAlignment(JLabel.RIGHT);
        labelPassWord.setFont(mainFont20);
        panelMainWhite.add(labelPassWord);

        JLabel labelNewPassWord = new JLabel("새 비밀번호 :");
        labelNewPassWord.setBounds(0, 230, 180, 40);
        labelNewPassWord.setHorizontalAlignment(JLabel.RIGHT);
        labelNewPassWord.setFont(mainFont20);
        panelMainWhite.add(labelNewPassWord);

        JLabel labelCheckNewPassWord = new JLabel("새 비밀번호 확인:");
        labelCheckNewPassWord.setBounds(0, 280, 180, 40);
        labelCheckNewPassWord.setHorizontalAlignment(JLabel.RIGHT);
        labelCheckNewPassWord.setFont(mainFont20);
        panelMainWhite.add(labelCheckNewPassWord);


        JLabel labelUserID0 = new JLabel(UserInfo.getInstance().getUserID());
        labelUserID0.setBounds(200, 80, 180, 40);
        labelUserID0.setHorizontalAlignment(JLabel.LEFT);
        labelUserID0.setFont(mainFont20);
        panelMainWhite.add(labelUserID0);

        textUserName = new JTextField(gson.getUsername(UserInfo.getInstance().getUserID()));
        textUserName.setBounds(200,130,180,40);
        textUserName.setFont(inputBoxFont);
        //textUserName.setBorder(null);
        textUserName.setLayout(null);
        panelMainWhite.add(textUserName);


        textPassword = new JPasswordField();
        textPassword.setBounds(200,180,180,40);
        textPassword.setFont(inputBoxFont);
        //textPassword.setBorder(null);
        textPassword.setLayout(null);
        panelMainWhite.add(textPassword);

        textNewPassword = new JPasswordField();
        textNewPassword.setBounds(200,230,180,40);
        textNewPassword.setFont(inputBoxFont);
        //textNewPassword.setBorder(null);
        textNewPassword.setLayout(null);
        panelMainWhite.add(textNewPassword);


        textCheckNewPassword = new JPasswordField();
        textCheckNewPassword.setBounds(200,280,180,40);
        textCheckNewPassword.setFont(inputBoxFont);
        //textCheckNewPassword.setBorder(null);
        textCheckNewPassword.setLayout(null);
        panelMainWhite.add(textCheckNewPassword);

        RoundedButton ButtonSignUp = new RoundedButton("정보수정"); //정보수정 버튼
        ButtonSignUp.setBounds(135,340,130,50);
        ButtonSignUp.setFont(mainFont30);
        ButtonSignUp.setBackground(mainBlue);
        ButtonSignUp.setForeground(Color.white);
        ButtonSignUp.setActionCommand("EditInfo");
        ButtonSignUp.addActionListener(this);
        panelMainWhite.add(ButtonSignUp);

        JButton ButtonLoanPage = new JButton("<HTML><body><center>뒤로가기</center></body></HTML>");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonLoanPage.setBounds(140,400,120,40);
        ButtonLoanPage.setFont(mainFont20);
        //ButtonLoanPage.setBorderPainted(false);
        ButtonLoanPage.setContentAreaFilled(false);
        ButtonLoanPage.setFocusPainted(false);
        ButtonLoanPage.setActionCommand("BackPage");
        ButtonLoanPage.addActionListener(this);
        panelMainWhite.add(ButtonLoanPage);

        /*JPanel panelSignUpBlue = new JPanel();  //마이페이지 컴포넌트 패널이 위치할 패널
        panelSignUpBlue.setBounds(355, 100, 570, 520);
        panelSignUpBlue.setBackground(mainBlue);
        add(panelSignUpBlue);
        panelSignUpBlue.setLayout(null);

        JPanel panelSignUpWhite = new JPanel(); //마이페이지 컴포넌트가 위치할 패널
        panelSignUpWhite.setBounds(6, 8, 558, 504);
        panelSignUpWhite.setBackground(Color.white);
        panelSignUpBlue.add(panelSignUpWhite);
        panelSignUpWhite.setLayout(null);

        JLabel labelSignUp = new JLabel("마이페이지");   //"마이페이지" 메인 라벨
        labelSignUp.setBounds(169, 15, 220, 50);
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

        JLabel labelUserID = new JLabel(UserInfo.getInstance().getUserID());   //아이디가 입력될 JTextField
        labelUserID.setBounds(185,75,200,35);
        labelUserID.setFont(inputBoxFont);
        labelUserID.setBorder(null);
        labelUserID.setLayout(null);
        panelSignUpWhite.add(labelUserID);

        JPanel panelIDLine = new JPanel();  //아이디 구분선 라벨
        panelIDLine.setBounds(180, 115, 210, 2);
        panelIDLine.setBackground(Color.gray);
        panelSignUpWhite.add(panelIDLine);

        textPassword = new JPasswordField(UserInfo.getInstance().getUserPassword()); //비밀번호가 입력될 JPasswordField
        textPassword.setBounds(185,130,200,35);
        textPassword.setFont(inputBoxFont);
        textPassword.setBorder(null);
        textPassword.setLayout(null);
        panelSignUpWhite.add(textPassword);

        JPanel panelPasswordLine = new JPanel();    //비밀번호 입력 구분선 라벨
        panelPasswordLine.setBounds(180, 170, 210, 2);
        panelPasswordLine.setBackground(mainBlue);
        panelSignUpWhite.add(panelPasswordLine);

        textName = new JTextField(gson.getUsername(UserInfo.getInstance().getUserID())); //이름이 입력될 JTextField
        textName.setBounds(185,185,200,35);
        textName.setFont(inputBoxFont);
        textName.setBorder(null);
        textName.setLayout(null);
        panelSignUpWhite.add(textName);

        JPanel panelIDName = new JPanel();  //비밀번호 입력 구분선 라벨
        panelIDName.setBounds(180, 225, 210, 2);
        panelIDName.setBackground(mainBlue);
        panelSignUpWhite.add(panelIDName);


        RoundedButton ButtonSignUp = new RoundedButton("정보수정"); //회원가입 버튼, (계정정보 확인 후 계정 생성)
        ButtonSignUp.setBounds(410,110,125,85);
        ButtonSignUp.setFont(mainFont30);
        ButtonSignUp.setBackground(mainBlue);
        ButtonSignUp.setForeground(Color.white);
        ButtonSignUp.setActionCommand("EditInfo");
        ButtonSignUp.addActionListener(this);
        panelSignUpWhite.add(ButtonSignUp);

        JButton ButtonLoanPage = new JButton("<HTML><body><center>나의 도서</center></body></HTML>");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonLoanPage.setBounds(219,400,120,40);
        ButtonLoanPage.setFont(mainFont20);
        //ButtonLoanPage.setBorderPainted(false);
        ButtonLoanPage.setContentAreaFilled(false);
        ButtonLoanPage.setFocusPainted(false);
        ButtonLoanPage.setActionCommand("MyBookPage");
        ButtonLoanPage.addActionListener(this);
        panelSignUpWhite.add(ButtonLoanPage);

        JButton ButtonRequestedBook = new JButton("<HTML><body><center>희망 도서 신청 현황</center></body></HTML>");   //희망 도서 신청 현황
        ButtonRequestedBook.setBounds(219,350,200,40);
        ButtonRequestedBook.setFont(mainFont20);
        //ButtonRequestedBook.setBorderPainted(false);
        ButtonRequestedBook.setContentAreaFilled(false);
        ButtonRequestedBook.setFocusPainted(false);
        ButtonRequestedBook.setActionCommand("RequestedBookPage");
        ButtonRequestedBook.addActionListener(this);
        panelSignUpWhite.add(ButtonRequestedBook);

        JButton ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonBackPage.setBounds(219,450,120,40);
        ButtonBackPage.setFont(mainFont20);
        //ButtonBackPage.setBorderPainted(false);
        ButtonBackPage.setContentAreaFilled(false);
        ButtonBackPage.setFocusPainted(false);
        ButtonBackPage.setActionCommand("BackPage");
        ButtonBackPage.addActionListener(this);
        panelSignUpWhite.add(ButtonBackPage);*/



        getContentPane().setBackground(Color.white);


    }

    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        JOptionPane alert = new JOptionPane();  //알림 패널 생성

        if (event.equals("EditInfo")) {
            if (textPassword.getText().equals("")) { //아이디나 비밀번호, 이름 미입력시 에러 메시지박스
                JOptionPane.showMessageDialog(null, "현재 비밀번호를 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
            } else if (!textPassword.getText().equals("") && textNewPassword.getText().equals("")&& textCheckNewPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "새 비밀번호를 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
            }  else if (!textPassword.getText().equals("") && textUserName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "이름을 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
            }else {

            }
        }
        if (event.equals("BackPage")) {
            MainPage MP = new MainPage();
            dispose();
        } else if (event.equals("MyInfoPage")) {
            MyInfoPage MF = new MyInfoPage();
            dispose();
        } else if (event.equals("MyBookPage")) {
            MyBookPage MP = new MyBookPage();
            dispose();
        } else if(event.equals("RequestedBookPage")){

        }

    }
}