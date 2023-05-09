package BookLRE;

/** 테스트 */
public class Test {

    public static void main(String[] args) {
        Book book = new Book();

        System.out.println("책 ㅇㅇㅇ 대출하기");
        book.loan();
        book.loan();    //책 ㅇㅇㅇ 이미 대출했으므로 다시 대출 불가

        System.out.println("책 ㅇㅇㅇ 연장하기");
        book.extend();

        System.out.println("책 ㅇㅇㅇ 반납하기");
        book.returnBook();

        book.extend();  //책 ㅇㅇㅇ 반납한 상태이므로 연장 불가
    }
}
