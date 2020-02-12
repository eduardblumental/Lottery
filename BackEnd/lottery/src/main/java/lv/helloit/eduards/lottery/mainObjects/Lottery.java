package lv.helloit.eduards.lottery.mainObjects;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.helloit.eduards.lottery.enums.LotteryStatus;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Lottery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4)
    @Column(unique=true)
    private String title;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private LotteryStatus status;

    @NotNull
    @DecimalMin(value = "2", inclusive = true)
    @Digits(integer = 4, fraction = 0)
    @Column(name = "\"limit\"")
    private Long limit;

    @Column
    private String winner;

}

