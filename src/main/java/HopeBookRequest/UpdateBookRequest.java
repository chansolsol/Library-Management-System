package HopeBookRequest;

import Res.UserInfo;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;


/**
 * 희망 도서 신청 수정
 */
public class UpdateBookRequest extends BookRequest {
    String newtitle;
    String newauthor;
    String newpublisher;
    String newyear;
    String[] inputText;

    @Override
    public void applicationCUD(String title, String author, String publisher, String year) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("수정할 희망 도서 제목 입력 : ");  //GUI 에선 버튼
//        String bookTitle = scanner.nextLine();
//
//        for (HopeBook book : books) {
//            if (book.getTitle().equals(bookTitle)) {
//                System.out.println("수정할 제목 입력 : ");
//                String newTitle = scanner.nextLine();
//                book.setTitle(newTitle);
//
//                System.out.println("수정할 저자 입력 : ");
//                String newAuthor = scanner.nextLine();
//                book.setAuthor(newAuthor);
//
//                System.out.println("수정할 출판사 입력 : ");
//                String newPublisher = scanner.nextLine();
//                book.setPublisher(newPublisher);
//
//                System.out.println("수정할 년도 입력 : ");
//                String newYear = scanner.nextLine();
//                book.setYear(newYear);
//
//                // 콘솔에서 입력된 마지막 개행문자를 소비
//                scanner.nextLine();
//            }
//        }

        String[] labels = {"이름", "저자", "출판사", "년도"};
        JTextField[] fields = new JTextField[4];

        JPanel panel = new JPanel(new GridLayout(0, 2));

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            JTextField field = new JTextField(10);
            panel.add(label);
            panel.add(field);
            fields[i] = field;
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "희망 도서 수정", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        String userID = UserInfo.getInstance().getUserID();

        if (result == JOptionPane.OK_OPTION) {
            inputText = new String[4];
            for (int i = 0; i < fields.length; i++) {
                inputText[i] = fields[i].getText();
            }

            newtitle = inputText[0];
            newauthor = inputText[1];
            newpublisher = inputText[2];
            newyear = inputText[3];

            for (HopeBook book : books) {
                if (book.getTitle().equals(title) && book.getAuthor().equals(author) &&
                        book.getPublisher().equals(publisher) && book.getYear().equals(year)) {
                    book.setTitle(newtitle);
                    book.setAuthor(newauthor);
                    book.setPublisher(newpublisher);
                    book.setYear(newyear);
                    book.setHopeID(userID);
                }
            }
        } else if (result == JOptionPane.CANCEL_OPTION) {

        }
    }

//        System.out.println("입력된 텍스트:");
//        for (String text : inputText) {
//            System.out.println(text);
//        }
}




