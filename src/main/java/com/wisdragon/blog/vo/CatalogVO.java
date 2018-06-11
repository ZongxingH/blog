package com.wisdragon.blog.vo;


import com.wisdragon.blog.domain.Blog_Catalog;

/**
 * Catalog VO.
 * 
 * @since 1.0.0 2017年8月1日
 * @author <a href="https://waylau.com">Way Lau</a> 
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
