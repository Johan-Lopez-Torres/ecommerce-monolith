package org.johan.microservices.sqljpaqueryes.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.*;
import org.johan.microservices.sqljpaqueryes.model.Product;
import org.johan.microservices.sqljpaqueryes.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter

public class OrderRequest {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 100)
    private String description;

    @Pattern(regexp = "^[A-Z0-9]{10,20}$", message = "Invalid tracking number format")
    private String trackingNumber;
    @NotBlank(message = "Address is mandatory")
    private String shippingAddress;
    @NotBlank(message = "City is mandatory")
    private String shippingCity;
    @NotBlank(message = "State is mandatory")
    private String shippingState;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    private Set<Product> products = new HashSet<>() ;



}
