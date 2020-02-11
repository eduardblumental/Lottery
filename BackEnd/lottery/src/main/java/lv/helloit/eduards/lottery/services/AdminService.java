package lv.helloit.eduards.lottery.services;

import lv.helloit.eduards.lottery.DAOs.AdminDAO;
import lv.helloit.eduards.lottery.DTOs.AdminDTO;
import lv.helloit.eduards.lottery.enums.ResponseStatus;
import lv.helloit.eduards.lottery.mainObjects.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

    private final AdminDAO adminDao;

    public AdminService(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

    public AdminDTO createNewAdmin (Admin admin) {
        adminDao.save(admin);

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setStatus(ResponseStatus.OK);
        adminDTO.setMessage("New admin with a login " + admin.getLogin() + " created");

        return adminDTO;
    }
}
