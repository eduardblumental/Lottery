package lv.helloit.eduards.lottery.DAOs;

import lv.helloit.eduards.lottery.mainObjects.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationDAO extends CrudRepository<Registration, Long> {
    List<Registration> findAllByLotteryId(Long lotteryId);
    Long countAllByLotteryId(Long lotteryId);
    Optional<Registration> findByCode(String code);
    boolean  existsByCode(String code);
}
