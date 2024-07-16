package com.Bookstore.bookstore.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter

public class ProductDto {
    @NotEmpty(message = "This Field is required")
    private String bookname;
    @NotEmpty(message = "This Field is required")
    private String sellername;
    @NotEmpty(message = "This Field is required")
    private String sellerphno;
    @NotEmpty(message = "This Field is required")
    private String selleremail;
    @Min(0)
    private double price;

    @Size(min = 10, message = "The description should be at least 10 characters")
    @Size(max = 2000, message = "The description cannot exceed 2000 characters")
    private String description;

    @Getter
    private MultipartFile imageFile; //

//	public String getBookname() {
//		return bookname;
//	}
//
//	public void setBookname(String bookname) {
//		this.bookname = bookname;
//	}
//
//	public String getSellername() {
//		return sellername;
//	}
//
//	public void setSellername(String sellername) {
//		this.sellername = sellername;
//	}
//
//	public String getSellerphno() {
//		return sellerphno;
//	}
//
//	public void setSellerphno(String sellerphno) {
//		this.sellerphno = sellerphno;
//	}
//
//	public String getSelleremail() {
//		return selleremail;
//	}
//
//	public void setSelleremail(String selleremail) {
//		this.selleremail = selleremail;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public MultipartFile getImageFile() {
//		return imageFile;
//	}
//
//	public void setImageFile(MultipartFile imageFile) {
//		this.imageFile = imageFile;
//	}
//
//	public MultipartFile getImageFile() {
//		// TODO Auto-generated method stub
//		return imageFile;
//	}

	

    

}
