package kr.or.connect.mavenweb.controller.api;

import kr.or.connect.mavenweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/comment")
public class CommentApiController {
    @Autowired
    private CommentService commentService;


}
