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

        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Library Management System : Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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

        JButton ButtonMyInfo = new JButton("회원정보");
        ButtonMyInfo.setBounds(0,100,200,51);
        ButtonMyInfo.setFont(mainFont20);
        ButtonMyInfo.setHorizontalAlignment(JButton.LEFT);
        //ButtonMyInfo.setBorderPainted(false);
        ButtonMyInfo.setContentAreaFilled(false);
        ButtonMyInfo.setFocusPainted(false);
        ButtonMyInfo.setActionCommand("MyInfoPage");
        ButtonMyInfo.addActionListener(this);
        panelMenuWhite.add(ButtonMyInfo);

        JButton ButtonMyBook = new JButton("대출도서조회");
        ButtonMyBook.setBounds(0,150,200,51);
        ButtonMyBook.setFont(mainFont20);
        ButtonMyBook.setHorizontalAlignment(JButton.LEFT);
        //ButtonMyBook.setBorderPainted(false);
        ButtonMyBook.setContentAreaFilled(false);
        ButtonMyBook.setFocusPainted(false);
        ButtonMyBook.setActionCommand("MyBookPage");
        ButtonMyBook.addActionListener(this);
        panelMenuWhite.add(ButtonMyBook);

        JButton ButtonRequestBook = new JButton("희망도서내역");
        ButtonRequestBook.setBounds(0,200,200,51);
        ButtonRequestBook.setFont(mainFont20);
        ButtonRequestBook.setHorizontalAlignment(JButton.LEFT);
        //ButtonRequestBook.setBorderPainted(false);
        ButtonRequestBook.setContentAreaFilled(false);
        ButtonRequestBook.setFocusPainted(false);
        ButtonRequestBook.setActionCommand("MyRequestedBookPage");
        ButtonRequestBook.addActionListener(this);
        panelMenuWhite.add(ButtonRequestBook);

        JPanel panelMainWhite = new JPanel(); //회원 정보 수정 페이지 컴포넌트가 위치할 패널
        panelMainWhite.setBounds(440, 150, 400, 500);
        panelMainWhite.setBackground(Color.white);
        add(panelMainWhite);
        panelMainWhite.setLayout(null);

        JLabel labelMyInfo = new JLabel("회원 정보 수정");
        labelMyInfo.setBounds(0, 0, 400, 40);
        labelMyInfo.setHorizontalAlignment(JLabel.CENTER);
        labelMyInfo.setFont(mainFont30);
        panelMainWhite.add(labelMyInfo);

        JLabel labelUserID = new JLabel("아이디 :");
        labelUserID.setBounds(0, 60, 180, 40);
        labelUserID.setHorizontalAlignment(JLabel.RIGHT);
        labelUserID.setFont(mainFont20);
        panelMainWhite.add(labelUserID);

        JLabel labelUserName = new JLabel("이름 :");
        labelUserName.setBounds(0, 110, 180, 40);
        labelUserName.setHorizontalAlignment(JLabel.RIGHT);
        labelUserName.setFont(mainFont20);
        panelMainWhite.add(labelUserName);

        JLabel labelPassWord = new JLabel("현재 비밀번호 :");
        labelPassWord.setBounds(0, 160, 180, 40);
        labelPassWord.setHorizontalAlignment(JLabel.RIGHT);
        labelPassWord.setFont(mainFont20);
        panelMainWhite.add(labelPassWord);

        JLabel labelNewPassWord = new JLabel("새 비밀번호 :");
        labelNewPassWord.setBounds(0, 210, 180, 40);
        labelNewPassWord.setHorizontalAlignment(JLabel.RIGHT);
        labelNewPassWord.setFont(mainFont20);
        panelMainWhite.add(labelNewPassWord);

        JLabel labelCheckNewPassWord = new JLabel("새 비밀번호 확인:");
        labelCheckNewPassWord.setBounds(0, 260, 180, 40);
        labelCheckNewPassWord.setHorizontalAlignment(JLabel.RIGHT);
        labelCheckNewPassWord.setFont(mainFont20);
        panelMainWhite.add(labelCheckNewPassWord);


        JLabel labelUserID0 = new JLabel(UserInfo.getInstance().getUserID());
        labelUserID0.setBounds(200, 60, 180, 40);
        labelUserID0.setHorizontalAlignment(JLabel.LEFT);
        labelUserID0.setFont(mainFont20);
        panelMainWhite.add(labelUserID0);

        textUserName = new JTextField(gson.getUsername(UserInfo.getInstance().getUserID()));
        textUserName.setBounds(200,110,180,40);
        textUserName.setFont(inputBoxFont);
        //textUserName.setBorder(null);
        textUserName.setLayout(null);
        panelMainWhite.add(textUserName);


        textPassword = new JPasswordField();
        textPassword.setBounds(200,160,180,40);
        textPassword.setFont(inputBoxFont);
        //textPassword.setBorder(null);
        textPassword.setLayout(null);
        panelMainWhite.add(textPassword);

        textNewPassword = new JPasswordField();
        textNewPassword.setBounds(200,210,180,40);
        textNewPassword.setFont(inputBoxFont);
        //textNewPassword.setBorder(null);
        textNewPassword.setLayout(null);
        panelMainWhite.add(textNewPassword);


        textCheckNewPassword = new JPasswordField();
        textCheckNewPassword.setBounds(200,260,180,40);
        textCheckNewPassword.setFont(inputBoxFont);
        //textCheckNewPassword.setBorder(null);
        textCheckNewPassword.setLayout(null);
        panelMainWhite.add(textCheckNewPassword);

        RoundedButton ButtonSignUp = new RoundedButton("정보수정"); //정보수정 버튼
        ButtonSignUp.setBounds(135,330,130,50);
        ButtonSignUp.setFont(mainFont30);
        ButtonSignUp.setBackground(mainBlue);
        ButtonSignUp.setForeground(Color.white);
        ButtonSignUp.setActionCommand("EditInfo");
        ButtonSignUp.addActionListener(this);
        panelMainWhite.add(ButtonSignUp);

        JButton ButtonLoanPage = new JButton("<HTML><body><center>뒤로가기</center></body></HTML>");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonLoanPage.setBounds(140,390,120,40);
        ButtonLoanPage.setFont(mainFont20);
        //ButtonLoanPage.setBorderPainted(false);
        ButtonLoanPage.setContentAreaFilled(false);
        ButtonLoanPage.setFocusPainted(false);
        ButtonLoanPage.setActionCommand("BackPage");
        ButtonLoanPage.addActionListener(this);
        panelMainWhite.add(ButtonLoanPage);

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
            MyInfoPage MI = new MyInfoPage();
            dispose();
        } else if (event.equals("MyBookPage")) {
            MyBookPage MB = new MyBookPage();
            dispose();
        } else if(event.equals("MyRequestedBookPage")){
            MyRequestedBookPage MRB = new MyRequestedBookPage();
            dispose();
        }

    }
}