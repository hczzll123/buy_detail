package com.hcz.buy_detail.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcz.buy_detail.entity.Buydetails;
import com.hcz.buy_detail.mapper.BuydetailsMapper;
import com.hcz.buy_detail.service.BuydetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hechangzheng
 * @since 2020-06-10
 */
@Service
public class BuydetailsServiceImpl extends ServiceImpl<BuydetailsMapper, Buydetails> implements BuydetailsService {

    @Override
    public void deleteOldData(String dayname) {


        QueryWrapper<Buydetails> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("trade_day",dayname);

        baseMapper.delete(queryWrapper);


    }

    @Override
    public List<Buydetails> getAllData() {

        List<Buydetails> list = baseMapper.selectList(null);

        return list;
    }

    @Override
    public List<Buydetails> selectByDayname(String name) {
        QueryWrapper<Buydetails> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("trade_day",name);


        List<Buydetails> buydetails = baseMapper.selectList(queryWrapper);


        return buydetails;
    }

    @Override
    public List<Buydetails> selectByNameAndKeyword(String name, String keyword) {

        QueryWrapper<Buydetails> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("trade_day",name);

        queryWrapper.like("cart_acct",keyword);

        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public void romoveById(Integer id) {

        baseMapper.deleteById(id);


    }
}
