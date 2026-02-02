package com.lederboard.backend.dto.UserRegistration;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
    private UUID id;
    private String userName;
    private String email;
}
