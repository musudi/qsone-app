package au.com.qsone.depreciable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import au.com.qsone.depreciable.entity.CustomUserDetails;
import au.com.qsone.depreciable.entity.User;
import au.com.qsone.depreciable.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Load User by userName
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUserName(userName);
        return optionalUser.map(CustomUserDetails::new).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User = %s does not exists", userName)));
    }
}
