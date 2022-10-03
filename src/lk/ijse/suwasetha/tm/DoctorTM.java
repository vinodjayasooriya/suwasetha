package lk.ijse.suwasetha.tm;

import com.jfoenix.controls.JFXButton;

public class DoctorTM {
    private String id;
    private String name;
    private String address;
    private String email;
    private String contact;
    private JFXButton btn;

    public DoctorTM() {
    }

    public DoctorTM(String id, String name, String address, String email, String contact, JFXButton btn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.btn = btn;
        this.btn.setStyle(
                "-fx-background-color: #d35400;" +
                        " -fx-text-fill: white");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "DoctorTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", btn=" + btn +
                '}';
    }
}
