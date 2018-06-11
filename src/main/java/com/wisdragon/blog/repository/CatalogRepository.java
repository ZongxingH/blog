package com.wisdragon.blog.repository;

import java.util.List;

import com.wisdragon.blog.domain.Blog_Catalog;
import com.wisdragon.blog.domain.Sys_User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Catalog Repository.
 * 
 * @since 1.0.0 2017年6月7日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface CatalogRepository extends JpaRepository<Blog_Catalog, Long> {
    /**
     * 根据用户查询
     * @param user
     * @return
     */
    List<Blog_Catalog> findByUser(Sys_User user);

    /**
     * 根据用户、分类名称查询
     * @param user
     * @param name
     * @return
     */
    List<Blog_Catalog> findByUserAndName(Sys_User user, String name);
}
