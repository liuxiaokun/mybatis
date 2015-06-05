package com.fred.mybatis.demo1;

import com.fred.mybatis.demo1.dao.BlogDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created by liuxiaokun on 2015/6/4.
 */
public class HelloWorld {


    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        /*SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = (Blog) session.selectOne("org.fred.mybatis.demo1.Blog.selectBlog", 1);
            System.out.println(blog.getId());
            System.out.println(blog.getContent());
        } finally {
            session.close();
        }*/

        /*SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlog(2);
            System.out.println(blog.getId());
            System.out.println(blog.getContent());
        } finally {
            session.close();
        }*/


       /* SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            List<Blog> blogs = blogDao.selectBlogs(1);

            System.out.println(blogs.size());
            for(Blog tem : blogs) {
                System.out.print(tem.getId());
                System.out.print(":");
                System.out.println(tem.getContent());
            }
        } finally {
            session.close();
        }*/


        /*SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = new Blog();
            blog.setContent("333333333333333333");
            blogDao.addBlog(blog);
            System.out.println(blog.getId());
            session.commit();
        } finally {
            session.close();
        }*/

        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session.getMapper(BlogDao.class);
            Blog blog = new Blog();
            blog.setId(5);
            blog.setContent("55");
            blogDao.updateBlog(blog);
            System.out.println(blog.getId());
            System.out.println(blog.getContent());
        } finally {
            session.close();
        }
    }
}
