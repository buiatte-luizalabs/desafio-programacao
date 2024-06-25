package com.priscilarosa.desafio.application.core.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "sales_data")
public class SalesDataEntity {

    public SalesDataEntity() {
    }

    public SalesDataEntity(Long id, String purchaserName, String itemDescription, Double itemPrice, Integer purchaseCount, String merchantAddress, String merchantName) {
        this.id = id;
        this.purchaserName = purchaserName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.purchaseCount = purchaseCount;
        this.merchantAddress = merchantAddress;
        this.merchantName = merchantName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "purchaser_name")
    private String purchaserName;
    @Column(name = "item_description")
    private String itemDescription;
    @Column(name = "item_price")
    private Double itemPrice;
    @Column(name = "purchase_count")
    private Integer purchaseCount;
    @Column(name = "merchant_address")
    private String merchantAddress;
    @Column(name = "merchant_name")
    private String merchantName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
