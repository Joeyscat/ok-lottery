package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.ZcurdField;
import fun.oook.lottery.commons.db.entity.ZcurdFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ZcurdFieldMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    long countByExample(ZcurdFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    int deleteByExample(ZcurdFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    @Delete({
        "delete from zcurd_field",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    @Insert({
        "insert into zcurd_field (head_id, field_name, ",
        "column_name, column_length, ",
        "data_type, input_type, ",
        "is_show_list, is_allow_detail, ",
        "is_allow_add, is_allow_update, ",
        "is_search, is_allow_null, ",
        "dict_sql, order_num, ",
        "search_type, is_sum, ",
        "default_value, create_time)",
        "values (#{headId,jdbcType=INTEGER}, #{fieldName,jdbcType=VARCHAR}, ",
        "#{columnName,jdbcType=VARCHAR}, #{columnLength,jdbcType=INTEGER}, ",
        "#{dataType,jdbcType=VARCHAR}, #{inputType,jdbcType=VARCHAR}, ",
        "#{isShowList,jdbcType=INTEGER}, #{isAllowDetail,jdbcType=INTEGER}, ",
        "#{isAllowAdd,jdbcType=INTEGER}, #{isAllowUpdate,jdbcType=INTEGER}, ",
        "#{isSearch,jdbcType=INTEGER}, #{isAllowNull,jdbcType=INTEGER}, ",
        "#{dictSql,jdbcType=VARCHAR}, #{orderNum,jdbcType=INTEGER}, ",
        "#{searchType,jdbcType=INTEGER}, #{isSum,jdbcType=INTEGER}, ",
        "#{defaultValue,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ZcurdField record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    int insertSelective(ZcurdField record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    List<ZcurdField> selectByExample(ZcurdFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, head_id, field_name, column_name, column_length, data_type, input_type, ",
        "is_show_list, is_allow_detail, is_allow_add, is_allow_update, is_search, is_allow_null, ",
        "dict_sql, order_num, search_type, is_sum, default_value, create_time",
        "from zcurd_field",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("fun.oook.lottery.commons.db.mapper.ZcurdFieldMapper.BaseResultMap")
    ZcurdField selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ZcurdField record, @Param("example") ZcurdFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ZcurdField record, @Param("example") ZcurdFieldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ZcurdField record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zcurd_field
     *
     * @mbg.generated
     */
    @Update({
        "update zcurd_field",
        "set head_id = #{headId,jdbcType=INTEGER},",
          "field_name = #{fieldName,jdbcType=VARCHAR},",
          "column_name = #{columnName,jdbcType=VARCHAR},",
          "column_length = #{columnLength,jdbcType=INTEGER},",
          "data_type = #{dataType,jdbcType=VARCHAR},",
          "input_type = #{inputType,jdbcType=VARCHAR},",
          "is_show_list = #{isShowList,jdbcType=INTEGER},",
          "is_allow_detail = #{isAllowDetail,jdbcType=INTEGER},",
          "is_allow_add = #{isAllowAdd,jdbcType=INTEGER},",
          "is_allow_update = #{isAllowUpdate,jdbcType=INTEGER},",
          "is_search = #{isSearch,jdbcType=INTEGER},",
          "is_allow_null = #{isAllowNull,jdbcType=INTEGER},",
          "dict_sql = #{dictSql,jdbcType=VARCHAR},",
          "order_num = #{orderNum,jdbcType=INTEGER},",
          "search_type = #{searchType,jdbcType=INTEGER},",
          "is_sum = #{isSum,jdbcType=INTEGER},",
          "default_value = #{defaultValue,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ZcurdField record);
}