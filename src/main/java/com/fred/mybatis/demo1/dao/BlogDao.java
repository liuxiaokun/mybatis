package com.fred.mybatis.demo1.dao;

import com.fred.mybatis.demo1.Blog;

import java.util.List;

/**
 * Created by liuxiaokun on 2015/6/5.
 */
public interface BlogDao {

    Blog selectBlog(int id);

    List<Blog> selectBlogs(int id);

    void addBlog(Blog blog);

    void updateBlog(Blog blog);
}
