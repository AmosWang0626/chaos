package cn.amos.encrypt;

/**
 * @project: demo-java
 * @date: 2017/10/16
 * @author: DaoYuanWang
 */
public class PushKeyEntity {

    private String phoneNo;
    private String salt;
    private String pushKey;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPushKey() {
        return pushKey;
    }

    public void setPushKey(String pushKey) {
        this.pushKey = pushKey;
    }
}
