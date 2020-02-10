package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.Other.LotteryDAO;
import lv.helloit.eduards.lottery.Other.RegistrationDAO;
import lv.helloit.eduards.lottery.Other.RegistrationStatus;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import lv.helloit.eduards.lottery.mainObjects.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegistrationService {

    private final Logger LOGGER = LoggerFactory.getLogger(LotteryService.class);

    private final LotteryDAO lotteryDAO;
    private final RegistrationDAO registrationDAO;

    public RegistrationService(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO;
    }

    public Registration register(Registration registration) {
        registrationDAO.save(registration);
        return registration;
    }

    public RegistrationStatus getStatus(Registration registration) {
        Long lotteryId = registration.getLotteryId();
        Optional<Lottery> optionalLottery = lotteryDAO.findById(lotteryId);
        Lottery lottery = optionalLottery.get();
        LOGGER.info(lottery.getWinner() + " " + registration.getCode());

        if (lottery.getWinner() == registration.getCode()) {
            return RegistrationStatus.WIN;
        }   else {
            return RegistrationStatus.LOOSE;
        }

    }
}
