package lv.helloit.eduards.lottery.Other;

import lv.helloit.eduards.lottery.mainObjects.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationDAO extends CrudRepository<Registration, Long> {
    List<Registration> findAllByLotteryId(Long lotteryId);
}
