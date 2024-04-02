package in.notpritam.projectservice.controllers;

import in.notpritam.projectservice.dtos.FakeStoreProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This enables so we can interacts with HTTPS
@RestController
@RequestMapping("/products")
public class ProductControllers {

    @GetMapping("/{id}")
    public FakeStoreProductDTO getProductById(@PathVariable("id") Long id){
            return null;
    }

}
