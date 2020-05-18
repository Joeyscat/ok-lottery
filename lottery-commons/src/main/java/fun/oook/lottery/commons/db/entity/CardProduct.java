package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-CardProduct")
public class CardProduct implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 奖品名称
     */
    @ApiModelProperty(value = "奖品名称")
    private String name;

    /**
     * 奖品图片
     */
    @ApiModelProperty(value = "奖品图片")
    private String pic;

    /**
     * 奖品简介
     */
    @ApiModelProperty(value = "奖品简介")
    private String info;

    /**
     * 奖品市场价
     */
    @ApiModelProperty(value = "奖品市场价")
    private BigDecimal price;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pic=").append(pic);
        sb.append(", info=").append(info);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}