package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.Other.LotteryDAO;
import lv.helloit.eduards.lottery.Other.LotteryStatus;
import lv.helloit.eduards.lottery.Other.RegistrationDAO;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import lv.helloit.eduards.lottery.mainObjects.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class LotteryService {

    private final Logger LOGGER = LoggerFactory.getLogger(LotteryService.class);

    private final LotteryDAO lotteryDAO;
    private final RegistrationDAO registrationDAO;

    public LotteryService(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO, RegistrationDAO registrationDAO1) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO1;
    }

    public Lottery createNewLottery(Lottery lottery) {
        lottery.setStatus(LotteryStatus.REGISTRATION_OPEN);
        lottery.setStartDate(LocalDateTime.now());
        lotteryDAO.save(lottery);
        return lottery;
    }

    public Lottery endRegistration(Lottery l) {
        Optional<Lottery> optionalLottery = lotteryDAO.findById(l.getId());
        Lottery lottery = optionalLottery.get();
        lottery.setEndDate(LocalDateTime.now());
        lottery.setStatus(LotteryStatus.REGISTRATION_CLOSED);
        lotteryDAO.save(lottery);
        return lottery;
    }

    public List<Lottery> stats() {
        List<Lottery> list = new ArrayList<>();

        for (Lottery lottery : lotteryDAO.findAll()){
            list.add(lottery);
        }

        return list;
    }

    public Lottery chooseWinner(Lottery lottery) {
        Long lotteryId = lottery.getId();

        List<Registration> list = registrationDAO.findAllByLotteryId(lotteryId);

        Random random = new Random();
        Registration winner = list.get(random.nextInt(list.size()));

        lottery.setWinner(winner.getCode());
        return lottery;
    }

}
