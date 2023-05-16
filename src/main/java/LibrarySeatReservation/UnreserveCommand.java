package LibrarySeatReservation;

public class UnreserveCommand implements Command {
    private LibrarySeat seat;

    public UnreserveCommand(LibrarySeat seat) {
        this.seat = seat;
    }
    public interface Command {
        void execute();
    }

    @Override
    public void execute() {
        if (seat.isReserved()) {
            seat.unreserve();
            System.out.println(seat.getSeatNumber() + "번 자리의 예약이 취소되었습니다.");
        } else {
            System.out.println("죄송합니다. " + seat.getSeatNumber() + "번 자리는 예약되어 있지 않습니다.");
        }
    }
}

