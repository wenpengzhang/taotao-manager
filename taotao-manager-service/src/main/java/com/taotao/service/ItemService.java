package com.taotao.service;

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
}
