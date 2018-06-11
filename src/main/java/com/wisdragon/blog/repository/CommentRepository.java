package com.wisdragon.blog.repository;

import com.wisdragon.blog.domain.Blog_Comment;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Comment Repository 接口. 
 * 
 * @since 1.0.0 2017年6月6日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface CommentRepository extends JpaRepository<Blog_Comment, Long> {

}
