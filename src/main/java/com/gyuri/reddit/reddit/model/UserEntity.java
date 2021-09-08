package com.gyuri.reddit.reddit.model;

import hu.gerviba.authsch2springbootstarter.struct.AuthschUser;

import java.util.UUID;

public class UserEntity implements AuthschUser {


    @Override
    public Long getId() {
        return null;
    }

    @Override
    public UUID getInternalId() {
        return null;
    }
}
