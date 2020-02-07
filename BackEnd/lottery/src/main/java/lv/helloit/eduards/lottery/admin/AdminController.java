package lv.helloit.eduards.lottery.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @GetMapping(value = "/login")
    public String adminLogin() {
        LOGGER.info("Someone logged in as Admin");
        return "admin-user";
    }

}
