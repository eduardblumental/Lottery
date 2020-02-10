package lv.helloit.eduards.lottery.controllers;

import lv.helloit.eduards.lottery.Other.RegistrationStatus;
import lv.helloit.eduards.lottery.mainObjects.Registration;
import lv.helloit.eduards.lottery.services.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;

    @PostMapping (value = "/register")
    public Registration newRegistration(@RequestBody Registration registration) {
        LOGGER.info("Registration has been made");
        return registrationService.register(registration);
    }

    @GetMapping (value = "/status")
    public RegistrationStatus getStatus (@RequestBody Registration registration) {
        LOGGER.info("Status requested");
        return registrationService.getStatus(registration);
    }

}
