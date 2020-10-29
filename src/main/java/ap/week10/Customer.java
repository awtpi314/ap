package ap.week10;

public class Customer {
    private String name;
    private String city;
    private String state;

    public Customer(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
