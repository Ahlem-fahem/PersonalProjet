package com.example.worldtour.config;

import com.example.worldtour.dto.UserDto;
import com.example.worldtour.entity.User;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
    public UserDto convertToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> convertToDto(List<User> users) {
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public User convertToEntity(UserDto UserDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(UserDto, User.class);
    }

    public List<User> convertToEntity(List<UserDto> usersDTO) {
        return usersDTO.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
