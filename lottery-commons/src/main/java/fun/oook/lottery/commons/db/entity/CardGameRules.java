package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-CardGameRules")
public class CardGameRules implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 活动ID
     */
    @ApiModelProperty(value = "活动ID")
    private Integer gameid;

    /**
     * 用户等级
     */
    @ApiModelProperty(value = "用户等级")
    private Short userlevel;

    /**
     * 可抽奖次数（0：不设上限）
     */
    @ApiModelProperty(value = "可抽奖次数（0：不设上限）")
    private Short enterTimes;

    /**
     * 最大中奖次数（0：不设上限）
     */
    @ApiModelProperty(value = "最大中奖次数（0：不设上限）")
    private Short goalTimes;

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

    public Short getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(Short userlevel) {
        this.userlevel = userlevel;
    }

    public Short getEnterTimes() {
        return enterTimes;
    }

    public void setEnterTimes(Short enterTimes) {
        this.enterTimes = enterTimes;
    }

    public Short getGoalTimes() {
        return goalTimes;
    }

    public void setGoalTimes(Short goalTimes) {
        this.goalTimes = goalTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gameid=").append(gameid);
        sb.append(", userlevel=").append(userlevel);
        sb.append(", enterTimes=").append(enterTimes);
        sb.append(", goalTimes=").append(goalTimes);
        sb.append("]");
        return sb.toString();
    }
}