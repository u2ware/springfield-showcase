package com.yourcompany.yourproject.reference.multipart1;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;

import com.u2ware.springfield.support.multipart.MultipartFileHandler;
import com.u2ware.springfield.support.multipart.UploadFileNameResolver;
import com.u2ware.springfield.view.multipart.MultipartFileBeanController;

@Controller
@RequestMapping("/reference/multipart1")
public class AjaxUploadController extends MultipartFileBeanController{
	
	@Autowired(required=false)
	private MultipartFileHandler multipartFileHandler;
	
	@Override
	public MultipartFileHandler getMultipartFileHandler() {
		return multipartFileHandler;
	}
	@Override
	public UploadFileNameResolver getMultipartFileNameResolver(final String name) {
		return new UploadFileNameResolver(){
			public String resolveFileName(MultipartFile multipartFile) throws IOException {
				return ""+System.currentTimeMillis();
			}};
	}
	

	@RequestMapping(value = "/upload.html", method = RequestMethod.GET)
	public String uploadForm() throws Exception {
		return "/uploadForm.html";
	}
	
	@RequestMapping(value="/upload.html", method=RequestMethod.POST)
	public View upload(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("multipartFile")MultipartFile[] multipartFile, 
			@RequestParam(value="contentFile",required=false)String name, 
			Model model) throws Exception{
		
		return uploadHandle(multipartFile, name, model);
	}
	

	@RequestMapping(value="/delete.html", method=RequestMethod.POST)
	public View delete(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("fileNames")String[] multipartFile, 
			Model model) throws Exception{
		return deleteHandle(multipartFile, model);
	}


}