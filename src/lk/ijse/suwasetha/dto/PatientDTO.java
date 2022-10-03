package lk.ijse.suwasetha.dto;

public class PatientDTO {
    private String nic;
    private String name;
    private String contact;
    private String address;
    private String gender;
    private int age;
    private String email;

    public PatientDTO() {
    }

    public PatientDTO(String nic, String name, String contact, String address, String gender, int age, String email) {
        this.nic = nic;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
