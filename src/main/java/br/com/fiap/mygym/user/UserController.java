package br.com.fiap.mygym.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.mygym.user.dto.UserProfileResponse;
import br.com.fiap.mygym.user.dto.UserRequest;
import br.com.fiap.mygym.user.dto.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<User> findbyName(@RequestParam String name) {
        return service.findByName(name);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        var user = service.create(userRequest.toModel());

        var uri = uriBuilder.path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(UserResponse.from(user));
    }

    @GetMapping("/profile")
    public UserProfileResponse getUserProfile() {
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return service.getUserProfile(email);
    }

}
