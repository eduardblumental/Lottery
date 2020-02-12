package lv.helloit.eduards.lottery.controllers;

import lv.helloit.eduards.lottery.DTOs.ChooseWinnerDTO;
import lv.helloit.eduards.lottery.DTOs.LotteryActionDTO;
import lv.helloit.eduards.lottery.exceptions.WrongInputException;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import lv.helloit.eduards.lottery.services.LotteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LotteryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @Autowired
    private LotteryService lotteryService;

    @PostMapping(value = "/start-registration")
    public LotteryActionDTO startRegistration (@RequestBody @Valid Lottery lottery, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new WrongInputException("Wrong input. Lottery name has to be at least 4 characters long and limit has to be between 2 and 9999.");
        }
        LOGGER.info("Registration for " + lottery.getTitle() +" has started");
        return lotteryService.createNewLottery(lottery);
    }

    @PostMapping(value = "/stop-registration")
    public LotteryActionDTO stopRegistration (@RequestBody Lottery lottery) {

        LOGGER.info("Registration stopped (lottery id: " + lottery.getId() +")");
        return lotteryService.endRegistration(lottery);
    }

    @PostMapping(value = "/choose-winner")
    public ChooseWinnerDTO chooseWinner (@RequestBody Lottery lottery) {

        LOGGER.info("Winner chosen (lottery id: " + lottery.getId() +")");
        return lotteryService.chooseWinner(lottery);
    }

    @GetMapping(value = "/stats")
    public List<Lottery> showStatistics () {
        LOGGER.info("Statistics requested");
        return lotteryService.stats();
    }

}
