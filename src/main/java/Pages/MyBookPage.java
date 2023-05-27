package Pages;

import BookBRE.BookBRE;
import BookCRUD.Book;
import BookCRUD.BookController;
import BookCRUD.BookDatabase;
import Res.LocalDateAdapter;
import Res.UserInfo;
import UserUpdate.MyInfoPage;
import UserUpdate.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static UserUpdate.UserInfo.readUserJSON;
import static UserUpdate.UserInfo.saveUserJSON;

public class MyBookPage extends JFrame implements ActionListener{

    JPanel panelMainBlue;
    JLabel labelMain;
    JLabel labelBook1ID;
    JLabel labelBook2ID;
    JLabel labelBook3ID;
    JLabel labelBook4ID;
    JLabel labelBook5ID;
    JLabel labelBook1LoanDate;
    JLabel labelBook1ReturnDate;
    JLabel labelBook2LoanDate;
    JLabel labelBook2ReturnDate;
    JLabel labelBook3LoanDate;
    JLabel labelBook3ReturnDate;

    JLabel labelBook4LoanDate;
    JLabel labelBook4ReturnDate;
    JLabel labelBook5LoanDate;
    JLabel labelBook5ReturnDate;

    LocalDate LoanDate1;
    LocalDate LoanDate2;
    LocalDate LoanDate3;
    LocalDate LoanDate4;
    LocalDate LoanDate5;

    JTextField textSearch;

    private static final String DB_FILE_NAME = "books.json";
    public MyBookPage(int searchKey){

        BookDatabase database = new BookDatabase(DB_FILE_NAME);
        BookController controller = new BookController();
        List<Book> books = null;
        try {
            books = database.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        controller.addAll(books);
        List<Book> searchedBooks = controller.UserBooks(UserInfo.getInstance().getUserID());
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
        String[] ID = new String[resultBookSize];
        String[] member = new String[resultBookSize];
        //String[] State = new String[resultBookSize];
        LocalDate[] LoanDate = new LocalDate[resultBookSize];
        LocalDate[] DueDate = new LocalDate[resultBookSize];

        //ResultBooks 배열에 각 Book 객체에 해당하는 속성 문자열로 채움
        for (int i = 0; i < resultBookSize; i++) {
            Book book = ResultBooks[i];
            title[i] = book.getTitle();
            author[i] = book.getAuthor();
            publisher[i] = book.getPublisher();
            year[i] = book.getYear();
            ID[i] = book.getId();
            if(book.getState()!=null) {
                member[i] = book.getMemberID();
                LoanDate[i] = book.getBorrowedDate();
                DueDate[i] = book.getDueDate();
            }
        }


        int bookSearchSize = (resultBookSize % 6);
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


        JPanel panelMainWhite = new JPanel(); //회원 정보 수정 페이지 컴포넌트가 위치할 패널
        panelMainWhite.setBounds(290, 150, 700, 500);
        panelMainWhite.setBackground(Color.white);
        add(panelMainWhite);
        panelMainWhite.setLayout(null);


        JLabel labelMyBook = new JLabel("대출 도서 조회");
        labelMyBook.setBounds(0, 10, 700, 40);
        labelMyBook.setHorizontalAlignment(JLabel.CENTER);
        labelMyBook.setFont(mainFont30);
        panelMainWhite.add(labelMyBook);


        JLabel labelLoanBook = new JLabel("대출한 도서 목록");    //"대출한 도서" 메인 라벨
        labelLoanBook.setBounds(20, 60, 220, 35);
        //labelLoanBook.setHorizontalAlignment(JLabel.CENTER);
        labelLoanBook.setFont(mainFont20);
        panelMainWhite.add(labelLoanBook);

        JPanel panelLoanBookBlue = new JPanel();
        panelLoanBookBlue.setBounds(0, 100, 700, 2);
        panelLoanBookBlue.setBackground(mainBlue);
        panelLoanBookBlue.setLayout(null);
        panelMainWhite.add(panelLoanBookBlue);

        JLabel labelIDBook = new JLabel("관리번호");    //"관리번호" 메인 라벨, 동의대학교 중앙도서관 관리번호를 기준으로 함
        labelIDBook.setBounds(20, 110, 200, 35);
        //labelIDBook.setHorizontalAlignment(JLabel.CENTER);
        labelIDBook.setFont(mainFont20);
        panelMainWhite.add(labelIDBook);

        JLabel labelTitleBook = new JLabel("제목");    //"제목" 메인 라벨
        labelTitleBook.setBounds(170, 110, 200, 35);
        //labelTitleBook.setHorizontalAlignment(JLabel.CENTER);
        labelTitleBook.setFont(mainFont20);
        panelMainWhite.add(labelTitleBook);

        JLabel labelLoanDateBook = new JLabel("대출일");    //"대출일" 메인 라벨, 양식 : 2000-00-00
        labelLoanDateBook.setBounds(340, 110, 200, 35);
        //labelLoanDateBook.setHorizontalAlignment(JLabel.CENTER);
        labelLoanDateBook.setFont(mainFont20);
        panelMainWhite.add(labelLoanDateBook);

        JLabel labelReturnDateBook = new JLabel("반납예정일");    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
        labelReturnDateBook.setBounds(470, 110, 200, 35);
        //labelReturnDateBook.setHorizontalAlignment(JLabel.CENTER);
        labelReturnDateBook.setFont(mainFont20);
        panelMainWhite.add(labelReturnDateBook);

        JLabel labelRenewBook = new JLabel("연장");    //"연장" 메인 라벨, 연장 버튼이 위치함
        labelRenewBook.setBounds(620, 110, 100, 35);
        //labelRenewBook.setHorizontalAlignment(JLabel.CENTER);
        labelRenewBook.setFont(mainFont20);
        panelMainWhite.add(labelRenewBook);

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

        if(bookSearchSize > 0){
            LoanDate1 = LoanDate[book1];
            labelBook1ID = new JLabel(ID[book1]);    //"도서1관리번호" 메인 라벨
            labelBook1ID.setBounds(20, 150, 200, 35);
            //labelBook1ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook1ID.setFont(mainFont20);
            panelMainWhite.add(labelBook1ID);

            JLabel labelBook1Title = new JLabel(title[book1]);    //"도서1제목" 메인 라벨
            labelBook1Title.setBounds(170, 150, 200, 35);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Title.setFont(mainFont20);
            panelMainWhite.add(labelBook1Title);

            labelBook1LoanDate = new JLabel(String.valueOf(LoanDate[book1]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook1LoanDate.setBounds(340, 150, 200, 35);
            //labelBook2LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook1LoanDate.setFont(mainFont20);
            panelMainWhite.add(labelBook1LoanDate);

            labelBook1ReturnDate = new JLabel(String.valueOf(DueDate[book1]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook1ReturnDate.setBounds(470, 150, 200, 35);
            //labelBook2ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook1ReturnDate.setFont(mainFont20);
            panelMainWhite.add(labelBook1ReturnDate);

            JButton ButtonBook1RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook1RenewBook.setBounds(615, 150, 50, 35);
            ButtonBook1RenewBook.setFont(mainFont20);
            //ButtonBook2RenewBook.setBorderPainted(false);
            ButtonBook1RenewBook.setContentAreaFilled(false);
            ButtonBook1RenewBook.setFocusPainted(false);
            ButtonBook1RenewBook.setActionCommand("Renew1");
            ButtonBook1RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook1RenewBook);
        }
        if(bookSearchSize > 1) {
            LoanDate2 = LoanDate[book2];
            labelBook2ID = new JLabel(ID[book2]);    //"도서1관리번호" 메인 라벨
            labelBook2ID.setBounds(20, 190, 200, 35);
            //labelBook2ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook2ID.setFont(mainFont20);
            panelMainWhite.add(labelBook2ID);

            JLabel labelBook2Title = new JLabel(title[book2]);    //"도서1제목" 메인 라벨
            labelBook2Title.setBounds(170, 190, 200, 35);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Title.setFont(mainFont20);
            panelMainWhite.add(labelBook2Title);

            labelBook2LoanDate = new JLabel(String.valueOf(LoanDate[book2]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook2LoanDate.setBounds(340, 190, 200, 35);
            //labelBook2LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook2LoanDate.setFont(mainFont20);
            panelMainWhite.add(labelBook2LoanDate);

            labelBook2ReturnDate = new JLabel(String.valueOf(DueDate[book2]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook2ReturnDate.setBounds(470, 190, 200, 35);
            //labelBook2ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook2ReturnDate.setFont(mainFont20);
            panelMainWhite.add(labelBook2ReturnDate);

            JButton ButtonBook2RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook2RenewBook.setBounds(615, 190, 50, 35);
            ButtonBook2RenewBook.setFont(mainFont20);
            //ButtonBook2RenewBook.setBorderPainted(false);
            ButtonBook2RenewBook.setContentAreaFilled(false);
            ButtonBook2RenewBook.setFocusPainted(false);
            ButtonBook2RenewBook.setActionCommand("Renew2");
            ButtonBook2RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook2RenewBook);
        }
        if(bookSearchSize > 2) {
            LoanDate3 = LoanDate[book3];
            labelBook3ID = new JLabel(ID[book3]);    //"도서1관리번호" 메인 라벨
            labelBook3ID.setBounds(20, 230, 200, 35);
            //labelBook3ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook3ID.setFont(mainFont20);
            panelMainWhite.add(labelBook3ID);

            JLabel labelBook3Title = new JLabel(title[book3]);    //"도서1제목" 메인 라벨
            labelBook3Title.setBounds(170, 230, 200, 35);
            //labelBook3Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Title.setFont(mainFont20);
            panelMainWhite.add(labelBook3Title);

            labelBook3LoanDate = new JLabel(String.valueOf(LoanDate[book3]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook3LoanDate.setBounds(340, 230, 200, 35);
            //labelBook3LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook3LoanDate.setFont(mainFont20);
            panelMainWhite.add(labelBook3LoanDate);

            labelBook3ReturnDate = new JLabel(String.valueOf(DueDate[book3]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook3ReturnDate.setBounds(470, 230, 200, 35);
            //labelBook3ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook3ReturnDate.setFont(mainFont20);
            panelMainWhite.add(labelBook3ReturnDate);

            JButton ButtonBook3RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook3RenewBook.setBounds(615, 230, 50, 35);
            ButtonBook3RenewBook.setFont(mainFont20);
            //ButtonBook3RenewBook.setBorderPainted(false);
            ButtonBook3RenewBook.setContentAreaFilled(false);
            ButtonBook3RenewBook.setFocusPainted(false);
            ButtonBook3RenewBook.setActionCommand("Renew3");
            ButtonBook3RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook3RenewBook);
        }
        if(bookSearchSize>3){
            LoanDate4 = LoanDate[book4];
            labelBook4ID = new JLabel(ID[book4]);    //"도서1관리번호" 메인 라벨
            labelBook4ID.setBounds(20, 270, 200, 35);
            //labelBook4ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook4ID.setFont(mainFont20);
            panelMainWhite.add(labelBook4ID);

            JLabel labelBook4Title = new JLabel(title[book4]);    //"도서1제목" 메인 라벨
            labelBook4Title.setBounds(170, 270, 200, 35);
            //labelBook4Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook4Title.setFont(mainFont20);
            panelMainWhite.add(labelBook4Title);

            labelBook4LoanDate = new JLabel(String.valueOf(LoanDate[book4]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook4LoanDate.setBounds(340, 270, 200, 35);
            //labelBook4LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook4LoanDate.setFont(mainFont20);
            panelMainWhite.add(labelBook4LoanDate);

            labelBook4ReturnDate = new JLabel(String.valueOf(DueDate[book4]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook4ReturnDate.setBounds(470, 270, 200, 35);
            //labelBook4ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook4ReturnDate.setFont(mainFont20);
            panelMainWhite.add(labelBook4ReturnDate);

            JButton ButtonBook4RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook4RenewBook.setBounds(615, 270, 50, 35);
            ButtonBook4RenewBook.setFont(mainFont20);
            //ButtonBook4RenewBook.setBorderPainted(false);
            ButtonBook4RenewBook.setContentAreaFilled(false);
            ButtonBook4RenewBook.setFocusPainted(false);
            ButtonBook4RenewBook.setActionCommand("Renew4");
            ButtonBook4RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook4RenewBook);
        }
        if(bookSearchSize>4){
            LoanDate5 = LoanDate[book5];
            labelBook5ID = new JLabel(ID[book5]);    //"도서1관리번호" 메인 라벨
            labelBook5ID.setBounds(20, 310, 200, 35);
            //labelBook5ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook5ID.setFont(mainFont20);
            panelMainWhite.add(labelBook5ID);

            JLabel labelBook5Title = new JLabel(title[book5]);    //"도서1제목" 메인 라벨
            labelBook5Title.setBounds(170, 310, 200, 35);
            //labelBook5Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook5Title.setFont(mainFont20);
            panelMainWhite.add(labelBook5Title);

            labelBook5LoanDate = new JLabel(String.valueOf(LoanDate[book5]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook5LoanDate.setBounds(340, 310, 200, 35);
            //labelBook5LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook5LoanDate.setFont(mainFont20);
            panelMainWhite.add(labelBook5LoanDate);

            labelBook5ReturnDate = new JLabel(String.valueOf(DueDate[book5]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook5ReturnDate.setBounds(470, 310, 200, 35);
            //labelBook5ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook5ReturnDate.setFont(mainFont20);
            panelMainWhite.add(labelBook5ReturnDate);

            JButton ButtonBook5RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook5RenewBook.setBounds(615, 310, 50, 35);
            ButtonBook5RenewBook.setFont(mainFont20);
            //ButtonBook5RenewBook.setBorderPainted(false);
            ButtonBook5RenewBook.setContentAreaFilled(false);
            ButtonBook5RenewBook.setFocusPainted(false);
            ButtonBook5RenewBook.setActionCommand("Renew4");
            ButtonBook5RenewBook.addActionListener(this);
            panelMainWhite.add(ButtonBook5RenewBook);
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

        // LocalDate 어댑터를 사용해 Gson 인스턴스 생성
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        Gson gson = gsonBuilder.create();

        // books.json 을 불러옴
        Path path = Paths.get(DB_FILE_NAME);
        String json = null;
        try {
            json = new String(Files.readAllBytes(path));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        java.util.List<BookBRE> books = gson.fromJson(json, new TypeToken<List<BookBRE>>(){}.getType());

        String UserID = (UserInfo.getInstance().getUserID());

        /*BookBRE book = books.stream()
                .filter(b -> b.getMemberID().equals(UserID))
                .findFirst()
                .orElse(null);*/
        if (event.equals("TextSearch")) {
            String keyword = textSearch.getText();
            TextSearchResultPage SR = new TextSearchResultPage(keyword, 0);
            dispose();
        }
        if (event.equals("Renew1")) {
            BookBRE book1 = books.stream()
                    .filter(b -> b.getId().equals(labelBook1ID.getText()))
                    .findFirst()
                    .orElse(null);
            int result = JOptionPane.showConfirmDialog(alert, "연장 기간 : "+LoanDate1.plusDays(7)+" ~ "+LoanDate1.plusDays(14));
            if(result==0){
                book1.getState().extend(book1);
                json = gson.toJson(books);
                try {
                    Files.write(path, json.getBytes());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                MyBookPage MB = new MyBookPage(0);
                dispose();

            }
        } else if (event.equals("Renew2")) {
            BookBRE book2 = books.stream()
                    .filter(b -> b.getId().equals(labelBook2ID.getText()))
                    .findFirst()
                    .orElse(null);
            int result = JOptionPane.showConfirmDialog(alert, "연장 기간 : "+LoanDate2.plusDays(7)+" ~ "+LoanDate2.plusDays(14));
            if(result==0){
                book2.getState().extend(book2);
                json = gson.toJson(books);
                try {
                    Files.write(path, json.getBytes());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                MyBookPage MB = new MyBookPage(0);
                dispose();

            }
        } else if (event.equals("Renew3")) {
            BookBRE book3 = books.stream()
                    .filter(b -> b.getId().equals(labelBook3ID.getText()))
                    .findFirst()
                    .orElse(null);
            int result = JOptionPane.showConfirmDialog(alert, "연장 기간 : "+LoanDate3.plusDays(7)+" ~ "+LoanDate3.plusDays(14));
            if(result==0){
                book3.getState().extend(book3);
                json = gson.toJson(books);
                try {
                    Files.write(path, json.getBytes());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                MyBookPage MB = new MyBookPage(0);
                dispose();

            }
        } else if (event.equals("Renew4")) {
            BookBRE book4 = books.stream()
                    .filter(b -> b.getId().equals(labelBook4ID.getText()))
                    .findFirst()
                    .orElse(null);
            int result = JOptionPane.showConfirmDialog(alert, "연장 기간 : "+LoanDate4.plusDays(7)+" ~ "+LoanDate4.plusDays(14));
            if (result==0) {

                book4.getState().extend(book4);
                json = gson.toJson(books);
                try {
                    Files.write(path, json.getBytes());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                MyBookPage MB = new MyBookPage(0);
                dispose();

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
