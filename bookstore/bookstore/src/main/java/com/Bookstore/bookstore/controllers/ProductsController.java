package com.Bookstore.bookstore.controllers;

import com.Bookstore.bookstore.models.Product;
import com.Bookstore.bookstore.models.ProductDto;
import com.Bookstore.bookstore.serivces.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository repo;

    // To show all products
    @GetMapping({"", "/"})
    public String showProductList(Model model){
        List<Product> products=repo.findAll();
        model.addAttribute("products", products);//adds the list of products to the Model object,This makes the list of products available to the view (Thymeleaf template) that will be rendered.
        return "products/index";//This line specifies the view name to be returned
    }

    //To create or insert products
    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProductDto productDto=new ProductDto();
        model.addAttribute("productDto",productDto);
        return "products/CreateProduct";
    }

    //to submit button
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute ProductDto productDto, BindingResult result) {

        // Validation errors for imageFile
        if (productDto.getImageFile().isEmpty()) {
            result.addError(new FieldError("productDto", "imageFile", "The image file is required"));
        }

        // Validation errors for all
        if (result.hasErrors()) {
            return "products/CreateProduct";
        }

        // Saving uploaded image into database
        MultipartFile image = productDto.getImageFile();
        //Date createdAt = new Date();
        String storageFileName =image.getOriginalFilename();

        try {
            String uploadDir = "src/main/resources/static/images/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        Product product = new Product();
        product.setBookname(productDto.getBookname());
        product.setSellername(productDto.getSellername());
        product.setSellerphno(productDto.getSellerphno());
        product.setSelleremail(productDto.getSelleremail());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageFileName(storageFileName);
        System.out.println(storageFileName);
        // Save to database
        repo.save(product);

        return "redirect:/products"; // Returns after submit to initial page
    }

    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id) {
        try {
            Product product = repo.findById(id).get();
            model.addAttribute("product", product);

            ProductDto productDto = new ProductDto();
            productDto.setBookname(product.getBookname());
            productDto.setSellername(product.getSellername());
            productDto.setSellerphno(product.getSellerphno());
            productDto.setSelleremail(product.getSelleremail());
            productDto.setPrice(product.getPrice());
            productDto.setDescription(product.getDescription());

            model.addAttribute("productDto", productDto);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/products";
        }
        return "products/EditProduct";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model,
                                @RequestParam int id,
                                @Valid @ModelAttribute ProductDto productDto,
                                BindingResult result) {
        try {
            Product product = repo.findById(id).get();
            model.addAttribute("product", product);

            if (result.hasErrors()) {
                return "products/EditProduct";
            }



            if (!productDto.getImageFile().isEmpty()) {
                // Delete old image
                String uploadDir = "/images/";
                Path oldImagePath = Paths.get(uploadDir + product.getImageFileName());

                System.out.println("Old Image Path: " + oldImagePath);

                try {
                    Files.delete(oldImagePath);
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }

                // Save new image file
                MultipartFile image = productDto.getImageFile();
                //Date createdAt = new Date();
                String storageFileName =image.getOriginalFilename(); // Here

                System.out.println("New Image Path: " + Paths.get(uploadDir+ storageFileName));

                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("New image saved successfully.");

                }
                product.setImageFileName(storageFileName);
                System.out.println("Updated image path:- "+storageFileName);
                System.out.println("Product image file name set to: " + product.getImageFileName());
            }
            product.setBookname(productDto.getBookname());
            product.setSellername(productDto.getSellername());
            product.setSellerphno(productDto.getSellerphno());
            product.setSelleremail(productDto.getSelleremail());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());



            System.out.println("Updating image file name:- "+product.getImageFileName());
            repo.save(product);
            System.out.println("Updated product: " + product);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return "redirect:/products";
    }



    // Delete
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id){
        try{
            Product product= repo.findById(id).get();

            //delete product image
            Path imagePath=Paths.get("/images"+product.getImageFileName());

            try{
                Files.delete(imagePath);
            }
            catch(Exception e){
                System.out.print("Exception: "+ e.getMessage());
            }

            //delete image from database
            repo.delete(product);
        }
        catch(Exception e){
            System.out.print("Exception: "+e.getMessage());
        }

        return "redirect:/products";
    }

}
