package com.nicktank.microservice.web;

import com.nicktank.microservice.domain.Product;
import com.nicktank.microservice.repository.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;



/**
 * Product Controller
 * 
 * - we use a productDTO to pass parameter to and from the REST calls
 * - we use paging for the list back to the REST
 * 
 */
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    protected ProductController() {

    }

    
    /**
     * find product object 
     *
     * @param product.id
     * @return The modified Product DTO.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    //<GET>http://localhost:8080/product/1    
    public ProductDto findProductById(@PathVariable(value = "id") String id) {
    	Product _product = verifyProduct(id);       
        return toDto(productRepository.save(_product));
    }
    
    


    /**
     * list a Products  (plus paging)
     *
     * @param pageable
     * @return
     */   
    @RequestMapping(method = RequestMethod.GET, path = "/list")    
    //<GET>http://localhost:8080/product/list
    //<GET>http://localhost:8080/product/list?page=0&size=2 <-with paging    
    public Page<ProductDto> getAllProducts(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        List<ProductDto> productDtoList = productPage.getContent().stream().map(_product -> toDto(_product)).collect(Collectors.toList());
        return new PageImpl<ProductDto>(productDtoList, pageable, productPage.getTotalPages());
    }



    /**
     * Create a product 
     *
     * @param dto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    //<POST>http://localhost:8080/product
    //{
    //	"name": "Product A",
    //  "price": 990.99
    //}   
    public void createProduct(@RequestBody @Validated ProductDto dto) {
        //Product(String name, String description, BigDecimal price)         
        productRepository.save(new Product( dto.getName(), dto.getUsdprice()));
    }
    
    
    /**
     * Update product object 
     *
     * @param product.id
     * @param dto
     * @return The modified Product DTO.
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    //<PUT>http://localhost:8080/product/1
    //{
    //	"name": "system1",
    //  "price": 99.99
    //}      
    public ProductDto updateWithPut(@PathVariable(value = "id") String id, @RequestBody @Validated ProductDto dto) {
        Product _product = verifyProduct(id);
        _product.setName(dto.getName()); 
        _product.setUsdprice(dto.getUsdprice());  
        return toDto(productRepository.save(_product));
    }
    
    
    /**
     * Update name or description for a Product
     *
     * @param product.id
     * @param dto
     * @return The modified DTO.
     */
    @RequestMapping(method = RequestMethod.PATCH, path = "/{id}")
    //<PATCH>http://localhost:8080/product/1
    //{
    //	"name": "change the name",
    //	"description": "changed to this"
    //}        
    public ProductDto updateWithPatch(@PathVariable(value = "id") String id, @RequestBody @Validated ProductDto dto) {
        Product _product = verifyProduct(id);
        if (dto.getName() != null) {
            _product.setName(dto.getName());
        }
        if (dto.getUsdprice() != null) {
            _product.setUsdprice(dto.getUsdprice());
        }  
        return toDto(productRepository.save(_product));
    }


    
    /**
     * Convert the Product entity to a ProductDto
     *
     * @param product 
     * @return ProductDto
     */
    private ProductDto toDto(Product _product) {
        //ProductDto(String id, String name, DigDecimal usdprice)    	
        return new ProductDto(_product.getId(), _product.getName(), _product.getUsdprice());
    }


    /**
     * Verify and return the Tour given a tourId.
     *
     * @param id
     * @return the found Product
     * @throws NoSuchElementException if no Product found.
     */
    private Product verifyProduct(String id) throws NoSuchElementException {
        Optional<Product> _product= productRepository.findById(id);
        if (!_product.isPresent()) {
            throw new NoSuchElementException("Product does not exist:  " + id);
        }
        return _product.get();
    }
 
    
    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }

}
