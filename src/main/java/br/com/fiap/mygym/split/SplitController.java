package br.com.fiap.mygym.split;

import br.com.fiap.mygym.split.dto.SplitRequest;
import br.com.fiap.mygym.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/split")
public class SplitController {
    private final SplitService splitService;
    private final UserRepository userRepository;

    public SplitController(SplitService splitService, UserRepository userRepository){
        this.splitService = splitService;
        this.userRepository = userRepository;
    }
    @GetMapping
    public Page<Split>findAll(@PageableDefault(size = 5)Pageable pageable){
        return splitService.findAll(pageable);
    }
    @PostMapping
    public Split create(@RequestBody SplitRequest splitRequest){
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        var user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        System.out.println(user);
        Split split = splitRequest.toModel(user);
        return splitService.create(split);
    }

}
