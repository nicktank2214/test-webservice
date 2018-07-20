package com.nicktank.microservice.web;


import java.math.BigDecimal;

import javax.validation.constraints.Size;

/**
 * Data Transfer Object for user
 */
public class ProductDto {

    @Size(max = 20)
    private String id;
    
    @Size(max = 200)
    private String name;
    
    
    private BigDecimal usdprice;
    
    

    /**
     * Constructor to fully initialize the ProductDto
     *
     */
    public ProductDto(String id, String name, BigDecimal usdprice) {
        this.name = name;
        this.id = id;        
        this.usdprice = usdprice;
    }

    protected ProductDto() {}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getUsdprice() {
		return usdprice;
	}
	public void setUsdprice(BigDecimal usdprice) {
		this.usdprice = usdprice;
	}     
    

}
