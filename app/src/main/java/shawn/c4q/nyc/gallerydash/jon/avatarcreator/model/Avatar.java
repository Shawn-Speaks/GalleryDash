package shawn.c4q.nyc.gallerydash.jon.avatarcreator.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by jonathancolon on 2/1/17.
 */

public class Avatar implements Serializable {

    private Long _id;
    private String firstName;
    private String lastName;
    private int gender;
    private int eyeColor;
    private int skintone;
    private int shirt;
    private int pants;
    private int theMet;
    private int museumofAfricanArt;
    private int museumofCartoons;
    private int moCADA;
    private int museumOfModernArt;

    private int hairStyle;
    private HashMap<Integer, Integer> museumsVisited;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getSkintone() {
        return skintone;
    }

    public void setSkintone(int skintone) {
        this.skintone = skintone;
    }

    public int getHairStyle() {
        return hairStyle;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }

    public int getShirt() {
        return shirt;
    }

    public void setShirt(int shirt) {
        this.shirt = shirt;
    }

    public int getPants() {
        return pants;
    }

    public void setPants(int pants) {
        this.pants = pants;
    }

    public HashMap<Integer, Integer> getMuseumsVisited() {
        return museumsVisited;
    }

    public void setMuseumsVisited(HashMap<Integer, Integer> museumsVisited) {
        this.museumsVisited = museumsVisited;
    }
}
