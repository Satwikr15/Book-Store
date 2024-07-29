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


}
