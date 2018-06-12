package com.wisdragon.blog.service.impl;

import java.util.Optional;

import com.wisdragon.blog.domain.Blog_Comment;
import com.wisdragon.blog.repository.CommentRepository;
import com.wisdragon.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Comment Service接口实现.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    
	@Override
	public Optional<Blog_Comment> getCommentById(Long id) {
		return commentRepository.findById(id);
	}

	@Override
	public void removeComment(Long id) {
		commentRepository.deleteById(id);
	}

}
