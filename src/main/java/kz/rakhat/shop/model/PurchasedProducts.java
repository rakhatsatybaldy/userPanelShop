package kz.rakhat.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "purchasedProducts")
public class PurchasedProducts{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userEmail;
    private String nameOfProduct;

    public PurchasedProducts(String userEmail, String nameOfProduct) {
        this.userEmail = userEmail;
        this.nameOfProduct = nameOfProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }
}
