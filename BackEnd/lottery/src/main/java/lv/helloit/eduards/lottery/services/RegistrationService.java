package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.DTOs.NewRegistrationDTO;
import lv.helloit.eduards.lottery.DTOs.RegistrationStatusDTO;
import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.DAOs.RegistrationDAO;
import lv.helloit.eduards.lottery.enums.RegistrationStatus;
import lv.helloit.eduards.lottery.enums.ResponseStatus;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import lv.helloit.eduards.lottery.mainObjects.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegistrationService {

    private final Logger LOGGER = LoggerFactory.getLogger(LotteryService.class);

    private final LotteryDAO lotteryDAO;
    private final RegistrationDAO registrationDAO;

    public RegistrationService(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO;
    }

    public NewRegistrationDTO register(Registration registration) {
        registrationDAO.save(registration);

        NewRegistrationDTO newRegistrationDTO = new NewRegistrationDTO();
        newRegistrationDTO.setStatus(ResponseStatus.OK);
        newRegistrationDTO.setMessage("Registration successful. Your code: " + registration.getCode());

        return newRegistrationDTO;
    }

    public RegistrationStatusDTO getStatus(Registration registration) {
        Long lotteryId = registration.getLotteryId();
        Optional<Lottery> optionalLottery = lotteryDAO.findById(lotteryId);
        Lottery lottery = optionalLottery.get();

        RegistrationStatusDTO registrationStatusDTO = new RegistrationStatusDTO();

        if (lottery.getWinner() == registration.getCode()) {
            registrationStatusDTO.setMessage("Congrats! Your code " + registration.getCode() + " won!");
            registrationStatusDTO.setStatus(RegistrationStatus.WIN);
            return registrationStatusDTO;
        }   else {
            registrationStatusDTO.setMessage("Sorry! Your code " + registration.getCode() + " lost!");
            registrationStatusDTO.setStatus(RegistrationStatus.LOOSE);
            return registrationStatusDTO;
        }

    }
}
