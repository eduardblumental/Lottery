package lv.helloit.eduards.lottery.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class LotteryService {

    private final LotteryDAO lotteryDAO;

    public LotteryService(LotteryDAO lotteryDAO) {
        this.lotteryDAO = lotteryDAO;
    }

    @PostMapping (value = "/create-new-lottery")
    public Lottery createNewLottery(Lottery lottery) {
        lotteryDAO.save(lottery);
        return lottery;
    }


}
