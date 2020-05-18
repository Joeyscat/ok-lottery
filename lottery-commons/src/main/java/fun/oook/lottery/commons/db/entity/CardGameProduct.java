package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-CardGameProduct")
public class CardGameProduct implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 活动id
     */
    @ApiModelProperty(value = "活动id")
    private Integer gameid;

    /**
     * 奖品id
     */
    @ApiModelProperty(value = "奖品id")
    private Integer productid;

    /**
     * 奖品数量
     */
    @ApiModelProperty(value = "奖品数量")
    private Short amount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gameid=").append(gameid);
        sb.append(", productid=").append(productid);
        sb.append(", amount=").append(amount);
        sb.append("]");
        return sb.toString();
    }
}