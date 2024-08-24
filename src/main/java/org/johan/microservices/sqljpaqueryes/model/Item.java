package org.johan.microservices.sqljpaqueryes.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal price;

    private BigDecimal discount;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        total = calculateTotal();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.total = calculateTotal();
    }

    public void onDelete() {
        this.updatedAt = LocalDateTime.now();
    }

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    private BigDecimal calculateTotal() {
        BigDecimal total = product.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
        BigDecimal discount = calculateDiscount();
        return total.subtract(discount);
    }

    private BigDecimal calculateDiscount() {
        return product.getDiscount() != null ? product
                .getDiscount()
                .divide(BigDecimal.valueOf(100))
                .multiply(product.getPrice()) : BigDecimal.ZERO;
    }

}
