package AdminPages;

import Res.RoundedButton;
import book.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CreateBookPage extends JFrame implements ActionListener{

    private static final String DB_FILE_NAME = "books.json";


    JTextField textBookTitle;
    JTextField textBookAuthor;
    JTextField textBookPublisher;
    JTextField textBookPublicationDate;
    JTextField textBookID;

    RoundedButton ButtonCreateBook;
    JButton ButtonBackPage;

    JPanel panelMainBlue;
    JPanel panelCreateBlue;
    JPanel panelCreateWhite;
    JLabel labelCreateBook;
    JLabel labelMain;
    JLabel labelBookTitle;
    JLabel labelBookAuthor;
    JLabel labelBookPublisher;
    JLabel labelBookPublicationDate;

    JLabel labelBookID;



    public CreateBookPage(){

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

        labelCreateBook = new JLabel("도서 생성");   //"도서관 시스템" 메인 라벨
        labelCreateBook.setBounds(440, 140, 400, 50);
        labelCreateBook.setHorizontalAlignment(JLabel.CENTER);
        labelCreateBook.setFont(mainFont40);
        add(labelCreateBook);

        textBookTitle = new JTextField();   //책 제목이 입력될 JTextField
        textBookTitle.setBounds(600,200,200,35);
        textBookTitle.setFont(inputBoxFont);
        //textBookTitle.setBorder(null);
        textBookTitle.setLayout(null);
        add(textBookTitle);

        labelBookTitle = new JLabel("제목");   //
        labelBookTitle.setBounds(480, 200, 120, 35);
        labelBookTitle.setHorizontalAlignment(JLabel.CENTER);
        labelBookTitle.setFont(mainFont20);
        add(labelBookTitle);

        textBookAuthor = new JTextField(); //책 저자가 입력될 JTextField
        textBookAuthor.setBounds(600,250,200,35);
        textBookAuthor.setFont(inputBoxFont);
        //textBookAuthor.setBorder(null);
        textBookAuthor.setLayout(null);
        add(textBookAuthor);

        labelBookAuthor = new JLabel("저자");   //
        labelBookAuthor.setBounds(480, 250, 120, 35);
        labelBookAuthor.setHorizontalAlignment(JLabel.CENTER);
        labelBookAuthor.setFont(mainFont20);
        add(labelBookAuthor);

        textBookPublisher = new JTextField(); //책 출판사가 입력될 JTextField
        textBookPublisher.setBounds(600,300,200,35);
        textBookPublisher.setFont(inputBoxFont);
        //textBookPublisher.setBorder(null);
        textBookPublisher.setLayout(null);
        add(textBookPublisher);

        labelBookPublisher = new JLabel("출판사");   //
        labelBookPublisher.setBounds(480, 300, 120, 35);
        labelBookPublisher.setHorizontalAlignment(JLabel.CENTER);
        labelBookPublisher.setFont(mainFont20);
        add(labelBookPublisher);


        textBookPublicationDate = new JTextField(); //책 출판년도가 입력될 JTextField
        textBookPublicationDate.setBounds(600,350,200,35);
        textBookPublicationDate.setFont(inputBoxFont);
        //textBookPublicationDate.setBorder(null);
        textBookPublicationDate.setLayout(null);
        add(textBookPublicationDate);

        labelBookPublicationDate = new JLabel("출판년도");   //
        labelBookPublicationDate.setBounds(480, 350, 120, 35);
        labelBookPublicationDate.setHorizontalAlignment(JLabel.CENTER);
        labelBookPublicationDate.setFont(mainFont20);
        add(labelBookPublicationDate);

        textBookID = new JTextField(); //책 관리번호가 입력될 JTextField
        textBookID.setBounds(600,400,200,35);
        textBookID.setFont(inputBoxFont);
        //textBookID.setBorder(null);
        textBookID.setLayout(null);
        add(textBookID);

        labelBookID = new JLabel("관리번호");   //
        labelBookID.setBounds(480, 400, 120, 35);
        labelBookID.setHorizontalAlignment(JLabel.CENTER);
        labelBookID.setFont(mainFont20);
        add(labelBookID);


        ButtonCreateBook = new RoundedButton("도서 생성");   //도서 추가
        ButtonCreateBook.setBounds(565,450,150,50);
        ButtonCreateBook.setFont(mainFont30);
        ButtonCreateBook.setBackground(mainBlue);
        ButtonCreateBook.setForeground(Color.white);
        ButtonCreateBook.setActionCommand("CreateBook");  //
        ButtonCreateBook.addActionListener(this);
        add(ButtonCreateBook);

        ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
        ButtonBackPage.setBounds(580,510,120,40);
        ButtonBackPage.setFont(mainFont20);
        //ButtonBackPage.setBorderPainted(false);
        ButtonBackPage.setContentAreaFilled(false);
        ButtonBackPage.setFocusPainted(false);
        ButtonBackPage.setActionCommand("BackPage");
        ButtonBackPage.addActionListener(this);
        add(ButtonBackPage);


        panelCreateWhite = new JPanel();
        panelCreateWhite.setBounds(443, 114, 394, 492);
        panelCreateWhite.setBackground(Color.white);
        add(panelCreateWhite);
        panelCreateWhite.setLayout(null);

        panelCreateBlue = new JPanel();
        panelCreateBlue.setBounds(440, 110, 400, 500);
        panelCreateBlue.setBackground(mainBlue);
        add(panelCreateBlue);
        panelCreateBlue.setLayout(null);

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        String title = textBookTitle.getText();
        String author = textBookAuthor.getText();
        String publisher = textBookPublisher.getText();
        String year = textBookPublicationDate.getText();
        String id = textBookID.getText();

        BookDatabase database = new BookDatabase(DB_FILE_NAME);

        BookController controller = new BookController();
        JOptionPane alert = new JOptionPane();  //알림 패널 생성

        if (event.equals("CreateBook")) {

            Book newBook = new BookBuilder().setTitle(title).setAuthor(author).setPublisher(publisher).setYear(year).setId(id).build();
            controller.addBook(newBook);
            try {
                database.save(controller.getAllBooks());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            alert.showMessageDialog(null, "책 생성 완료", "알림", JOptionPane.INFORMATION_MESSAGE);

            AdminPage AP = new AdminPage();
            setVisible(false);
            dispose();

        } else if (event.equals("BackPage")) {
            AdminPage AP = new AdminPage();
            setVisible(false);
            dispose();

        } else if (event.equals("")){
            //setVisible(false);
            //dispose();
        }
    }


}