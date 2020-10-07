package tables;

import javax.persistence.*;

@Entity
public class Services {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "serviceTitle", nullable = false)
    @Basic private String serviceTitle;
    @Column(name = "serviceType", nullable = false)
    @Basic private String serviceType;
    @Column(name = "servicePrice", nullable = false)
    @Basic private double servicePrice;


    public Services() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String briefInfo() {
        return "id: " + id + " название:" + serviceTitle + ", цена:" + servicePrice;
    }
}
