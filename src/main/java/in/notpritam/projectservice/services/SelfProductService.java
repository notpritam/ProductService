package in.notpritam.projectservice.services;

import in.notpritam.projectservice.models.Product;
import in.notpritam.projectservice.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class SelfProductService implements IProductService{

    private ProductRepository productRepository;

    public  SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }
}
