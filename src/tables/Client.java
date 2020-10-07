package tables;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SecondName", nullable = false)
    @Basic private String secondName;
    @Column(name = "FirstName", nullable = false)
    @Basic private String firstName;
    @Column(name = "MiddleName", nullable = false)
    @Basic private String middleName;
    @Column(name = "phone", nullable = false)
    @Basic private String phone;
    @Column(name = "driverLicenseNum", nullable = false)
    @Basic private String driverLicenseNum;
    @Column(name = "CarModel", nullable = false)
    @Basic private String carModel;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriverLicenseNum() {
        return driverLicenseNum;
    }

    public void setDriverLicenseNum(String driverLicenseNum) {
        this.driverLicenseNum = driverLicenseNum;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String briefInfo() {
        return "id: " + id + ", " + secondName + " " + firstName + " " + middleName;
    }
}
