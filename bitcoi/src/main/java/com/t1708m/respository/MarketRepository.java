package com.t1708m.respository;

import com.t1708m.entity.Market;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends  JpaRepository<Market,Long> {
    Page<Market> findAllByStatus (int status, Pageable pageable);
}
