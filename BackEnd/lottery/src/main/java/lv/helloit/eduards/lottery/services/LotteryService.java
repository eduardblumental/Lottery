package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.DTOs.ChooseWinnerDTO;
import lv.helloit.eduards.lottery.DTOs.LotteryActionDTO;
import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.enums.LotteryStatus;
import lv.helloit.eduards.lottery.DAOs.RegistrationDAO;
import lv.helloit.eduards.lottery.enums.ResponseStatus;
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

    public LotteryService(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO;
    }

    public LotteryActionDTO createNewLottery(Lottery lottery) {
        lottery.setStatus(LotteryStatus.REGISTRATION_OPEN);
        lottery.setStartDate(LocalDateTime.now());
        lotteryDAO.save(lottery);

        LotteryActionDTO lotteryActionDTO = new LotteryActionDTO();
        lotteryActionDTO.setId(lottery.getId());
        lotteryActionDTO.setStatus(ResponseStatus.OK);

        return lotteryActionDTO;
    }

    public LotteryActionDTO endRegistration(Lottery l) {
        Optional<Lottery> optionalLottery = lotteryDAO.findById(l.getId());
        Lottery lottery = optionalLottery.get();
        lottery.setEndDate(LocalDateTime.now());
        lottery.setStatus(LotteryStatus.REGISTRATION_CLOSED);
        lotteryDAO.save(lottery);

        LotteryActionDTO lotteryActionDTO = new LotteryActionDTO();
        lotteryActionDTO.setId(lottery.getId());
        lotteryActionDTO.setStatus(ResponseStatus.OK);

        return lotteryActionDTO;
    }

    public List<Lottery> stats() {
        List<Lottery> list = new ArrayList<>();

        for (Lottery lottery : lotteryDAO.findAll()){
            list.add(lottery);
        }

        return list;
    }

    public ChooseWinnerDTO chooseWinner(Lottery l) {
        Long lotteryId = l.getId();
        Optional<Lottery> optionalLottery = lotteryDAO.findById(lotteryId);
        Lottery lottery = optionalLottery.get();
        List<Registration> list = registrationDAO.findAllByLotteryId(lotteryId);

        Random random = new Random();
        Registration winner = list.get(random.nextInt(list.size()));

        lottery.setWinner(winner.getCode());
        lottery.setStatus(LotteryStatus.WINNER_CHOSEN);
        lotteryDAO.save(lottery);

        ChooseWinnerDTO chooseWinnerDTO = new ChooseWinnerDTO();
        chooseWinnerDTO.setStatus(ResponseStatus.OK);
        chooseWinnerDTO.setWinnerCode(lottery.getWinner());

        return chooseWinnerDTO;
    }

}
