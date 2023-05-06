package Pages;

import Pages.MainPage;
import Res.RoundedButton;
import book.Book;
import book.BookController;
import book.BookDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class BookDetailPage extends JFrame implements ActionListener{

    JTextField textSearch;
    JButton ButtonSearch;
    JButton ButtonBackPage;
    JPanel panelMainBlue;
    JLabel labelMain;
    JPanel panelSearch;

    private static final String DB_FILE_NAME = "books.json";

    public BookDetailPage(String keyword){

        BookDatabase database = new BookDatabase(DB_FILE_NAME);
        BookController controller = new BookController();
        List<Book> books = null;
        try {
            books = database.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        controller.addAll(books);
        List<Book> searchedBooks = controller.searchBooks(keyword);
        int resultBookSize = searchedBooks.size();

        Book[] ResultBooks = new Book[resultBookSize];

        //ResultBooks 배열에 searchedBooks 리스트의 Book 객체를 저장함
        for (int i = 0; i < resultBookSize; i++) {
            ResultBooks[i] = searchedBooks.get(i);
        }

        //문자열 배열을 각각 검색 결과 수와 동일한 크기로 생성
        String[] title = new String[resultBookSize];
        String[] author = new String[resultBookSize];
        String[] publisher = new String[resultBookSize];
        String[] year = new String[resultBookSize];
        String[] id = new String[resultBookSize];

        //ResultBooks 배열에 각 Book 객체에 해당하는 속성 문자열로 채움
        for (int i = 0; i < resultBookSize; i++) {
            Book book = ResultBooks[i];
            title[i] = book.getTitle();
            author[i] = book.getAuthor();
            publisher[i] = book.getPublisher();
            year[i] = book.getYear();
            id[i] = book.getId();
        }

        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Library Management System : AdminPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을시 JFrame 메모리 자원 회수
        setResizable(false);

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

        JLabel labelSearchKey = new JLabel("상세정보 : " + keyword);   //도서 검색 키
        labelSearchKey.setBounds(490, 150, 300, 30);
        labelSearchKey.setHorizontalAlignment(JLabel.CENTER);
        labelSearchKey.setFont(mainFont20);
        add(labelSearchKey);

        JPanel panelSearchKey = new JPanel();  //도서 검색 키 구분선
        panelSearchKey.setBounds(415, 190, 450, 2);
        panelSearchKey.setBackground(mainBlue);
        add(panelSearchKey);



        ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
        ButtonBackPage.setBounds(580,600,120,40);
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
            String keyword = textSearch.getText();
            TextSearchResultPage SR = new TextSearchResultPage(keyword);
            setVisible(false);
            dispose();

        } else if (event.equals("BackPage")) {
            MainPage MP = new MainPage();
            setVisible(false);
            dispose();

        }
    }
}