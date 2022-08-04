package com.example.travel.service.impl;

import com.example.travel.dao.TraderMapper;
import com.example.travel.domain.Trader;
import com.example.travel.service.TraderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TraderServiceImpl implements  TraderService{

    @Autowired
    private TraderMapper traderMapper;

    @Override
    public boolean insert(Trader trader) {
        return traderMapper.insert(trader)>0;
    }

    @Override
    public boolean update(Trader trader) {
        return traderMapper.update(trader)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return traderMapper.delete(id)>0;
    }

    @Override
    public Trader selectByPrimaryKey(Integer id) {
        return traderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Trader> allTrader() {
        return traderMapper.allTrader();
    }

    @Override
    public List<Trader> traderOfName(String name) {
        return traderMapper.traderOfName(name);
    }
}
