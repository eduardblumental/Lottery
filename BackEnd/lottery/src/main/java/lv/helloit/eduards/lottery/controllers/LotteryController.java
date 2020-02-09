package lv.helloit.eduards.lottery.controllers;

import lv.helloit.eduards.lottery.mainObjects.Lottery;
import lv.helloit.eduards.lottery.services.LotteryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotteryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @Autowired
    private LotteryService lotteryService;

    @PostMapping(value = "/create-new-lottery")
    public String newLottery (@RequestBody Lottery lottery) {
            LOGGER.info("New lottery created");
            return lotteryService.createNewLottery(lottery);
    }

    @PostMapping(value = "/start-registration")
    public String startRegistration () {
        LOGGER.info("Registration opened");
        return null;
    }

    @PostMapping(value = "/stop-registration")
    public String stopRegistration () {
        LOGGER.info("Registration closed");
        return null;
    }

    @PostMapping(value = "/choose-winner")
    public String chooseWinner () {
        LOGGER.info("Winner chosen");
        return null;
    }

    @GetMapping(value = "/stats")
    public String showStatistics () {
        LOGGER.info("Statistics");
        return null;
    }

}
