package HopeBookRequest;

public class HopeBook {

    private String title;
    private String author;
    private String publisher;
    private String year;
    private String hopeID = ""; // 희망 도서를 신청한 ID

    public HopeBook(String title, String author, String publisher, String year, String hopeID) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.hopeID = hopeID;
    }

    public String getHopeID() {
        return hopeID;
    }

    public void setHopeID(String userID) {
        this.hopeID = userID;
    }

    // getters 및 setters ..
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
