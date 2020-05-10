package fun.oook.lottery.commons.db.entity;

import java.io.Serializable;
import java.util.Date;

public class SysRoleDatarule implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_datarule.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_datarule.role_id
     *
     * @mbg.generated
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_datarule.datarule_id
     *
     * @mbg.generated
     */
    private Integer dataruleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_datarule.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_role_datarule
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_datarule.id
     *
     * @return the value of sys_role_datarule.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_datarule.id
     *
     * @param id the value for sys_role_datarule.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_datarule.role_id
     *
     * @return the value of sys_role_datarule.role_id
     *
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_datarule.role_id
     *
     * @param roleId the value for sys_role_datarule.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_datarule.datarule_id
     *
     * @return the value of sys_role_datarule.datarule_id
     *
     * @mbg.generated
     */
    public Integer getDataruleId() {
        return dataruleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_datarule.datarule_id
     *
     * @param dataruleId the value for sys_role_datarule.datarule_id
     *
     * @mbg.generated
     */
    public void setDataruleId(Integer dataruleId) {
        this.dataruleId = dataruleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_datarule.create_time
     *
     * @return the value of sys_role_datarule.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_datarule.create_time
     *
     * @param createTime the value for sys_role_datarule.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}