package com.t1708m.controller;

import com.t1708m.entity.Coid;
import com.t1708m.entity.Market;
import com.t1708m.service.BitcoidService;
import com.t1708m.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/market")
public class MarketController {
    @Autowired
    private MarketService marketService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listMarket(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<Market> marketPage = marketService.getListMarket(page, limit);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", HttpStatus.OK.value());
        hashMap.put("message", "Created Success");
        hashMap.put("data", marketPage.getContent());

        HashMap<String, Object> paginationMap = new HashMap<>();
        paginationMap.put("totalPage", marketPage.getTotalPages());
        paginationMap.put("totalItem", marketPage.getTotalElements());
        paginationMap.put("currentPage", marketPage.getPageable().getPageNumber());
        paginationMap.put("limit", marketPage.getPageable().getPageSize());
        hashMap.put("pagination", paginationMap);


        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Market> create(@RequestBody Market market) {
        return new ResponseEntity<>(marketService.createMarket(market), HttpStatus.CREATED);
    }
}
