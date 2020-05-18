package fun.oook.lottery.commons.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "fun-oook-lottery-commons-db-entity-ViewCardUserHit")
public class ViewCardUserHit implements Serializable {
    @ApiModelProperty(value = "")
    private String id;

    @ApiModelProperty(value = "")
    private String title;

    @ApiModelProperty(value = "")
    private String uname;

    @ApiModelProperty(value = "")
    private String realname;

    @ApiModelProperty(value = "")
    private String idcard;

    @ApiModelProperty(value = "")
    private String phone;

    @ApiModelProperty(value = "")
    private String name;

    @ApiModelProperty(value = "")
    private BigDecimal price;

    @ApiModelProperty(value = "")
    private Date hittime;

    @ApiModelProperty(value = "")
    private Integer userid;

    @ApiModelProperty(value = "")
    private Integer gameid;

    @ApiModelProperty(value = "")
    private Integer productid;

    @ApiModelProperty(value = "")
    private String level;

    @ApiModelProperty(value = "")
    private String type;

    @ApiModelProperty(value = "")
    private Date starttime;

    @ApiModelProperty(value = "")
    private Date endtime;

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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getHittime() {
        return hittime;
    }

    public void setHittime(Date hittime) {
        this.hittime = hittime;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", uname=").append(uname);
        sb.append(", realname=").append(realname);
        sb.append(", idcard=").append(idcard);
        sb.append(", phone=").append(phone);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", hittime=").append(hittime);
        sb.append(", userid=").append(userid);
        sb.append(", gameid=").append(gameid);
        sb.append(", productid=").append(productid);
        sb.append(", level=").append(level);
        sb.append(", type=").append(type);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append("]");
        return sb.toString();
    }
}