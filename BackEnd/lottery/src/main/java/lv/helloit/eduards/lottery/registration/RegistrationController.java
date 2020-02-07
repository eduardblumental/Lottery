package lv.helloit.eduards.lottery.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @PostMapping (value = "/register")
    public String register () {
        LOGGER.info("Registration has been made");
//      todo return
        return null;
    }

    @GetMapping (value = "/status")
    public String getStatus () {
        LOGGER.info("Status requested");
//      todo return
        return null;
    }

}
