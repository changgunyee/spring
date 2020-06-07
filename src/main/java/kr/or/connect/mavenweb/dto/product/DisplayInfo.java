package kr.or.connect.mavenweb.dto.product;

import java.util.Date;

public class DisplayInfo {
    private Integer displayInfoId;
    private Integer productId;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String telephone;
    private String homepage;
    private String email;
    private Date createDate;
    private Date modifyDate;
    private String productContent;
    private String productDescription;
    private String productEvent;
    private Integer categoryId;
    private String categoryName;

    @Override
    public String toString() {
        return "DisplayInfo{"+
                "categoryId="+categoryId+
                ", categoryName='"+categoryName+'\''+
                ", createDate="+createDate+
                ", displayInfoId="+displayInfoId+
                ", email='"+email+'\''+
                ", homepage='"+homepage+'\''+
                ", modifyDate="+modifyDate+
                ", openingHours='"+openingHours+'\''+
                ", placeLot='"+placeLot+'\''+
                ", placeStreet='"+placeStreet+'\''+
                ", placeName='"+placeName+'\''+
                ", productContent='"+productContent+'\''+
                ", productDescription='"+productDescription+'\''+
                ", productEvent='"+productEvent+'\''+
                ", productId="+productId+
                ", telephone='"+telephone+'\''+
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPlaceStreet() {
        return placeStreet;
    }

    public void setPlaceStreet(String placeStreet) {
        this.placeStreet = placeStreet;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getPlaceLot() {
        return placeLot;
    }

    public void setPlaceLot(String placeLot) {
        this.placeLot = placeLot;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductEvent() {
        return productEvent;
    }

    public void setProductEvent(String productEvent) {
        this.productEvent = productEvent;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
