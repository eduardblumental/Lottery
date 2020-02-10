package lv.helloit.eduards.lottery.controllers;

import lv.helloit.eduards.lottery.mainObjects.Lottery;
import lv.helloit.eduards.lottery.services.LotteryService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LotteryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @Autowired
    private LotteryService lotteryService;

    @PostMapping(value = "/start-registration")
    public Lottery startRegistration (@RequestBody Lottery lottery) {
        lotteryService.createNewLottery(lottery);
        LOGGER.info("Registration started");
        return lotteryService.createNewLottery(lottery);
    }

    @PostMapping(value = "/stop-registration")
    public Lottery stopRegistration (@RequestBody Lottery lottery) {
        LOGGER.info("Registration closed");
        return lotteryService.endRegistration(lottery);
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
