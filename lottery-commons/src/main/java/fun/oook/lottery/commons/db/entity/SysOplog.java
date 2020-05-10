package fun.oook.lottery.commons.db.entity;

import java.io.Serializable;
import java.util.Date;

public class SysOplog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_oplog.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_oplog.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_oplog.op_content
     *
     * @mbg.generated
     */
    private String opContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_oplog.ip
     *
     * @mbg.generated
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_oplog.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_oplog
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_oplog.id
     *
     * @return the value of sys_oplog.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_oplog.id
     *
     * @param id the value for sys_oplog.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_oplog.user_id
     *
     * @return the value of sys_oplog.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_oplog.user_id
     *
     * @param userId the value for sys_oplog.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_oplog.op_content
     *
     * @return the value of sys_oplog.op_content
     *
     * @mbg.generated
     */
    public String getOpContent() {
        return opContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_oplog.op_content
     *
     * @param opContent the value for sys_oplog.op_content
     *
     * @mbg.generated
     */
    public void setOpContent(String opContent) {
        this.opContent = opContent == null ? null : opContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_oplog.ip
     *
     * @return the value of sys_oplog.ip
     *
     * @mbg.generated
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_oplog.ip
     *
     * @param ip the value for sys_oplog.ip
     *
     * @mbg.generated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_oplog.create_time
     *
     * @return the value of sys_oplog.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_oplog.create_time
     *
     * @param createTime the value for sys_oplog.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}