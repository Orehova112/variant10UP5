package var10;

/**
 */
public class Word {
    private String spelling;
    private Mood mood;
    private int ratio;

    Word() {
        this.spelling = "unset";
        this.mood = new Mood();
        this.ratio = 0;
    }

    Word(String spelling, Mood mood, int ratio) {
        this.spelling = spelling;
        this.mood = mood;
        this.ratio = ratio;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public String getSpelling() {
        return this.spelling;
    }

    public Mood getMood() {
        return this.mood;
    }

    public int getRatio() {
        return this.ratio;
    }

}
