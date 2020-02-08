package lv.helloit.eduards.lottery.admin;

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
