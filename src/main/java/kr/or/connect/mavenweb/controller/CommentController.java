package kr.or.connect.mavenweb.controller;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import kr.or.connect.mavenweb.dto.*;
import kr.or.connect.mavenweb.service.*;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(path = "/comment")
    public String renderCommentPage(@RequestParam(name = "id") int displayInfoId, ModelMap modelMap) {
        modelMap.putAll(commentService.getCommentResponse(displayInfoId));
        return "comment";
    }

    @GetMapping(path = "/commentWrite")
    public String renderCommentWritePage(
            @RequestParam(name = "productId") int productId,
            @RequestParam(name = "reservationInfoId") int reservationInfoId,
            @RequestParam(name = "description") String description,
            ModelMap modelMap) {
        modelMap.put("productId", productId);
        modelMap.put("reservationInfoId", reservationInfoId);
        modelMap.put("description", description);
        return "commentWrite";
    }

    @PostMapping("/commentWrite")
    public String addComment(
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam(name = "score") Float score,
            @RequestParam(name = "comment") String comment,
            @RequestParam(name = "productId") Integer productId,
            @RequestParam(name = "reservationInfoId") Integer reservationInfoId) {
        String uuid = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        String createDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString();
        if (file.getSize() == 0) {
            commentService.addComment(null, null, null, createDate, score, productId, reservationInfoId, comment);
            return "redirect:/myreservation";
        }

        String path = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
        String saveFileName = path+"/"+uuid;
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File oldFile = new File(StorageUrl.PATH+saveFileName);
        while (oldFile.exists()) {
            uuid = UUID.randomUUID().toString();
            saveFileName = path+"/"+uuid;
            oldFile = new File(StorageUrl.PATH+saveFileName);
        }

        try {
            FileOutputStream fos = new FileOutputStream(StorageUrl.PATH+saveFileName);
            InputStream is = file.getInputStream();

            writeWithStream(is, fos);
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }

        commentService.addComment(uuid, saveFileName, file.getContentType(), createDate, score, productId, reservationInfoId, comment);
        return "redirect:/myreservation";
    }

    @GetMapping("/comment-image/{id}")
    public void getCommentImage(@PathVariable(name = "id") int commentImageId, HttpServletRequest request, HttpServletResponse response) {
        FileInfo fileInfo = commentService.getCommentImageFileInfo(commentImageId);

        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", fileInfo.getContentType());
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        try {
            FileInputStream fis = new FileInputStream(StorageUrl.PATH+fileInfo.getSaveFileName());
            OutputStream out = response.getOutputStream();

            writeWithStream(fis, out);
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }
    }

    private void writeWithStream(InputStream inputStream, OutputStream outputStream) {
        try {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readCount);
            }
        } catch (Exception e) {
            throw new RuntimeException("file Save Error");
        }
    }
}
