package com.wisdragon.blog.service;

import com.wisdragon.blog.domain.Sys_Auth;

import java.util.Optional;


/**
 * Authority 服务接口.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface AuthorityService {
	/**
	 * 根据ID查询 Authority
	 * @param id
	 * @return
	 */
	Optional<Sys_Auth> getAuthorityById(Long id);
}
