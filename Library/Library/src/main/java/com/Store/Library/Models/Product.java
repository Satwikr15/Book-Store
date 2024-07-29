package com.Store.Library.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookname;
    private String sellername;
    private String sellerphno;
    private String selleremail;
    private double price;

//    @Column(columnDefinition = "TEXT")
//    private String description;
    private String imageFileName;

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getBookname() {
        return bookname;
    }

    public Product setBookname(String bookname) {
        this.bookname = bookname;
        return this;
    }

    public String getSellername() {
        return sellername;
    }

    public Product setSellername(String sellername) {
        this.sellername = sellername;
        return this;
    }

    public String getSellerphno() {
        return sellerphno;
    }

    public Product setSellerphno(String sellerphno) {
        this.sellerphno = sellerphno;
        return this;
    }

    public String getSelleremail() {
        return selleremail;
    }

    public Product setSelleremail(String selleremail) {
        this.selleremail = selleremail;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Product setDescription(String description) {
//        this.description = description;
//        return this;
//    }

    public String getImageFileName() {
        return imageFileName;
    }

    public Product setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
        return this;
    }
}
