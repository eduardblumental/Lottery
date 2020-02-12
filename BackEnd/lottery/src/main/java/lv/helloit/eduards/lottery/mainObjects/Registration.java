package lv.helloit.eduards.lottery.mainObjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    @Column
    private Long lotteryId;

    @NotEmpty
    @Email
    @Column
    private String email;

    @NotNull
    @Digits(integer = 3, fraction = 0)
    @DecimalMin(value = "1", inclusive = true)
    @DecimalMax(value = "150", inclusive = true)
    @Column
    private Integer age;

    @NotNull
    @Digits(integer = 16, fraction = 0)
    @Column(unique = true)
    private Long code;

}
