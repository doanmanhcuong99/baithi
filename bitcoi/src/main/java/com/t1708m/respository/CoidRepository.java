package com.t1708m.respository;

import com.t1708m.entity.Coid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoidRepository extends JpaRepository<Coid, Long> {
    Page<Coid> findAllByStatus (int status, Pageable pageable);


}
