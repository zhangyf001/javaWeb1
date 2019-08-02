package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping(value="fileUpload")
public class fileUploadAction {
	@RequestMapping(value="fileUp",method=RequestMethod.POST)
	public String  fileupload(@RequestParam("file") MultipartFile[] file,HttpSession session) throws IOException{
		String path = session.getServletContext().getRealPath("/upload");
		System.out.println(path);
		for(MultipartFile e:file){
			if(e.isEmpty()) continue;
			File f = new File(path + "/" + new Date().getTime() + "_" + e.getOriginalFilename());
			FileUtils.copyInputStreamToFile(e.getInputStream(), f);
		}
		return "fileUploadSuccess";
	}
	
}
