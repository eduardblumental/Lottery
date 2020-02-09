package lv.helloit.eduards.lottery.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationDTO {

    private Long id;
    private Long lotteryId;
    private String email;
    private Integer age;
    private Long code;

}
