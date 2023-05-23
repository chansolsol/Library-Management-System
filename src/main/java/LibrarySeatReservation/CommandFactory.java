package LibrarySeatReservation;

public class CommandFactory {
    public Command createCommand(String action, LibrarySeat seat) {
        switch (action) {
            case "reserve":
                return new ReserveCommand(seat);
            case "unreserved":
                return new UnreserveCommand(seat);
            default:
                throw new IllegalArgumentException("올바른 명령어가 아닙니다.");
        }
    }
}
//CommandFactory 클래스는 createCommand() 메서드를 통해 ReserveCommand와 UnreserveCommand 객체를 생성합니다.
// createCommand() 메서드는 인자로 받은 명령어를 판단하여 ReserveCommand 객체 또는 UnreserveCommand 객체를 생성하고
// 반환합니다.