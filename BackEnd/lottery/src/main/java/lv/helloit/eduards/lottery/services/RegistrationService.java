package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.DTOs.GetStatusDTO;
import lv.helloit.eduards.lottery.DTOs.NewRegistrationDTO;
import lv.helloit.eduards.lottery.DTOs.RegistrationStatusDTO;
import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.DAOs.RegistrationDAO;
import lv.helloit.eduards.lottery.Validators.RegistrationValidator;
import lv.helloit.eduards.lottery.enums.LotteryStatus;
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
    private final RegistrationValidator registrationValidator;

    public RegistrationService(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO, RegistrationValidator registrationValidator) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO;
        this.registrationValidator = registrationValidator;
    }

    public NewRegistrationDTO register(Registration registration) {


        registrationDAO.save(registration);

        NewRegistrationDTO newRegistrationDTO = new NewRegistrationDTO();
        newRegistrationDTO.setStatus(ResponseStatus.OK);
        newRegistrationDTO.setMessage("Registration successful. Your code is " + registration.getCode() + ".");

        return newRegistrationDTO;
    }

    public RegistrationStatusDTO getStatus(GetStatusDTO getStatusDTO) {
        registrationValidator.checkIfRegistrationExists(getStatusDTO);

        Long lotteryId = getStatusDTO.getLotteryId();
        Optional<Lottery> optionalLottery = lotteryDAO.findById(lotteryId);
        Lottery lottery = optionalLottery.get();

        RegistrationStatusDTO registrationStatusDTO = new RegistrationStatusDTO();

        if (lottery.getStatus() != LotteryStatus.WINNER_CHOSEN) {
            registrationStatusDTO.setMessage("Winner for lottery with id:" + lottery.getId() + " hasn't been chosen yet!");
            registrationStatusDTO.setStatus(RegistrationStatus.PENDING);
            return registrationStatusDTO;
        }   else if (lottery.getWinner().equals(getStatusDTO.getCode())) {
            registrationStatusDTO.setMessage("Congrats! Your code " + getStatusDTO.getCode() + " won!");
            registrationStatusDTO.setStatus(RegistrationStatus.WIN);
            return registrationStatusDTO;
        }   else {
            registrationStatusDTO.setMessage("Sorry! Your code " + getStatusDTO.getCode() + " lost!");
            registrationStatusDTO.setStatus(RegistrationStatus.LOOSE);
            return registrationStatusDTO;
        }

    }
}
