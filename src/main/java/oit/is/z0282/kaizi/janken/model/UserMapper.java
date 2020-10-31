package oit.is.z0282.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT ID, NAME FROM USERS")
    ArrayList<User> selectAllUsers();

    @Select("SELECT ID, NAME FROM USERS WHERE ID = #{id}")
    User selectUserById(int id);

    @Select("SELECT ID, NAME FROM USERS WHERE NAME = #{name}")
    ArrayList<User> selectUsersByName(String name);
}
