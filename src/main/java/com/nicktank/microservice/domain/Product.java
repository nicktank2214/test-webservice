package com.nicktank.microservice.domain;

import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Objects;


/**
 */
@Entity
@Table (name="product")
public class Product {

	@Id
    private String id;

    @Column
    private String name;

    @Column 
    private BigDecimal usdprice;





    public Product(String id, String name, BigDecimal usdprice) {
        this.id = id;
        this.name = name;
        this.usdprice = usdprice;
    }
    public Product(String name, BigDecimal usdprice) {
        this.name = name;
        this.usdprice = usdprice;
    }
    
    protected Product() {
    }


    
    
    

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUsdprice() {
		return usdprice;
	}
	public void setUsdprice(BigDecimal usdprice) {
		this.usdprice = usdprice;
	}




    public String toString() {
        return "Product{" +
                "id=" + id+
                ", name='" + name + '\'' +
                ", usdprice ='" + usdprice+ '\''+ '}'
                ;
    }
                
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(usdprice, product.usdprice) 
                ;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, usdprice    		);
    }
    
}
