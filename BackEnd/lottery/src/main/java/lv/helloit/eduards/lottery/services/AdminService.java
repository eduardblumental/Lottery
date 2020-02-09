package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.Other.AdminDAO;
import lv.helloit.eduards.lottery.mainObjects.Admin;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AdminService {

    private final AdminDAO adminDao;

    public AdminService(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

    public Admin createNewAdmin (Admin admin) {
        adminDao.save(admin);
        return admin;
    }
}
