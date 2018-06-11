package com.wisdragon.blog.repository;

import com.wisdragon.blog.domain.Sys_Auth;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Authority 仓库.
 * 
 * @since 1.0.0 2017年5月30日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface AuthorityRepository extends JpaRepository<Sys_Auth, Long> {
	
}
