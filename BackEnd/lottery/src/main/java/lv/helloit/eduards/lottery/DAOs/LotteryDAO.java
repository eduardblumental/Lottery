package lv.helloit.eduards.lottery.DAOs;

import lv.helloit.eduards.lottery.mainObjects.Lottery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryDAO extends CrudRepository<Lottery, Long> {

}
