package lv.helloit.eduards.lottery.lottery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LotteryController {

    public static final Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @PostMapping
    public String newLottery () {
        LOGGER.info("New lottery created");
        //todo return
        return null;
    }

    @PostMapping
    public String startRegistration () {
        LOGGER.info("Registration opened");
        return null;
    }

    @PostMapping
    public String stopRegistration () {
        LOGGER.info("Registration closed");
        return null;
    }

    @PostMapping
    public String chooseWinner () {
        LOGGER.info("Winner chosen");
        return null;
    }

    @GetMapping
    public String showStatistics () {
        LOGGER.info("Statistics");
        return null;
    }

}
