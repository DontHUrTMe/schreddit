package com.gyuri.reddit.reddit.config;

import com.gyuri.reddit.reddit.model.UserEntity;
import com.gyuri.reddit.reddit.model.UserService;
import hu.gerviba.authsch2springbootstarter.struct.AuthschLoginLogicSupplier;
import hu.gerviba.authsch2springbootstarter.struct.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginSupplierBeanConfig {
    @Autowired
    private UserService users;

    @Bean
    public AuthschLoginLogicSupplier authschLogicConfig() {
        return new AuthschLoginLogicSupplier()
                // Your custom user entity class
                .setUserClass(UserEntity.class)

                // Requested scopes
                .setRequestScopes(Scope.BASIC, Scope.DISPLAY_NAME, Scope.SURNAME,
                        Scope.GIVEN_NAME, Scope.EMAIL, Scope.LINKED_ACCOUNTS,
                        Scope.EDU_PERSON_ENTILEMENT, Scope.MOBILE,
                        Scope.COURSES, Scope.ENTRANTS, Scope.ACTIVE_DIRECTORY_MEMBERSHIP,
                        Scope.BME_UNIT_SCOPE, Scope.PERMANENT_ADDRESS)

                // Methods to load, create and authorize user
                .setResolver(users::getUserById)
                .setCreateUser(users::createUser)
                .setLoadUser(users::loadUser)
                .setUserExists(users::isUserExists)
                .setResolveRoles(users::resolveRoles);
    }
}
