package Pages;

import HopeBookRequest.DeleteBookRequest;
import HopeBookRequest.HopeBook;
import HopeBookRequest.UpdateBookRequest;
import LibrarySeatReservation.Command;
import LibrarySeatReservation.LibrarySeat;
import Res.UserInfo;
import UserUpdate.MyInfoPage;
import UserUpdate.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static UserUpdate.UserInfo.readUserJSON;
import static UserUpdate.UserInfo.saveUserJSON;

public class MyRequestedBookPage extends JFrame implements ActionListener {

    JPanel panelMainBlue;
    JLabel labelMain;
    JTextField textSearch;
    private static final String HOPE_BOOKS = "hopebooks.json";
    List<HopeBook> books;
    List<HopeBook> filteredBooks;
    Gson gson = new Gson();

    JLabel labelBook1Title;
    JLabel labelBook2Title;
    JLabel labelBook3Title;
    JLabel labelBook4Title;
    String[] titles;
    String[] authors;
    String[] publishers;
    String[] years;
    int book1;
    int book2;
    int book3;
    int book4;
    int book5;

    public MyRequestedBookPage(int searchKey) {

        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Library Management System : MyRequestedBookPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        panelMainBlue.setLayout(null);
        add(panelMainBlue);

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


        JPanel panelMenuWhite = new JPanel(); //마이페이지 메뉴 컴포넌트 패널이 위치할 패널
        panelMenuWhite.setBounds(50, 150, 200, 400);
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

        JButton ButtonUserInfo = new JButton("회원정보");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonUserInfo.setBounds(0,100,200,51);
        ButtonUserInfo.setFont(mainFont20);
        ButtonUserInfo.setHorizontalAlignment(JButton.LEFT);
        //ButtonUserInfo.setBorderPainted(false);
        ButtonUserInfo.setContentAreaFilled(false);
        ButtonUserInfo.setFocusPainted(false);
        ButtonUserInfo.setActionCommand("MyInfoPage");
        ButtonUserInfo.addActionListener(this);
        panelMenuWhite.add(ButtonUserInfo);

        JButton ButtonMyBook = new JButton("대출도서조회");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonMyBook.setBounds(0,150,200,51);
        ButtonMyBook.setFont(mainFont20);
        ButtonMyBook.setHorizontalAlignment(JButton.LEFT);
        //ButtonMyBook.setBorderPainted(false);
        ButtonMyBook.setContentAreaFilled(false);
        ButtonMyBook.setFocusPainted(false);
        ButtonMyBook.setActionCommand("MyBookPage");
        ButtonMyBook.addActionListener(this);
        panelMenuWhite.add(ButtonMyBook);

        JButton ButtonRequestBook = new JButton("희망도서내역");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonRequestBook.setBounds(0,250,200,51);
        ButtonRequestBook.setFont(mainFont20);
        ButtonRequestBook.setHorizontalAlignment(JButton.LEFT);
        //ButtonRequestBook.setBorderPainted(false);
        ButtonRequestBook.setContentAreaFilled(false);
        ButtonRequestBook.setFocusPainted(false);
        ButtonRequestBook.setActionCommand("MyRequestedBookPage");
        ButtonRequestBook.addActionListener(this);
        panelMenuWhite.add(ButtonRequestBook);

        JButton ButtonReservedBook = new JButton("예약도서조회");   //뒤로가기 버튼, (LoginPage 생성)
        ButtonReservedBook.setBounds(0,200,200,51);
        ButtonReservedBook.setFont(mainFont20);
        ButtonReservedBook.setHorizontalAlignment(JButton.LEFT);
        //ButtonReservedBook.setBorderPainted(false);
        ButtonReservedBook.setContentAreaFilled(false);
        ButtonReservedBook.setFocusPainted(false);
        ButtonReservedBook.setActionCommand("MyReservedBookPage");
        ButtonReservedBook.addActionListener(this);
        panelMenuWhite.add(ButtonReservedBook);


        JPanel panelMainWhite = new JPanel(); //희망 도서 내역 페이지 컴포넌트가 위치할 패널
        panelMainWhite.setBounds(290, 150, 700, 500);
        panelMainWhite.setBackground(Color.white);
        add(panelMainWhite);
        panelMainWhite.setLayout(null);

        JLabel labelMyRequest = new JLabel("희망 도서 내역");
        labelMyRequest.setBounds(0, 10, 700, 40);
        labelMyRequest.setHorizontalAlignment(JLabel.CENTER);
        labelMyRequest.setFont(mainFont30);
        panelMainWhite.add(labelMyRequest);


        JLabel labelLoanBook = new JLabel("희망 도서 신청 목록");    //"대출한 도서" 메인 라벨
        labelLoanBook.setBounds(20, 60, 220, 35);
        //labelLoanBook.setHorizontalAlignment(JLabel.CENTER);
        labelLoanBook.setFont(mainFont20);
        panelMainWhite.add(labelLoanBook);

        JPanel panelLoanBookBlue = new JPanel();
        panelLoanBookBlue.setBounds(0, 100, 700, 2);
        panelLoanBookBlue.setBackground(mainBlue);
        panelLoanBookBlue.setLayout(null);
        panelMainWhite.add(panelLoanBookBlue);

        JLabel labelTitle = new JLabel("제목");    //"제목" 메인 라벨
        labelTitle.setBounds(20, 110, 200, 35);
        //labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setFont(mainFont20);
        panelMainWhite.add(labelTitle);

        JLabel labelAuthor = new JLabel("저자");    //"제목" 메인 라벨
        labelAuthor.setBounds(200, 110, 200, 35);
        //labelAuthor.setHorizontalAlignment(JLabel.CENTER);
        labelAuthor.setFont(mainFont20);
        panelMainWhite.add(labelAuthor);

        JLabel labelPublisher = new JLabel("출판사");    //"대출일" 메인 라벨, 양식 : 2000-00-00
        labelPublisher.setBounds(300, 110, 200, 35);
        //labelPublisher.setHorizontalAlignment(JLabel.CENTER);
        labelPublisher.setFont(mainFont20);
        panelMainWhite.add(labelPublisher);

        JLabel labelPublicationDate = new JLabel("출판년도");    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
        labelPublicationDate.setBounds(470, 110, 200, 35);
        //labelPublicationDate.setHorizontalAlignment(JLabel.CENTER);
        labelPublicationDate.setFont(mainFont20);
        panelMainWhite.add(labelPublicationDate);

        JLabel labelCancelBook = new JLabel("수정");    //"연장" 메인 라벨, 연장 버튼이 위치함
        labelCancelBook.setBounds(620, 110, 100, 35);
        //labelCancelBook.setHorizontalAlignment(JLabel.CENTER);
        labelCancelBook.setFont(mainFont20);
        panelMainWhite.add(labelCancelBook);



        filteredBooks = new ArrayList<>();

        try {
            java.lang.reflect.Type bookListType = new TypeToken<List<HopeBook>>() {}.getType();

            FileReader reader = new FileReader("hopebooks.json");
            books = gson.fromJson(reader, bookListType);
            reader.close();

            if (books != null) {
                for (HopeBook book : books) {
                    if (book.getHopeID().equals(UserInfo.getInstance().getUserID())) {
                        filteredBooks.add(book);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int resultBookSize = filteredBooks.size();

        titles = new String[resultBookSize];
        authors = new String[resultBookSize];
        publishers = new String[resultBookSize];
        years = new String[resultBookSize];
        for (int i = 0; i < resultBookSize; i++) {
            titles[i] = filteredBooks.get(i).getTitle();
            authors[i] = filteredBooks.get(i).getAuthor();
            publishers[i] = filteredBooks.get(i).getPublisher();
            years[i] = filteredBooks.get(i).getYear();
        }

        int bookSearchSize = 0;
        resultBookSize = resultBookSize - searchKey*5;

        if (resultBookSize <= 5) {
            bookSearchSize = resultBookSize;
        } else {
            bookSearchSize = 5;
        }

        book1 = searchKey*5;
        book2 = searchKey*5 + 1;
        book3 = searchKey*5 + 2;
        book4 = searchKey*5 + 3;
        book5 = searchKey*5 + 4;

        if(bookSearchSize > 0){

            labelBook1Title = new JLabel(titles[book1]);    //"도서1제목" 메인 라벨
            labelBook1Title.setBounds(20, 150, 200, 35);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Title.setFont(mainFont20);
            panelMainWhite.add(labelBook1Title);

            JLabel labelBook1Author = new JLabel(authors[book1]);    //"도서1저자" 메인 라벨, 양식 : 2000-00-00
            labelBook1Author.setBounds(200, 150, 200, 35);
            //labelBook1Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Author.setFont(mainFont20);
            panelMainWhite.add(labelBook1Author);

            JLabel labelBook1Publisher = new JLabel(publishers[book1]);    //"도서1출판사" 메인 라벨, 양식 : 2000-00-00
            labelBook1Publisher.setBounds(300, 150, 200, 35);
            //labelBook1Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Publisher.setFont(mainFont20);
            panelMainWhite.add(labelBook1Publisher);

            JLabel labelBook1PublicationDate = new JLabel(years[book1]);    //"도서1출판년도" 메인 라벨, 양식 : 2000-00-00
            labelBook1PublicationDate.setBounds(470, 150, 200, 35);
            //labelBook1PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook1PublicationDate.setFont(mainFont20);
            panelMainWhite.add(labelBook1PublicationDate);

            JButton ButtonBook1RenewBook = new JButton("<HTML><body><center>수정</center></body></HTML>");   //연장 버튼
            ButtonBook1RenewBook.setBounds(615, 150, 50, 35);
            ButtonBook1RenewBook.setFont(mainFont20);
            //ButtonBook2RenewBook.setBorderPainted(false);
            ButtonBook1RenewBook.setContentAreaFilled(false);
            ButtonBook1RenewBook.setFocusPainted(false);
            ButtonBook1RenewBook.setActionCommand("RequestedBook1");
            ButtonBook1RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook1RenewBook);
        }
        if(bookSearchSize > 1) {

            labelBook2Title = new JLabel(titles[book2]);    //"도서2제목" 메인 라벨
            labelBook2Title.setBounds(20, 190, 200, 35);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Title.setFont(mainFont20);
            panelMainWhite.add(labelBook2Title);

            JLabel labelBook2Author = new JLabel(authors[book2]);    //"도서2저자" 메인 라벨
            labelBook2Author.setBounds(200, 190, 200, 35);
            //labelBook2Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Author.setFont(mainFont20);
            panelMainWhite.add(labelBook2Author);

            JLabel labelBook2Publisher = new JLabel(publishers[book2]);    //"도서2출판사" 메인 라벨
            labelBook2Publisher.setBounds(300, 190, 200, 35);
            //labelBook2Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Publisher.setFont(mainFont20);
            panelMainWhite.add(labelBook2Publisher);

            JLabel labelBook2PublicationDate = new JLabel(years[book2]);    //"도서2출판년도" 메인 라벨
            labelBook2PublicationDate.setBounds(470, 190, 200, 35);
            //labelBook2PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook2PublicationDate.setFont(mainFont20);
            panelMainWhite.add(labelBook2PublicationDate);

            JButton ButtonBook2RenewBook = new JButton("<HTML><body><center>수정</center></body></HTML>");   //연장 버튼
            ButtonBook2RenewBook.setBounds(615, 190, 50, 35);
            ButtonBook2RenewBook.setFont(mainFont20);
            //ButtonBook2RenewBook.setBorderPainted(false);
            ButtonBook2RenewBook.setContentAreaFilled(false);
            ButtonBook2RenewBook.setFocusPainted(false);
            ButtonBook2RenewBook.setActionCommand("RequestedBook2");
            ButtonBook2RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook2RenewBook);
        }
        if(bookSearchSize > 2) {

            labelBook3Title = new JLabel(titles[book3]);    //"도서3제목" 메인 라벨
            labelBook3Title.setBounds(20, 230, 200, 35);
            //labelBook3Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Title.setFont(mainFont20);
            panelMainWhite.add(labelBook3Title);

            JLabel labelBook3Author = new JLabel(authors[book3]);    //"도서3저자" 메인 라벨
            labelBook3Author.setBounds(200, 230, 200, 35);
            //labelBook3Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Author.setFont(mainFont20);
            panelMainWhite.add(labelBook3Author);

            JLabel labelBook3Publisher = new JLabel(publishers[book3]);    //"도서3출판사" 메인 라벨
            labelBook3Publisher.setBounds(300, 230, 200, 35);
            //labelBook3Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Publisher.setFont(mainFont20);
            panelMainWhite.add(labelBook3Publisher);

            JLabel labelBook3PublicationDate = new JLabel(years[book3]);    //"도서3출판년도" 메인 라벨
            labelBook3PublicationDate.setBounds(470, 230, 200, 35);
            //labelBook3PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook3PublicationDate.setFont(mainFont20);
            panelMainWhite.add(labelBook3PublicationDate);

            JButton ButtonBook3RenewBook = new JButton("<HTML><body><center>수정</center></body></HTML>");   //연장 버튼
            ButtonBook3RenewBook.setBounds(615, 230, 50, 35);
            ButtonBook3RenewBook.setFont(mainFont20);
            //ButtonBook3RenewBook.setBorderPainted(false);
            ButtonBook3RenewBook.setContentAreaFilled(false);
            ButtonBook3RenewBook.setFocusPainted(false);
            ButtonBook3RenewBook.setActionCommand("RequestedBook3");
            ButtonBook3RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook3RenewBook);
        }
        if(bookSearchSize>3){

            labelBook4Title = new JLabel(titles[book4]);    //"도서4제목" 메인 라벨
            labelBook4Title.setBounds(20, 280, 200, 35);
            //labelBook4Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook4Title.setFont(mainFont20);
            panelMainWhite.add(labelBook4Title);

            JLabel labelBook4Author = new JLabel(authors[book4]);    //"도서4저자" 메인 라벨
            labelBook4Author.setBounds(200, 280, 200, 35);
            //labelBook4Author.setHorizontalAlignment(JLabel.CENTER);
            labelBook4Author.setFont(mainFont20);
            panelMainWhite.add(labelBook4Author);

            JLabel labelBook4Publisher = new JLabel(publishers[book4]);    //"도서4출판사" 메인 라벨
            labelBook4Publisher.setBounds(300, 280, 200, 35);
            //labelBook4Publisher.setHorizontalAlignment(JLabel.CENTER);
            labelBook4Publisher.setFont(mainFont20);
            panelMainWhite.add(labelBook4Publisher);

            JLabel labelBook4PublicationDate = new JLabel(years[book4]);    //"도서4출판년도" 메인 라벨
            labelBook4PublicationDate.setBounds(470, 280, 200, 35);
            //labelBook4PublicationDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook4PublicationDate.setFont(mainFont20);
            panelMainWhite.add(labelBook4PublicationDate);

            JButton ButtonBook4RenewBook = new JButton("<HTML><body><center>수정</center></body></HTML>");   //연장 버튼
            ButtonBook4RenewBook.setBounds(615, 280, 50, 35);
            ButtonBook4RenewBook.setFont(mainFont20);
            //ButtonBook4RenewBook.setBorderPainted(false);
            ButtonBook4RenewBook.setContentAreaFilled(false);
            ButtonBook4RenewBook.setFocusPainted(false);
            ButtonBook4RenewBook.setActionCommand("RequestedBook4");
            ButtonBook4RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook4RenewBook);
        }

        JButton ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
        ButtonBackPage.setBounds(300,400,120,40);
        ButtonBackPage.setFont(mainFont20);
        //ButtonBackPage.setBorderPainted(false);
        ButtonBackPage.setContentAreaFilled(false);
        ButtonBackPage.setFocusPainted(false);
        ButtonBackPage.setActionCommand("BackPage");
        ButtonBackPage.addActionListener(this);
        panelMainWhite.add(ButtonBackPage);

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정
    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();
        JFrame alert = new JFrame();
        //DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
        String[] options = { "  수 정  ", "  삭 제  ", "  취 소  " };

        if (event.equals("TextSearch")) {
            String keyword = textSearch.getText();
            TextSearchResultPage SR = new TextSearchResultPage(keyword, 0);
            dispose();
        }
        if (event.equals("RequestedBook1")) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    "희망 도서 수정",
                    "기능 선택",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (result == 0) {
                // "수정"
                int resultR = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 수정하시겠습니까?");
                if(resultR==0){
                    String title = titles[book1];
                    String author = authors[book1];
                    String publisher = publishers[book1];
                    String year = years[book1];

                    UpdateBookRequest updateBookRequest = new UpdateBookRequest();
                    updateBookRequest.requestBook(title, author, publisher, year);

                    new MyRequestedBookPage(0);
                }

            } else if (result == 1) {
                // "삭제"
                int resultE = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 삭제하시겠습니까?");
                if(resultE==0){
                    String title = titles[book1];
                    String author = authors[book1];
                    String publisher = publishers[book1];
                    String year = years[book1];

                    DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
                    deleteBookRequest.requestBook(title, author, publisher, year);

                    new MyRequestedBookPage(0);
                }
            } else if (result == 2) {
                // "취소"
                //공백으로 두면 됨
            }


        } else if (event.equals("RequestedBook2")) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    "희망 도서 수정",
                    "기능 선택",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (result == 0) {
                // "수정"
                int resultR = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 수정하시겠습니까?");
                if(resultR==0){

                    String title = titles[book2];
                    String author = authors[book2];
                    String publisher = publishers[book2];
                    String year = years[book2];

                    UpdateBookRequest updateBookRequest = new UpdateBookRequest();
                    updateBookRequest.requestBook(title, author, publisher, year);

                    MyRequestedBookPage MRB = new MyRequestedBookPage(0);
                    dispose();
                }

            } else if (result == 1) {
                // "삭제"
                int resultE = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 삭제하시겠습니까?");
                if(resultE==0){
                    String title = titles[book2];
                    String author = authors[book2];
                    String publisher = publishers[book2];
                    String year = years[book2];

                    DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
                    deleteBookRequest.requestBook(title, author, publisher, year);

                    MyRequestedBookPage MRB = new MyRequestedBookPage(0);
                    dispose();

                }
            } else if (result == 2) {
                // "취소"
                //공백으로 두면 됨
            }
        } else if (event.equals("RequestedBook3")) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    "희망 도서 수정",
                    "기능 선택",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (result == 0) {
                // "수정"
                int resultR = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 수정하시겠습니까?");
                if(resultR==0){

                    String title = titles[book3];
                    String author = authors[book3];
                    String publisher = publishers[book3];
                    String year = years[book3];

                    UpdateBookRequest updateBookRequest = new UpdateBookRequest();
                    updateBookRequest.requestBook(title, author, publisher, year);

                    MyRequestedBookPage MRB = new MyRequestedBookPage(0);
                    dispose();
                }

            } else if (result == 1) {
                // "삭제"
                int resultE = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 삭제하시겠습니까?");
                if(resultE==0){

                    String title = titles[book3];
                    String author = authors[book3];
                    String publisher = publishers[book3];
                    String year = years[book3];

                    DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
                    deleteBookRequest.requestBook(title, author, publisher, year);

                    MyRequestedBookPage MRB = new MyRequestedBookPage(0);
                    dispose();

                }
            } else if (result == 2) {
                // "취소"
                //공백으로 두면 됨
            }
        } else if (event.equals("RequestedBook4")) {
            int result = JOptionPane.showOptionDialog(
                    null,
                    "희망 도서 수정",
                    "기능 선택",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (result == 0) {
                // "수정"
                int resultR = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 수정하시겠습니까?");
                if(resultR==0){
                    String title = titles[book4];
                    String author = authors[book4];
                    String publisher = publishers[book4];
                    String year = years[book4];

                    UpdateBookRequest updateBookRequest = new UpdateBookRequest();
                    updateBookRequest.requestBook(title, author, publisher, year);

                    MyRequestedBookPage MRB = new MyRequestedBookPage(0);
                    dispose();

                }

            } else if (result == 1) {
                // "삭제"
                int resultE = JOptionPane.showConfirmDialog(alert, "도서 : "+ event + "번을 삭제하시겠습니까?");
                if(resultE==0){
                    String title = titles[book4];
                    String author = authors[book4];
                    String publisher = publishers[book4];
                    String year = years[book4];

                    DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
                    deleteBookRequest.requestBook(title, author, publisher, year);

                    MyRequestedBookPage MRB = new MyRequestedBookPage(0);
                    dispose();

                }
            } else if (result == 2) {
                // "취소"
                //공백으로 두면 됨
            }
        }
        if (event.equals("BackPage")) {
            MainPage MP = new MainPage();
            dispose();
        } else if (event.equals("MyInfoPage")) {
            User[] users = readUserJSON("users.json");
            MyInfoPage infoPage = new MyInfoPage(users[0], "users.json", users);
            saveUserJSON("users.json", users);
            dispose();
        } else if (event.equals("MyBookPage")) {
            MyBookPage MB = new MyBookPage(0);
            dispose();
        } else if(event.equals("MyRequestedBookPage")){
            MyRequestedBookPage MRB = new MyRequestedBookPage(0);
            dispose();
        } else if(event.equals("MyReservedBookPage")) {
            MyReservedBookPage MRB = new MyReservedBookPage(0);
            dispose();
        }

    }
}
