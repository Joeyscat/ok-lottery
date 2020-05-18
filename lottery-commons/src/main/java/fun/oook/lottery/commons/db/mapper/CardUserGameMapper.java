package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardUserGame;
import fun.oook.lottery.commons.db.entity.CardUserGameExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CardUserGameMapper {

    @Select("SELECT COUNT(id) AS num FROM card_user_game c WHERE c.user_id=#{userId}")
    Integer getGamesNumByUserId(final int userId);

    @Select("SELECT COUNT(id) AS num FROM card_user_hit c WHERE c.userid=#{userId}")
    Integer getPrizesNumByUserId(final int userId);

    long countByExample(CardUserGameExample example);

    int deleteByExample(CardUserGameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardUserGame record);

    int insertSelective(CardUserGame record);

    List<CardUserGame> selectByExample(CardUserGameExample example);

    CardUserGame selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardUserGame record, @Param("example") CardUserGameExample example);

    int updateByExample(@Param("record") CardUserGame record, @Param("example") CardUserGameExample example);

    int updateByPrimaryKeySelective(CardUserGame record);

    int updateByPrimaryKey(CardUserGame record);
}