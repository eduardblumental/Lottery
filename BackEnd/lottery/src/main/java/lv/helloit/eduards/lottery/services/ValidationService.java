package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.DAOs.RegistrationDAO;
import lv.helloit.eduards.lottery.enums.LotteryStatus;
import lv.helloit.eduards.lottery.exceptions.LotteryDoesntExistException;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
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

    public boolean checkLotteryName(String title) {
        return lotteryDAO.existsByTitle(title);
    }


    public LotteryStatus checkLotteryStatus(Long id) {
        if (!lotteryDAO.existsById(id)) {
            throw new LotteryDoesntExistException("Lottery with id:" + id + " does not exist");
        }

        Optional<Lottery> optionalLottery = lotteryDAO.findById(id);
        Lottery lottery = optionalLottery.get();

        return lottery.getStatus();
    }
}