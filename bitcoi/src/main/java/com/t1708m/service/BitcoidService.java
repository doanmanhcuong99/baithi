package com.t1708m.service;

import com.t1708m.entity.Coid;
import com.t1708m.entity.Market;
import org.springframework.data.domain.Page;

public interface BitcoidService {
    Page<Coid> getListCoid(int page, int limit);

    Coid create(Coid coid);

    Coid update(long id, Coid coid);



}
