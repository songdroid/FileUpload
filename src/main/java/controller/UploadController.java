package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import dao.UploadDao;
import dto.UploadDto;

@Controller
@RequestMapping("/upload.spring")
public class UploadController {
	@RequestMapping(params={"ver=first"})
	public String firstHandle(){
		return "upload1";
	}
	
	@RequestMapping(params={"ver=first"}, method=RequestMethod.POST)
	public String firstSubmitHandler(UploadDto uploadDto, HttpServletRequest req) throws IOException{
		/*
		System.out.println(uploadDto.getTitle());
		System.out.println(uploadDto.getName());
		System.out.println(uploadDto.getUpFile().getOriginalFilename());
		 */
		
		MultipartFile file = uploadDto.getUpFile();
		System.out.println(uploadDto.getUpFile().getOriginalFilename());
		String path = 
			WebUtils.getRealPath(req.getSession().getServletContext(), "/upload");
		
		UploadDao uploadDao = new UploadDao();
		uploadDao.writeFile(file, path, file.getOriginalFilename());
		
		return "completeUpload1";
	}
}
