package com.wisdragon.blog.service;

import com.wisdragon.blog.domain.Sys_Auth;

import java.util.Optional;


/**
 * Authority 服务接口.
 * 
 * @since 1.0.0 2017年5月30日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface AuthorityService {
	/**
	 * 根据ID查询 Authority
	 * @param id
	 * @return
	 */
	Optional<Sys_Auth> getAuthorityById(Long id);
}
