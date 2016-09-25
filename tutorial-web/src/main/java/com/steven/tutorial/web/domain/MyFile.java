package com.steven.tutorial.web.domain;

/**
 * 封装了服务器端文件路径，客户端文件路径和要传输的字节数组的文件类
 * 
 * @author liuzhuanghong
 *
 */
public class MyFile {
	
	private String clientFile;

	private String serverFile;

	private long position;

	private byte[] bytes;

	public String getClientFile() {
		return clientFile;
	}

	public void setClientFile(String clientFile) {
		this.clientFile = clientFile;
	}

	public String getServerFile() {
		return serverFile;
	}

	public void setServerFile(String serverFile) {
		this.serverFile = serverFile;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}
