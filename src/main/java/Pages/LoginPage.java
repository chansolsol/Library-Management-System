package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import AdminPages.AdminPage;
import Res.*;
import BookCRUD.Book;
import BookCRUD.BookDatabase;


public class LoginPage extends JFrame implements ActionListener {

    GsonMethod gson = new GsonMethod();
    private static final String DB_FILE_NAME = "books.json";
    BookDatabase database = new BookDatabase(DB_FILE_NAME);
    private JTextField textID;
    private JPasswordField textPassword;

    public LoginPage() {

        gson.signInit();    //프로그램 실행 시 로그인 json 정보 불러옴
        try {
            List<Book> books = database.load(); //프로그램 실행 시 도서 json 정보 불러옴
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        JPanel panelLoginBlue = new JPanel();   //로그인 컴포넌트 패널이 위치할 패널
        panelLoginBlue.setBounds(355, 200, 570, 320);
        panelLoginBlue.setBackground(mainBlue);
        add(panelLoginBlue);
        panelLoginBlue.setLayout(null);

        JPanel panelLoginWhite = new JPanel();  //로그인 컴포넌트가 위치할 패널
        panelLoginWhite.setBounds(6, 8, 558, 304);
        panelLoginWhite.setBackground(Color.white);
        panelLoginBlue.add(panelLoginWhite);
        panelLoginWhite.setLayout(null);

        JLabel labelLogin = new JLabel("회원 로그인");   //"회원 로그인" 메인 라벨
        labelLogin.setBounds(169, 15, 220, 50);
        labelLogin.setHorizontalAlignment(JLabel.CENTER);
        labelLogin.setFont(mainFont40);
        panelLoginWhite.add(labelLogin);

        JLabel labelID = new JLabel("아이디"); //"아이디" 로그인 라벨
        labelID.setBounds(60, 100, 120, 35);
        labelID.setHorizontalAlignment(JLabel.CENTER);
        labelID.setFont(mainFont20);
        panelLoginWhite.add(labelID);

        JLabel labelPW = new JLabel("비밀번호");    //"비밀번호" 로그인 라벨
        labelPW.setBounds(60, 160, 120, 35);
        labelPW.setHorizontalAlignment(JLabel.CENTER);
        labelPW.setFont(mainFont20);
        panelLoginWhite.add(labelPW);

        textID = new JTextField();   //아이디가 입력될 JTextField
        textID.setBounds(185,100,200,35);
        textID.setFont(inputBoxFont);
        textID.setBorder(null);
        textID.setLayout(null);
        panelLoginWhite.add(textID);

        JPanel panelIDLine = new JPanel();  //아이디 입력 구분선 라벨
        panelIDLine.setBounds(180, 140, 210, 2);
        panelIDLine.setBackground(mainBlue);
        panelLoginWhite.add(panelIDLine);

        textPassword = new JPasswordField(); //비밀번호가 입력될 JPasswordField
        textPassword.setBounds(185,160,200,35);
        textPassword.setFont(inputBoxFont);
        textPassword.setBorder(null);
        textPassword.setLayout(null);
        panelLoginWhite.add(textPassword);

        JPanel panelPasswordLine = new JPanel();    //비밀번호 입력 구분선 라벨
        panelPasswordLine.setBounds(180, 200, 210, 2);
        panelPasswordLine.setBackground(mainBlue);
        panelLoginWhite.add(panelPasswordLine);

        RoundedButton ButtonLogin = new RoundedButton("로그인");   //로그인 버튼, (계정정보 확인 후 MainPage 생성)
        ButtonLogin.setBounds(410,110,105,85);
        ButtonLogin.setFont(mainFont30);
        ButtonLogin.setBackground(mainBlue);
        ButtonLogin.setForeground(Color.white);
        ButtonLogin.setActionCommand("login");  //액션 커맨드 "login" 이벤트 발생
        ButtonLogin.addActionListener(this);
        panelLoginWhite.add(ButtonLogin);

        JButton ButtonSignUp = new JButton("회원가입"); //회원가입 버튼, (SignUpPage 생성)
        ButtonSignUp.setBounds(109,230,165,40);
        ButtonSignUp.setFont(mainFont20);
        //ButtonSignUp.setBorderPainted(false);
        ButtonSignUp.setContentAreaFilled(false);
        ButtonSignUp.setFocusPainted(false);
        ButtonSignUp.setActionCommand("signUp");    //액션 커맨드 "signUp" 이벤트 발생
        ButtonSignUp.addActionListener(this);
        panelLoginWhite.add(ButtonSignUp);

        JButton ButtonNonMemLogin = new JButton("비회원 로그인"); //비회원 로그인 버튼, (MainPage 생성)
        ButtonNonMemLogin.setBounds(284,230,165,40);
        ButtonNonMemLogin.setFont(mainFont20);
        //ButtonNonMemLogin.setBorderPainted(false);
        ButtonNonMemLogin.setContentAreaFilled(false);
        ButtonNonMemLogin.setFocusPainted(false);
        ButtonNonMemLogin.setActionCommand("guest");    //액션 커맨드 "guest" 이벤트 발생
        ButtonNonMemLogin.addActionListener(this);
        panelLoginWhite.add(ButtonNonMemLogin);

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

    }

    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();
        JOptionPane alert = new JOptionPane();  //알림 패널 생성

        if (event.equals("login")) {
            String ID = textID.getText();   //아이디 문자열 가져오기
            String password = new String(textPassword.getPassword());   //비밀번호 문자열 가져오기

                if (gson.login(ID ,password)) {     //로그인 정보 일치 시 메인페이지 출력
                    if (ID.equals("admin")) {   //admin 로그인
                        UserInfo.getInstance().setUserID(ID);
                        UserInfo.getInstance().setUserPassword(password);
                        AdminPage adminPage = new AdminPage();
                        dispose();
                    } else {
                        UserInfo.getInstance().setUserID(ID);
                        UserInfo.getInstance().setUserPassword(password);
                        MainPage mainPage = new MainPage();
                        dispose();
                    }
                } else {    //로그인 정보 불일치 시 에러 메시지박스 출력
                    alert.showMessageDialog(null, "존재하지 않는 아이디입니다.", "알림", JOptionPane.ERROR_MESSAGE);
                }

        } else if (event.equals("signUp")) {
            SignUpPage SP = new SignUpPage();   //회원가입 페이지 생성, (JFrame SignUpPage 생성)
            dispose();  //로그인 페이지 자원 회수
        } else if (event.equals("guest")){
            MainPage mainPage = new MainPage();   //비회원 로그인 페이지 생성
            dispose();
        }

    }
}
