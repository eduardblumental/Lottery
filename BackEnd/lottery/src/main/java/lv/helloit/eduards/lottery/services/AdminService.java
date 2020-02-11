package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.DAOs.AdminDAO;
import lv.helloit.eduards.lottery.mainObjects.Admin;
import org.springframework.stereotype.Component;

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
