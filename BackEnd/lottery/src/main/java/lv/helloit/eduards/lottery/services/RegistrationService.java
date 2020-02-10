package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.Other.LotteryDAO;
import lv.helloit.eduards.lottery.Other.RegistrationDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {

    private final Logger LOGGER = LoggerFactory.getLogger(LotteryService.class);

    private final LotteryDAO lotteryDAO;
    private final RegistrationDAO registrationDAO;

    public RegistrationService(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO, RegistrationDAO registrationDAO1) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO1;
    }
}
