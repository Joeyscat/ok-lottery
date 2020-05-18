package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-ViewGameHitNum")
public class ViewGameHitNum implements Serializable {
    @ApiModelProperty(value = "")
    private String id;

    @ApiModelProperty(value = "")
    private Integer gameid;

    @ApiModelProperty(value = "")
    private Long num;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gameid=").append(gameid);
        sb.append(", num=").append(num);
        sb.append("]");
        return sb.toString();
    }
}