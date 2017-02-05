package shawn.c4q.nyc.gallerydash.Shawn.ShawnModels.LocationCheck;

/**
 * Created by shawnspeaks on 2/4/17.
 */

public class ConvertMuseumsNameToID {

    public int museumID;

    public ConvertMuseumsNameToID(String museumName) {
        int temp = -1;
        switch(museumName){
            case "American Museum of Natural History":
                temp = 1;
                break;
            case "The Metropolitan Museum of Art":
                temp = 2;
                break;
            case "Solomon R. Guggenheim Museum":
                temp = 3;
                break;
            case "Rubin Museum of Art":
                temp = 4;
                break;
            case "The Museum of Modern Art":
                temp = 5;
                break;
            case "Whitney Museum of American Art":
                temp = 6;
                break;
            case "Brooklyn Museum":
                temp = 7;
                break;
            case "The Frick Collection" :
                temp = 8;
                break;
            case "Society of Illustrators":
                temp = 9;
                break;
            case  "Museum of Contemporary African Diasporan Arts":
                temp = 10;
                break;
            case "New Museum":
                temp = 11;
                break;
            case "Museum of Modern Art":
                temp = 12;
                break;
        }
        museumID = temp;
    }

}
