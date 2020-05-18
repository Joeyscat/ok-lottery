package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-ViewGameCurinfo")
public class ViewGameCurinfo implements Serializable {
    @ApiModelProperty(value = "")
    private String id;

    @ApiModelProperty(value = "")
    private String title;

    @ApiModelProperty(value = "")
    private Date starttime;

    @ApiModelProperty(value = "")
    private Date endtime;

    @ApiModelProperty(value = "")
    private BigDecimal total;

    @ApiModelProperty(value = "")
    private Long hit;

    @ApiModelProperty(value = "")
    private String type;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getHit() {
        return hit;
    }

    public void setHit(Long hit) {
        this.hit = hit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", total=").append(total);
        sb.append(", hit=").append(hit);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}