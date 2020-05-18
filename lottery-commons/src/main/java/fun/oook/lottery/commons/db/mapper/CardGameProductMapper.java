package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardGameProduct;
import fun.oook.lottery.commons.db.entity.CardGameProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardGameProductMapper {
    long countByExample(CardGameProductExample example);

    int deleteByExample(CardGameProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardGameProduct record);

    int insertSelective(CardGameProduct record);

    List<CardGameProduct> selectByExample(CardGameProductExample example);

    CardGameProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardGameProduct record, @Param("example") CardGameProductExample example);

    int updateByExample(@Param("record") CardGameProduct record, @Param("example") CardGameProductExample example);

    int updateByPrimaryKeySelective(CardGameProduct record);

    int updateByPrimaryKey(CardGameProduct record);
}