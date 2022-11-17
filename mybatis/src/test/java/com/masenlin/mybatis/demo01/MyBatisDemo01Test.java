package com.masenlin.mybatis.demo01;

import com.masenlin.mybatis.demo01.entity.Person;
import com.masenlin.mybatis.demo01.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangc
 * @date 2022年11月15日 17:27
 */

public class MyBatisDemo01Test {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            // 根据全局配置文件创建出 SqlSessionFactory，SqlSessionFactory 是负责创建 SqlSession 对象的工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertPerson() {
        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = new Person();
            person.setName("张三");
            person.setAge(24);
            person.setSex("男");
            mapper.insertPerson(person);
            // 提交本次会话要执行的内容
            sqlSession.commit();
            System.out.println(person.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭会话
            sqlSession.close();
        }
    }

    @Test
    public void updatePersonById() {
        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = new Person();
            person.setId(5);
            person.setName("张三明");
            person.setAge(20);
            person.setSex("男");
            mapper.updatePersonById(person);
            // 提交本次会话要执行的内容
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭会话
            sqlSession.close();
        }
    }

    @Test
    public void getPersonById() {
        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = mapper.getPersonById(5);
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭会话
            sqlSession.close();
        }
    }

    @Test
    public void deletePersonById() {
        // 获取数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            mapper.deletePersonById(5);
            // 提交本次会话要执行的内容
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭会话
            sqlSession.close();
        }
    }


}
