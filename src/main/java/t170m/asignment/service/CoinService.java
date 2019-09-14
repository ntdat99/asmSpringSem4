package t170m.asignment.service;

import t170m.asignment.entity.Coin;
import t170m.asignment.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CoinService {
    @Autowired
    CoinRepository coinRepository;

    public List<Coin> getList() {
        return coinRepository.findAll();
    }


    public List<Coin> getByName(String name){
        return coinRepository.findAllByNameAndStatus(name, 1);
    }

    public Coin createCoin(Coin coin) {
        coin.setId(Calendar.getInstance().getTimeInMillis());
        coin.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setStatus(1);
        return coinRepository.save(coin);
    }




}
