package entities;


public final class Driver {
    private final String first_name;
    private final String last_name;
    private final String car_number;
    private final String password;

    public Driver(String first_name, String last_name, String car_number, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.car_number = car_number;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
