package com.hyp.crm.settings.domain;

/**
 * @author HYP
 * @create 2020-11-15 19:02
 */
public class User {
    /*
    关于字符串中表现的日期及时间我们在市场上常用的有两种方式日期,
        年月日
             yyyy-MM-dd 10位字符串
        日期+时间:年月日时分秒19位字符串
             yyyy-MM-dd HH : mm : sS

    */
    /*
    * 关于登录：
        验证账号和密码
        User user =执行sqL语句select * from tbl_user where LoginAct=? and LoginPwd=?user对象为null，说明账号密码错误
        如果user对象不为null，说明账号密码正确需要继续向下验证其他的字段信息
        从user中get到
        expireTime 验证失效时间
        LockState 验证锁定状态
        allowIps  验证浏览器端的IP地址是否有效
     */
    private String id;//编号，主键
    private String name;//用户的真实姓名
    private String loginPwd;//登录密码
    private String email;//邮箱
    private String expireTime;//失效时间 19位字符串
    private String lockState;//锁定状态 0：锁定  1：启用
    private String deptno;//部门编号
    private String allowIps;//允许访问的IP地址
    private String createTime;//创建时间 19位的字符串
    private String createBy;//创建人
    private String editTime;//修改时间  19位字符串
    private String editBy;//修改人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowlps) {
        this.allowIps = allowlps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}
