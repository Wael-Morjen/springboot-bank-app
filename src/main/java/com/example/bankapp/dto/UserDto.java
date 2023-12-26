package com.example.bankapp.dto;

import com.example.bankapp.models.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;

    @NotNull(message = "Firstname must not be empty")
    @NotEmpty(message = "Firstname must not be empty")
    @NotBlank(message = "Firstname must not be empty")
    private String firstname;

    @NotNull(message = "Lastname must not be empty")
    @NotEmpty(message = "Lastname must not be empty")
    @NotBlank(message = "Lastname must not be empty")
    private String lastname;

    @NotNull(message = "Email must not be empty")
    @NotEmpty(message = "Email must not be empty")
    @NotBlank(message = "Email must not be empty")
    @Email(message = "The email is not compliant")
    private String email;

    @NotNull(message = "Password must not be empty")
    @NotEmpty(message = "Password must not be empty")
    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, max = 16, message = "Password must contains 8 to 16 characters")
    private String password;

    private String iban;

    private boolean active;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .iban(user.getAccount() == null ? "" : user.getAccount().getIban())
                .active(user.isActive())
                .build();
    }

    public static User toEntity(UserDto user) {
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
