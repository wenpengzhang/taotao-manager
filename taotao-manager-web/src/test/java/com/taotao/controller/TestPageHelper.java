package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

	private ApplicationContext applicationContext;

	@Test
	public void testPageHelper() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		// 从Spring容器中获取Mapper的代理对象，
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		// 执行查询,并关闭
		TbItemExample itemExample = new TbItemExample();
		// 分页处理
		PageHelper.startPage(1, 10);
		List<TbItem> list = itemMapper.selectByExample(itemExample);
		// 获取商品列表
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		// 获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品信息：" + total);

	}

}
