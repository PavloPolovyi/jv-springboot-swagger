package mate.academy.springboot.swagger.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.springboot.swagger.model.Product;
import mate.academy.springboot.swagger.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to, Pageable pageable) {
        return productRepository.findAllByPriceBetween(from, to, pageable).stream()
                .collect(Collectors.toList());
    }
}