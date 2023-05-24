package LibrarySeatReservation;

import javax.swing.*;

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
            seat.setSeatID(null);
            seat.unreserved();
            JFrame alert = new JFrame();
            JOptionPane.showMessageDialog(alert, "좌석 : "+seat.getSeatNumber()+"번 퇴실 완료");
        } else {
            JFrame alert = new JFrame();
            JOptionPane.showMessageDialog(alert, "좌석 : "+seat.getSeatNumber()+"번은 예약되지 않은 자리입니다.");
        }
    }
}

