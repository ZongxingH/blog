package com.wisdragon.blog.vo;


import com.wisdragon.blog.domain.Blog_Catalog;

/**
 * Catalog VO.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public class CatalogVO {
	
	private String username;
	private Blog_Catalog catalog;
	
	public CatalogVO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Blog_Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Blog_Catalog catalog) {
		this.catalog = catalog;
	}

}
