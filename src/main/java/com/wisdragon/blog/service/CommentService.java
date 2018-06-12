package com.wisdragon.blog.service;

import com.wisdragon.blog.domain.Blog_Comment;

import java.util.Optional;


/**
 * Comment Service接口.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface CommentService {

	/**
     * 根据id获取 Comment
     * @param id
     * @return
     */
	Optional<Blog_Comment> getCommentById(Long id);
    /**
     * 删除评论
     * @param id
     * @return
     */
    void removeComment(Long id);
}
