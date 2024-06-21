public class User {
    private String name[];
    private String phone;
    private String email;

    public User(String firstName, String lastName, String phone, String email) {
        this.name = new String[2];
        this.name[0] = firstName;
        this.name[1] = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name[0] + " " + name[1];
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String firstName, String lastName) {
        this.name[0] = firstName;
        this.name[1] = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
