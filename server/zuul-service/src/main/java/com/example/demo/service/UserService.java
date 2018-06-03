package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserDto;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username);

        if (user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'", username));
        return user;
    }

    public Boolean hasProtectedAccess() {
        return SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ADMIN"));
    }

    public UserDto.Refer findByUsername(String username) {
        User user = userRepository.findByEmail(username);
        UserDto.Refer refer = new UserDto.Refer();
        refer.setId(user.getId());
        refer.setName(user.getName());
        refer.setEmail(user.getEmail());
        return refer;
    }
}
