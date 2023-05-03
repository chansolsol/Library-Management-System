package AdminPages;

import Pages.TextSearchResultPage;
import book.Book;
import book.BookDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class AdminPage extends JFrame implements ActionListener{

    JTextField textSearch;

    JButton ButtonSearch;
    JButton ButtonCreateBook;
    JButton ButtonUpdateBook;
    JButton ButtonDeleteBook;

    JComboBox<String> selectOption;

    JPanel panelMainBlue;
    JLabel labelMain;
    JPanel panelSearch;
    private static final String DB_FILE_NAME = "books.json";
    BookDatabase database = new BookDatabase(DB_FILE_NAME);

    public AdminPage() {

        try {
            List<Book> books = database.load();
        } catch (IOException e) {
            e.printStackTrace();
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

        labelMain = new JLabel("도서관 관리 시스템");   //"도서관 시스템" 메인 라벨
        labelMain.setBounds(382, 0, 500, 80);
        labelMain.setHorizontalAlignment(JLabel.CENTER);
        labelMain.setFont(mainFont50);
        labelMain.setForeground(Color.white);
        panelMainBlue.add(labelMain);

        String Options[] = {"제목","저자","출판사"};   //도서 검색 옵션 종류
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


        ButtonCreateBook = new JButton("도서 생성");   //도서 추가
        ButtonCreateBook.setBounds(540,200,200,40);
        ButtonCreateBook.setFont(mainFont20);
        ButtonCreateBook.setContentAreaFilled(false);
        ButtonCreateBook.setFocusPainted(false);
        ButtonCreateBook.setActionCommand("CreateBook");  //
        ButtonCreateBook.addActionListener(this);
        add(ButtonCreateBook);

        ButtonUpdateBook = new JButton("도서 수정");   //도서 업데이트
        ButtonUpdateBook.setBounds(540,270,200,40);
        ButtonUpdateBook.setFont(mainFont20);
        ButtonUpdateBook.setContentAreaFilled(false);
        ButtonUpdateBook.setFocusPainted(false);
        ButtonUpdateBook.setActionCommand("UpdateBook");  //
        ButtonUpdateBook.addActionListener(this);
        add(ButtonUpdateBook);

        ButtonDeleteBook = new JButton("도서 삭제");   //도서 삭제
        ButtonDeleteBook.setBounds(540,340,200,40);
        ButtonDeleteBook.setFont(mainFont20);
        ButtonDeleteBook.setContentAreaFilled(false);
        ButtonDeleteBook.setFocusPainted(false);
        ButtonDeleteBook.setActionCommand("DeleteBook");
        ButtonDeleteBook.addActionListener(this);
        add(ButtonDeleteBook);





        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        if (event.equals("TextSearch")) {
            String keyword = textSearch.getText();
            TextSearchResultAdminPage SR = new TextSearchResultAdminPage(keyword);
            setVisible(false);
            dispose();

        } else if (event.equals("CreateBook")) {
            CreateBookPage CB = new CreateBookPage();
            setVisible(false);
            dispose();

        } else if (event.equals("UpdateBook")){
            UpdateBookPage UB = new UpdateBookPage();
            setVisible(false);
            dispose();
        } else if (event.equals("DeleteBook")){
            DeleteBookPage DB = new DeleteBookPage();
            setVisible(false);
            dispose();
        } else if (event.equals("")){
            //setVisible(false);
            //dispose();
        }

    }
}