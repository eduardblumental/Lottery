package lv.helloit.eduards.lottery.lottery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotteryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @PostMapping(value = "/new-lottery")
    public String newLottery () {
        LOGGER.info("New lottery created");
        //todo return
        return null;
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
