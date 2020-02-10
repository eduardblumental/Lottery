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

import java.util.List;

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

//    @PostMapping(value = "/choose-winner")
//    public Lottery chooseWinner (@RequestBody Lottery lottery) {
//        LOGGER.info("Winner chosen");
//        return lotteryService.chooseWinner(lottery);
//    }

    @GetMapping(value = "/stats")
    public List<Lottery> showStatistics () {
        LOGGER.info("Statistics requested");
        return lotteryService.stats();
    }

}
