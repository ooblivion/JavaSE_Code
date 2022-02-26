package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @version v1.0
 * @InterfaceName: UserMapper
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public interface UserMapper {
    List<User> selectAll();

    User selectById(int id);
}
