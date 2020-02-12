package lv.helloit.eduards.lottery.controllers;

import lv.helloit.eduards.lottery.DTOs.GetStatusDTO;
import lv.helloit.eduards.lottery.DTOs.NewRegistrationDTO;
import lv.helloit.eduards.lottery.DTOs.RegistrationStatusDTO;
import lv.helloit.eduards.lottery.exceptions.WrongInputException;
import lv.helloit.eduards.lottery.mainObjects.Registration;
import lv.helloit.eduards.lottery.services.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;

    @PostMapping (value = "/register")
    public NewRegistrationDTO newRegistration(@RequestBody @Valid Registration registration, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new WrongInputException("Wrong Input. Please enter a lottery id, a valid email, your age and a 16-digit code.");
        }
        LOGGER.info("Code " + registration.getCode() + " registered (lottery id: " + registration.getLotteryId() + ")");
        return registrationService.register(registration);
    }

    @GetMapping (value = "/status")
    public RegistrationStatusDTO getStatus (@RequestBody @Valid GetStatusDTO getStatusDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new WrongInputException("Wrong Input. Please enter a lottery id, your email and a 16-digit code.");
        }
        LOGGER.info("Code " + getStatusDTO.getCode() + " requested status (lottery id: " + getStatusDTO.getLotteryId() + ")");
        return registrationService.getStatus(getStatusDTO);
    }

}
