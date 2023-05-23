package LibrarySeatReservation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeatRepository {
    private List<LibrarySeat> seats;
    private String filePath;

    public SeatRepository(String filePath) {
        this.seats = new ArrayList<>();
        this.filePath = filePath;
    }

    public void load() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Gson gson = new Gson();
                LibrarySeat[] seatArray = gson.fromJson(reader, LibrarySeat[].class);
                for (LibrarySeat seat : seatArray) {
                    seats.add(seat);
                }
            }
        }
    }

    public List<LibrarySeat> getSeats() {
        return seats;
    }

    public boolean save() throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(seats);
            writer.write(json);
        }
        return true;
    }
}
//SeatRepository 클래스는 파일로부터 좌석 정보를 읽어오거나 파일에 좌석 정보를 저장합니다.
// load() 메서드는 libraryseat.json 파일에서 좌석 정보를 읽어와 LibrarySeat 객체 리스트를 만들고,
// getSeats() 메서드는 리스트를 반환합니다. save() 메서드는 LibrarySeat 객체 리스트를 libraryseat.json 파일에 저장합니다.
