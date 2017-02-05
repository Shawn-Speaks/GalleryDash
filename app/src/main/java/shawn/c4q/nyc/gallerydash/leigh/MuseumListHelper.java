package shawn.c4q.nyc.gallerydash.leigh;

import java.util.ArrayList;

import shawn.c4q.nyc.gallerydash.leigh.models.MuseumData;

/**
 * Created by leighdouglas on 2/3/17.
 */

public class MuseumListHelper {

    public static MuseumListHelper instance;

    private ArrayList<MuseumData> museumDataList;

    public static MuseumListHelper getInstance() {
        if (instance == null) {
            instance = new MuseumListHelper();
        }
        return instance;
    }

    public void setList(ArrayList<MuseumData> list) {
        if (museumDataList != null) {
            museumDataList.clear();
        } else {
            museumDataList = new ArrayList<>();
        }

        this.museumDataList.addAll(parseList(list));
    }

    public ArrayList<MuseumData> getMuseumDataList() {
        return museumDataList;
    }

    public ArrayList<MuseumData> parseList(ArrayList<MuseumData> list) {
        ArrayList<MuseumData> temp = new ArrayList<>();
        for (MuseumData data : list) {
            switch (data.getProperties().getName()) {
                case "Metropolitan Museum of Art (MET)":
                    temp.add(data);
                    break;
                case "Museum of Modern Art (MoMA)":
                    temp.add(data);
                    break;
                case "Museum for African Art":
                    temp.add(data);
                    break;
                case "Museum of Comic and Cartoon Art (MoCCA)":
                    temp.add(data);
                    break;
                case "Museum of Contemporary African Diasporan Arts (MoCADA)":
                    temp.add(data);
                    break;
                case "Solomon R. Guggenheim Museum":
                    temp.add(data);
                    break;
                case "Whitney Museum of American Art":
                    temp.add(data);
                    break;
                case "Brooklyn Museum":
                    temp.add(data);
                    break;
                case "Frick Collection":
                    temp.add(data);
                    break;
                case "Rubin Museum of Art":
                    temp.add(data);
                    break;
                case "New Museum of Contemporary Art":
                    temp.add(data);
                    break;
                case "American Museum of Natural History":
                    temp.add(data);
                    break;
                case "P.S. 1 Contemporary Art Center":
                    temp.add(data);
                    break;
            }
        }
        return temp;
    }
}
