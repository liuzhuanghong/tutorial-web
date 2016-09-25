package com.steven.tutorial.web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.steven.tutorial.web.domain.MyFile;
import com.steven.tutorial.web.exception.FileTransferException;

@WebService
public interface FileTransferService {
	@WebMethod
	void uploadFile(MyFile myFile) throws FileTransferException;

	@WebMethod
	MyFile downloadFile(MyFile myFile) throws FileTransferException;
}
