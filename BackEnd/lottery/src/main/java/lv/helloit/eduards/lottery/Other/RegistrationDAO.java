package lv.helloit.eduards.lottery.Other;

import lv.helloit.eduards.lottery.mainObjects.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDAO extends CrudRepository<Registration, Long> {
}
