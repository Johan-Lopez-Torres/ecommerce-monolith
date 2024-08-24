package org.johan.microservices.sqljpaqueryes.dto.request;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "SKU is mandatory")
    private String sku;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 30, message = "Name should be between 3 and 50 characters")
    private String name;

    @Positive(message = "Price should be positive")
    private BigDecimal price;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 1, max = 100, message = "Description should be between 3 and 100 characters")
    private String description;

    @NotBlank(message = "Category is mandatory")
    @Size(min = 1, max = 30, message = "Category should be between 3 and 30 characters")
    private String category;

    @Positive(message = "Stock should be positive")
    private String stock;

}
