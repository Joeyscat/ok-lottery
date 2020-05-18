package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardUserHit;
import fun.oook.lottery.commons.db.entity.CardUserHitExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardUserHitMapper {
    long countByExample(CardUserHitExample example);

    int deleteByExample(CardUserHitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardUserHit record);

    int insertSelective(CardUserHit record);

    List<CardUserHit> selectByExample(CardUserHitExample example);

    CardUserHit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardUserHit record, @Param("example") CardUserHitExample example);

    int updateByExample(@Param("record") CardUserHit record, @Param("example") CardUserHitExample example);

    int updateByPrimaryKeySelective(CardUserHit record);

    int updateByPrimaryKey(CardUserHit record);
}