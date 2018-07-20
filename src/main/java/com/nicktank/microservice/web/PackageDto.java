package com.nicktank.microservice.web;


import java.math.BigDecimal;

import javax.validation.constraints.Size;

/**
 * Data Transfer Object for user
 */
public class PackageDto {

    private Integer id;
    
    @Size(max = 200)
    private String name;

    @Size(max = 200)
    private String description;

    @Size(max = 200)
    private String products;
    
    private BigDecimal price;
    
    

    /**
     * Constructor to fully initialize the PackageDto
     *
     */
    public PackageDto(Integer id, String name, String description, String products, BigDecimal price) {
        this.name = name;
        this.id = id;        
        this.description = description;
        this.products = products;
        this.price = price;
    }

    protected PackageDto() {}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}     
    

}
