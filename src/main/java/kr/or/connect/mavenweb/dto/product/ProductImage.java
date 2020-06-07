package kr.or.connect.mavenweb.dto.product;

import java.util.Date;

public class ProductImage {
    private Integer productImageId;
    private Integer productId;
    private String type;
    private Integer fileInfoId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private Boolean deleteFlag;
    private Date createDate;
    private Date modifyDate;

    @Override
    public String toString() {
        return "ProductImage{"+
                "contentType='"+contentType+'\''+
                ", createDate="+createDate+
                ", deleteFlag="+deleteFlag+
                ", fileInfoId="+fileInfoId+
                ", fileName='"+fileName+'\''+
                ", modifyDate="+modifyDate+
                ", productId="+productId+
                ", productImageId="+productImageId+
                ", saveFileName='"+saveFileName+'\''+
                ", type='"+type+'\''+
                '}';
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(Integer fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
