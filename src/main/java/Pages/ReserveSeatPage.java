package Pages;

import LibrarySeatReservation.Command;
import LibrarySeatReservation.CommandFactory;
import LibrarySeatReservation.LibrarySeat;
import LibrarySeatReservation.SeatRepository;
import Res.RoundedButton;
import BookCRUD.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class ReserveSeatPage extends JFrame implements ActionListener{

    private static final String DB_FILE_NAME = "books.json";
    BookDatabase database = new BookDatabase(DB_FILE_NAME);
    BookController controller = new BookController();
    List<Book> books;


    JTextField textBookTitle;
    JTextField textBookID;

    RoundedButton ButtonDeleteBook;
    JButton ButtonBackPage;

    JPanel panelMainBlue;
    JPanel panelDeleteBlue;
    JPanel panelDeleteWhite;

    JLabel labelDeleteBook;
    JLabel labelMain;

    JLabel labelBookID;

    private static final String FILE_PATH = "libraryseat.json";

    class MyButton extends JButton {

        static int count = 0;// 정적변수
        int index;

        public MyButton(String s) {
            super(s);// 조상클래스 생성자 호출
            index = count++;// 후행증가
        }// 생성자오버로딩

    }// MyButton class

    public ReserveSeatPage(){

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

        labelDeleteBook = new JLabel("열람실 자리 배정");   //"도서관 시스템" 메인 라벨
        labelDeleteBook.setBounds(440, 140, 400, 50);
        labelDeleteBook.setHorizontalAlignment(JLabel.CENTER);
        labelDeleteBook.setFont(mainFont40);
        add(labelDeleteBook);


        /*
        textBookID = new JTextField(); //열람실 예약 번호가 입력될 JTextField
        textBookID.setBounds(600,300,200,35);
        textBookID.setFont(inputBoxFont);
        //textBookID.setBorder(null);
        textBookID.setLayout(null);
        add(textBookID);

        labelBookID = new JLabel("자리 번호");   //
        labelBookID.setBounds(480, 300, 120, 35);
        labelBookID.setHorizontalAlignment(JLabel.CENTER);
        labelBookID.setFont(mainFont20);
        add(labelBookID); */

        /*
        ButtonDeleteBook = new RoundedButton("자리 배정");   //도서 수정
        ButtonDeleteBook.setBounds(565,500,150,50);
        ButtonDeleteBook.setFont(mainFont30);
        ButtonDeleteBook.setBackground(mainBlue);
        ButtonDeleteBook.setForeground(Color.white);
        ButtonDeleteBook.setActionCommand("ReserveSeat");  //
        ButtonDeleteBook.addActionListener(this);
        add(ButtonDeleteBook);
        */

        ButtonBackPage = new JButton("뒤로가기");   //뒤로가기 버튼
        ButtonBackPage.setBounds(580,550,120,40);
        ButtonBackPage.setFont(mainFont20);
        //ButtonBackPage.setBorderPainted(false);
        ButtonBackPage.setContentAreaFilled(false);
        ButtonBackPage.setFocusPainted(false);
        ButtonBackPage.setActionCommand("BackPage");
        ButtonBackPage.addActionListener(this);
        add(ButtonBackPage);

        JPanel panelSeatWhite = new JPanel();
        panelSeatWhite.setBounds(490, 200, 300, 290);
        panelSeatWhite.setBackground(Color.white);
        add(panelSeatWhite);
        panelSeatWhite.setLayout(null);

        panelDeleteWhite = new JPanel();
        panelDeleteWhite.setBounds(443, 114, 394, 492);
        panelDeleteWhite.setBackground(Color.white);
        add(panelDeleteWhite);
        panelDeleteWhite.setLayout(null);

        panelDeleteBlue = new JPanel();
        panelDeleteBlue.setBounds(440, 110, 400, 500);
        panelDeleteBlue.setBackground(mainBlue);
        add(panelDeleteBlue);
        panelDeleteBlue.setLayout(null);



        MyButton[] buttons;     // 버튼배열 선언
        MyButton reset;

        panelSeatWhite.setLayout(new GridLayout(5, 4, 30, 30));

        buttons = new MyButton[21];     // 배열크기가 20 버튼 배열생성
        for (int i = 0; i < 20; i++) {
            buttons[i] = new MyButton((("" + (i + 1)).trim()));
            //buttons[i].setFont(mainFont20);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setFocusPainted(false);
        }
        for (int i = 0; i < 20; i++) {      // 20개의 버튼을 패널에 추가
            panelSeatWhite.add(buttons[i]);
        }
        for (int i = 0; i < 20; i++) {      // 20개의 버튼 이벤트 등록
            buttons[i].addActionListener(this);
        }

        getContentPane().setBackground(Color.white);    //전체 배경 흰색으로 설정

    }
    public void actionPerformed(ActionEvent e) {

        String event = e.getActionCommand();
        JFrame alert = new JFrame();

        String[] options = { "  예 약  ", "  퇴 실  ", "  취 소  " };

        SeatRepository repository = new SeatRepository(FILE_PATH);
        CommandFactory commandFactory = new CommandFactory();

        try {
            repository.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if (event.equals("BackPage")) {
            MainPage MP = new MainPage();
            dispose();
        } else {
            int result = JOptionPane.showOptionDialog(
                    null,
                    "도서관 좌석 기능 선택",
                    "기능 선택",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (result == 0) {
                // "배정"
                {
                    int resultR = JOptionPane.showConfirmDialog(alert, "좌석 : "+ event + "번을 예약하시겠습니까?");
                    if(resultR==0){

                        int seatNumber = Integer.parseInt(event);
                        LibrarySeat seat = findSeat(repository.getSeats(), seatNumber);

                        Command command = commandFactory.createCommand("reserve", seat);
                        command.execute();
                        try {
                            repository.save();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            } else if (result == 1) {
                // "퇴실"
                int resultE = JOptionPane.showConfirmDialog(alert, "좌석 : "+ event + "번을 퇴실하시겠습니까?");
                if(resultE==0){

                    int seatNumber = Integer.parseInt(event);
                    LibrarySeat seat = findSeat(repository.getSeats(), seatNumber);

                    Command command = commandFactory.createCommand("unreserved", seat);
                    command.execute();
                    try {
                        repository.save();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else if (result == 2) {
                // "취소"

            }
        }

    }
    private static LibrarySeat findSeat(List<LibrarySeat> seats, int seatNumber) {
        for (LibrarySeat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }
        return null;
    }

}