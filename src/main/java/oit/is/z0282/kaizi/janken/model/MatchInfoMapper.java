package oit.is.z0282.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface MatchInfoMapper {
    @Insert("INSERT INTO MATCHE_INFO (USER_1, USER_2, IS_ACTIVE) VALUES (#{user_1},#{user_2},#{is_active});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertMatchInfo(MatchInfo match_info);
}
