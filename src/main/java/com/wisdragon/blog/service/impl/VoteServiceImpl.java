package com.wisdragon.blog.service.impl;

import java.util.Optional;

import com.wisdragon.blog.domain.Blog_Vote;
import com.wisdragon.blog.repository.VoteRepository;
import com.wisdragon.blog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Vote 服务实现.
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;
    
	@Override
	public Optional<Blog_Vote> getVoteById(Long id) {
		return voteRepository.findById(id);
	}
	
	@Override
	public void removeVote(Long id) {
		voteRepository.deleteById(id);
	}
}
