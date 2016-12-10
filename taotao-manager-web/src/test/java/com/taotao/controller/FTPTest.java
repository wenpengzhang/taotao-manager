package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {
	@Test
	public void testFtpClient() throws IOException, URISyntaxException {
		// 创建FtpClient对象
		FTPClient ftpClient = new FTPClient();
		// 创建ftp连接
		ftpClient.connect("192.168.1.179", 21);
		// 登录ftp服务器,使用用户名密码
		ftpClient.login("ftpuser", "zwp064");
		// 上传文件
		// 读取一个本地文件
		File file = new File("F:\\PSP\\test.jpg");
		FileInputStream fileInputStream = new FileInputStream(file);
		// 设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		// 设置二进制上传的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		// 上传方法
		// 第一个参数是文件名
		// 第二个参数是文件流
		ftpClient.storeFile("hello1.jpg", fileInputStream);
		// 关闭连接
		ftpClient.logout();

	}

	@Test
	public void testFtpUtil() throws Exception {
		File file = new File("F:\\PSP\\test.jpg");
		FileInputStream fileInputStream = new FileInputStream(file);
		FtpUtil.uploadFile("192.168.1.179", 21, "ftpuser", "zwp064", "/home/ftpuser/www/images", "2016/12/10",
				"hello.jpg", fileInputStream);

	}

}
