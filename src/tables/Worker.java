package tables;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Worker {
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
    @Column(name = "Phone", nullable = false)
    @Basic private String phone;
    @Column(name = "HiringDate", nullable = false)
    @Basic private LocalDate hiringDate;
    @Column(name = "Salary", nullable = false)
    @Basic private double salary;
    @Column(name = "Occupation", nullable = false)
    @Basic private String occupation;

    public Worker() {
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

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String briefInfo() {
        return "id: " + ", " + secondName + " " + firstName + " " + middleName + ", " + occupation;
    }
}
