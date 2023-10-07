package com.example.autoconfiguration.dao;

import com.example.autoconfiguration.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserDao {

    @Select("SELECT * FROM public.\"User\" WHERE id = #{userId}")
    User getUserById(@Param("userId") long userId);

    @Insert("INSERT INTO public.\"User\" (name, email) VALUES (#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
        //will return User with id obtained from DB after inserting
    void createUser(User user);

    @Update("Update public.\"User\" set name = #{name}, email= #{email} where id=#{id}")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
        //will return User with id obtained from DB after updating
    void updateUser(User user);

    @Delete("Delete from public.\"User\" where id=#{userId}")
    void deleteUser(long userId);

}
