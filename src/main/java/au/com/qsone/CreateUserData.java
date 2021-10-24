package au.com.qsone;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import au.com.qsone.entity.Role;
import au.com.qsone.entity.User;
import au.com.qsone.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class CreateUserData implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        addUsers();
    }

    /**
     * Create users if not exist in DB
     */
    private void addUsers() {
        if (!userService.checkUsersDataExistInDB()) {
            log.info("Save Users");
            userService.saveAll(createUsers());
        } else {
            log.info("Users are available in DB!");
        }
    }

    /**
     * Create User with Roles for testing purpose
     * 
     * @return List
     */
    private List<User> createUsers() {
        final List<User> users = new ArrayList<>();
        users.add(create("client", Collections.singletonList(Role.ROLE_CUSTOMER), "client"));
        users.add(create("office", Collections.singletonList(Role.ROLE_ADMIN), "office"));
        users.add(create("contractor", Collections.singletonList(Role.ROLE_CONTRACTOR), "contractor"));
        users.add(create("manager", Arrays.asList(Role.ROLE_CONTRACTOR, Role.ROLE_MANAGER), "manager"));
        users.add(create("admin", Collections.singletonList(Role.ROLE_ADMIN), "admin2021"));
        return users;
    }

    private User create(final String userName, final List<Role> roles, final String password) {
        return User.builder().userName(userName).password(passwordEncoder.encode(password)).active(true).roles(roles)
                .build();
    }
}
