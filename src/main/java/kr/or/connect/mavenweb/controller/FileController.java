package kr.or.connect.mavenweb.controller;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/static")
public class FileController {
    @GetMapping("/**")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Content-Type", "img/png");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
		String t=StorageUrl.PATH+request.getRequestURI().replace("/static/", "");
        
        try (
                FileInputStream fis = new FileInputStream(t);
                OutputStream out = response.getOutputStream();
        ) {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }
    }
}
