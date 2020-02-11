package lv.helloit.eduards.lottery.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.helloit.eduards.lottery.enums.ResponseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private ResponseStatus status;
    private String message;
}






