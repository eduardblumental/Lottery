package lv.helloit.eduards.lottery.admin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/create-new-admin")
    public Admin admin (@RequestBody Admin admin) {
        LOGGER.info("New Admin created");
        return adminService.createNewAdmin(admin);
    }

    @GetMapping(value = "/login")
    public String adminLogin() {
        LOGGER.info("Someone logged in as Admin");
        return "admin-user";
    }

}
