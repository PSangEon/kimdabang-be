package com.kimdabang.kdbserver.user.user.presentation;

import com.kimdabang.kdbserver.user.user.dto.UserSignUpDto;
import com.kimdabang.kdbserver.user.user.vo.UserResponseVo;
import com.kimdabang.kdbserver.user.user.application.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UserResponseVo> getUserById(@PathVariable Long id) {
        UserSignUpDto getUser = userService.getUserById(id);
        log.info("getUser : {}", getUser);
        UserResponseVo userResponseVo = getUser.toResponseVo();
        return ResponseEntity.ok(userResponseVo);
    }
}
