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
//ReserveCommand 클래스는 Command 인터페이스를 구현하여 execute() 메서드를 가지며, 좌석 예약을 처리합니다.
// execute() 메서드에서는 인자로 받은 LibrarySeat 객체의 예약 여부를 판단하여 이미 예약된 자리인 경우에는 메시지를 출력하고,
// 그렇지 않은 경우에는 자리를 예약하고 메시지를 출력합니다.