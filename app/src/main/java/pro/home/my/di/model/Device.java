package pro.home.my.di.model;

public class Device {

    private long id;
    private String name;
    private String state;

    public Device(long id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
