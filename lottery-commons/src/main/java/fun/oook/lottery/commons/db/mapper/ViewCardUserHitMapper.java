package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.ViewCardUserHit;
import fun.oook.lottery.commons.db.entity.ViewCardUserHitExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViewCardUserHitMapper {
    long countByExample(ViewCardUserHitExample example);

    int deleteByExample(ViewCardUserHitExample example);

    int insert(ViewCardUserHit record);

    int insertSelective(ViewCardUserHit record);

    List<ViewCardUserHit> selectByExample(ViewCardUserHitExample example);

    int updateByExampleSelective(@Param("record") ViewCardUserHit record, @Param("example") ViewCardUserHitExample example);

    int updateByExample(@Param("record") ViewCardUserHit record, @Param("example") ViewCardUserHitExample example);
}