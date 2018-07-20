package com.nicktank.microservice.domain;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * Product for a Package
 *
 * Created by Nick Tankard
 */
@Entity
@Table (name="package_product")
public class PackageProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column (name = "package_id")
	private Integer packageid;



	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product _product;


    @ManyToOne
    @JoinColumn(name="package_id", insertable=false, updatable=false)
    private Package _package;
    
    

	public PackageProduct(Integer id, Integer packageid, Product product) {
		this.id = id;
		this.packageid = packageid;
		this._product = product; 
	}
	
	
	public PackageProduct(Integer packageid, Product product) {
		this.packageid = packageid;
		this._product = product; 
	}

	//constructor protected to force use of data init constructor
	protected PackageProduct() {
	}



    

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPackageid() {
		return packageid;
	}
	public void setPackageid(Integer packageid) {
		this.packageid = packageid;
	}


	public Product getProduct() {
		return _product;
	}
	public void setProduct(Product product) {
		this._product = product;
	}





	public String toString() {
		return "PackageProduct{" +
				"id=" + id+
				", packageid='" + packageid+ '\'' +
				", product='" + _product+ '\''+  '}'
				;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PackageProduct packageProduct = (PackageProduct) o;
		return Objects.equals(id, packageProduct.id) &&
				Objects.equals(packageid, packageProduct.packageid) &&
				Objects.equals(_product, packageProduct._product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, packageid, _product);
	}



}
