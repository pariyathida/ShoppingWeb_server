package camt.cbsd.repository;

import camt.cbsd.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Lenovo on 17-Apr-17.
 */
public interface ProductRepository extends CrudRepository<Product,Long>{
    Product findById(Long id);
    Product findByName(String name);
    List<Product> findByNameIgnoreCaseContaining(String name);
    List<Product> findByDescriptionIgnoreCaseContaining(String description);
}
