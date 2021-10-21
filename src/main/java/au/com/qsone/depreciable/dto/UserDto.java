package au.com.qsone.depreciable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import au.com.qsone.depreciable.entity.Role;

@Data
@AllArgsConstructor
public class UserDto {

    int id;
    String userName;
    boolean isActive;
    List<Role> roles;
}
