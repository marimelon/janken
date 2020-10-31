package oit.is.z0282.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface MatchMapper {
    @Select("SELECT ID, USER_1, USER_2, USER_1_HAND, USER_2_HAND FROM MATCHES")
    ArrayList<Match> selectAllMatches();

    @Insert("INSERT INTO matches (USER_1, USER_2, USER_1_HAND, USER_2_HAND) VALUES (#{user_1},#{user_2},#{user_1_hand},#{user_2_hand});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertChamber(Match match);
}
