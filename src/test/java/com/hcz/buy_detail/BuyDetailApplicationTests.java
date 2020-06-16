package com.hcz.buy_detail;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcz.buy_detail.entity.Buydetails;
import com.hcz.buy_detail.service.BuydetailsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BuyDetailApplicationTests {

	@Autowired
	BuydetailsService buydetailsService;

	@Test
	public void testPoiExcel() {





	}


	@Test
	public void testpage() {

		Page<Buydetails> buydetailsPage = new Page<>(1,3);

		QueryWrapper<Buydetails> queryWrapper = new QueryWrapper<>();

		queryWrapper.eq("trade_day","2020-06-08");

		IPage<Buydetails> page = buydetailsService.page(buydetailsPage, queryWrapper);

		List<Buydetails> records = page.getRecords();

		System.out.println(records);


	}

}
