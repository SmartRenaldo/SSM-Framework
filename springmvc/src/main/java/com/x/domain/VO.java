package com.x.domain;

import java.util.List;

/**
 * @author Gavin
 */
public class VO {
    private List<User> users;

    public VO(List<User> users) {
        this.users = users;
    }

    public VO() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "VO{" +
                "users=" + users +
                '}';
    }
}
