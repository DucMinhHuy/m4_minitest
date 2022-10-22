package minhhuy.minitestweek1.moddel;

import javax.persistence.*;

@Entity
@Table(name = "minitest")
public class AppSpendingManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private String description;
    private String spendingList;
    private String image;

    public AppSpendingManagement() {
    }

    public AppSpendingManagement(int id, String name, double price, String description, String spendingList, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.spendingList = spendingList;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpendingList() {
        return spendingList;
    }

    public void setSpendingList(String spendingList) {
        this.spendingList = spendingList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
