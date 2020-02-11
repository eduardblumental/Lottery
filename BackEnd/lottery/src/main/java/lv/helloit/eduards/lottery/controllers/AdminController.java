package lv.helloit.eduards.lottery.controllers;


import lv.helloit.eduards.lottery.DTOs.AdminDTO;
import lv.helloit.eduards.lottery.enums.ResponseStatus;
import lv.helloit.eduards.lottery.services.AdminService;
import lv.helloit.eduards.lottery.mainObjects.Admin;
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
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/create-new-admin")
    public AdminDTO admin (@RequestBody @Valid Admin admin, BindingResult bindingResult) {
        LOGGER.info("New Admin created");
        return adminService.createNewAdmin(admin);
    }

    @GetMapping(value = "/login")
    public AdminDTO adminLogin() {
        LOGGER.info("Someone logged in as Admin");

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setStatus(ResponseStatus.OK);
        adminDTO.setMessage("Welcome on board sir!");

        return adminDTO;
    }

}
