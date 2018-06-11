package com.wisdragon.blog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import com.wisdragon.blog.domain.Sys_Auth;
import com.wisdragon.blog.domain.Sys_User;
import com.wisdragon.blog.service.AuthorityService;
import com.wisdragon.blog.service.UserService;
import com.wisdragon.blog.util.ConstraintViolationExceptionHandler;
import com.wisdragon.blog.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * User 控制器.
 * 
 * @since 1.0.0 2017年7月9日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;
	
	/**
	 * 查询所有用户
	 * 
	 * @param async
	 * @param pageIndex
	 * @param pageSize
	 * @param name
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(@RequestParam(value = "async", required = false) boolean async,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "name", required = false, defaultValue = "") String name, Model model) {

		Pageable pageable = PageRequest.of(pageIndex, pageSize);
		Page<Sys_User> page = userService.listUsersByNameLike(name, pageable);
		List<Sys_User> list = page.getContent(); // 当前所在页面数据列表

		model.addAttribute("page", page);
		model.addAttribute("userList", list);
		return new ModelAndView(async == true ? "users/list :: #mainContainerRepleace" : "users/list", "userModel",
				model);
	}

	/**
	 * 获取创建表单页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new Sys_User(null, null, null, null));
		return new ModelAndView("users/add", "userModel", model);
	}

    /**
     * 保存或者修改用户
     * @param user
     * @param authorityId
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> saveOrUpateUser(Sys_User user, Long authorityId) {
    	
		List<Sys_Auth> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(authorityId).get());
		user.setAuthorities(authorities);

        try {
            userService.saveOrUpateUser(user);
        }  catch (ConstraintViolationException e)  {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        }

        return ResponseEntity.ok().body(new Response(true, "处理成功", user));
    }

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response> delete(@PathVariable("id") Long id, Model model) {
		try {
			userService.removeUser(id);
		} catch (Exception e) {
			return ResponseEntity.ok().body(new Response(false, e.getMessage()));
		}
		return ResponseEntity.ok().body(new Response(true, "处理成功"));
	}

	/**
	 * 获取修改用户的界面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value = "edit/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		Optional<Sys_User> user = userService.getUserById(id);
		model.addAttribute("user", user.get());
		return new ModelAndView("users/edit", "userModel", model);
	}

}