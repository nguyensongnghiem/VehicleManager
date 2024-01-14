package model;

public class Manufacturer {
    String id;
    String name;
    String nation;

    public Manufacturer(String id, String name, String nation) {
        this.id = id;
        this.name = name;
        this.nation = nation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}

