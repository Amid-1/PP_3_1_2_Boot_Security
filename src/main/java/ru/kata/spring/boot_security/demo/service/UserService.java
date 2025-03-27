package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    void saveUser(UserDto userDto);
    void deleteUser(Long id);
    UserDto getUserById(Long id);
}
