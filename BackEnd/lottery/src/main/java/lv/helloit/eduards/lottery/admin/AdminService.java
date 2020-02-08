package lv.helloit.eduards.lottery.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin createNewAdmin (Admin admin) {
        adminDao.save(admin);
        return admin;
    }
}
