package model;

public class borrower {
    private String id ,name ,bitrhDate,email,phone,image;

    public borrower() {
    }

    public borrower(String id, String name, String bitrhDate, String email, String phone, String image) {
        this.id = id;
        this.name = name;
        this.bitrhDate = bitrhDate;
        this.email = email;
        this.phone = phone;
        this.image = image;
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

    public String getBitrhDate() {
        return bitrhDate;
    }

    public void setBitrhDate(String bitrhDate) {
        this.bitrhDate = bitrhDate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
