package lv.helloit.eduards.lottery.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Registration {

    @Id
    private Long id;

    @Column
    private String email;

    @Column
    private Integer age;

    @Column
    private Long code;

}
