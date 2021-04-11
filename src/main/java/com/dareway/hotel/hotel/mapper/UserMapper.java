package com.dareway.hotel.hotel.mapper;

import com.dareway.hotel.hotel.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name like  CONCAT('%',#{userName},'%') AND role = 'user' ")
    public List<User> getUserByName(@Param("userName") String userName);
    @Select("select * from user where role = 'user'")
    public List<User> getAllUser();
    @Select("select * from user  where user_name = #{userName}")
    User selectUserByName(@Param("userName") String userName);
    @Delete("delete from user where user_id = #{userId}")
    public Boolean deleteByuserId(@Param("userId") int userId);
    @Select("select * from user where user_id = #{userId}")
    public User findUserById(@Param("userId") int userId);

    @Select("select * from user where user_name = #{userName}")
    public User findUserByUserName(@Param("userName") String userName);
}
