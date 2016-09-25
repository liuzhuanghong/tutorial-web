package com.steven.tutorial.web.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.steven.tutorial.web.domain.MyFile;
import com.steven.tutorial.web.exception.FileTransferException;
import com.steven.tutorial.web.service.FileTransferService;

/**
 * 测试通过CXF实现上传下载文件类
 * 
 * @author liuzhuanghong
 *
 */
public class FileTransferClientTest {

	private static final String address = "http://localhost:8088/tutorial-web/ws/fileTransferService";

	private static final String clientFile = "/Users/liuzhuanghong/temp/client/hehe_client.txt";
	private static final String serverFile = "/Users/liuzhuanghong/temp/service/hehe_service.txt";

	@Test
	public void testUploadFile() {
		long start = System.currentTimeMillis();
		try {

			FileTransferClientTest.uploadFile();
			FileTransferClientTest.downloadFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long stop = System.currentTimeMillis();
		System.out.println("Time: " + (stop - start));
	}

	public void testDownloadFile() {
		long start = System.currentTimeMillis();
		try {

			FileTransferClientTest.downloadFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long stop = System.currentTimeMillis();
		System.out.println("Time: " + (stop - start));
	}

	private static void uploadFile() throws FileTransferException {
		InputStream is = null;
		try {
			MyFile myFile = new MyFile();
			is = new FileInputStream(clientFile);
			byte[] bytes = new byte[1024 * 1024];
			while (true) {
				int size = is.read(bytes);
				if (size <= 0) {
					break;
				}

				byte[] fixedBytes = Arrays.copyOfRange(bytes, 0, size);
				myFile.setClientFile(clientFile);
				myFile.setServerFile(serverFile);
				myFile.setBytes(fixedBytes);

				uploadFile(myFile);

				myFile.setPosition(myFile.getPosition() + fixedBytes.length);
			}
		} catch (IOException e) {
			throw new FileTransferException(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	private static void uploadFile(MyFile myFile) throws FileTransferException {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress(address);
		factoryBean.setServiceClass(FileTransferService.class);
		Object obj = factoryBean.create();

		FileTransferService service = (FileTransferService) obj;
		service.uploadFile(myFile);
	}

	private static void downloadFile() throws FileTransferException {
		MyFile myFile = new MyFile();
		myFile.setServerFile(serverFile);
		long position = 0;
		while (true) {
			myFile.setPosition(position);
			myFile = downloadFile(myFile);
			if (myFile.getBytes().length <= 0) {
				break;
			}

			OutputStream os = null;
			try {
				if (position != 0) {
					os = FileUtils.openOutputStream(new File(clientFile), true);
				} else {
					os = FileUtils.openOutputStream(new File(clientFile), false);
				}
				os.write(myFile.getBytes());
			} catch (IOException e) {
				throw new FileTransferException(e.getMessage(), e);
			} finally {
				IOUtils.closeQuietly(os);
			}

			position += myFile.getBytes().length;
		}
	}

	private static MyFile downloadFile(MyFile myFile) throws FileTransferException {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress(address);
		factoryBean.setServiceClass(FileTransferService.class);
		Object obj = factoryBean.create();
		FileTransferService service = (FileTransferService) obj;
		return service.downloadFile(myFile);
	}
}
