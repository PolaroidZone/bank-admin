package constructer;
public class User {
    private String name;
    private String address;
    private String email;
    private String phone;
    private int cardNumber;
    private int pin;
    private String city;

    public User() {
    }

    public User(String name, String address, String email, String phone, int cardNumber, int pin, String city) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
