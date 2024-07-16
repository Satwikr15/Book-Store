package com.Bookstore.bookstore.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookname;
    private String sellername;
    private String sellerphno;
    private String selleremail;
    private double price;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String imageFileName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getSellerphno() {
		return sellerphno;
	}
	public void setSellerphno(String sellerphno) {
		this.sellerphno = sellerphno;
	}
	public String getSelleremail() {
		return selleremail;
	}
	public void setSelleremail(String selleremail) {
		this.selleremail = selleremail;
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
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
    
	

    //getters and setters

//    public int getId() {
//        return id;
//    }
//
//    public Product setId(int id) {
//        this.id = id;
//        return this;
//    }
//
//    public String getBookname() {
//        return bookname;
//    }
//
//    public Product setBookname(String bookname) {
//        this.bookname = bookname;
//        return this;
//    }
//
//    public String getSellername() {
//        return sellername;
//    }
//
//    public Product setSellername(String sellername) {
//        this.sellername = sellername;
//        return this;
//    }
//
//    public String getSellerphno() {
//        return sellerphno;
//    }
//
//    public Product setSellerphno(String sellerphno) {
//        this.sellerphno = sellerphno;
//        return this;
//    }
//
//    public String getSelleremail() {
//        return selleremail;
//    }
//
//    public Product setSelleremail(String selleremail) {
//        this.selleremail = selleremail;
//        return this;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public Product setPrice(double price) {
//        this.price = price;
//        return this;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Product setDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    public String getImageFileName() {
//        return imageFileName;
//    }
//
//    public Product setImageFileName(String imageFileName) {
//        this.imageFileName = imageFileName;
//        return this;
//    }
//
//    //constructors for both with fields and without fields
//    public Product(int id, String bookname, String sellername, String sellerphno, String selleremail, double price, String description, String imageFileName) {
//        this.id = id;
//        this.bookname = bookname;
//        this.sellername = sellername;
//        this.sellerphno = sellerphno;
//        this.selleremail = selleremail;
//        this.price = price;
//        this.description = description;
//        this.imageFileName = imageFileName;
//    }
//
//    public Product() {
//    }
}
