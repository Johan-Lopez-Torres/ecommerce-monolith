package org.johan.microservices.sqljpaqueryes.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequest {
    @NotBlank
    private Integer quantity;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private BigDecimal discount;

    @NotBlank
    private BigDecimal total;





}
