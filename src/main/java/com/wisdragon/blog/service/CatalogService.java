package com.wisdragon.blog.service;

import com.wisdragon.blog.domain.Blog_Catalog;
import com.wisdragon.blog.domain.Sys_User;

import java.util.List;
import java.util.Optional;


/**
 * Catalog 服务接口.
 * 
 * @since 1.0.0 2017年4月10日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface CatalogService {
	/**
	 * 保存Catalog
	 * @param catalog
	 * @return
	 */
	Blog_Catalog saveCatalog(Blog_Catalog catalog);
	
	/**
	 * 删除Catalog
	 * @param id
	 * @return
	 */
	void removeCatalog(Long id);

	/**
	 * 根据id获取Catalog
	 * @param id
	 * @return
	 */
	Optional<Blog_Catalog> getCatalogById(Long id);
	
	/**
	 * 获取Catalog列表
	 * @return
	 */
	List<Blog_Catalog> listCatalogs(Sys_User user);
}
