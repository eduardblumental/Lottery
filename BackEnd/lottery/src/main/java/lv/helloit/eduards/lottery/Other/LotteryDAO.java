package lv.helloit.eduards.lottery.Other;

import lv.helloit.eduards.lottery.mainObjects.Lottery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LotteryDAO extends CrudRepository<Lottery, Long> {

}
