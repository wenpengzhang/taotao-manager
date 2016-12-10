package com.taotao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传接口
 * 
 * @author Vincent
 *
 */
public interface PictureService {
	/**
	 * 上传图片
	 * 
	 * @param uploadFile
	 *            文件
	 * @return
	 * @throws Exception
	 */
	Map uploadPicture(MultipartFile uploadFile);

}
