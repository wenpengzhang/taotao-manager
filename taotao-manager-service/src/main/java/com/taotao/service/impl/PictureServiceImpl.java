package com.taotao.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;

/**
 * 图片上传服务
 * 
 * @author Vincent
 *
 */
@Service
public class PictureServiceImpl implements PictureService {
	/**
	 * ftp地址
	 */
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	/**
	 * ftp端口号
	 */
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	/**
	 * ftp用户名
	 */
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	/**
	 * ftp密码
	 */
	@Value("${FTP_PASSWORD}")
	private String PASSWORD;
	/**
	 * ftp文件存放根路径
	 */
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	/**
	 * 图片服务器的基础路径
	 */
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		try {
			// 生成一个新的文件名
			// 获取原始文件名
			String oldname = uploadFile.getOriginalFilename();
			// 生成新的文件名
			// UUID.randomUUID();
			String newname = IDUtils.genImageName();
			newname = newname + oldname.substring(oldname.lastIndexOf("."));
			// 图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, PASSWORD, FTP_BASE_PATH, imagePath,
					newname, uploadFile.getInputStream());
			if (!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("message", "文件上传成功");
			resultMap.put("url", IMAGE_BASE_URL + imagePath + "/" + newname);
			return resultMap;

		} catch (IOException e) {
			e.printStackTrace();
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}

	}

}
