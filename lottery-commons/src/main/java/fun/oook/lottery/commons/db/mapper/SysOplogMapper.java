package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.SysOplog;
import fun.oook.lottery.commons.db.entity.SysOplogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysOplogMapper {
    long countByExample(SysOplogExample example);

    int deleteByExample(SysOplogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysOplog record);

    int insertSelective(SysOplog record);

    List<SysOplog> selectByExample(SysOplogExample example);

    SysOplog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysOplog record, @Param("example") SysOplogExample example);

    int updateByExample(@Param("record") SysOplog record, @Param("example") SysOplogExample example);

    int updateByPrimaryKeySelective(SysOplog record);

    int updateByPrimaryKey(SysOplog record);
}