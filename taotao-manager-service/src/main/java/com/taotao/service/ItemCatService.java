package com.taotao.service;

import java.util.List;

import com.taotao.pojo.TbItemCat;

public interface ItemCatService {
	/**
	 * 根据父节点查询目录
	 * 
	 * @param parentId
	 * @return
	 */
	List<TbItemCat> getItemCatList(long parentId);

}
