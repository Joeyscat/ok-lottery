package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardGameRules;
import fun.oook.lottery.commons.db.entity.CardGameRulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CardGameRulesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    long countByExample(CardGameRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    int deleteByExample(CardGameRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    @Delete({
        "delete from card_game_rules",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    @Insert({
        "insert into card_game_rules (gameid, userlevel, ",
        "enter_times, goal_times)",
        "values (#{gameid,jdbcType=INTEGER}, #{userlevel,jdbcType=SMALLINT}, ",
        "#{enterTimes,jdbcType=SMALLINT}, #{goalTimes,jdbcType=SMALLINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CardGameRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    int insertSelective(CardGameRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    List<CardGameRules> selectByExample(CardGameRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, gameid, userlevel, enter_times, goal_times",
        "from card_game_rules",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("fun.oook.lottery.commons.db.mapper.CardGameRulesMapper.BaseResultMap")
    CardGameRules selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CardGameRules record, @Param("example") CardGameRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CardGameRules record, @Param("example") CardGameRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CardGameRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_game_rules
     *
     * @mbg.generated
     */
    @Update({
        "update card_game_rules",
        "set gameid = #{gameid,jdbcType=INTEGER},",
          "userlevel = #{userlevel,jdbcType=SMALLINT},",
          "enter_times = #{enterTimes,jdbcType=SMALLINT},",
          "goal_times = #{goalTimes,jdbcType=SMALLINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardGameRules record);
}