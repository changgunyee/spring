package kr.or.connect.mavenweb.dto.comment;

import java.util.Date;

public class CommentImage {
    Integer imageId;
    Integer reservationInfoId;
    Integer reservationUserCommentId;
    Integer fileId;
    String fileName;
    String saveFileName;
    String contentType;
    Boolean deleteFlag;
    Date createDate;
    String modifyDate;

    @Override
    public String toString() {
        return "CommentImage{"+
                "contentType='"+contentType+'\''+
                ", createDate="+createDate+
                ", deleteFlag="+deleteFlag+
                ", fileId="+fileId+
                ", fileName='"+fileName+'\''+
                ", imageId="+imageId+
                ", modifyDate='"+modifyDate+'\''+
                ", reservationInfoId="+reservationInfoId+
                ", reservationUserCommentId="+reservationUserCommentId+
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

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public Integer getReservationUserCommentId() {
        return reservationUserCommentId;
    }

    public void setReservationUserCommentId(Integer reservationUserCommentId) {
        this.reservationUserCommentId = reservationUserCommentId;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }
}
