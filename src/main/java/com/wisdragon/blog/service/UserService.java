package com.wisdragon.blog.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.wisdragon.blog.domain.Sys_User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * 用户服务接口.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface UserService {
	 /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    Sys_User saveOrUpateUser(Sys_User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    Sys_User registerUser(Sys_User user);

    /**
     * 删除用户
     * @param id
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    Optional<Sys_User> getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<Sys_User> listUsersByNameLike(String name, Pageable pageable);
    
    /**
     * 根据用户名集合，查询用户详细信息列表
     * @param usernames
     * @return
     */
    List<Sys_User> listUsersByUsernames(Collection<String> usernames);
}