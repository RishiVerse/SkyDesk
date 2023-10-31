package JDeskWorking;

public class User {

    private String title;
    private String author;
    private String recent;

    public User(String title, String author, String recent) {
        this.title = title;
        this.author = author;
        this.recent = recent;
    }

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

    public String getRecent() {
        return recent;
    }

    public void setRecent(String recent) {
        this.recent = recent;
    }


}
