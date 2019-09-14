package com.t1708m.controller;

import com.t1708m.entity.Coid;
import com.t1708m.service.BitcoidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/coid")
public class CoidController {
    @Autowired
    private BitcoidService bitcoidService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listCoid(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<Coid> coidPage = bitcoidService.getListCoid(page, limit);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", HttpStatus.OK.value());
        hashMap.put("message", "Created Success");
        hashMap.put("data", coidPage.getContent());

        HashMap<String, Object> paginationMap = new HashMap<>();
        paginationMap.put("totalPage", coidPage.getTotalPages());
        paginationMap.put("totalItem", coidPage.getTotalElements());
        paginationMap.put("currentPage", coidPage.getPageable().getPageNumber());
        paginationMap.put("limit", coidPage.getPageable().getPageSize());
        hashMap.put("pagination", paginationMap);


        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }



  /*  @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<Page<Coid>> search(@RequestParam String name) {
        Page<Coid> searchCoid = (Page<Coid>) bitcoidService.search(name);
        return new ResponseEntity<>(searchCoid, HttpStatus.OK);
    }*/

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Coid> create(@RequestBody Coid coid) {
        return new ResponseEntity<>(bitcoidService.create(coid), HttpStatus.CREATED);
    }

}
