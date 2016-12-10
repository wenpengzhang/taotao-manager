package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/***
 * 商品管理controller
 * 
 * @author Vincent
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	// 根据id查询商品信息
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem geTbItemById(@PathVariable long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	// 分页查询商品信息
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult euDataGridResult = itemService.getItemList(page, rows);
		return euDataGridResult;
	}
}
