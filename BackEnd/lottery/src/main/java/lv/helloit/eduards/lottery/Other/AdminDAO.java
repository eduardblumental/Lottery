package lv.helloit.eduards.lottery.Other;

import lv.helloit.eduards.lottery.mainObjects.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends CrudRepository<Admin, Long> {



}
