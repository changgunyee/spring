package kr.or.connect.mavenweb.dto.comment;

import java.util.Date;
import java.util.List;

public class Comment {
    private Integer commentId;
    private Integer productId;
    private Float score;
    private String comment;
    private Date createDate;
    private Date modifyDate;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
    private String reservationEmail;
    private Date reservationDate;
    private List<CommentImage> commentImages;

    public Comment() {
    }

    public Comment(Integer commentId, Integer productId, Float score, String comment, Date createDate, Date modifyDate, Integer reservationInfoId, String reservationName, String reservationTelephone, String reservationEmail, Date reservationDate, List<CommentImage> commentImages) {
        this.commentId = commentId;
        this.productId = productId;
        this.score = score;
        this.comment = comment;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.reservationInfoId = reservationInfoId;
        this.reservationName = reservationName;
        this.reservationTelephone = reservationTelephone;
        this.reservationEmail = reservationEmail;
        this.reservationDate = reservationDate;
        this.commentImages = commentImages;
    }

    @Override
    public String toString() {
        return "Comment{"+
                "commentId="+commentId+
                ", productId="+productId+
                ", score="+score+
                ", comment='"+comment+'\''+
                ", createDate="+createDate+
                ", modifyDate="+modifyDate+
                ", reservationInfoId="+reservationInfoId+
                ", reservationName='"+reservationName+'\''+
                ", reservationTelephone='"+reservationTelephone+'\''+
                ", reservationEmail='"+reservationEmail+'\''+
                ", reservationDate="+reservationDate+
                ", commentImages="+commentImages+
                '}';
    }

    public List<CommentImage> getCommentImages() {
        return commentImages;
    }

    public void setCommentImages(List<CommentImage> commentImages) {
        this.commentImages = commentImages;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTelephone() {
        return reservationTelephone;
    }

    public void setReservationTelephone(String reservationTelephone) {
        this.reservationTelephone = reservationTelephone;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
