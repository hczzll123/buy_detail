package com.hcz.buy_detail.service;

import com.hcz.buy_detail.entity.Buydetails;
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
public interface BuydetailsService extends IService<Buydetails> {

    void deleteOldData(String dayname);

    List<Buydetails> getAllData();

    List<Buydetails> selectByDayname(String name);

    List<Buydetails> selectByNameAndKeyword(String name, String keyword);

    void romoveById(Integer id);
}
