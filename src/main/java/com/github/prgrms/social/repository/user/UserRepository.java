package com.github.prgrms.social.repository.user;

import com.github.prgrms.social.model.commons.Id;
import com.github.prgrms.social.model.user.ConnectedUser;
import com.github.prgrms.social.model.user.Email;
import com.github.prgrms.social.model.user.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    void update(User user);

    User findById(Long seq);

    User findByEmail(Email email);

    List<ConnectedUser> findAllConnectedUser(Long seq);

    List<Id<User, Long>> findConnectedIds(Long seq);

}
