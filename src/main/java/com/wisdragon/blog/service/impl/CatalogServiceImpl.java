package com.wisdragon.blog.service.impl;

import java.util.List;
import java.util.Optional;

import com.wisdragon.blog.domain.Blog_Catalog;
import com.wisdragon.blog.domain.Sys_User;
import com.wisdragon.blog.repository.CatalogRepository;
import com.wisdragon.blog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Catalog 服务接口实现.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
@Service
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	private CatalogRepository catalogRepository;
	
	@Override
	public Blog_Catalog saveCatalog(Blog_Catalog catalog) {
		 // 判断重复
        List<Blog_Catalog> list = catalogRepository.findByUserAndName(catalog.getUser(),
        		catalog.getName());
        if(list !=null && list.size() > 0) {
            throw new IllegalArgumentException("该分类已经存在了");
        }
        return catalogRepository.save(catalog);
	}
	
	@Override
	public void removeCatalog(Long id) {
		catalogRepository.deleteById(id);
	}

	@Override
	public Optional<Blog_Catalog> getCatalogById(Long id) {
		return catalogRepository.findById(id);
	}

	@Override
	public List<Blog_Catalog> listCatalogs(Sys_User user) {
		return catalogRepository.findByUser(user);
	}

}
