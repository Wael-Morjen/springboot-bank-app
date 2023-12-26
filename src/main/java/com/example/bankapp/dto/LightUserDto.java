package com.example.bankapp.dto;

import com.example.bankapp.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LightUserDto {

    private Integer id;

    @NotNull(message = "Firstname must not be empty")
    @NotEmpty(message = "Firstname must not be empty")
    @NotBlank(message = "Firstname must not be empty")
    private String firstname;

    @NotNull(message = "Lastname must not be empty")
    @NotEmpty(message = "Lastname must not be empty")
    @NotBlank(message = "Lastname must not be empty")
    private String lastname;

    public static LightUserDto fromEntity(User user) {
        // null check
        return LightUserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }

    public static User toEntity(LightUserDto user) {
        // null check
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }
}
