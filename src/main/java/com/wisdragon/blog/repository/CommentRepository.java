package com.wisdragon.blog.repository;

import com.wisdragon.blog.domain.Blog_Comment;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Comment Repository 接口. 
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface CommentRepository extends JpaRepository<Blog_Comment, Long> {

}
