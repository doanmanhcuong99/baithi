package com.t1708m.service;

import com.t1708m.entity.Coid;
import com.t1708m.entity.Market;
import org.springframework.data.domain.Page;

public interface MarketService {

    Page<Market> getListMarket(int page, int limit);

    Market createMarket(Market market);

    Market updateMarket(long id, Market market);

}
