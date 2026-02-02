package com.lederboard.backend.dto.UserRegistration;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDTO {
    private String userName;
    private String email;
    private String password;
}
