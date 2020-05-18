package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.ViewUserHitNum;
import fun.oook.lottery.commons.db.entity.ViewUserHitNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViewUserHitNumMapper {
    long countByExample(ViewUserHitNumExample example);

    int deleteByExample(ViewUserHitNumExample example);

    int insert(ViewUserHitNum record);

    int insertSelective(ViewUserHitNum record);

    List<ViewUserHitNum> selectByExample(ViewUserHitNumExample example);

    int updateByExampleSelective(@Param("record") ViewUserHitNum record, @Param("example") ViewUserHitNumExample example);

    int updateByExample(@Param("record") ViewUserHitNum record, @Param("example") ViewUserHitNumExample example);
}