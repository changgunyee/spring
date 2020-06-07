package kr.or.connect.mavenweb.dto.product;

import java.util.Date;

public class ProductPrice {
    private Integer productPriceId;
    private Integer productId;
    private String priceTypeName;
    private Integer price;
    private Float discountRate;
    private Date createDate;
    private Date modifyDate;

    @Override
    public String toString() {
        return "ProductPrice{"+
                "createDate="+createDate+
                ", discountRate="+discountRate+
                ", modifyDate="+modifyDate+
                ", price="+price+
                ", priceTypeName='"+priceTypeName+'\''+
                ", productId="+productId+
                ", productPriceId="+productPriceId+
                '}';
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(Integer productPriceId) {
        this.productPriceId = productPriceId;
    }
}
