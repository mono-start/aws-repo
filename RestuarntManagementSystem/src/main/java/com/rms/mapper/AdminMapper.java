package com.rms.mapper;

import com.rms.domain.User;
import com.rms.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

 UserDto toUserDto(User user);
 List<UserDto> toUserDtos(List<User> users);
 User toUser(UserDto userDto);
 List<User> toUsers(List<UserDto> userDtos);

}
