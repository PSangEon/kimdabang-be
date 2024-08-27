package com.kimdabang.kdbserver.user.user.application;

import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.user.dto.UserSignUpDto;
import com.kimdabang.kdbserver.user.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void signUp(UserSignUpDto userSignUpDto) {
        log.info("userSignUpDto : {}", userSignUpDto);
        User user = userSignUpDto.toEntity();
        log.info("user : {}", user);
        userRepository.save(user);
//        todo : memberSignUpDto를 Member로 변환하여 저장
    }

    @Override
    public UserSignUpDto getUserById(Long id) {

        log.info("id : {}", id);
        User getUser = userRepository.findById(id).orElseThrow();
        log.info("getUserr : {}", getUser);
        UserSignUpDto userSignUpDto = UserSignUpDto.builder()
                .id(getUser.getId())
                .UUID(getUser.getUUID())
                .loginId(getUser.getLoginId())
                .password(getUser.getPassword())
                .name(getUser.getName())
                .email(getUser.getEmail())
                .phone(getUser.getPhone())
                .gender(getUser.getGender())
                .solar(getUser.getSolar())
                .birth(getUser.getBirth())
                .nickname(getUser.getNickname())
                .grade(getUser.getGrade())
                .profileImg(getUser.getProfileImg())
                .build();
        log.info("userSignUpDto : {}", userSignUpDto);
        return userSignUpDto;
    }

    @Override
    public UserSignUpDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("해당 이메일을 가진 회원이 없습니다.")
        );
        if (user != null) {
            UserSignUpDto userSignUpDto = UserSignUpDto.builder()
                    .id(user.getId())
                    .UUID(user.getUUID())
                    .loginId(user.getLoginId())
                    .password(user.getPassword())
                    .name(user.getName())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .gender(user.getGender())
                    .solar(user.getSolar())
                    .birth(user.getBirth())
                    .nickname(user.getNickname())
                    .grade(user.getGrade())
                    .profileImg(user.getProfileImg())
                    .build();
            return userSignUpDto;
        }
        return null;
    }
}