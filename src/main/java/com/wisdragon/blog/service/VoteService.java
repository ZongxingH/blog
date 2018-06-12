package com.wisdragon.blog.service;

import com.wisdragon.blog.domain.Blog_Vote;

import java.util.Optional;


/**
 * Vote 服务接口.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface VoteService {
	/**
	 * 根据id获取 Vote
	 * @param id
	 * @return
	 */
	Optional<Blog_Vote> getVoteById(Long id);
	/**
	 * 删除Vote
	 * @param id
	 * @return
	 */
	void removeVote(Long id);
}
