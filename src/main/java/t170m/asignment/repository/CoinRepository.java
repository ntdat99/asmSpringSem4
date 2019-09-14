package t170m.asignment.repository;

import t170m.asignment.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface   CoinRepository extends JpaRepository<Coin, Long> {

    List<Coin> findAllByNameAndStatus(String name, int status);

}
