package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardUser;
import fun.oook.lottery.commons.db.entity.CardUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardUserMapper {
    long countByExample(CardUserExample example);

    int deleteByExample(CardUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardUser record);

    int insertSelective(CardUser record);

    List<CardUser> selectByExample(CardUserExample example);

    CardUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardUser record, @Param("example") CardUserExample example);

    int updateByExample(@Param("record") CardUser record, @Param("example") CardUserExample example);

    int updateByPrimaryKeySelective(CardUser record);

    int updateByPrimaryKey(CardUser record);
}