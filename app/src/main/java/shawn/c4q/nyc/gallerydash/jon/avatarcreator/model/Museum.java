package shawn.c4q.nyc.gallerydash.jon.avatarcreator.model;

/**
 * Created by jonathancolon on 2/4/17.
 */

public class Museum {
    private Long _id;
    private String museumName;
    private int numberOfVisits;
    private long timeLastVisted;

    public Museum(){}

    public Museum(String museumName, int numberOfVisits, long timeLastVisted) {
        this.museumName = museumName;
        this.numberOfVisits = 0;
        this.timeLastVisted = timeLastVisted;
    }

    public Museum(String museumName) {
        this.museumName = museumName;
    }

    public String getMuseumName() {
        return museumName;
    }

    public void setMuseumName(String museumName) {
        this.museumName = museumName;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public long getTimeLastVisted() {
        return timeLastVisted;
    }

    public void setTimeLastVisted(long timeLastVisted) {
        this.timeLastVisted = timeLastVisted;
    }
}
