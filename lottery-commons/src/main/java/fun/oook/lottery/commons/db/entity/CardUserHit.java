package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-CardUserHit")
public class CardUserHit implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Integer userid;

    /**
     * 活动ID
     */
    @ApiModelProperty(value = "活动ID")
    private Integer gameid;

    /**
     * 奖品ID
     */
    @ApiModelProperty(value = "奖品ID")
    private Integer productid;

    /**
     * 中奖时间
     */
    @ApiModelProperty(value = "中奖时间")
    private Date hittime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Date getHittime() {
        return hittime;
    }

    public void setHittime(Date hittime) {
        this.hittime = hittime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", gameid=").append(gameid);
        sb.append(", productid=").append(productid);
        sb.append(", hittime=").append(hittime);
        sb.append("]");
        return sb.toString();
    }
}