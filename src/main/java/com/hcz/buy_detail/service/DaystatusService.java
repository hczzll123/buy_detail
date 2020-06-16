package com.hcz.buy_detail.service;

import com.hcz.buy_detail.entity.Daystatus;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hechangzheng
 * @since 2020-06-10
 */
public interface DaystatusService extends IService<Daystatus> {

    List<Daystatus> selectAll();

    void updateStatus(Daystatus daystatus);
}
