package com.odoo.combat.api.v1.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odoo.combat.config.auth.jwt.JwtHelper;
import com.odoo.combat.entities.Users;
import com.odoo.combat.services.UserService;
import com.odoo.combat.services.impl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/v1/auth")
public class ApiAuthController {

	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final JwtHelper jwtHelper;
	private final UserService userService;

	public ApiAuthController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService,
			JwtHelper jwtHelper, UserService userService) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtHelper = jwtHelper;
		this.userService = userService;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.username());

		String token = jwtHelper.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponse(token, jwtHelper.getExpirationDateFromToken(token)));
	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> registerUser(@RequestBody SignUpRequest signUpRequest) {

		userService.createUser(
				Users.builder().email(signUpRequest.username()).password(signUpRequest.password()).build());

		UserDetails userDetails = userDetailsService.loadUserByUsername(signUpRequest.username());

		String token = jwtHelper.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponse(token, jwtHelper.getExpirationDateFromToken(token)));
	}

	@GetMapping("/login")
	public ResponseEntity<String> authenticateUser() {
		return new ResponseEntity<>("Login Using Get Request Is Not Supported", HttpStatus.METHOD_NOT_ALLOWED);
	}

}