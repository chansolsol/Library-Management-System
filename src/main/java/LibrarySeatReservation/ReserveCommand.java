package LibrarySeatReservation;

import Res.UserInfo;

import javax.swing.*;

public class ReserveCommand implements Command {
    private LibrarySeat seat;

    public ReserveCommand(LibrarySeat seat) {
        this.seat = seat;
    }
    public interface Command {
        void execute();
    }

    @Override
    public void execute() {
        if (seat.isReserved()) {
            JFrame alert = new JFrame();
            JOptionPane.showMessageDialog(alert, "이미 예약된 자리입니다." + "\n" + "예약자 ID: " + seat.getSeatID());
        } else {
            String seatID = UserInfo.getInstance().getUserID();
            seat.setSeatID(seatID);
            seat.reserve();
            JFrame alert = new JFrame();
            JOptionPane.showMessageDialog(alert, "좌석 : "+seat.getSeatNumber()+"번 예약 완료");
        }
    }
}
