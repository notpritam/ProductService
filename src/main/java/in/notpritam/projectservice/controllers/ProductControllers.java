package in.notpritam.projectservice.controllers;

import in.notpritam.projectservice.dtos.ExceptionDTO;
import in.notpritam.projectservice.dtos.FakeStoreProductDTO;
import in.notpritam.projectservice.models.Product;
import in.notpritam.projectservice.services.FakeStoreProductService;
import in.notpritam.projectservice.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

// This enables so we can interacts with HTTPS
@RestController
@RequestMapping("/products")
public class ProductControllers {

   IProductService productService;

    public ProductControllers(@Qualifier("selfProductService") IProductService productService){
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

//            ResponseEntity<Object> responseEntity = null;
//            try{
//             Product product =  fakeStoreProductService.getProductById(id);
//             responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            }catch (RuntimeException exception) {
//                ExceptionDTO exceptionDTO = new ExceptionDTO();
//                exceptionDTO.setMessage("Something Went Wrong");
//                exceptionDTO.setResolution("Do Nothing");
//                responseEntity = new ResponseEntity<>(exceptionDTO,HttpStatus.NOT_FOUND);
//            }


            return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping
    public  Product createProduct(@RequestBody Product product){
        return  productService.createProduct(product);
    }

}
