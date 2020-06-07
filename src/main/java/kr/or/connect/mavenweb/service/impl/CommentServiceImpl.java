package kr.or.connect.mavenweb.service.impl;

import kr.or.connect.mavenweb.dao.CommentDao;
import kr.or.connect.mavenweb.dao.ProductDao;
import kr.or.connect.mavenweb.dto.FileInfo;
import kr.or.connect.mavenweb.dto.comment.Comment;
import kr.or.connect.mavenweb.dto.comment.CommentImage;
import kr.or.connect.mavenweb.dto.comment.CommentImageParam;
import kr.or.connect.mavenweb.dto.comment.CommentParam;
import kr.or.connect.mavenweb.dto.product.DisplayInfo;
import kr.or.connect.mavenweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public Map<String, Object> getComments(Integer displayInfoId) {
        List<Comment> comments = commentDao.selectComments(displayInfoId);
        float totalScore = 0;
        float averageScore = 0;
        int scoreCount = 0;

        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            comment.setReservationEmail(switchReservationEmail(comment.getReservationEmail()));

            if (comment.getScore() != null) {
                totalScore += comment.getScore();
                scoreCount++;
            }
            List<CommentImage> commentImages = commentDao.selectCommentImages(comment.getCommentId());
            comment.setCommentImages(commentImages);
        }

        if (comments.size() != 0) {
            averageScore = totalScore / scoreCount;
        }

        Map<String, Object> commentsMap = new HashMap<>();
        commentsMap.put("comments", comments);
        commentsMap.put("averageScore", averageScore);
        return commentsMap;
    }


    @Override
    public Map<String, Object> getCommentResponse(Integer displayInfoId) {
        DisplayInfo displayInfo = productDao.selectDisplayInfo(displayInfoId);
        Map<String, Object> comments = getComments(displayInfoId);

        Map<String, Object> detailComments = new HashMap<>();
        for (String k : comments.keySet()) {
            detailComments.put(k, comments.get(k));
        }
        detailComments.put("displayInfo", displayInfo);
        return detailComments;
    }

    @Override
    @Transactional
    public Boolean addComment(String fileName, String saveFileName, String contentType, String createDate, Float score, Integer productId, Integer reservationInfoId, String commentText) {
        if (fileName == null) {
            commentDao.insertReservationComment(new CommentParam(null, productId, reservationInfoId, score, commentText, createDate, createDate));
            return true;
        }
        Integer fileInfoId = commentDao.insertFileInfo(new FileInfo(null, fileName, saveFileName, contentType, 0, createDate, createDate));
        Integer reservationUserCommentId = commentDao.insertReservationComment(new CommentParam(null, productId, reservationInfoId, score, commentText, createDate, createDate));
        commentDao.insertReservationCommentImage(new CommentImageParam(null, reservationInfoId, reservationUserCommentId, fileInfoId));
        return true;
    }

    private String switchReservationEmail(String email) {
        if (email.length() > 3) {
            return email.substring(0, 4)+"****";
        }
        return "********";
    }

    @Override
    public FileInfo getCommentImageFileInfo(int reservationCommentImageId) {
        return commentDao.selectCommentImageFileInfo(reservationCommentImageId);
    }
}
