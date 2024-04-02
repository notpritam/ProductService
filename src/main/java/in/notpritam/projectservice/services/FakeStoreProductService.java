package in.notpritam.projectservice.services;

import in.notpritam.projectservice.dtos.FakeStoreProductDTO;
import in.notpritam.projectservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {

        // get the product by using id from here

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        return null;
    }
}
