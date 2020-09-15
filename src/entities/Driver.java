package entities;


public final class Driver {
    private String api_key;
    private final String first_name;
    private final String last_name;
    private final String car_number;

    public Driver(String first_name, String last_name, String car_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.car_number = car_number;
    }

    public String getApi_key() {
        return api_key;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setApi_key(String key) {
        this.api_key = key;
    }
}
