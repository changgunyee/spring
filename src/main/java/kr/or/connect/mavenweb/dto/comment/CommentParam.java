package kr.or.connect.mavenweb.dto.comment;

public class CommentParam {
    Float score;
    String comment;
    String createDate;
    String modifyDate;
    private Integer id;
    private Integer productId;
    private Integer reservationInfoId;

    public CommentParam() {
    }

    public CommentParam(Integer id, Integer productId, Integer reservationInfoId, Float score, String comment, String createDate, String modifyDate) {
        this.id = id;
        this.productId = productId;
        this.reservationInfoId = reservationInfoId;
        this.score = score;
        this.comment = comment;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
