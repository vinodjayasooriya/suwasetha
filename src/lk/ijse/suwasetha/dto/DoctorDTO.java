package lk.ijse.suwasetha.dto;

public class DoctorDTO {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String image;

    public DoctorDTO() {
    }

    public DoctorDTO(String id, String name, String address, String contact, String email, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
