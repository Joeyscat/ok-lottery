package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardGameRules;
import fun.oook.lottery.commons.db.entity.CardGameRulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardGameRulesMapper {
    long countByExample(CardGameRulesExample example);

    int deleteByExample(CardGameRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardGameRules record);

    int insertSelective(CardGameRules record);

    List<CardGameRules> selectByExample(CardGameRulesExample example);

    CardGameRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardGameRules record, @Param("example") CardGameRulesExample example);

    int updateByExample(@Param("record") CardGameRules record, @Param("example") CardGameRulesExample example);

    int updateByPrimaryKeySelective(CardGameRules record);

    int updateByPrimaryKey(CardGameRules record);
}