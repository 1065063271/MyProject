package com.empty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shopcar", schema = "tmsql", catalog = "")
@IdClass(ShopcarEntityPK.class)
public class ShopcarEntity {
    private int productId;
    private String userId;
    private Double productPrice;
    private Integer productNum;
    private String productName;

    @Id
    @Column(name = "ProductId", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "userId", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "ProductPrice", nullable = true, precision = 0)
    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "ProductNum", nullable = true)
    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    @Basic
    @Column(name = "ProductName", nullable = true, length = 50)
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
        ShopcarEntity that = (ShopcarEntity) o;
        return productId == that.productId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(productPrice, that.productPrice) &&
                Objects.equals(productNum, that.productNum) &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, userId, productPrice, productNum, productName);
    }
}
