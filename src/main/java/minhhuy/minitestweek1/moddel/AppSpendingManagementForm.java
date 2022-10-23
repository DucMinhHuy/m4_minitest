package minhhuy.minitestweek1.moddel;

import org.springframework.web.multipart.MultipartFile;

//import javax.persistence.*;

//@Entity
//@Table(name = "minitest")
public class AppSpendingManagementForm {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String description;
    private String spendingList;
    private MultipartFile image;

    public AppSpendingManagementForm() {
    }

    public AppSpendingManagementForm(Long id, String name, double price, String description, String spendingList, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.spendingList = spendingList;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
