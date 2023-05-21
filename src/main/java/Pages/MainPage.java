package Pages;

import Res.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame implements ActionListener{

    JTextField textSearch;
    JPanel panelSearch;
    JButton ButtonSearch;
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

        panelSearch = new JPanel();  //도서 검색 텍스트 입력 구분선
        panelSearch.setBounds(390, 140, 500, 2);
        panelSearch.setBackground(mainBlue);
        add(panelSearch);

        ButtonSearch = new JButton("\uE71E");   //도서 검색 버튼
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

            ButtonLoanBook = new JButton("대출 도서 정보");   //도서 추가
            ButtonLoanBook.setBounds(520, 200, 240, 40);
            ButtonLoanBook.setFont(mainFont20);
            ButtonLoanBook.setContentAreaFilled(false);
            ButtonLoanBook.setFocusPainted(false);
            ButtonLoanBook.setActionCommand("MyBook");
            ButtonLoanBook.addActionListener(this);
            add(ButtonLoanBook);

            JButton ButtonReserveSeat = new JButton("열람실 자리 예약");   //도서 추가
            ButtonReserveSeat.setBounds(520, 260, 240, 40);
            ButtonReserveSeat.setFont(mainFont20);
            ButtonReserveSeat.setContentAreaFilled(false);
            ButtonReserveSeat.setFocusPainted(false);
            ButtonReserveSeat.setActionCommand("ReserveSeat");
            ButtonReserveSeat.addActionListener(this);
            add(ButtonReserveSeat);
        }

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("TextSearch")) {
            String keyword = textSearch.getText();
            TextSearchResultPage SR = new TextSearchResultPage(keyword);
            dispose();

        } else if (event.equals("MyPage")) {
            MyInfoPage IP = new MyInfoPage();
            dispose();
        } else if (event.equals("MyBook")){
            MyBookPage BP = new MyBookPage();
            dispose();
        } else if (event.equals("ReserveSeat")){
            ReservationPage RP = new ReservationPage();
            dispose();
        }

    }
}
