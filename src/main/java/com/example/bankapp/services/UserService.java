package com.example.bankapp.services;

import com.example.bankapp.dto.AuthenticationRequest;
import com.example.bankapp.dto.AuthenticationResponse;
import com.example.bankapp.dto.LightUserDto;
import com.example.bankapp.dto.UserDto;

public interface UserService extends AbstractService<UserDto> {

    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);

    AuthenticationResponse register(UserDto dto);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    Integer update(LightUserDto userDto);
}
