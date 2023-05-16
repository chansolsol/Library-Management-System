package BookReservation;

public interface Command {
    void execute();
}
//Command 인터페이스는 명령(Command) 객체들이 구현해야 하는 메서드인 execute()를 선언합니다.
// CommandFactory 클래스는 createCommand() 메서드를 통해 ReserveCommand와 UnreserveCommand 객체를 생성합니다.
// 이 클래스는 commandName과 Book 객체를 인자로 받으며,
// commandName이 "Reserve"이면 ReserveCommand 객체를, "Unreserve"이면 UnreserveCommand 객체를 반환합니다.
// 그렇지 않은 경우에는 IllegalArgumentException 예외를 발생시킵니다.