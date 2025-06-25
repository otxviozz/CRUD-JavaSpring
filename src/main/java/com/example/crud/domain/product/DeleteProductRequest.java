package com.example.crud.domain.product;

import jakarta.validation.constraints.NotBlank;

public record DeleteProductRequest(
		@NotBlank String id
		) {
}
