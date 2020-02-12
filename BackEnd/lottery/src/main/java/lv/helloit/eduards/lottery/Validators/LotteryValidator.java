package lv.helloit.eduards.lottery.Validators;

import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.DAOs.RegistrationDAO;
import lv.helloit.eduards.lottery.enums.LotteryStatus;
import lv.helloit.eduards.lottery.exceptions.CantChooseWinnerException;
import lv.helloit.eduards.lottery.exceptions.CantStopRegistrationException;
import lv.helloit.eduards.lottery.exceptions.LotteryAlreadyExistsException;
import lv.helloit.eduards.lottery.exceptions.LotteryDoesntExistException;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LotteryValidator {

    private final LotteryDAO lotteryDAO;
    private final RegistrationDAO registrationDAO;

    public LotteryValidator(LotteryDAO lotteryDAO, RegistrationDAO registrationDAO) {
        this.lotteryDAO = lotteryDAO;
        this.registrationDAO = registrationDAO;
    }


    public LotteryStatus checkLotteryStatus(Long id) {
        checkIfExists(id);

        Optional<Lottery> optionalLottery = lotteryDAO.findById(id);
        Lottery lottery = optionalLottery.get();

        return lottery.getStatus();
    }

    public Long countNumberOfRegistrations (Long id) {
        return registrationDAO.countAllByLotteryId(id);
    }

    public void checkIfExists (Long id) {
        if (!lotteryDAO.existsById(id)) {
            throw new LotteryDoesntExistException("Lottery with id: " + id + " does not exist.");
        }
    }

    public void validateCreateNewLottery(Lottery lottery) {
        if (lotteryDAO.existsByTitle(lottery.getTitle())) {
            throw new LotteryAlreadyExistsException("Lottery with this name already exists.");
        }
    }

    public void validateStopRegistration(Long id) {
        checkIfExists(id);

        Optional<Lottery> optionalLottery = lotteryDAO.findById(id);
        Lottery lottery = optionalLottery.get();

        if (checkLotteryStatus(id) != LotteryStatus.REGISTRATION_OPEN) {
            throw new CantStopRegistrationException("Cannot stop registration when lottery status is " + lottery.getStatus()+ ".");
        }
    }

    public void validateChooseWinner(Long id) {
        checkIfExists(id);

        Optional<Lottery> optionalLottery = lotteryDAO.findById(id);
        Lottery lottery = optionalLottery.get();

        if (countNumberOfRegistrations(id) == 0) {
            throw new CantChooseWinnerException("Cannot choose winner. No one has registered for the lottery yet.");
        }

        if (checkLotteryStatus(id) != LotteryStatus.REGISTRATION_CLOSED) {
            throw new CantChooseWinnerException("Cannot choose winner when lottery status is " + lottery.getStatus() + ".");
        }

    }


}