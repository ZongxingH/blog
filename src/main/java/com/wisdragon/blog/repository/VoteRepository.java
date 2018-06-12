package com.wisdragon.blog.repository;

import com.wisdragon.blog.domain.Blog_Vote;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Vote Repository接口.
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface VoteRepository extends JpaRepository<Blog_Vote, Long> {
	
}
