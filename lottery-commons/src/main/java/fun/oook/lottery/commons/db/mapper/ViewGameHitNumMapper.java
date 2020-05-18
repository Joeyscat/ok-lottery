package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.ViewGameHitNum;
import fun.oook.lottery.commons.db.entity.ViewGameHitNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViewGameHitNumMapper {
    long countByExample(ViewGameHitNumExample example);

    int deleteByExample(ViewGameHitNumExample example);

    int insert(ViewGameHitNum record);

    int insertSelective(ViewGameHitNum record);

    List<ViewGameHitNum> selectByExample(ViewGameHitNumExample example);

    int updateByExampleSelective(@Param("record") ViewGameHitNum record, @Param("example") ViewGameHitNumExample example);

    int updateByExample(@Param("record") ViewGameHitNum record, @Param("example") ViewGameHitNumExample example);
}