package in.notpritam.projectservice.controllers;

import in.notpritam.projectservice.dtos.FakeStoreProductDTO;
import in.notpritam.projectservice.models.Product;
import in.notpritam.projectservice.services.FakeStoreProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This enables so we can interacts with HTTPS
@RestController
@RequestMapping("/products")
public class ProductControllers {

    FakeStoreProductService fakeStoreProductService;

    public ProductControllers(){
        this.fakeStoreProductService = new FakeStoreProductService();
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
            return fakeStoreProductService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return fakeStoreProductService.getAllProduct();
    }

}
