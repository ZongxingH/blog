package com.wisdragon.blog.service.impl;

import java.util.List;
import java.util.Optional;

import com.wisdragon.blog.domain.Blog_File;
import com.wisdragon.blog.repository.FileRepository;
import com.wisdragon.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * File 服务.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	public FileRepository fileRepository;

	@Override
	public Blog_File saveFile(Blog_File file) {
		return fileRepository.save(file);
	}

	@Override
	public void removeFile(String id) {
		fileRepository.deleteById(id);
	}

	@Override
	public Optional<Blog_File> getFileById(String id) {
		return fileRepository.findById(id);
	}

	@Override
	public List<Blog_File> listFilesByPage(int pageIndex, int pageSize) {
		Page<Blog_File> page = null;
		List<Blog_File> list = null;
		
		Sort sort = new Sort(Direction.DESC,"uploadDate"); 
		Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
		
		page = fileRepository.findAll(pageable);
		list = page.getContent();
		return list;
	}
}
