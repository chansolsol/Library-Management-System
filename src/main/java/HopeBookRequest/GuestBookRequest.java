package HopeBookRequest;

/** 게스트 사용자 */
public class GuestBookRequest extends BookRequest {
    @Override
    public void writeApplication() {
        System.out.println("로그인이 필요합니다. (메시지 박스)");
    }
}
