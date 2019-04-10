package com.project.rest.webservice.Project.controller;



import java.util.List;
import java.util.Optional;

//import java.util.HashSet;
//import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.rest.webservice.Project.message.JwtResponse;
import com.project.rest.webservice.Project.message.LoginForm;
import com.project.rest.webservice.Project.message.SignUpForm;
//import com.project.rest.webservice.Project.model.Role;
//import com.project.rest.webservice.Project.model.RoleName;
//import com.project.rest.webservice.Project.model.RoleRepository;
import com.project.rest.webservice.Project.model.User;
import com.project.rest.webservice.Project.model.UserRepository;
import com.project.rest.webservice.Project.security.JwtProvider;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
	

		@Autowired
		AuthenticationManager authenticationManager;
		
		@Autowired
		UserRepository userRepository;
				
		@Autowired
		PasswordEncoder encoder;
		
		@Autowired
		JwtProvider jwtProvider;
		
		@PostMapping("/signin")
		public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest){
		
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequest.getUsername(),
							loginRequest.getPassword()
							)
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			String jwt = jwtProvider.generateJwtToken(authentication);
			return ResponseEntity.ok(new JwtResponse(jwt));
		
		}
		
		@PostMapping("/signup")
		public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest){
			
			if(userRepository.existsByUsername(signUpRequest.getUsername())) {
				return new ResponseEntity<String>("Fail -> Username is already taken", HttpStatus.BAD_REQUEST);
			}
			
			if(userRepository.existsByEmail(signUpRequest.getEmail())) {
				return new ResponseEntity<String>("Fail -> Email is already taken", HttpStatus.BAD_REQUEST);
			}
			
			User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
			
			userRepository.save(user);
			
			return ResponseEntity.ok().body("You have fully registered!");
		}
		@GetMapping("/details/{userID}")
		public User getDetails(@PathVariable (value = "userID") Long userID){
			Optional<User> user = userRepository.findById(userID);
			return user.get();
		}
		@PutMapping("updateUserDetails/{userID}")
		public User updateDetails(@PathVariable (value = "userID") Long userID, @Valid @RequestBody SignUpForm signUpRequest) {
			Optional <User> user = userRepository.findById(userID);
				user.get().setName(signUpRequest.getName());
				user.get().setEmail(signUpRequest.getEmail());
				user.get().getPassword();
				user.get().setUsername(signUpRequest.getUsername());
			userRepository.save(user.get());
			return user.get();
		}
		@PutMapping("updateUserPassword/{userID}")
		public User updatePassword(@PathVariable (value = "userID") Long userID, @Valid @RequestBody SignUpForm signUpRequest) {
			Optional <User> user = userRepository.findById(userID);
			user.get().getName();
			user.get().getUsername();
			user.get().getEmail();
			user.get().setPassword(encoder.encode(signUpRequest.getPassword()));
			userRepository.save(user.get());
			return user.get();
		}
	
		
}	
		
