package lv.helloit.eduards.lottery.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.helloit.eduards.lottery.Other.LotteryStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LotteryDTO {

    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LotteryStatus lotteryStatus;
    private Long numberOfParticipants;

}