package com.example.travel.service.impl;

import com.example.travel.dao.ConsumerMapper;
import com.example.travel.domain.Consumer;
import com.example.travel.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer)>0;
    }

    @Override
    public boolean update(Consumer consumer) {
        return consumerMapper.update(consumer)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return consumerMapper.delete(id)>0;
    }

    @Override
    public Consumer selectByPrimaryKey(Integer id) {
        return consumerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Consumer> allConsumer() {
        return consumerMapper.allConsumer();
    }

    @Override
    public boolean verifyPassword(String username, String password) {

        return consumerMapper.verifyPassword(username,password)>0;
    }

    @Override
    public Consumer getByUsername(String username) {
        return consumerMapper.getByUsername(username);
    }


}
