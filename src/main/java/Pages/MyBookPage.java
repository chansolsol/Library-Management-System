package Pages;

import BookBRE.BookBRE;
import BookCRUD.Book;
import BookCRUD.BookController;
import BookCRUD.BookDatabase;
import Res.LocalDateAdapter;
import Res.UserInfo;
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

public class MyBookPage extends JFrame implements ActionListener{

    JPanel panelMainBlue;
    JLabel labelMain;
    JLabel labelBook1ID;
    JLabel labelBook2ID;
    JLabel labelBook3ID;
    JLabel labelBook1LoanDate;
    JLabel labelBook1ReturnDate;
    JLabel labelBook2LoanDate;
    JLabel labelBook2ReturnDate;
    JLabel labelBook3LoanDate;
    JLabel labelBook3ReturnDate;

    LocalDate LoanDate1;
    LocalDate LoanDate2;
    LocalDate LoanDate3;

    private static final String DB_FILE_NAME = "books.json";
    public MyBookPage(){

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
        int[] year = new int[resultBookSize];
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

        JLabel labelLoanText = new JLabel("대출 가능 : "+ bookSearchSize +" / 10");    //"대출 가능" 라벨, 가능 권수를 나타냄
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

        JLabel labelRenewText = new JLabel("연장 가능 : "+bookSearchSize+"/"+bookSearchSize);    //"연장 가능" 라벨, 대출한 책을 맥시멈으로 잡음
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

        JLabel labelReturnText = new JLabel("연채 도서 : 0");    //"연채 도서" 라벨
        labelReturnText.setBounds(780, 220, 220, 35);
        labelReturnText.setHorizontalAlignment(JLabel.CENTER);
        labelReturnText.setFont(mainFont20);
        add(labelReturnText);


        JLabel labelLoanBook = new JLabel("대출한 도서");    //"대출한 도서" 메인 라벨
        labelLoanBook.setBounds(300, 320, 220, 35);
        //labelLoanBook.setHorizontalAlignment(JLabel.CENTER);
        labelLoanBook.setFont(mainFont20);
        add(labelLoanBook);

        JPanel panelLoanBookBlue = new JPanel();
        panelLoanBookBlue.setBounds(285, 360, 700, 2);
        panelLoanBookBlue.setBackground(mainBlue);
        panelLoanBookBlue.setLayout(null);
        add(panelLoanBookBlue);

        JLabel labelIDBook = new JLabel("관리번호");    //"관리번호" 메인 라벨, 동의대학교 중앙도서관 관리번호를 기준으로 함
        labelIDBook.setBounds(300, 370, 200, 35);
        //labelIDBook.setHorizontalAlignment(JLabel.CENTER);
        labelIDBook.setFont(mainFont20);
        add(labelIDBook);

        JLabel labelTitleBook = new JLabel("제목");    //"제목" 메인 라벨
        labelTitleBook.setBounds(450, 370, 200, 35);
        //labelTitleBook.setHorizontalAlignment(JLabel.CENTER);
        labelTitleBook.setFont(mainFont20);
        add(labelTitleBook);

        JLabel labelLoanDateBook = new JLabel("대출일");    //"대출일" 메인 라벨, 양식 : 2000-00-00
        labelLoanDateBook.setBounds(620, 370, 200, 35);
        //labelLoanDateBook.setHorizontalAlignment(JLabel.CENTER);
        labelLoanDateBook.setFont(mainFont20);
        add(labelLoanDateBook);

        JLabel labelReturnDateBook = new JLabel("반납예정일");    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
        labelReturnDateBook.setBounds(750, 370, 200, 35);
        //labelReturnDateBook.setHorizontalAlignment(JLabel.CENTER);
        labelReturnDateBook.setFont(mainFont20);
        add(labelReturnDateBook);

        JLabel labelRenewBook = new JLabel("연장");    //"연장" 메인 라벨, 연장 버튼이 위치함
        labelRenewBook.setBounds(900, 370, 100, 35);
        //labelRenewBook.setHorizontalAlignment(JLabel.CENTER);
        labelRenewBook.setFont(mainFont20);
        add(labelRenewBook);



        if(bookSearchSize > 0){
            LoanDate1 = LoanDate[0];
            labelBook1ID = new JLabel(ID[0]);    //"도서1관리번호" 메인 라벨
            labelBook1ID.setBounds(300, 410, 200, 35);
            //labelBook1ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook1ID.setFont(mainFont20);
            add(labelBook1ID);

            JLabel labelBook1Title = new JLabel(title[0]);    //"도서1제목" 메인 라벨
            labelBook1Title.setBounds(450, 410, 200, 35);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook1Title.setFont(mainFont20);
            add(labelBook1Title);

            labelBook1LoanDate = new JLabel(String.valueOf(LoanDate[0]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook1LoanDate.setBounds(620, 410, 200, 35);
            //labelBook2LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook1LoanDate.setFont(mainFont20);
            add(labelBook1LoanDate);

            labelBook1ReturnDate = new JLabel(String.valueOf(DueDate[0]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook1ReturnDate.setBounds(750, 410, 200, 35);
            //labelBook2ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook1ReturnDate.setFont(mainFont20);
            add(labelBook1ReturnDate);

            JButton ButtonBook1RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook1RenewBook.setBounds(895, 410, 50, 35);
            ButtonBook1RenewBook.setFont(mainFont20);
            //ButtonBook2RenewBook.setBorderPainted(false);
            ButtonBook1RenewBook.setContentAreaFilled(false);
            ButtonBook1RenewBook.setFocusPainted(false);
            ButtonBook1RenewBook.setActionCommand("Renew1");
            ButtonBook1RenewBook.addActionListener(this);
            add(ButtonBook1RenewBook);
        }
        if(bookSearchSize > 1) {
            LoanDate2 = LoanDate[0];
            labelBook2ID = new JLabel(ID[1]);    //"도서1관리번호" 메인 라벨
            labelBook2ID.setBounds(300, 450, 200, 35);
            //labelBook2ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook2ID.setFont(mainFont20);
            add(labelBook2ID);

            JLabel labelBook2Title = new JLabel(title[1]);    //"도서1제목" 메인 라벨
            labelBook2Title.setBounds(450, 450, 200, 35);
            //labelBook2Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook2Title.setFont(mainFont20);
            add(labelBook2Title);

            labelBook2LoanDate = new JLabel(String.valueOf(LoanDate[1]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook2LoanDate.setBounds(620, 450, 200, 35);
            //labelBook2LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook2LoanDate.setFont(mainFont20);
            add(labelBook2LoanDate);

            labelBook2ReturnDate = new JLabel(String.valueOf(DueDate[1]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook2ReturnDate.setBounds(750, 450, 200, 35);
            //labelBook2ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook2ReturnDate.setFont(mainFont20);
            add(labelBook2ReturnDate);

            JButton ButtonBook2RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook2RenewBook.setBounds(895, 450, 50, 35);
            ButtonBook2RenewBook.setFont(mainFont20);
            //ButtonBook2RenewBook.setBorderPainted(false);
            ButtonBook2RenewBook.setContentAreaFilled(false);
            ButtonBook2RenewBook.setFocusPainted(false);
            ButtonBook2RenewBook.setActionCommand("Renew2");
            ButtonBook2RenewBook.addActionListener(this);
            add(ButtonBook2RenewBook);
        }
        if(bookSearchSize > 2) {
            LoanDate3 = LoanDate[2];
            labelBook3ID = new JLabel(ID[2]);    //"도서1관리번호" 메인 라벨
            labelBook3ID.setBounds(300, 490, 200, 35);
            //labelBook3ID.setHorizontalAlignment(JLabel.CENTER);
            labelBook3ID.setFont(mainFont20);
            add(labelBook3ID);

            JLabel labelBook3Title = new JLabel(title[2]);    //"도서1제목" 메인 라벨
            labelBook3Title.setBounds(450, 490, 200, 35);
            //labelBook3Title.setHorizontalAlignment(JLabel.CENTER);
            labelBook3Title.setFont(mainFont20);
            add(labelBook3Title);

            labelBook3LoanDate = new JLabel(String.valueOf(LoanDate[2]));    //"도서1대출일" 메인 라벨, 양식 : 2000-00-00
            labelBook3LoanDate.setBounds(620, 490, 200, 35);
            //labelBook3LoanDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook3LoanDate.setFont(mainFont20);
            add(labelBook3LoanDate);

            labelBook3ReturnDate = new JLabel(String.valueOf(DueDate[2]));    //"반납예정일" 메인 라벨, 양식 : 2000-00-00
            labelBook3ReturnDate.setBounds(750, 490, 200, 35);
            //labelBook3ReturnDate.setHorizontalAlignment(JLabel.CENTER);
            labelBook3ReturnDate.setFont(mainFont20);
            add(labelBook3ReturnDate);

            JButton ButtonBook3RenewBook = new JButton("<HTML><body><center>연장</center></body></HTML>");   //연장 버튼
            ButtonBook3RenewBook.setBounds(895, 490, 50, 35);
            ButtonBook3RenewBook.setFont(mainFont20);
            //ButtonBook3RenewBook.setBorderPainted(false);
            ButtonBook3RenewBook.setContentAreaFilled(false);
            ButtonBook3RenewBook.setFocusPainted(false);
            ButtonBook3RenewBook.setActionCommand("Renew3");
            ButtonBook3RenewBook.addActionListener(this);
            add(ButtonBook3RenewBook);
        }


        JButton ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
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

        if (event.equals("Renew1")) {
            BookBRE book1 = books.stream()
                    .filter(b -> b.getId().equals(labelBook1ID.getText()))
                    .findFirst()
                    .orElse(null);
            int result = JOptionPane.showConfirmDialog(alert, "연장 기간 : "+LoanDate1+" ~ "+LoanDate1.plusDays(7));
            if(result==0){
                if(book1.extend()) {
                    json = gson.toJson(books);
                    try {
                        Files.write(path, json.getBytes());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(alert, "연장 완료");
                } else {
                    JOptionPane.showMessageDialog(alert, "연장은 1회만 가능합니다.");
                }
            }
        } else if (event.equals("Renew2")) {
            BookBRE book2 = books.stream()
                    .filter(b -> b.getId().equals(labelBook2ID.getText()))
                    .findFirst()
                    .orElse(null);
            int result = JOptionPane.showConfirmDialog(alert, "연장 기간 : "+LoanDate2+" ~ "+LoanDate2.plusDays(7));
            if(result==0){
                if(book2.extend()) {
                    json = gson.toJson(books);
                    try {
                        Files.write(path, json.getBytes());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(alert, "연장 완료");
                } else {
                    JOptionPane.showMessageDialog(alert, "연장은 1회만 가능합니다.");
                }
            }
        } else if (event.equals("Renew3")) {
            BookBRE book3 = books.stream()
                    .filter(b -> b.getId().equals(labelBook3ID.getText()))
                    .findFirst()
                    .orElse(null);
            int result = JOptionPane.showConfirmDialog(alert, "연장 기간 : "+LoanDate3+" ~ "+LoanDate3.plusDays(7));
            if(result==0){
                if(book3.extend()) {
                    json = gson.toJson(books);
                    try {
                        Files.write(path, json.getBytes());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(alert, "연장 완료");
                } else {
                    JOptionPane.showMessageDialog(alert, "연장은 1회만 가능합니다.");
                }
            }
        }else if (event.equals("BackPage")) {
            MainPage MP = new MainPage();
            setVisible(false);
            dispose();
        }

    }
}
