package com.wisdragon.blog.repository;

import java.util.Collection;
import java.util.List;

import com.wisdragon.blog.domain.Sys_User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * User Repository 接口.
 * 
 * @since 1.0.0 2017年7月16日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface UserRepository extends JpaRepository<Sys_User, Long>{
	
	/**
	 * 根据用户姓名分页查询用户列表
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Sys_User> findByNameLike(String name, Pageable pageable);
	
	/**
	 * 根据用户账号查询用户
	 * @param username
	 * @return
	 */
	Sys_User findByUsername(String username);

	/**
	 * 根据名称列表查询用户列表
	 * @param usernames
	 * @return
	 */
	List<Sys_User> findByUsernameIn(Collection<String> usernames);
}