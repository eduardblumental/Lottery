package lv.helloit.eduards.lottery.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lv.helloit.eduards.lottery.Other.LotteryDAO;
import lv.helloit.eduards.lottery.Other.LotteryStatus;
import lv.helloit.eduards.lottery.Other.ResponseStatus;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import org.json.JSONException;
import org.json.JSONObject;
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

    public String createNewLottery(Lottery lottery) {
        lottery.setStatus(LotteryStatus.REGISTRATION_OPEN);
        lottery.setStartDate(LocalDateTime.now());

        JSONObject response = new JSONObject();

        try {
            if(lotteryDAO.save(lottery) != null) {
                //Saved
                response.put("status", ResponseStatus.OK);
                response.put("id", lottery.getId());
            } else {
                //Not saved

            }
        } catch (IllegalArgumentException | JSONException err) {
            //Not saved
        }

        return response.toString();
    }

}
