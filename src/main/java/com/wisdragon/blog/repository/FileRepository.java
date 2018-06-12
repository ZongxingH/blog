package com.wisdragon.blog.repository;

import com.wisdragon.blog.domain.Blog_File;
import org.springframework.data.mongodb.repository.MongoRepository;



/**
 * File 存储库.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface FileRepository extends MongoRepository<Blog_File, String> {
}
