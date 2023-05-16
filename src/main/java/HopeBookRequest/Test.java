package HopeBookRequest;

public class Test {



    public static void main(String[] args) {

        AdminBookRequest adminBookRequest = new AdminBookRequest();
        StudentBookRequest studentBookRequest = new StudentBookRequest();
        GuestBookRequest guestBookRequest = new GuestBookRequest();

//        adminBookRequest.requestBook();
//        System.out.println("--------------------");
        studentBookRequest.requestBook();
//        System.out.println("--------------------");
//        guestBookRequest.requestBook();
    }
}
