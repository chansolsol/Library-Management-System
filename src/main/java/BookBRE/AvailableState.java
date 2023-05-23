package BookBRE;

import Res.UserInfo;

import java.time.LocalDate;

/** 대출 가능한 상태 */
public class AvailableState implements BookState {

    @Override
    public void borrow(BookBRE book) {
        book.setBorrowedDate(LocalDate.now());
        book.setDueDate(LocalDate.now().plusDays(7)); // 마감일을 지금부터 7일로 설정
        book.setState(new BorrowedState()); // 대출 상태로 변경
        book.setMemberID(UserInfo.getInstance().getUserID()); //사용자 로그인 정보 싱글턴 반환
    }

    @Override
    public void returnBook(BookBRE book) {
        System.out.println("이 책은 대출한 것이 아니므로 반납할 수 없습니다.");
    }

    @Override
    public void extend(BookBRE book) {
        System.out.println("이 책은 대출한 것이 아니므로 연장할 수 없습니다.");
    }

    @Override
    public String toString() {
        return "AvailableState";
    }
}