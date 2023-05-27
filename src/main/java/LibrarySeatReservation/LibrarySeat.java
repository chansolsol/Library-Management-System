package LibrarySeatReservation;

public class LibrarySeat {
    private int seatNumber;
    private boolean reserved;
    private String seatID = ""; // 자리를 예약한 ID

    public LibrarySeat(int seatNumber, boolean reserved, String seatID) {
        this.seatNumber = seatNumber;
        this.reserved = reserved;
        this.seatID = seatID;
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

    public void unreserved() {
        reserved = false;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }
}
