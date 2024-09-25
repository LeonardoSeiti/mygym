package br.com.fiap.mygym.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.mygym.user.dto.UserProfileResponse;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public User create(User user){
        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );
        return repository.save(user);
    }
    public UserProfileResponse getUserProfile(String email){
        return repository.findByEmail(email)
        .map(UserProfileResponse::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));	
    }
}