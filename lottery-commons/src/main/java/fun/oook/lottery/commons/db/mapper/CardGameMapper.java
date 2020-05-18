package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardGame;
import fun.oook.lottery.commons.db.entity.CardGameExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardGameMapper {
    long countByExample(CardGameExample example);

    int deleteByExample(CardGameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardGame record);

    int insertSelective(CardGame record);

    List<CardGame> selectByExample(CardGameExample example);

    CardGame selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardGame record, @Param("example") CardGameExample example);

    int updateByExample(@Param("record") CardGame record, @Param("example") CardGameExample example);

    int updateByPrimaryKeySelective(CardGame record);

    int updateByPrimaryKey(CardGame record);
}