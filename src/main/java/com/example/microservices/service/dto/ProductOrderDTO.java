package com.example.microservices.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.example.microservices.domain.enumeration.OrderStatus;

/**
 * A DTO for the {@link com.example.microservices.domain.ProductOrder} entity.
 */
public class ProductOrderDTO implements Serializable {
    
    private String id;

    @NotNull
    private Instant placedDate;

    @NotNull
    private OrderStatus status;

    @NotNull
    private String code;

    private Long invoiceId;


    private String customerId;

    private String customerEmail;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(Instant placedDate) {
        this.placedDate = placedDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductOrderDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductOrderDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductOrderDTO{" +
            "id=" + getId() +
            ", placedDate='" + getPlacedDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", code='" + getCode() + "'" +
            ", invoiceId=" + getInvoiceId() +
            ", customerId='" + getCustomerId() + "'" +
            ", customerEmail='" + getCustomerEmail() + "'" +
            "}";
    }
}
