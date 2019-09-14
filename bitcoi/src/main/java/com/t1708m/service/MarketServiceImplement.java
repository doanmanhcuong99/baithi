package com.t1708m.service;

import com.t1708m.entity.Market;
import com.t1708m.respository.CoidRepository;
import com.t1708m.respository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class MarketServiceImplement implements MarketService {
    @Autowired
    private MarketRepository marketRepository;

    @Override
    public Page<Market> getListMarket(int page, int limit) {
        return marketRepository.findAllByStatus(1, PageRequest.of(page - 1, limit));
    }

    @Override
    public Market createMarket(Market market) {
        market.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
        market.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
        market.setStatus(1);
        return marketRepository.save(market);
    }

    @Override
    public Market updateMarket(long id, Market market) {
        return null;
    }
}
