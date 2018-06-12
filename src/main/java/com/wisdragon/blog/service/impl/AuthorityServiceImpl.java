/**
 * 
 */
package com.wisdragon.blog.service.impl;

import java.util.Optional;

import com.wisdragon.blog.domain.Sys_Auth;
import com.wisdragon.blog.repository.AuthorityRepository;
import com.wisdragon.blog.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Authority 服务接口的实现.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public Optional<Sys_Auth> getAuthorityById(Long id) {
		return authorityRepository.findById(id);
	}

}
