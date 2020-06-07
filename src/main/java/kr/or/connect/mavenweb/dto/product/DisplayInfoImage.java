package kr.or.connect.mavenweb.dto.product;

import java.util.Date;

public class DisplayInfoImage {
    private Integer displayInfoImageId;
    private Integer displayInfoId;
    private Integer fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private Boolean deleteFlag;
    private Date createDate;
    private Date modifyDate;

    @Override
    public String toString() {
        return "DisplayInfoImage{"+
                " contentType='"+contentType+'\''+
                ", createDate="+createDate+
                ", deleteFlag="+deleteFlag+
                ", displayInfoId="+displayInfoId+
                ", displayInfoImageId="+displayInfoImageId+
                ", fileId="+fileId+
                ", fileName='"+fileName+'\''+
                ", modifyDate="+modifyDate+
                ", saveFileName='"+saveFileName+'\''+
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

    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public Integer getDisplayInfoImageId() {
        return displayInfoImageId;
    }

    public void setDisplayInfoImageId(Integer displayInfoImageId) {
        this.displayInfoImageId = displayInfoImageId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }
}
