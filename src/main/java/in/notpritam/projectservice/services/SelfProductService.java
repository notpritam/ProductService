package in.notpritam.projectservice.services;

import in.notpritam.projectservice.Exceptions.ProductNotFoundException;
import in.notpritam.projectservice.models.Category;
import in.notpritam.projectservice.models.Product;
import in.notpritam.projectservice.repositories.CategoryRepository;
import in.notpritam.projectservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements IProductService{

    private final ProductRepository productRepository;
    private  final CategoryRepository categoryRepository;

    public  SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product Not Found", id);
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null){
            // save a new category
           product.setCategory(categoryRepository.save(category));
        }

        return productRepository.save(product);
    }
}
