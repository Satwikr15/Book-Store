package com.Store.Library.Models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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

//    @Size(min = 10, message = "The description should be at least 10 characters")
//    @Size(max = 2000, message = "The description cannot exceed 2000 characters")
//    private String description;

    @Getter
    private MultipartFile imageFile; //

    public @NotEmpty(message = "This Field is required") String getBookname() {
        return bookname;
    }

    public void setBookname(@NotEmpty(message = "This Field is required") String bookname) {
        this.bookname = bookname;
    }

    public @NotEmpty(message = "This Field is required") String getSellername() {
        return sellername;
    }

    public void setSellername(@NotEmpty(message = "This Field is required") String sellername) {
        this.sellername = sellername;
    }

    public @NotEmpty(message = "This Field is required") String getSellerphno() {
        return sellerphno;
    }

    public void setSellerphno(@NotEmpty(message = "This Field is required") String sellerphno) {
        this.sellerphno = sellerphno;
    }

    public @NotEmpty(message = "This Field is required") String getSelleremail() {
        return selleremail;
    }

    public void setSelleremail(@NotEmpty(message = "This Field is required") String selleremail) {
        this.selleremail = selleremail;
    }

    @Min(0)
    public double getPrice() {
        return price;
    }

    public void setPrice(@Min(0) double price) {
        this.price = price;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
