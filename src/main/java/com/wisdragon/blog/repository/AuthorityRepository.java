package com.wisdragon.blog.repository;

import com.wisdragon.blog.domain.Sys_Auth;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Authority 仓库.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface AuthorityRepository extends JpaRepository<Sys_Auth, Long> {
	
}
