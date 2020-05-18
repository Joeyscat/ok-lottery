package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.ViewGameCurinfo;
import fun.oook.lottery.commons.db.entity.ViewGameCurinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViewGameCurinfoMapper {
    long countByExample(ViewGameCurinfoExample example);

    int deleteByExample(ViewGameCurinfoExample example);

    int insert(ViewGameCurinfo record);

    int insertSelective(ViewGameCurinfo record);

    List<ViewGameCurinfo> selectByExample(ViewGameCurinfoExample example);

    int updateByExampleSelective(@Param("record") ViewGameCurinfo record, @Param("example") ViewGameCurinfoExample example);

    int updateByExample(@Param("record") ViewGameCurinfo record, @Param("example") ViewGameCurinfoExample example);
}