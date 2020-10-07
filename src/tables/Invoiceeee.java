package tables;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Invoiceeee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ClientFullName", nullable = false)
    @Basic private String clientFullName;
    @Column(name = "CarModel", nullable = false)
    @Basic private String carModel;
    @Column(name = "ClientPhone", nullable = false)
    @Basic private String phone;
    @Column(name = "WorkerFullName", nullable = false)
    @Basic private String workerFullName;
    @Column(name = "Service", nullable = false)
    @Basic private String service;
    @Column(name = "ServicePrice", nullable = false)
    @Basic private double servicePrice;

    public Invoiceeee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkerFullName() {
        return workerFullName;
    }

    public void setWorkerFullName(String workerFullName) {
        this.workerFullName = workerFullName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }
}
