package com.wisdragon.blog.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.wisdragon.blog.domain.Sys_User;
import com.wisdragon.blog.repository.UserRepository;
import com.wisdragon.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 用户服务接口实现.
 *
 * @since 1.0.0 2017年7月27日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public Sys_User saveOrUpateUser(Sys_User user) {
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public Sys_User registerUser(Sys_User user) {
		//  加密密码
		user.setEncodePassword(user.getPassword()); 
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<Sys_User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public Page<Sys_User> listUsersByNameLike(String name, Pageable pageable) {
		
        // 模糊查询
        name = "%" + name + "%";
        Page<Sys_User> users = userRepository.findByNameLike(name, pageable);
        return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
			
	@Override
	public List<Sys_User> listUsersByUsernames(Collection<String> usernames) {
		return userRepository.findByUsernameIn(usernames);
	}
 
}
