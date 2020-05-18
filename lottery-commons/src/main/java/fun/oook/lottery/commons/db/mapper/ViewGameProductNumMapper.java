package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.ViewGameProductNum;
import fun.oook.lottery.commons.db.entity.ViewGameProductNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViewGameProductNumMapper {
    long countByExample(ViewGameProductNumExample example);

    int deleteByExample(ViewGameProductNumExample example);

    int insert(ViewGameProductNum record);

    int insertSelective(ViewGameProductNum record);

    List<ViewGameProductNum> selectByExample(ViewGameProductNumExample example);

    int updateByExampleSelective(@Param("record") ViewGameProductNum record, @Param("example") ViewGameProductNumExample example);

    int updateByExample(@Param("record") ViewGameProductNum record, @Param("example") ViewGameProductNumExample example);
}