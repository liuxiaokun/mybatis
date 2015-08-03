package com.fred.mybatis.demo1.dao;

import com.fred.mybatis.demo1.Blog;

import java.util.List;

/**
 * create£¬update£¬delete action must be execute session.commit()
 */
public interface BlogDao {

    Blog selectBlog(int id);

    List<Blog> selectBlogs(int id);

    void addBlog(Blog blog);

    void updateBlog(Blog blog);
}
