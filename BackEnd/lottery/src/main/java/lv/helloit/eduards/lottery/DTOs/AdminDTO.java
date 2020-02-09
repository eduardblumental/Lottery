package lv.helloit.eduards.lottery.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDTO {

    private Long id;
    private String login;
    private String password;

}
