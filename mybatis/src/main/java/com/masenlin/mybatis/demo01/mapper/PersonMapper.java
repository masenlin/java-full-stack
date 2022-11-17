package com.masenlin.mybatis.demo01.mapper;

import com.masenlin.mybatis.demo01.entity.Person;

/**
 * @author wangc
 * @date 2022年11月15日 17:14
 */
public interface PersonMapper {
    /**
     * 新增人员信息
     *
     * @param person
     */
    void insertPerson(Person person);

    /**
     * 更新人员信息
     *
     * @param person
     */
    void updatePersonById(Person person);

    /**
     * 根据id获取人员信息
     *
     * @param id
     * @return
     */
    Person getPersonById(Integer id);

    /**
     * 根据id删除人员信息
     *
     * @param id
     */
    void deletePersonById(Integer id);


}
