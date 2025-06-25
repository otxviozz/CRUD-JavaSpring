package com.example.crud.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String name;
	
	private Integer price_in_cents;
	
	
	public Product(RequestProduct requestProduct) {
		this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
	}
	
	public void setName(String name) {
        this.name = name;
    }

    public void setPrice_in_cents(Integer price_in_cents) {
        this.price_in_cents = price_in_cents;
    }
}
