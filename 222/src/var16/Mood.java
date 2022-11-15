package var10;

/**
 */
public class Mood {
    private String title;

    Mood() {
        this.title = "unset";
    }

    Mood(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
