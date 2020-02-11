package lv.helloit.eduards.lottery.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.helloit.eduards.lottery.enums.RegistrationStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationStatusDTO {
    private RegistrationStatus status;
    private String message;
}
