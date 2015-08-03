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
        SqlSession session1 = sqlSessionFactory.openSession();
        try {
            /*
                First parameter: namespace + id
                com.fred.mybatis.demo1.dao.BlogDao + "." + selectBlog
            */
            Blog blog = session1.selectOne("com.fred.mybatis.demo1.dao.BlogDao.selectBlog", 1);
            System.out.println(blog.getId());
            System.out.println(blog.getContent());
        } finally {
            session1.close();
        }

        // use blogDao interface
        SqlSession session2 = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session2.getMapper(BlogDao.class);
            Blog blog = blogDao.selectBlog(2);
            System.out.println(blog.getId());
            System.out.println(blog.getContent());
        } finally {
            session2.close();
        }


        SqlSession session3 = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session3.getMapper(BlogDao.class);
            List<Blog> blogs = blogDao.selectBlogs(1);

            System.out.println(blogs.size());
            for(Blog tem : blogs) {
                System.out.print(tem.getId());
                System.out.print(":");
                System.out.println(tem.getContent());
            }
        } finally {
            session3.close();
        }


        SqlSession session4 = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session4.getMapper(BlogDao.class);
            Blog blog = new Blog();
            blog.setContent("333333333333333333");
            blogDao.addBlog(blog);
            System.out.println(blog.getId());
            session4.commit();
        } finally {
            session4.close();
        }

        SqlSession session5 = sqlSessionFactory.openSession();
        try {
            BlogDao blogDao = session5.getMapper(BlogDao.class);
            Blog blog = new Blog();
            blog.setId(5);
            blog.setContent("55");
            blogDao.updateBlog(blog);
            System.out.println(blog.getId());
            System.out.println(blog.getContent());
            session5.commit();
        } finally {
            session5.close();
        }
    }
}
