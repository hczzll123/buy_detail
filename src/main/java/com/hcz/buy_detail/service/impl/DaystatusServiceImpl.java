package com.hcz.buy_detail.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcz.buy_detail.entity.Daystatus;
import com.hcz.buy_detail.mapper.DaystatusMapper;
import com.hcz.buy_detail.service.DaystatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hechangzheng
 * @since 2020-06-10
 */
@Service
public class DaystatusServiceImpl extends ServiceImpl<DaystatusMapper, Daystatus> implements DaystatusService {


    @Autowired
    DaystatusMapper daystatusMapper;

    @Override
    public List<Daystatus> selectAll() {

        List<Daystatus> daystatuses = baseMapper.selectList(null);

        return daystatuses;

    }

    @Override
    public void updateStatus(Daystatus daystatus) {

        QueryWrapper<Daystatus> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("date", daystatus.getDate());


        List<Daystatus> daystatuses = baseMapper.selectList(queryWrapper);

        //为空则直接插入
        if (null == daystatuses || daystatuses.size() == 0) {

            baseMapper.insert(daystatus);
        }

        daystatus.setStatus("重解析");

        daystatusMapper.update(daystatus, queryWrapper);


    }
}
