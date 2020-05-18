package fun.oook.lottery.commons.db.mapper;

import fun.oook.lottery.commons.db.entity.CardProductDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public interface GameLoadMapper {

    @Select("SELECT p.*, gp.amount " +
            "FROM card_product p " +
            "         INNER JOIN card_game_product gp " +
            "                    ON p.id = gp.productid " +
            "WHERE gp.gameid = #{gameId,jdbcType=INTEGER};")
    public List<CardProductDTO> getByGameId(final int gameId);
}
