package com.github.prgrms.social.model.post;

import com.github.prgrms.social.model.user.Email;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Writer {

    private final Email email;

    private final String name;

    public Writer(Email email) {
        this(email, null);
    }

    public Writer(Email email, String name) {
        this.email = email;
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("email", email)
                .append("name", name)
                .toString();
    }

}
