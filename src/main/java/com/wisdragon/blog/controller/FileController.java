package com.wisdragon.blog.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import com.wisdragon.blog.domain.Blog_File;
import com.wisdragon.blog.service.FileService;
import com.wisdragon.blog.util.MD5Util;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileService fileService;

//	@Value("${server.address}")
//	private String serverAddress;
//
//	@Value("${server.port}")
//	private String serverPort;

//	@RequestMapping(value = "/")
	public String index(Model model) {
		// 展示最新二十条数据
		model.addAttribute("files", fileService.listFilesByPage(0, 20));
		return "fileIndex";
	}

	/**
	 * 分页查询文件
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
//	@GetMapping("/{pageIndex}/{pageSize}")
//	@ResponseBody
	public List<Blog_File> listFilesByPage(@PathVariable int pageIndex, @PathVariable int pageSize) {
		return fileService.listFilesByPage(pageIndex, pageSize);
	}

	/**
	 * 获取文件片信息
	 * 
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
//	@GetMapping("/{id}")
//	@ResponseBody
	public ResponseEntity<Object> serveFile(@PathVariable String id) throws UnsupportedEncodingException {

		Optional<Blog_File> file = fileService.getFileById(id);

		if (file.isPresent()) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes("utf-8"),"ISO-8859-1"))
					.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
					.header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
					.body(file.get().getContent().getData());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
		}

	}

	/**
	 * 在线显示文件
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	@ResponseBody
	public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {

		Optional<Blog_File> file = fileService.getFileById(id);

		if (file.isPresent()) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.get().getName() + "\"")
					.header(HttpHeaders.CONTENT_TYPE, file.get().getContentType())
					.header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
					.body(file.get().getContent().getData());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
		}

	}

	/**
	 * 上传
	 * 
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
//	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		try {
			Blog_File f = new Blog_File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
					new Binary(file.getBytes()));
			f.setMd5(MD5Util.getMD5(file.getInputStream()));
			fileService.saveFile(f);
		} catch (IOException | NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "Your " + file.getOriginalFilename() + " is wrong!");
			return "redirect:/";
		}

		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}

	/**
	 * 上传接口
	 *
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		Blog_File returnFile = null;
		try {
			Blog_File f = new Blog_File(file.getOriginalFilename(), file.getContentType(), file.getSize(),
					new Binary(file.getBytes()));
			f.setMd5(MD5Util.getMD5(file.getInputStream()));
			returnFile = fileService.saveFile(f);
			String path = "/files/view/" + returnFile.getId();
			return ResponseEntity.status(HttpStatus.OK).body(path);

		} catch (IOException | NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

	}


	@PostMapping("/upload/test")
//	@ResponseBody
	public String handleFileUpload(@RequestParam("testInfo") String testInfo,@RequestParam("extraField") String extraField) {
		System.out.println("testInfo:" + testInfo + ",extraField:" + extraField);

		return "test success !";

	}

	/**
	 * 删除文件
	 * 
	 * @param id
	 * @return
	 */
//	@DeleteMapping("/{id}")
//	@ResponseBody
	public ResponseEntity<String> deleteFile(@PathVariable String id) {

		try {
			fileService.removeFile(id);
			return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
