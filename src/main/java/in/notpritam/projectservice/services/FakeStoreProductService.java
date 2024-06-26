package in.notpritam.projectservice.services;

import in.notpritam.projectservice.Exceptions.ProductNotFoundException;
import in.notpritam.projectservice.dtos.FakeStoreProductDTO;
import in.notpritam.projectservice.models.Category;
import in.notpritam.projectservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements IProductService {


    RestTemplate restTemplate;

    public  FakeStoreProductService(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Product getProductById(Long id) {

        // get the product by using id from here

        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);

        if(fakeStoreProductDTO == null){
            throw  new ProductNotFoundException("Please a valid product id.", id);
        }

        return mapFakeStoreProductDTOToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProduct() {


        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();


        if(fakeStoreProductDTOS.length< 1){
            throw new ProductNotFoundException("Not Product Found", (long) -1);
        }

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            products.add(mapFakeStoreProductDTOToProduct(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }


    public Product mapFakeStoreProductDTOToProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        // Check if data is null
        if (fakeStoreProductDTO == null) {
            return null;
        }

        // Map data to Product object
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());

        // Map category
        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);

        return product;
    }
}
