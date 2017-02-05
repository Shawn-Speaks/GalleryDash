package shawn.c4q.nyc.gallerydash.jon.avatarcreator.model;

/**
 * Created by jonathancolon on 2/4/17.
 */

public class Museum {
    private Long _id;
    private String MuseumName;
    private int numberOfVisits;
    private long timeLastVisted;

    public String getMuseumName() {
        return MuseumName;
    }

    public void setMuseumName(String museumName) {
        MuseumName = museumName;
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
