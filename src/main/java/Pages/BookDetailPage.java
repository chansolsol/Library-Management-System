package Pages;

import BookCRUD.Book;
import BookCRUD.BookController;
import BookCRUD.BookDatabase;
import Res.UserInfo;

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
    String SK;

    private static final String DB_FILE_NAME = "books.json";

    public BookDetailPage(String keyword, String SearchKeyword){

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
        List<Book> searchedBooks = controller.detailBooks(keyword);
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
        java.awt.Font mainFont25 = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 25);
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

        JLabel labelSearchKey = new JLabel(title[0]);   //도서 검색 키
        labelSearchKey.setBounds(490, 150, 300, 40);
        labelSearchKey.setHorizontalAlignment(JLabel.CENTER);
        labelSearchKey.setFont(mainFont25);
        add(labelSearchKey);

        /*JPanel panelSearchKey = new JPanel();  //도서 검색 키 구분선
        panelSearchKey.setBounds(415, 190, 450, 2);
        panelSearchKey.setBackground(mainBlue);
        add(panelSearchKey);*/


        JPanel panelBook1Image = new JPanel();  //도서1 이미지
        panelBook1Image.setBounds(375, 200, 100, 100);
        panelBook1Image.setBackground(Color.gray);
        add(panelBook1Image);

        JLabel labelTitle = new JLabel("제목 :");   //도서1 제목
        labelTitle.setBounds(525, 200, 150, 30);
        //labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setFont(mainFont20);
        add(labelTitle);

        JLabel labelBook1Title = new JLabel(title[0]);   //도서1 제목
        labelBook1Title.setBounds(705, 200, 200, 30);
        //labelBook1Title.setHorizontalAlignment(JLabel.CENTER);
        labelBook1Title.setFont(mainFont20);
        add(labelBook1Title);


        JLabel labelAuthor = new JLabel("저자 :");   //도서1 저자
        labelAuthor.setBounds(525, 240, 200, 30);
        //labelAuthor.setHorizontalAlignment(JLabel.CENTER);
        labelAuthor.setFont(mainFont20);
        add(labelAuthor);

        JLabel labelBook1Author = new JLabel(author[0]);   //도서1 저자
        labelBook1Author.setBounds(705, 240, 200, 30);
        //labelBook1Author.setHorizontalAlignment(JLabel.CENTER);
        labelBook1Author.setFont(mainFont20);
        add(labelBook1Author);


        JLabel labelPublisher = new JLabel("출판사 :");   //도서1 출판사
        labelPublisher.setBounds(525, 280, 200, 30);
        //labelPublisher.setHorizontalAlignment(JLabel.CENTER);
        labelPublisher.setFont(mainFont20);
        add(labelPublisher);

        JLabel labelBook1Publisher = new JLabel(publisher[0]);   //도서1 출판사
        labelBook1Publisher.setBounds(705, 280, 200, 30);
        //labelBook1Publisher.setHorizontalAlignment(JLabel.CENTER);
        labelBook1Publisher.setFont(mainFont20);
        add(labelBook1Publisher);


        JLabel labelPublicationDate = new JLabel("출판년도 :");   //도서1 출판년도
        labelPublicationDate.setBounds(525, 320, 200, 30);
        //labelPublicationDate.setHorizontalAlignment(JLabel.CENTER);
        labelPublicationDate.setFont(mainFont20);
        add(labelPublicationDate);

        JLabel labelBook1PublicationDate = new JLabel(year[0]);   //도서1 출판년도
        labelBook1PublicationDate.setBounds(705, 320, 200, 30);
        //labelBook1PublicationDate.setHorizontalAlignment(JLabel.CENTER);
        labelBook1PublicationDate.setFont(mainFont20);
        add(labelBook1PublicationDate);


        JLabel labelID = new JLabel("관리번호 :");   //도서1 관리번호
        labelID.setBounds(525, 360, 200, 30);
        //labelID.setHorizontalAlignment(JLabel.CENTER);
        labelID.setFont(mainFont20);
        add(labelID);

        JLabel labelBook1ID = new JLabel(id[0]);   //도서1 관리번호
        labelBook1ID.setBounds(705, 360, 200, 30);
        //labelBook1ID.setHorizontalAlignment(JLabel.CENTER);
        labelBook1ID.setFont(mainFont20);
        add(labelBook1ID);


        if (UserInfo.getInstance().getUserID()!=null) {
            JButton ButtonLoan = new JButton("도서 대출");   //도서대출 버튼
            ButtonLoan.setBounds(565, 410, 150, 40);
            ButtonLoan.setFont(mainFont20);
            //ButtonLoan.setBorderPainted(false);
            ButtonLoan.setContentAreaFilled(false);
            ButtonLoan.setFocusPainted(false);
            ButtonLoan.setActionCommand("Loan");
            ButtonLoan.addActionListener(this);
            add(ButtonLoan);

            JButton ButtonReserve = new JButton("도서 예약");   //도서예약 버튼
            ButtonReserve.setBounds(565, 460, 150, 40);
            ButtonReserve.setFont(mainFont20);
            //ButtonReserve.setBorderPainted(false);
            ButtonReserve.setContentAreaFilled(false);
            ButtonReserve.setFocusPainted(false);
            ButtonReserve.setActionCommand("Reserve");
            ButtonReserve.addActionListener(this);
            add(ButtonReserve);
        }


        /*JPanel panelCreateWhite = new JPanel();
        panelCreateWhite.setBounds(443, 114, 492, 492);
        panelCreateWhite.setBackground(Color.white);
        add(panelCreateWhite);
        panelCreateWhite.setLayout(null);

        JPanel panelCreateBlue = new JPanel();
        panelCreateBlue.setBounds(440, 110, 500, 500);
        panelCreateBlue.setBackground(mainBlue);
        add(panelCreateBlue);
        panelCreateBlue.setLayout(null);*/

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

        if (event.equals("TextSearch")) {
            String keyword = textSearch.getText();
            TextSearchResultPage SR = new TextSearchResultPage(keyword);
            dispose();

        } else if (event.equals("BackPage")) {
            TextSearchResultPage SR = new TextSearchResultPage(SK);
            dispose();

        }
    }
}