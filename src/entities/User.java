package entities;


public final class User {
    private String api_key;
    private final String first_name;
    private final String last_name;
    private final String email;

    public User(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String key) {
        this.api_key = key;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }
}
