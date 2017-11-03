package ghostapp.africa.incentro.ghostapp.model;

/**
 * Created by lynnette on 11/3/17.
 */

public class Dream {

    private String name;
    private int thumbnail;

    public Dream() {
    }

    public Dream(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}


