package LibrarySeatReservation;

public class LibrarySeat {
    private int seatNumber;
    private boolean reserved;

    public LibrarySeat(int seatNumber, boolean reserved) {
        this.seatNumber = seatNumber;
        this.reserved = reserved;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        reserved = true;
    }

    public void unreserve() {
        reserved = false;
    }
}
//LibrarySeat 클래스는 도서관 좌석을 나타내며, 좌석 번호와 좌석이 예약되었는지 여부를 저장합니다.
// reserve()와 unreserve() 메서드는 각각 좌석을 예약하거나 예약을 취소합니다.
