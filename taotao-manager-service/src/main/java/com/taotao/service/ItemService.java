package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	/**
	 * 根据商品id查询商品详情
	 * 
	 * @param itemId
	 *            商品的id
	 * @return
	 */
	TbItem getItemById(long itemId);

	/**
	 * 分页查询商品列表
	 * 
	 * @param page
	 *            当前页码
	 * @param rows
	 *            每页条数
	 * @return
	 */
	EUDataGridResult getItemList(int page, int rows);
}
