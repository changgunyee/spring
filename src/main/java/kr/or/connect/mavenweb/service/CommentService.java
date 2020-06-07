package kr.or.connect.mavenweb.service;

import kr.or.connect.mavenweb.dto.FileInfo;

import java.util.Map;

public interface CommentService {

    public Map<String, Object> getComments(Integer displayInfoId);

    public Map<String, Object> getCommentResponse(Integer displayInfoId);

    public Boolean addComment(String fileName, String saveFileName, String contentType, String createDate, Float score, Integer productId, Integer reservationInfoId, String commentText);

    public FileInfo getCommentImageFileInfo(int reservationCommentImageId);

}
