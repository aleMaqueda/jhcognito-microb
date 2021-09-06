package com.example.microservices.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import com.example.microservices.domain.enumeration.OrderItemStatus;

/**
 * A DTO for the {@link com.example.microservices.domain.OrderItem} entity.
 */
public class OrderItemDTO implements Serializable {
    
    private String id;

    @NotNull
    @Min(value = 0)
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal totalPrice;

    @NotNull
    private OrderItemStatus status;


    private String productId;

    private String productName;

    private String orderId;

    private String orderCode;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderItemStatus getStatus() {
        return status;
    }

    public void setStatus(OrderItemStatus status) {
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String productOrderId) {
        this.orderId = productOrderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String productOrderCode) {
        this.orderCode = productOrderCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderItemDTO)) {
            return false;
        }

        return id != null && id.equals(((OrderItemDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderItemDTO{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", totalPrice=" + getTotalPrice() +
            ", status='" + getStatus() + "'" +
            ", productId='" + getProductId() + "'" +
            ", productName='" + getProductName() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", orderCode='" + getOrderCode() + "'" +
            "}";
    }
}
