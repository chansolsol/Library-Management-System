package LibrarySeatReservation;

public interface Command {
    void execute();
}
//Command 인터페이스는 execute() 메서드 하나만 가지고 있으며, 실제 커맨드 객체들이 이 인터페이스를 구현합니다.