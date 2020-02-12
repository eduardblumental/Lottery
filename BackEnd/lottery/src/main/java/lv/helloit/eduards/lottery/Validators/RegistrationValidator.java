package lv.helloit.eduards.lottery.Validators;

import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.DAOs.RegistrationDAO;
import lv.helloit.eduards.lottery.DTOs.GetStatusDTO;
import lv.helloit.eduards.lottery.enums.LotteryStatus;
import lv.helloit.eduards.lottery.exceptions.*;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import lv.helloit.eduards.lottery.mainObjects.Registration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class RegistrationValidator {

    private final LotteryDAO lotteryDAO;
    private final RegistrationDAO registrationDAO;
    private final LotteryValidator lotteryValidator;

    public RegistrationValidator(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO, LotteryValidator lotteryValidator) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO;
        this.lotteryValidator = lotteryValidator;
    }

    public void checkIfRegistrationExists (GetStatusDTO getStatusDTO) {
        lotteryValidator.checkIfExists(getStatusDTO.getLotteryId());

        String code = getStatusDTO.getCode();
        Optional<Registration> optionalRegistration = registrationDAO.findByCode(code);
        if (!optionalRegistration.isPresent()){
            throw new RegistrationDoesntExistException("Registration with code " + code + " doesn't exist.");
        }

        Registration registration = optionalRegistration.get();
        if (!getStatusDTO.getEmail().equals(registration.getEmail())) {
            throw new WrongInputException("Given email doesn't match the registration code.");
        }
    }

    public void controlRegistration(Long id) {
        lotteryValidator.checkIfExists(id);
        
        Optional<Lottery> optionalLottery = lotteryDAO.findById(id);
        Lottery lottery = optionalLottery.get();

        if (lotteryValidator.countNumberOfRegistrations(id) >= lottery.getLimit()){
            throw new LimitHasBeenReachedException("Registration limit for lottery id:" + id + " has been reached.");
        }

        if (!lotteryValidator.checkLotteryStatus(id).equals(LotteryStatus.REGISTRATION_OPEN)){
            throw new RegistrationIsStoppedException("Registration for lottery id:" + id + " is stopped");
        }
    }
    
    public void controlAge(Long age){
        Long legalAge = 21l;
        Long ageWhenPeopleDie = 150l;
        if(age < legalAge){
            throw new TooYoungException("You must be 21 years old to participate in the lottery.");
        }
        if(age > ageWhenPeopleDie){
            throw new TooYoungException("Please, provide your true age or go back to your grave:-)");
        }
    }

    public void validateCode(Registration registration){
        Long lotteryId = registration.getLotteryId();
        String code = registration.getCode();
        String email = registration.getEmail();

        Optional<Lottery> optionalLottery = lotteryDAO.findById(lotteryId);
        Lottery lottery = optionalLottery.get();
        LocalDateTime lotteryStartDate = lottery.getStartDate();

        Integer first2Digits = lotteryStartDate.getDayOfMonth();
        Integer second2Digits = lotteryStartDate.getDayOfMonth();


    }
}
