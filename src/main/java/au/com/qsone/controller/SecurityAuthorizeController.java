package au.com.qsone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import au.com.qsone.dto.UserDto;
import au.com.qsone.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/qsoneapp")
public class SecurityAuthorizeController {

    @Autowired
    UserService userService;

    /**
     * Method to test for User having no roles i.e accessible to all
     * 
     * @return
     */
    @GetMapping("/anonymous")
    @ResponseStatus(HttpStatus.OK)
    public String accessToAllUsers() {
        log.info("Accessible to all users.");
        return "Welcome anonymous User";
    }

    /**
     * Method to test for CUSTOMER ROLE.
     * 
     * @return
     */
    @GetMapping("/client")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('CUSTOMER')")
    public String testUserRoleAccess() {
        log.info("Accessible to CUSTOMER Role.");
        return "Welcome User (CUSTOMER)!";
    }

    /**
     * Method to test for Users who have ADMIN Role only.
     * 
     * @return
     */
    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public String testAdminRoleAccess() {
        log.info("Accessible to ADMIN Role.");
        return "Welcome ADMIN User!";
    }

    /**
     * Method to test for Users who have SUPERVISOR Role only.
     * 
     * @return
     */
    @GetMapping("/supervisor")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('SUPERVISOR')")
    public String testSupervisorsRoleAccess() {
        log.info("Accessible to SUPERVISOR Role.");
        return "Welcome SUPERVISOR User!";
    }

    /**
     * Method to test for Users who have both ADMIN AND SUPERVISOR Role.
     * 
     * @return
     */
    @GetMapping("/admin-supervisor")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('SUPERVISOR') AND hasRole('ADMIN')")
    public String testSupervisorAndAdminRoleAccess() {
        log.info("Accessible to ADMIN OR SUPERVISOR Role.");
        return "Welcome User (ADMIN OR SUPERVISOR)!";
    }

    /**
     * ADMIN Role can get all users.
     * 
     * @return
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAllUser() {
        log.info("fetching users");
        return userService.getUsers();
    }
}
