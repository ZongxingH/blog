package com.wisdragon.blog.repository;

import com.wisdragon.blog.domain.Blog;
import com.wisdragon.blog.domain.Blog_Catalog;
import com.wisdragon.blog.domain.Sys_User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Blog 仓库.
 *
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface BlogRepository extends JpaRepository<Blog, Long>{

	/**
	 * 根据用户名、博客标题分页查询博客列表
	 * @param user
	 * @param title
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByUserAndTitleLike(Sys_User user, String title, Pageable pageable);
	
	/**
	 * 根据用户名、博客查询博客列表（时间逆序）
	 * @param title
	 * @param user
	 * @param tags
	 * @param user2
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,
																			Sys_User user, String tags, Sys_User user2, Pageable pageable);
	/**
	 * 根据分类查询博客列表
	 * @param catalog
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByCatalog(Blog_Catalog catalog, Pageable pageable);
}
