package com.rms.service;

import com.rms.domain.User;
import com.rms.mapper.AdminMapper;
import com.rms.model.UserDto;
import com.rms.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {


    private final UserRepository userRepository;

    private final AdminMapper adminMapper;

    public UserDto authenticate(UserDto userDto) {
        if (ObjectUtils.isEmpty(userDto)) return null;
        User byUsernameAndPassword = userRepository.findByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
        if (ObjectUtils.isEmpty(byUsernameAndPassword)) return null;
        return adminMapper.toUserDto(byUsernameAndPassword);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return adminMapper.toUserDtos(users);
    }

    public UserDto createUser(UserDto userDto) {
        if (ObjectUtils.isEmpty(userDto)) return null;
        User user = adminMapper.toUser(userDto);
        userRepository.save(user);
        return adminMapper.toUserDto(user);
    }

}
