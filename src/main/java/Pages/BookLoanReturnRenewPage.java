package Pages;

import book.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class BookLoanReturnRenewPage extends JFrame implements ActionListener{

    JPanel panelMainBlue;
    JLabel labelMain;

    public BookLoanReturnRenewPage(){

        setSize(1280, 720); //JFrame 크기 설정
        setLayout(null);    //컴포넌트를 자유롭게 배치
        setLocationRelativeTo(null);    //JFrame 생성시 화면 중앙에 배치
        setVisible(true);   //JFrame 시각화
        setTitle("Library Management System : BookLoanReturnRenewPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을시 JFrame 메모리 자원 회수
        setResizable(false);     //JFrame 사이즈 조절 제한

        java.awt.Font mainFont50 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 50);   //폰트 설정
        java.awt.Font mainFont40 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 40);
        java.awt.Font mainFont30 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 30);
        java.awt.Font mainFont20 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 20);
        java.awt.Font inputBoxFont = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD,20);
        java.awt.Font SearchIconFont = new java.awt.Font("Segoe MDL2 Assets", Font.BOLD,20);


        Color mainBlue = new Color(1, 108, 205);    //메인 색상 설정

        panelMainBlue = new JPanel();
        panelMainBlue.setBounds(0, 0, 1280, 80);
        panelMainBlue.setBackground(mainBlue);
        panelMainBlue.setLayout(null);
        add(panelMainBlue);


        labelMain = new JLabel("도서관 시스템");   //"도서관 시스템" 메인 라벨
        labelMain.setBounds(382, 0, 500, 80);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont50);
        labelMain.setForeground(Color.white);
        panelMainBlue.add(labelMain);

        JLabel labelLoan = new JLabel("대출");    //"대출" 메인 라벨
        labelLoan.setBounds(280, 165, 220, 35);
        labelLoan.setHorizontalAlignment(JLabel.CENTER);
        labelLoan.setFont(mainFont30);
        add(labelLoan);

        JPanel panelLoanBlue = new JPanel();
        panelLoanBlue.setBounds(280, 210, 220, 2);
        panelLoanBlue.setBackground(mainBlue);
        panelLoanBlue.setLayout(null);
        add(panelLoanBlue);

        JLabel labelLoanText = new JLabel("대출 가능 : 0 / 10");    //"대출" 메인 라벨
        labelLoanText.setBounds(280, 220, 220, 35);
        labelLoanText.setHorizontalAlignment(JLabel.CENTER);
        labelLoanText.setFont(mainFont20);
        add(labelLoanText);

        JLabel labelRenew = new JLabel("연장");    //"연장" 메인 라벨
        labelRenew.setBounds(530, 165, 220, 35);
        labelRenew.setHorizontalAlignment(JLabel.CENTER);
        labelRenew.setFont(mainFont30);
        add(labelRenew);

        JPanel panelRenewBlue = new JPanel();
        panelRenewBlue.setBounds(530, 210, 220, 2);
        panelRenewBlue.setBackground(mainBlue);
        panelRenewBlue.setLayout(null);
        add(panelRenewBlue);

        JLabel labelRenewText = new JLabel("연장 가능 0 / 1");    //"대출" 메인 라벨
        labelRenewText.setBounds(530, 220, 220, 35);
        labelRenewText.setHorizontalAlignment(JLabel.CENTER);
        labelRenewText.setFont(mainFont20);
        add(labelRenewText);

        JLabel labelReturn = new JLabel("반납");    //"반납" 메인 라벨
        labelReturn.setBounds(780, 165, 220, 35);
        labelReturn.setHorizontalAlignment(JLabel.CENTER);
        labelReturn.setFont(mainFont30);
        add(labelReturn);

        JPanel panelReturnBlue = new JPanel();
        panelReturnBlue.setBounds(780, 210, 220, 2);
        panelReturnBlue.setBackground(mainBlue);
        panelReturnBlue.setLayout(null);
        add(panelReturnBlue);

        JLabel labelReturnText = new JLabel("연채 도서 : 0 / 0");    //"대출" 메인 라벨
        labelReturnText.setBounds(780, 220, 220, 35);
        labelReturnText.setHorizontalAlignment(JLabel.CENTER);
        labelReturnText.setFont(mainFont20);
        add(labelReturnText);


        JLabel labelLoanBook = new JLabel("대출한 도서");    //"반납" 메인 라벨
        labelLoanBook.setBounds(300, 320, 220, 35);
        //labelLoanBook.setHorizontalAlignment(JLabel.CENTER);
        labelLoanBook.setFont(mainFont20);
        add(labelLoanBook);

        JPanel panelLoanBookBlue = new JPanel();
        panelLoanBookBlue.setBounds(285, 360, 700, 2);
        panelLoanBookBlue.setBackground(mainBlue);
        panelLoanBookBlue.setLayout(null);
        add(panelLoanBookBlue);

        JLabel labelIDBook = new JLabel("관리번호");    //"반납" 메인 라벨
        labelIDBook.setBounds(300, 370, 200, 35);
        //labelIDBook.setHorizontalAlignment(JLabel.CENTER);
        labelIDBook.setFont(mainFont20);
        add(labelIDBook);

        JLabel labelTitleBook = new JLabel("제목");    //"반납" 메인 라벨
        labelTitleBook.setBounds(450, 370, 200, 35);
        //labelTitleBook.setHorizontalAlignment(JLabel.CENTER);
        labelTitleBook.setFont(mainFont20);
        add(labelTitleBook);

        JLabel labelLoanDateBook = new JLabel("대출일");    //"반납" 메인 라벨
        labelLoanDateBook.setBounds(600, 370, 200, 35);
        //labelLoanDateBook.setHorizontalAlignment(JLabel.CENTER);
        labelLoanDateBook.setFont(mainFont20);
        add(labelLoanDateBook);

        JLabel labelReturnDateBook = new JLabel("반납예정일");    //"반납" 메인 라벨
        labelReturnDateBook.setBounds(750, 370, 200, 35);
        //labelReturnDateBook.setHorizontalAlignment(JLabel.CENTER);
        labelReturnDateBook.setFont(mainFont20);
        add(labelReturnDateBook);

        JLabel labelRenewBook = new JLabel("연장");    //"반납" 메인 라벨
        labelRenewBook.setBounds(900, 370, 200, 35);
        //labelRenewBook.setHorizontalAlignment(JLabel.CENTER);
        labelRenewBook.setFont(mainFont20);
        add(labelRenewBook);

        JButton ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
        ButtonBackPage.setBounds(580,520,120,40);
        ButtonBackPage.setFont(mainFont20);
        //ButtonBackPage.setBorderPainted(false);
        ButtonBackPage.setContentAreaFilled(false);
        ButtonBackPage.setFocusPainted(false);
        ButtonBackPage.setActionCommand("BackPage");
        ButtonBackPage.addActionListener(this);
        add(ButtonBackPage);

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("TextSearch")) {


        } else if (event.equals("BackPage")) {
            MainPage MP = new MainPage();
            setVisible(false);
            dispose();
        }

    }
}
