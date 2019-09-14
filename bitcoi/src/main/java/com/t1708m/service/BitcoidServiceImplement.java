package com.t1708m.service;

import com.t1708m.entity.Coid;
import com.t1708m.entity.Market;
import com.t1708m.respository.CoidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class BitcoidServiceImplement implements BitcoidService {
    @Autowired
    private CoidRepository coidRepository;


    @Override
    public Page<Coid> getListCoid(int page, int limit) {
        return coidRepository.findAllByStatus(1, PageRequest.of(page - 1, limit));
    }

    @Override
    public Coid create(Coid coid) {
        coid.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
        coid.setUpdateAtMLS(Calendar.getInstance().getTimeInMillis());
        coid.setStatus(1);
        return coidRepository.save(coid);
    }

    @Override
    public Coid update(long id, Coid coid) {
        return null;
    }


}
