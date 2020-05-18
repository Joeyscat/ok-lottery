package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardProduct;
import fun.oook.lottery.commons.db.entity.CardProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardProductMapper {
    long countByExample(CardProductExample example);

    int deleteByExample(CardProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardProduct record);

    int insertSelective(CardProduct record);

    List<CardProduct> selectByExample(CardProductExample example);

    CardProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardProduct record, @Param("example") CardProductExample example);

    int updateByExample(@Param("record") CardProduct record, @Param("example") CardProductExample example);

    int updateByPrimaryKeySelective(CardProduct record);

    int updateByPrimaryKey(CardProduct record);
}