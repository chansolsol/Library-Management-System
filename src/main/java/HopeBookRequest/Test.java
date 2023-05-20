package HopeBookRequest;

public class Test {

    public static void main(String[] args) {

        AdminBookRequest adminBookRequest = new AdminBookRequest();
        GeneralBookRequest generalBookRequest = new GeneralBookRequest();
        GuestBookRequest guestBookRequest = new GuestBookRequest();

        /**
         * 일반 사용자: 희망 도서 신청
         * 관리자: 희망 도서 목록 확인 및 삭제
         * 게스트: 로그인 필요 알림창 출력
         **/

        generalBookRequest.requestBook();
//        adminBookRequest.requestBook();
//        guestBookRequest.requestBook();

    }
}
