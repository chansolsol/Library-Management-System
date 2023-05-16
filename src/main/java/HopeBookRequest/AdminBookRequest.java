package HopeBookRequest;

public class AdminBookRequest extends BookRequestTemplate {
    @Override
    public void writeApplication() {
        System.out.println("관리자 신청 도서 확인");
    }
}
