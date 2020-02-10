package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.Other.LotteryDAO;
import lv.helloit.eduards.lottery.Other.LotteryStatus;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class LotteryService {

    private final Logger LOGGER = LoggerFactory.getLogger(LotteryService.class);

    private final LotteryDAO lotteryDAO;

    public LotteryService(LotteryDAO lotteryDAO) {
        this.lotteryDAO = lotteryDAO;
    }

    public Lottery createNewLottery(Lottery lottery) {
        lottery.setStatus(LotteryStatus.REGISTRATION_OPEN);
        lottery.setStartDate(LocalDateTime.now());
        lotteryDAO.save(lottery);
        return lottery;
    }

    public Lottery endRegistration(Lottery lottery) {
        Optional<Lottery> optionalLottery = lotteryDAO.findById(lottery.getId());
        Lottery lot = optionalLottery.get();
        lot.setStatus(LotteryStatus.REGISTRATION_CLOSED);
        lotteryDAO.save(lot);
        return lot;
    }

}
