package com.steven.tutorial.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传Action
 * @author liuzhuanghong
 */
public class UploadFileAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private List<File> upload;

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private List<String> uploadContentType;

	private List<String> uploadFileName;

	private String result;

	@Override
	public String execute() throws Exception {

		// 文件保存路径
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		System.out.println("文件保存路径:" + path);
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		for (int i = 0; i < upload.size(); i++) {
			FileUtils.copyFile(upload.get(i), new File(file, uploadFileName.get(i)));
		}
		result = "文件上传成功";
		return SUCCESS;
	}
}
