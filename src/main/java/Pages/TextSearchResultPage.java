package Pages;

import AdminPages.AdminPage;
import BookCRUD.Book;
import BookCRUD.BookController;
import BookCRUD.BookDatabase;
import Res.UserInfo;
import UserUpdate.MyInfoPage;
import UserUpdate.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import static UserUpdate.UserInfo.readUserJSON;
import static UserUpdate.UserInfo.saveUserJSON;

public class TextSearchResultPage extends JFrame implements ActionListener{

    JTextField textSearch;
    JButton ButtonSearch;
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

    JLabel labelBook4Title;
    JLabel labelBook4Author;
    JLabel labelBook4PublicationDate;
    JLabel labelBook4Publisher ;
    JLabel labelBook4ID;

    JLabel labelBook5Title;
    JLabel labelBook5Author;
    JLabel labelBook5PublicationDate;
    JLabel labelBook5Publisher ;
    JLabel labelBook5ID;

    String SK;
    private static final String DB_FILE_NAME = "books.json";

    public TextSearchResultPage(String SearchKeyword, int searchKey){

        SK = SearchKeyword;

        BookDatabase database = new BookDatabase(DB_FILE_NAME);
        BookController controller = new BookController();
        List<Book> books = null;
        try {
            books = database.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        controller.addAll(books);
        List<Book> searchedBooks = controller.searchBooks(SearchKeyword);
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
        java.awt.Font mainFont18 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 18);
        java.awt.Font mainFont11 = new java.awt.Font("맑은 고딕", Font.PLAIN, 7);
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

        JLabel labelSearchKey = new JLabel("검색어 : " + SearchKeyword);   //도서 검색 키
        labelSearchKey.setBounds(490, 150, 300, 30);
        labelSearchKey.setHorizontalAlignment(JLabel.CENTER);
        labelSearchKey.setFont(mainFont20);
        add(labelSearchKey);

        JPanel panelSearchKey = new JPanel();  //도서 검색 키 구분선
        panelSearchKey.setBounds(415, 190, 450, 2);
        panelSearchKey.setBackground(mainBlue);
        add(panelSearchKey);

        int bookSearchSize = 0;
        resultBookSize = resultBookSize - searchKey*5;

        if (resultBookSize <= 5) {
            bookSearchSize = resultBookSize;
        } else {
            bookSearchSize = 5;
        }

        int book1 = searchKey*5;
        int book2 = searchKey*5 + 1;
        int book3 = searchKey*5 + 2;
        int book4 = searchKey*5 + 3;
        int book5 = searchKey*5 + 4;


        if (bookSearchSize > 0){

            JPanel panelBook1Image = new JPanel();  //도서1 이미지
            panelBook1Image.setBounds(420, 200, 60, 60);
            panelBook1Image.setBackground(Color.gray);
            add(panelBook1Image);

            labelBook1Title = new JLabel(title[book1]);   //도서1 제목
            labelBook1Title.setBounds(500, 200, 200, 25);
            //labelBook1Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Title.setFont(mainFont18);
            add(labelBook1Title);


            labelBook1ID = new JLabel(id[book1]);   //도서1 관리번호
            labelBook1ID.setBounds(690, 200, 150, 25);
            //labelBook1ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook1ID.setFont(mainFont18);
            add(labelBook1ID);

            labelBook1Author = new JLabel(author[book1]);   //도서1 저자
            labelBook1Author.setBounds(500, 230, 70, 25);
            //labelBook1Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Author.setFont(mainFont18);
            add(labelBook1Author);

            labelBook1Publisher = new JLabel(publisher[book1]);   //도서1 출판사
            labelBook1Publisher.setBounds(570, 230, 120, 25);
            //labelBook1Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Publisher.setFont(mainFont18);
            add(labelBook1Publisher);

            labelBook1PublicationDate = new JLabel(String.valueOf(year[book1]));   //도서1 출판년도
            labelBook1PublicationDate.setBounds(690, 230, 100, 25);
            //labelBook1PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook1PublicationDate.setFont(mainFont18);
            add(labelBook1PublicationDate);

            JPanel panelBook1 = new JPanel();  //도서 검색 키 구분선
            panelBook1.setBounds(415, 265, 450, 2);
            panelBook1.setBackground(Color.gray);
            add(panelBook1);

            JButton ButtonBook1 = new JButton();   //도서1 상세정보 버튼
            ButtonBook1.setText("<HTML><body><center>상세<br>정보</center></body></HTML>");
            ButtonBook1.setBounds(820, 200, 45, 60);
            ButtonBook1.setFont(mainFont18);
            //ButtonBook1.setBorderPainted(false);
            ButtonBook1.setContentAreaFilled(false);
            ButtonBook1.setFocusPainted(false);
            ButtonBook1.setActionCommand("Book1");
            ButtonBook1.addActionListener(this);
            add(ButtonBook1);

        }

        if (bookSearchSize > 1){
            JPanel panelBook2Image = new JPanel();  //도서2 이미지
            panelBook2Image.setBounds(420, 275, 60, 60);
            panelBook2Image.setBackground(Color.gray);
            add(panelBook2Image);

            labelBook2Title = new JLabel(title[book2]);   //도서1 제목
            labelBook2Title.setBounds(500, 275, 200, 30);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Title.setFont(mainFont18);
            add(labelBook2Title);

            labelBook2ID = new JLabel(id[book2]);   //도서1 관리번호
            labelBook2ID.setBounds(690, 275, 120, 30);
            //labelBook2ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook2ID.setFont(mainFont18);
            add(labelBook2ID);

            labelBook2Author = new JLabel(author[book2]);   //도서1 저자
            labelBook2Author.setBounds(500, 305, 70, 30);
            //labelBook2Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Author.setFont(mainFont18);
            add(labelBook2Author);

            labelBook2Publisher = new JLabel(publisher[book2]);   //도서1 출판사
            labelBook2Publisher.setBounds(570, 305, 120, 30);
            //labelBook2Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Publisher.setFont(mainFont18);
            add(labelBook2Publisher);

            labelBook2PublicationDate = new JLabel(String.valueOf(year[book2]));   //도서1 출판년도
            labelBook2PublicationDate.setBounds(690, 305, 100, 30);
            //labelBook2PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook2PublicationDate.setFont(mainFont18);
            add(labelBook2PublicationDate);

            JPanel panelBook2 = new JPanel();  //도서 검색 키 구분선
            panelBook2.setBounds(415, 340, 450, 2);
            panelBook2.setBackground(Color.gray);
            add(panelBook2);

            JButton ButtonBook2 = new JButton();   //도서1 상세정보 버튼
            ButtonBook2.setText("<HTML><body><center>상세<br>정보</center></body></HTML>");
            ButtonBook2.setBounds(820,275,45,60);
            ButtonBook2.setFont(mainFont18);
            //ButtonBook2.setBorderPainted(false);
            ButtonBook2.setContentAreaFilled(false);
            ButtonBook2.setFocusPainted(false);
            ButtonBook2.setActionCommand("Book2");
            ButtonBook2.addActionListener(this);
            add(ButtonBook2);
        }

        if (bookSearchSize > 2){

            JPanel panelBook3Image = new JPanel();  //도서3 이미지
            panelBook3Image.setBounds(420, 350, 60, 60);
            panelBook3Image.setBackground(Color.gray);
            add(panelBook3Image);

            labelBook3Title = new JLabel(title[book3]);   //도서3 제목
            labelBook3Title.setBounds(500, 350, 200, 25);
            //labelBook3Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Title.setFont(mainFont18);
            add(labelBook3Title);

            labelBook3ID = new JLabel(id[book3]);   //도서3 관리번호
            labelBook3ID.setBounds(690, 350, 120, 25);
            //labelBook3ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook3ID.setFont(mainFont18);
            add(labelBook3ID);

            labelBook3Author = new JLabel(author[book3]);   //도서3 저자
            labelBook3Author.setBounds(500, 380, 70, 25);
            //labelBook3Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Author.setFont(mainFont18);
            add(labelBook3Author);

            labelBook3Publisher = new JLabel(publisher[book3]);   //도서3 출판사
            labelBook3Publisher.setBounds(570, 380, 120, 25);
            //labelBook3Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Publisher.setFont(mainFont18);
            add(labelBook3Publisher);

            labelBook3PublicationDate = new JLabel(String.valueOf(year[book3]));   //도서3 출판년도
            labelBook3PublicationDate.setBounds(690, 380, 120, 25);
            //labelBook3PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook3PublicationDate.setFont(mainFont18);
            add(labelBook3PublicationDate);

            JPanel panelBook3 = new JPanel();  //도서 검색 키 구분선
            panelBook3.setBounds(415, 415, 450, 2);
            panelBook3.setBackground(Color.gray);
            add(panelBook3);

            JButton ButtonBook3 = new JButton();   //도서3 상세정보 버튼
            ButtonBook3.setText("<HTML><body><center>상세<br>정보</center></body></HTML>");
            ButtonBook3.setBounds(820,350,45,60);
            ButtonBook3.setFont(mainFont18);
            //ButtonBook3.setBorderPainted(false);
            ButtonBook3.setContentAreaFilled(false);
            ButtonBook3.setFocusPainted(false);
            ButtonBook3.setActionCommand("Book3");
            ButtonBook3.addActionListener(this);
            add(ButtonBook3);

        }
        if (bookSearchSize > 3){

            JPanel panelBook4Image = new JPanel();  //도서4 이미지
            panelBook4Image.setBounds(420, 425, 60, 60);
            panelBook4Image.setBackground(Color.gray);
            add(panelBook4Image);

            labelBook4Title = new JLabel(title[book4]);   //도서4 제목
            labelBook4Title.setBounds(500, 425, 200, 25);
            //labelBook4Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook4Title.setFont(mainFont18);
            add(labelBook4Title);

            labelBook4ID = new JLabel(id[book4]);   //도서4 관리번호
            labelBook4ID.setBounds(690, 425, 120, 25);
            //labelBook4ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook4ID.setFont(mainFont18);
            add(labelBook4ID);

            labelBook4Author = new JLabel(author[book4]);   //도서4 저자
            labelBook4Author.setBounds(500, 455, 70, 25);
            //labelBook4Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook4Author.setFont(mainFont18);
            add(labelBook4Author);

            labelBook4Publisher = new JLabel(publisher[book4]);   //도서4 출판사
            labelBook4Publisher.setBounds(570, 455, 120, 25);
            //labelBook4Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook4Publisher.setFont(mainFont18);
            add(labelBook4Publisher);

            labelBook4PublicationDate = new JLabel(String.valueOf(year[book4]));   //도서4 출판년도
            labelBook4PublicationDate.setBounds(690, 455, 120, 25);
            //labelBook4PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook4PublicationDate.setFont(mainFont18);
            add(labelBook4PublicationDate);

            JPanel panelBook4 = new JPanel();  //도서 검색 키 구분선
            panelBook4.setBounds(415, 490, 450, 2);
            panelBook4.setBackground(Color.gray);
            add(panelBook4);

            JButton ButtonBook4 = new JButton();   //도서4 상세정보 버튼
            ButtonBook4.setText("<HTML><body><center>상세<br>정보</center></body></HTML>");
            ButtonBook4.setBounds(820,425,45,60);
            ButtonBook4.setFont(mainFont18);
            //ButtonBook4.setBorderPainted(false);
            ButtonBook4.setContentAreaFilled(false);
            ButtonBook4.setFocusPainted(false);
            ButtonBook4.setActionCommand("Book4");
            ButtonBook4.addActionListener(this);
            add(ButtonBook4);

        }
        if (bookSearchSize > 4){

            JPanel panelBook5Image = new JPanel();  //도서5 이미지
            panelBook5Image.setBounds(420, 500, 60, 60);
            panelBook5Image.setBackground(Color.gray);
            add(panelBook5Image);

            labelBook5Title = new JLabel(title[book5]);   //도서5 제목
            labelBook5Title.setBounds(500, 500, 200, 25);
            //labelBook5Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook5Title.setFont(mainFont18);
            add(labelBook5Title);

            labelBook5ID = new JLabel(id[book5]);   //도서5 관리번호
            labelBook5ID.setBounds(690, 500, 120, 25);
            //labelBook5ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook5ID.setFont(mainFont18);
            add(labelBook5ID);

            labelBook5Author = new JLabel(author[book5]);   //도서5 저자
            labelBook5Author.setBounds(500, 530, 70, 25);
            //labelBook5Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook5Author.setFont(mainFont18);
            add(labelBook5Author);

            labelBook5Publisher = new JLabel(publisher[book5]);   //도서5 출판사
            labelBook5Publisher.setBounds(570, 530, 120, 25);
            //labelBook5Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook5Publisher.setFont(mainFont18);
            add(labelBook5Publisher);

            labelBook5PublicationDate = new JLabel(String.valueOf(year[book5]));   //도서5 출판년도
            labelBook5PublicationDate.setBounds(690, 530, 120, 25);
            //labelBook5PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook5PublicationDate.setFont(mainFont18);
            add(labelBook5PublicationDate);

            JPanel panelBook5 = new JPanel();  //도서 검색 키 구분선
            panelBook5.setBounds(415, 565, 450, 2);
            panelBook5.setBackground(Color.gray);
            add(panelBook5);



            JButton ButtonBook5 = new JButton();   //도서5 상세정보 버튼
            ButtonBook5.setText("<HTML><body><center>상세<br>정보</center></body></HTML>");
            ButtonBook5.setBounds(820,500,45,60);
            ButtonBook5.setFont(mainFont18);
            //ButtonBook5.setBorderPainted(false);
            ButtonBook5.setContentAreaFilled(false);
            ButtonBook5.setFocusPainted(false);
            ButtonBook5.setActionCommand("Book5");
            ButtonBook5.addActionListener(this);
            add(ButtonBook5);

        }

        if (UserInfo.getInstance().getUserID()!=null) {

            JButton ButtonMyPage = new JButton("<HTML><body><center>마이페이지</center></body></HTML>");   //회원 정보 페이지 버튼
            ButtonMyPage.setBounds(1100, 100, 120, 40);
            ButtonMyPage.setFont(mainFont20);
            ButtonMyPage.setContentAreaFilled(false);
            ButtonMyPage.setFocusPainted(false);
            ButtonMyPage.setActionCommand("MyPage");
            ButtonMyPage.addActionListener(this);
            add(ButtonMyPage);
        }

        int buttNum = searchKey;
        buttNum ++;
//        if(buttNum>0) {
//            JButton ButtonNextPage = new JButton(String.valueOf(searchKey));   //페이지 이동 버튼
//            ButtonNextPage.setBounds(580, 580, 30, 30);
//            ButtonNextPage.setFont(mainFont11);
//            //ButtonNextPage.setBorderPainted(false);
//            ButtonNextPage.setContentAreaFilled(false);
//            ButtonNextPage.setFocusPainted(false);
//            ButtonNextPage.setActionCommand("");
//            ButtonNextPage.addActionListener(this);
//            add(ButtonNextPage);
//        }

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
        String DetailKeyword;

        if (event.equals("TextSearch")) {
            String keyword = textSearch.getText();
            TextSearchResultPage SR = new TextSearchResultPage(keyword, 0);
            dispose();

        } else if (event.equals("BackPage")) {
            if (UserInfo.getInstance().getUserID().equals("admin")) {
                AdminPage AP = new AdminPage();
                dispose();
            } else {
                MainPage MP = new MainPage();
                dispose();
            }
        } else if (event.equals("Book1")) {
            DetailKeyword = labelBook1ID.getText();
            BookDetailPage BDP = new BookDetailPage(DetailKeyword, SK);
            dispose();
        } else if (event.equals("Book2")){
            DetailKeyword = labelBook2ID.getText();
            BookDetailPage BDP = new BookDetailPage(DetailKeyword, SK);
            dispose();
        } else if (event.equals("Book3")){
            DetailKeyword = labelBook3ID.getText();
            BookDetailPage BDP = new BookDetailPage(DetailKeyword, SK);
            dispose();
        } else if (event.equals("Book4")){
            DetailKeyword = labelBook4ID.getText();
            BookDetailPage BDP = new BookDetailPage(DetailKeyword, SK);
            dispose();
        } else if (event.equals("Book5")){
            DetailKeyword = labelBook5ID.getText();
            BookDetailPage BDP = new BookDetailPage(DetailKeyword, SK);
            dispose();
        } else if (event.equals("MyPage")) {
            User[] users = readUserJSON("users.json");
            MyInfoPage infoPage = new MyInfoPage(users[0], "users.json", users);
            saveUserJSON("users.json", users);
            dispose();
        }
    }


}