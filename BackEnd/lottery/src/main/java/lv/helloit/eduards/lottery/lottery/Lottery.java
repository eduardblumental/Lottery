package lv.helloit.eduards.lottery.lottery;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Lottery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String lotteryName;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private String status;

    @Column
    private Long numberOfParticipants;

}
