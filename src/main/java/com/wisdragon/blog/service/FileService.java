/**
 * 
 */
package com.wisdragon.blog.service;

import com.wisdragon.blog.domain.Blog_File;

import java.util.List;
import java.util.Optional;


/**
 * File 服务接口.
 * 
 * @since 1.0.0 2017年3月28日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface FileService {
	/**
	 * 保存文件
	 * @param File
	 * @return
	 */
	Blog_File saveFile(Blog_File file);
	
	/**
	 * 删除文件
	 * @param File
	 * @return
	 */
	void removeFile(String id);
	
	/**
	 * 根据id获取文件
	 * @param File
	 * @return
	 */
	Optional<Blog_File> getFileById(String id);

	/**
	 * 分页查询，按上传时间降序
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<Blog_File> listFilesByPage(int pageIndex, int pageSize);
}
