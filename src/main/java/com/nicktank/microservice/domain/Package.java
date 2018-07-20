package com.nicktank.microservice.domain;

import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;


/**
 */
@Entity
@Table (name="package")
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column 
    private BigDecimal price;


    @OneToMany(cascade = CascadeType.ALL,
    		fetch = FetchType.EAGER,
            mappedBy = "_package")
    private Set<PackageProduct> packageproducts;
   


    public Package(Integer id,	String name, String description, BigDecimal price) {
    	this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Package(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    protected Package() {
    }


    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

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
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	


	public Set<PackageProduct> getPackageProducts() {
		return packageproducts;
	}
	public void setPackageProducts(Set<PackageProduct> packageproducts) {
		this.packageproducts = packageproducts;
	}
	
	




    @Override
    public String toString() {
        return "Package{" +
                "id=" + id+
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +                
                ", price ='" + price+ '\''+  '}'
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package _package = (Package) o;
        return Objects.equals(id, _package.id) &&
                Objects.equals(name, _package.name) &&
                Objects.equals(description, _package.description) &&
                Objects.equals(price, _package.price) 
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}
