package oit.is.z0282.kaizi.janken.model;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchMapper {
    @Select("SELECT ID, USER_1, USER_2, USER_1_HAND, USER_2_HAND FROM MATCHES")
    ArrayList<Match> selectAllMatches();    
}
