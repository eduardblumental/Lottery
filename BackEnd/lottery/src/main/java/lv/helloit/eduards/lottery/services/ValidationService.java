package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.DAOs.RegistrationDAO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidationService {

    private final LotteryDAO lotteryDAO;
    private final RegistrationDAO registrationDAO;

    public ValidationService(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO;
    }

    public boolean checkLotteryName (String title) {
        return lotteryDAO.existsByTitle(title);
    }
}
