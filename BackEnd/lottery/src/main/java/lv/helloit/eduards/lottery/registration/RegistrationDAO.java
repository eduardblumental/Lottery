package lv.helloit.eduards.lottery.registration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDAO extends CrudRepository<Registration, Long> {
}
