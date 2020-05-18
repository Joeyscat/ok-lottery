package fun.oook.lottery.commons.db.entity;

import org.springframework.beans.BeanUtils;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
public class CardUserDTO extends CardUser {

    private Integer games;
    private Integer products;

    public CardUserDTO(final CardUser user) {
        BeanUtils.copyProperties(user, this);
    }

    public CardUserDTO() {
        super();
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(final Integer games) {
        this.games = games;
    }

    public Integer getProducts() {
        return products;
    }

    public void setProducts(final Integer products) {
        this.products = products;
    }
}
