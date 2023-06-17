package com.study.sidejavachallenge.domain.member.controller;

/*
import com.study.sidejavachallenge.domain.member.dto.request.JwtReissueRequestDto;
import com.study.sidejavachallenge.domain.member.dto.request.LoginDto;
import com.study.sidejavachallenge.domain.member.dto.request.SignUpDto;
import com.study.sidejavachallenge.domain.member.dto.response.JwtAuthResponseDto;
import com.study.sidejavachallenge.domain.member.repository.UserRepository;
import com.study.sidejavachallenge.domain.member.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

//@Api(value = "auth controller exposes signin, signup rest-apis")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; PasswordEncoderUtils passwordEncoderUtils;
    private final JwtUtil jwtUtil;
    private final JwtService jwtService;

    //@ApiOperation(value = "signin to app: 로그인")
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findByName(loginDto.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("User not found with username or email : " + loginDto.getUsernameOrEmail()));

        // get accessToken from jwtTokenProvider
        String accessToken = jwtUtil.generateToken(authentication);
        String refreshToken = UUID.randomUUID().toString();

        // insert accessToken, refreshToken to db
        jwtService.createJwt(accessToken, refreshToken, user);

//        return new ResponseEntity<>("User signed in successfully!", HttpStatus.OK);
        return ResponseEntity.ok(new JwtAuthResponseDto(accessToken, refreshToken, user));
    }

    @PostMapping("/refresh")
    //@ApiOperation(value = "Reissue JWT Access Token & Refresh Token")
    public ResponseEntity<?> refreshToken(@RequestBody JwtReissueRequestDto requestDto) {

        return jwtService.findByDto(requestDto)
                .map(Token::getUser)
                .map(user -> {
                    // get accessToken from jwtTokenProvider
                    String accessToken = jwtUtil.generateToken(user);
                    String refreshToken = UUID.randomUUID().toString();

                    // insert accessToken, refreshToken to db and delete old refreshToken
                    jwtService.createJwt(accessToken, refreshToken, user);
                    jwtService.deleteByRefreshToken(requestDto.getRefreshToken());

                    return ResponseEntity.ok(new JwtAuthResponseDto(accessToken, refreshToken, user));
                })
                .orElseThrow(() -> new RuntimeException("User not found with username or email"));
    }

    //@ApiOperation(value = "signup to app: 회원가입")
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
        if (userRepository.existsByName(signUpDto.getName())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        // create user object
        // test role : admin
        User user = User.builder()
                .username(signUpDto.getName())
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .role(User.RoleType.ADMIN)
                .build();

        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}

 */
