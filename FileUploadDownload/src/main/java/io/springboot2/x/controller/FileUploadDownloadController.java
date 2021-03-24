package io.springboot2.x.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import io.springboot2.x.entity.UploadFile;
import io.springboot2.x.repository.UploadFileRepository;

@Controller
public class FileUploadDownloadController {
	
	@Autowired
	UploadFileRepository repo;
	
	@GetMapping({"/fileUploadPage","/"})
	public String getFileUploadPage() {
		return "FileUpload";
	}
	
	@PostMapping("/doUpload")
	public String handleUpload(@RequestParam("file1")CommonsMultipartFile[] cmf, Model model) {
		for(CommonsMultipartFile mfile:cmf) {
			UploadFile uploadFile = new UploadFile();
			
			uploadFile.setFileName(mfile.getOriginalFilename());
			uploadFile.setFileData(mfile.getBytes());
			repo.save(uploadFile);
		}
		model.addAttribute("message", "File(s) uploaded successfully");
		return "FileUpload";
	}
	
	@GetMapping("/downLoadPage")
	public String getDownloadPage(Model model) {
		List<Object[]> filesList = repo.getFieldsAndNames();
		model.addAttribute("files",filesList);
		return "FileDownload";
	}

	@GetMapping("/doDownload")
	public void downloadFile(HttpServletResponse response,@RequestParam("fileid")Integer fileId) {
		Optional<UploadFile> opt = repo.findById(fileId);
		
		UploadFile uploadFile = opt.get();
		
		response.setHeader("Content-Disposition", "attachment: filename"+uploadFile.getFileName());
		
		try {
			FileCopyUtils.copy(uploadFile.getFileData(), response.getOutputStream());
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
	}


}
