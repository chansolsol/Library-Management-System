package Pages;

import Res.Delinquency;
import Res.UserInfo;
import UserUpdate.MyInfoPage;
import UserUpdate.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static UserUpdate.UserInfo.readUserJSON;
import static UserUpdate.UserInfo.saveUserJSON;

public class MainPage extends JFrame implements ActionListener{

    JTextField textSearch;
    JButton ButtonMyPage;
    JButton ButtonLoanBook;

    public MainPage(){



        setSize(1280, 720); //JFrame 크기 설정
        setLayout(null);    //컴포넌트를 자유롭게 배치
        setLocationRelativeTo(null);    //JFrame 생성시 화면 중앙에 배치
        setVisible(true);   //JFrame 시각화
        setTitle("Library Management System : MainPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을시 JFrame 메모리 자원 회수
        setResizable(false);     //JFrame 사이즈 조절 제한

        java.awt.Font mainFont50 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 50);   //폰트 설정
        java.awt.Font mainFont40 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 40);
        java.awt.Font mainFont30 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 30);
        java.awt.Font mainFont20 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 20);
        java.awt.Font inputBoxFont = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD,20);
        java.awt.Font SearchIconFont = new java.awt.Font("Segoe MDL2 Assets", Font.BOLD,20);


        Color mainBlue = new Color(1, 108, 205);    //메인 색상 설정

        JPanel panelMainBlue = new JPanel();
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

        JLabel labelSearchMain = new JLabel("검색어 :");   //"도서관 시스템" 메인 라벨
        labelSearchMain.setBounds(400, 100, 90, 35);
        //labelSearchMain.setHorizontalAlignment(JLabel.CENTER);
        labelSearchMain.setFont(mainFont20);
        add(labelSearchMain);

        textSearch = new JTextField();   //도서 검색 텍스트 입력 JTextField
        textSearch.setBounds(500,100,300,35);
        textSearch.setFont(inputBoxFont);
        textSearch.setBorder(null);
        textSearch.setLayout(null);
        add(textSearch);

        JPanel panelSearch = new JPanel();  //도서 검색 텍스트 입력 구분선
        panelSearch.setBounds(390, 140, 500, 2);
        panelSearch.setBackground(mainBlue);
        add(panelSearch);

        JButton ButtonSearch = new JButton("\uE71E");   //도서 검색 버튼
        ButtonSearch.setBounds(835,98,55,40);
        ButtonSearch.setFont(SearchIconFont);
        //ButtonSearch.setBorderPainted(false);
        ButtonSearch.setContentAreaFilled(false);
        ButtonSearch.setFocusPainted(false);
        ButtonSearch.setActionCommand("TextSearch");
        ButtonSearch.addActionListener(this);
        add(ButtonSearch);

        if (UserInfo.getInstance().getUserID()!=null) {

            ButtonMyPage = new JButton("<HTML><body><center>마이페이지</center></body></HTML>");   //회원 정보 페이지 버튼
            ButtonMyPage.setBounds(1100,100,120,40);
            ButtonMyPage.setFont(mainFont20);
            ButtonMyPage.setContentAreaFilled(false);
            ButtonMyPage.setFocusPainted(false);
            ButtonMyPage.setActionCommand("MyPage");
            ButtonMyPage.addActionListener(this);
            add(ButtonMyPage);

            ButtonLoanBook = new JButton("<HTML><body><center>대출 도서 조회</center></body></HTML>");   //도서 추가
            ButtonLoanBook.setBounds(520, 200, 240, 40);
            ButtonLoanBook.setFont(mainFont20);
            ButtonLoanBook.setContentAreaFilled(false);
            ButtonLoanBook.setFocusPainted(false);
            ButtonLoanBook.setActionCommand("MyBook");
            ButtonLoanBook.addActionListener(this);
            add(ButtonLoanBook);

            JButton ButtonReserveSeat = new JButton("<HTML><body><center>열람실 자리 예약</center></body></HTML>");   //도서 추가
            ButtonReserveSeat.setBounds(520, 440, 240, 40);
            ButtonReserveSeat.setFont(mainFont20);
            ButtonReserveSeat.setContentAreaFilled(false);
            ButtonReserveSeat.setFocusPainted(false);
            ButtonReserveSeat.setActionCommand("ReserveSeat");
            ButtonReserveSeat.addActionListener(this);
            add(ButtonReserveSeat);

            JButton ButtonRequestedBook = new JButton("희망 도서 조회");   //도서 추가
            ButtonRequestedBook.setBounds(520, 320, 240, 40);
            ButtonRequestedBook.setFont(mainFont20);
            ButtonRequestedBook.setContentAreaFilled(false);
            ButtonRequestedBook.setFocusPainted(false);
            ButtonRequestedBook.setActionCommand("RequestedBook");
            ButtonRequestedBook.addActionListener(this);
            add(ButtonRequestedBook);

            JButton ButtonRequestBook = new JButton("희망 도서 신청");   //도서 추가
            ButtonRequestBook.setBounds(520, 380, 240, 40);
            ButtonRequestBook.setFont(mainFont20);
            ButtonRequestBook.setContentAreaFilled(false);
            ButtonRequestBook.setFocusPainted(false);
            ButtonRequestBook.setActionCommand("RequestBook");
            ButtonRequestBook.addActionListener(this);
            add(ButtonRequestBook);

            JButton ButtonReservedBook = new JButton("예약 도서 조회");   //도서 추가
            ButtonReservedBook.setBounds(520, 260, 240, 40);
            ButtonReservedBook.setFont(mainFont20);
            ButtonReservedBook.setContentAreaFilled(false);
            ButtonReservedBook.setFocusPainted(false);
            ButtonReservedBook.setActionCommand("ReservedBook");
            ButtonReservedBook.addActionListener(this);
            add(ButtonReservedBook);
        }

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

        Delinquency del = new Delinquency();    // 연체된 도서 있는지 확인

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("TextSearch")) {
            String keyword = textSearch.getText();
            TextSearchResultPage SR = new TextSearchResultPage(keyword, 0);
            dispose();

        } else if (event.equals("MyPage")) {
            User[] users = readUserJSON("users.json");
            MyInfoPage infoPage = new MyInfoPage(users[0], "users.json", users);
            saveUserJSON("users.json", users);
            dispose();
        } else if (event.equals("MyBook")){
            MyBookPage BP = new MyBookPage(0);
            dispose();
        } else if (event.equals("RequestBook")){
            RequestBookPage RBP = new RequestBookPage();
            dispose();
        }else if (event.equals("ReserveSeat")){
            ReserveSeatPage RPS = new ReserveSeatPage();
            dispose();
        } else if (event.equals("ReservedBook")){
            MyReservedBookPage MBP = new MyReservedBookPage(0);
            dispose();
        } else if (event.equals("RequestedBook")) {
            MyRequestedBookPage MRB = new MyRequestedBookPage(0);
            dispose();
        }

    }
}
