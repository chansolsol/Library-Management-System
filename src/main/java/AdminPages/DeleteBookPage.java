package AdminPages;

import Res.RoundedButton;
import book.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DeleteBookPage extends JFrame implements ActionListener{

    private static final String DB_FILE_NAME = "books.json";


    JTextField textBookTitle;
    JTextField textBookAuthor;
    JTextField textBookPublisher;
    JTextField textBookPublicationDate;
    JTextField textBookID;

    RoundedButton ButtonCreateBook;
    JButton ButtonBackPage;

    JPanel panelMainBlue;

    JLabel labelCreateBook;
    JLabel labelMain;
    JLabel labelBookTitle;
    JLabel labelBookAuthor;
    JLabel labelBookPublisher;
    JLabel labelBookPublicationDate;

    JLabel labelBookID;



    public DeleteBookPage(){

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

        labelCreateBook = new JLabel("도서 삭제");   //"도서관 시스템" 메인 라벨
        labelCreateBook.setBounds(440, 150, 400, 50);
        labelCreateBook.setHorizontalAlignment(JLabel.CENTER);
        labelCreateBook.setFont(mainFont40);
        add(labelCreateBook);


        textBookID = new JTextField(); //책 관리번호가 입력될 JTextField
        textBookID.setBounds(600,300,200,35);
        textBookID.setFont(inputBoxFont);
        //textBookID.setBorder(null);
        textBookID.setLayout(null);
        add(textBookID);

        labelBookID = new JLabel("관리번호");   //
        labelBookID.setBounds(480, 300, 120, 35);
        labelBookID.setHorizontalAlignment(JLabel.CENTER);
        labelBookID.setFont(mainFont20);
        add(labelBookID);



        ButtonCreateBook = new RoundedButton("도서 삭제");   //도서 수정
        ButtonCreateBook.setBounds(565,450,150,50);
        ButtonCreateBook.setFont(mainFont30);
        ButtonCreateBook.setBackground(mainBlue);
        ButtonCreateBook.setForeground(Color.white);
        ButtonCreateBook.setActionCommand("DeleteBook");  //
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

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();

        String DeleteId = textBookID.getText();

        BookDatabase database = new BookDatabase(DB_FILE_NAME);
        BookController controller = new BookController();
        JOptionPane alert = new JOptionPane();  //알림 패널 생성

        if (event.equals("DeleteBook")) {

            controller.removeBook(DeleteId);
            try {
                database.save(controller.getAllBooks());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            alert.showMessageDialog(null, "책 삭제 완료", "알림", JOptionPane.INFORMATION_MESSAGE);

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