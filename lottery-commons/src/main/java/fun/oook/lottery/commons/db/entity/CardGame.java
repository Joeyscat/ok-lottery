package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-CardGame")
public class CardGame implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 活动标题
     */
    @ApiModelProperty(value = "活动标题")
    private String title;

    /**
     * 活动图片
     */
    @ApiModelProperty(value = "活动图片")
    private String pic;

    /**
     * 活动简介
     */
    @ApiModelProperty(value = "活动简介")
    private String info;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date starttime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endtime;

    /**
     * 活动类型
     */
    @ApiModelProperty(value = "活动类型")
    private Byte type;

    /**
     * 活动状态
     */
    @ApiModelProperty(value = "活动状态")
    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", pic=").append(pic);
        sb.append(", info=").append(info);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}