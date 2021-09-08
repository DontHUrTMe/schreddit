package com.gyuri.reddit.reddit.model;

import hu.gerviba.authsch2springbootstarter.struct.AuthschUser;
import hu.gerviba.authsch2springbootstarter.struct.ProfileDataResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    public Object getUserById(Long aLong) {
        return null;
    }

    public AuthschUser createUser(ProfileDataResponse profileDataResponse) {
        return null;
    }

    public AuthschUser loadUser(ProfileDataResponse profileDataResponse) {
        return null;
    }

    public boolean isUserExists(ProfileDataResponse profileDataResponse) {
        return false;
    }

    public List<String> resolveRoles(ProfileDataResponse profileDataResponse, AuthschUser authschUser) {
        return null;
    }
}
