package lv.helloit.eduards.lottery.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassLotteryIdDTO {

    @NotNull
    private Long id;
}
