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
    JLabel labelBook1ID;

    JLabel labelBook2Title;
    JLabel labelBook2Author;
    JLabel labelBook2PublicationDate;
    JLabel labelBook2Publisher ;
    JLabel labelBook2ID;

    JLabel labelBook3Title;
    JLabel labelBook3Author;
    JLabel labelBook3PublicationDate;
    JLabel labelBook3Publisher ;
    JLabel labelBook3ID;

    private static final String DB_FILE_NAME = "books.json";

    public TextSearchResultPage(String keyword){

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

        for (int i = 0; i < resultBookSize; i++) {
            ResultBooks[i] = searchedBooks.get(i);
        }

        String[] title = new String[resultBookSize];
        String[] author = new String[resultBookSize];
        String[] publisher = new String[resultBookSize];
        String[] year = new String[resultBookSize];
        String[] id = new String[resultBookSize];

        for (int i = 0; i < resultBookSize; i++) {
            Book book = ResultBooks[i];
            title[i] = book.getTitle();
            author[i] = book.getAuthor();
            publisher[i] = book.getPublisher();
            year[i] = book.getYear();
            id[i] = book.getId();
        }

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

        if ((resultBookSize % 3) == 1){
            labelBook1Title = new JLabel(title[0]);   //도서1 제목
            labelBook1Title.setBounds(400, 200, 120, 35);
            //labelBook1Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Title.setFont(mainFont20);
            add(labelBook1Title);

            labelBook1Author = new JLabel(author[0]);   //도서1 저자
            labelBook1Author.setBounds(400, 240, 120, 35);
            //labelBook1Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Author.setFont(mainFont20);
            add(labelBook1Author);

            labelBook1Publisher = new JLabel(publisher[0]);   //도서1 출판사
            labelBook1Publisher.setBounds(525, 240, 120, 35);
            //labelBook1Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Publisher.setFont(mainFont20);
            add(labelBook1Publisher);

            labelBook1PublicationDate = new JLabel(year[0]);   //도서1 출판년도
            labelBook1PublicationDate.setBounds(650, 240, 120, 35);
            //labelBook1PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook1PublicationDate.setFont(mainFont20);
            add(labelBook1PublicationDate);

            labelBook1ID = new JLabel(id[0]);   //도서1 관리번호
            labelBook1ID.setBounds(775, 240, 120, 35);
            //labelBook1ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook1ID.setFont(mainFont20);
            add(labelBook1ID);
        }

        if ((resultBookSize % 3) == 2){
            labelBook2Title = new JLabel(title[1]);   //도서2 제목
            labelBook2Title.setBounds(400, 300, 120, 35);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Title.setFont(mainFont20);
            add(labelBook2Title);

            labelBook2Author = new JLabel(author[1]);   //도서2 저자
            labelBook2Author.setBounds(400, 340, 120, 35);
            //labelBook2Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Author.setFont(mainFont20);
            add(labelBook2Author);

            labelBook2Publisher = new JLabel(publisher[1]);   //도서2 출판사
            labelBook2Publisher.setBounds(525, 340, 120, 35);
            //labelBook2Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Publisher.setFont(mainFont20);
            add(labelBook2Publisher);

            labelBook2PublicationDate = new JLabel(year[1]);   //도서2 출판년도
            labelBook2PublicationDate.setBounds(650, 340, 120, 35);
            //labelBook2PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook2PublicationDate.setFont(mainFont20);
            add(labelBook2PublicationDate);

            labelBook2ID = new JLabel(id[1]);   //도서2 관리번호
            labelBook2ID.setBounds(775, 340, 120, 35);
            //labelBook2ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook2ID.setFont(mainFont20);
            add(labelBook2ID);
        }

        if ((resultBookSize % 3) == 3){
            labelBook3Title = new JLabel(title[2]);   //도서3 제목
            labelBook3Title.setBounds(400, 400, 120, 35);
            //labelBook3Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Title.setFont(mainFont20);
            add(labelBook3Title);

            labelBook3Author = new JLabel(author[2]);   //도서3 저자
            labelBook3Author.setBounds(400, 440, 120, 35);
            //labelBook3Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Author.setFont(mainFont20);
            add(labelBook3Author);

            labelBook3Publisher = new JLabel(publisher[2]);   //도서3 출판사
            labelBook3Publisher.setBounds(525, 440, 120, 35);
            //labelBook3Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Publisher.setFont(mainFont20);
            add(labelBook3Publisher);

            labelBook3PublicationDate = new JLabel(year[2]);   //도서3 출판년도
            labelBook3PublicationDate.setBounds(650, 440, 120, 35);
            //labelBook3PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook3PublicationDate.setFont(mainFont20);
            add(labelBook3PublicationDate);

            labelBook3ID = new JLabel(id[2]);   //도서3 관리번호
            labelBook3ID.setBounds(775, 440, 120, 35);
            //labelBook3ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook3ID.setFont(mainFont20);
            add(labelBook3ID);
        }


        ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
        ButtonBackPage.setBounds(580,550,120,40);
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