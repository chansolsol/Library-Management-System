package Pages;

import Pages.MainPage;
import Res.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class TextSearchResultPage extends JFrame implements ActionListener{

    JTextField textSearch;
    JButton ButtonSearch;
    JComboBox<String> selectOption;
    String Options[] = {"제목","저자","출판사"};   //도서 검색 옵션 종류
    JButton ButtonBackPage;
    JPanel panelMainBlue;
    JLabel labelMain;
    JPanel panelSearch;
    JLabel labelBook1Title;
    JLabel labelBook1Author;
    JLabel labelBook1PublicationDate;

    JLabel labelBook1Publisher ;

    public TextSearchResultPage(){

        setSize(1280, 720); //JFrame 크기 설정
        setLayout(null);    //컴포넌트를 자유롭게 배치
        setLocationRelativeTo(null);    //JFrame 생성시 화면 중앙에 배치
        setVisible(true);   //JFrame 시각화
        setTitle("Library Management System : AdminPage");
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
        add(panelMainBlue);
        panelMainBlue.setLayout(null);

        labelMain = new JLabel("도서관 시스템");   //"도서관 시스템" 메인 라벨
        labelMain.setBounds(382, 0, 500, 80);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont50);
        labelMain.setForeground(Color.white);
        panelMainBlue.add(labelMain);

        selectOption = new JComboBox<String>(Options);  //도서 검색 옵션용 JComboBox
        selectOption.setBounds(390,110,70,20);
        selectOption.addActionListener(this);
        selectOption.setActionCommand("Option");
        add(selectOption);

        textSearch = new JTextField();   //도서 검색 텍스트 입력 JTextField
        textSearch.setBounds(465,100,370,35);
        textSearch.setFont(inputBoxFont);
        textSearch.setBorder(null);
        textSearch.setLayout(null);
        add(textSearch);

        panelSearch = new JPanel();  //도서 검색 텍스트 입력 구분선
        panelSearch.setBounds(390, 140, 450, 2);
        panelSearch.setBackground(mainBlue);
        add(panelSearch);

        ButtonSearch = new JButton("\uE71E");   //도서 검색 버튼
        ButtonSearch.setBounds(845,100,55,40);
        ButtonSearch.setFont(SearchIconFont);
        //ButtonSearch.setBorderPainted(false);
        ButtonSearch.setContentAreaFilled(false);
        ButtonSearch.setFocusPainted(false);
        ButtonSearch.setActionCommand("TextSearch");
        ButtonSearch.addActionListener(this);
        add(ButtonSearch);

        labelBook1Title = new JLabel("도서1제목");   //도서1 제목
        labelBook1Title.setBounds(400, 200, 120, 35);
        //labelBook1Title.setHorizontalAlignment(JLabel.CENTER);
        labelBook1Title.setFont(mainFont20);
        add(labelBook1Title);

        labelBook1Author = new JLabel("도서1저자");   //도서1 저자
        labelBook1Author.setBounds(400, 240, 120, 35);
        //labelBook1Author.setHorizontalAlignment(JLabel.CENTER);
        labelBook1Author.setFont(mainFont20);
        add(labelBook1Author);

        labelBook1Publisher = new JLabel("도서1출판사");   //도서1 출판사
        labelBook1Publisher.setBounds(550, 240, 120, 35);
        //labelBook1Publisher.setHorizontalAlignment(JLabel.CENTER);
        labelBook1Publisher.setFont(mainFont20);
        add(labelBook1Publisher);

        labelBook1PublicationDate = new JLabel("도서1출판년도");   //도서1 출판년도
        labelBook1PublicationDate.setBounds(700, 240, 120, 35);
        //labelBook1PublicationDate.setHorizontalAlignment(JLabel.CENTER);
        labelBook1PublicationDate.setFont(mainFont20);
        add(labelBook1PublicationDate);



        ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
        ButtonBackPage.setBounds(580,500,120,40);
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

        if (event.equals("BackPage")) {
            MainPage MP = new MainPage();
            setVisible(false);
            dispose();

        } else if (event.equals("")) {
            //setVisible(false);
            //dispose();

        } else if (event.equals("")){
            //setVisible(false);
            //dispose();
        }
    }


}