package in.notpritam.projectservice.services;

import in.notpritam.projectservice.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);
    List<Product> getAllProduct();
}
