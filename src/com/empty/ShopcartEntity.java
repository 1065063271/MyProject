package com.empty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shopcart", schema = "tmsql", catalog = "")
public class ShopcartEntity {
    private int shopId;
    private Integer productId;
    private String owner;
    private Double productPrice;
    private Integer productNum;
    private String productName;

    @Id
    @Column(name = "shopId", nullable = false)
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "productId", nullable = true)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "owner", nullable = true, length = 20)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "productPrice", nullable = true, precision = 0)
    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "productNum", nullable = true)
    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    @Basic
    @Column(name = "productName", nullable = true, length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopcartEntity that = (ShopcartEntity) o;
        return shopId == that.shopId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(productPrice, that.productPrice) &&
                Objects.equals(productNum, that.productNum) &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, productId, owner, productPrice, productNum, productName);
    }
}
