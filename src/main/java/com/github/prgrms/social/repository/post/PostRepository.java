package com.github.prgrms.social.repository.post;

import com.github.prgrms.social.model.commons.Id;
import com.github.prgrms.social.model.post.Post;
import com.github.prgrms.social.model.user.User;

import java.util.List;

public interface PostRepository {

    Post save(Post post);

    void update(Post post);

    Post findById(Long seq);

    List<Post> findAll(Id<User, Long> userId);

}
