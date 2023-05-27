package LibrarySeatReservation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "libraryseat.json";

    public static void main(String[] args) {
        SeatRepository repository = new SeatRepository(FILE_PATH);
        CommandFactory commandFactory = new CommandFactory();
        Scanner scanner = new Scanner(System.in);
        try {
            repository.load();
        } catch (IOException e) {
            System.err.println("파일을 불러오는데 실패했습니다.");
            e.printStackTrace();
            return;
        }

        while (true) {
            System.out.println("명령을 입력하세요 (reserve, unreserved, exit): ");
            String action = scanner.next();
            if ("exit".equals(action)) {
                break;
            }
            System.out.println("자리 번호를 입력하세요: ");
            int seatNumber = scanner.nextInt();
            LibrarySeat seat = findSeat(repository.getSeats(), seatNumber);
            if (seat == null) {
                System.out.println("존재하지 않는 자리입니다.");
                continue;
            }
            Command command = commandFactory.createCommand(action, seat);
            command.execute();
        }

        try {
            repository.save();
        } catch (IOException e) {
            System.err.println("파일 저장에 실패했습니다.");
            e.printStackTrace();
        }
    }

    private static LibrarySeat findSeat(List<LibrarySeat> seats, int seatNumber) {
        for (LibrarySeat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }
        return null;
    }
}
