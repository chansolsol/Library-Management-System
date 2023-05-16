package HopeBookRequest;

public class GuestBookRequest extends BookRequestTemplate {
    @Override
    public void writeApplication() {
        System.out.println("게스트 신청서 작성");
    }
}
