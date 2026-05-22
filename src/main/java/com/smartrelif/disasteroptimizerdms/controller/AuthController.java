package com.smartrelif.disasteroptimizerdms.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.smartrelif.disasteroptimizerdms.repository.LoginHistoryRepository;
import com.smartrelif.disasteroptimizerdms.model.LoginHistory;


import com.smartrelif.disasteroptimizerdms.model.User;
import com.smartrelif.disasteroptimizerdms.repository.UserRepository;
import com.smartrelif.disasteroptimizerdms.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	@PostMapping("/login")
	public Map<String, String> login(
	        @RequestBody User user,
	        HttpServletRequest request) {

	    User dbUser = userRepository.findByEmail(user.getEmail())
	            .orElseThrow(() -> new RuntimeException("User Not Found"));

	    if (!encoder.matches(user.getPassword(), dbUser.getPassword())) {
	        throw new RuntimeException("Invalid Credentials");
	    }

	    // Save Login History
	    LoginHistory history = new LoginHistory();
	    history.setEmail(dbUser.getEmail());
	    history.setLoginTime(LocalDateTime.now());
	    history.setIpAddress(request.getRemoteAddr());

	    loginHistoryRepository.save(history);

	    String token = JwtUtil.generateToken(user.getEmail());

	    Map<String, String> response = new HashMap<>();
	    response.put("token", token);

	    return response;
	}


    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);

        return "User Registered Successfully";
    }

   
    @GetMapping("/me")
    public User getCurrentUser(@RequestHeader("Authorization") String token) {

        token = token.replace("Bearer ", "");

        String email = JwtUtil.extractEmail(token);

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}

