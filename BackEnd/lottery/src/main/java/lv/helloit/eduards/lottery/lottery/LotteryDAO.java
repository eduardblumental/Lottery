package lv.helloit.eduards.lottery.lottery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryDAO extends CrudRepository<Lottery, Long> {

}
