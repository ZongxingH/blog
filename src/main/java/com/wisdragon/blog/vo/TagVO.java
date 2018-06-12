package com.wisdragon.blog.vo;

/**
 * Tag 值对象.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public class TagVO {
	
	private String name;
	private Long count;
	
	public TagVO(String name, Long count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
 
}
