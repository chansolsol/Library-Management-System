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
