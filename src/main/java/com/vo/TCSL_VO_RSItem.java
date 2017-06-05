package com.vo;
import java.util.List;
/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
public class TCSL_VO_RSItem {
    //房态生效时间
    private String date;
    //PMS房型代码
    private String invTypeCode;
    //价格代码，参考《价格代码套系》
    private String ratePlanCode;
    /*星期一：该天是否有效
     * 0：不生效
     * 1：生效
     */
    private String mon;
    /*星期二：该天是否有效
     * 0：不生效
     * 1：生效
     */
    private String tue;
    /*星期三：该天是否有效
     * 0：不生效
     * 1：生效
     */
    private String weds;
    /*星期四：该天是否有效
     * 0：不生效
     * 1：生效
     */
    private String thur;
    /*星期五：该天是否有效
     * 0：不生效
     * 1：生效
     */
    private String fri;
    /*星期六：该天是否有效
     * 0：不生效
     * 1：生效
     */
    private String sat;
    /*星期日：该天是否有效
     * 0：不生效
     * 1：生效
     */
    private String sun;
    /*
     *渠道代码（携程：CTRIP，艺龙：ELONG，去哪儿:QUNAR)。
     * 该节点支持1个或多个，表示分别控制已上线的不同渠道房态
     */
    private List<String> destinationSystemCodes;
    //权限默认为Master
    private String restriction;
    /*
     *房间状态
     * （开放：Open ，关闭：Close ）
     */
    private String status;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInvTypeCode() {
        return invTypeCode;
    }

    public void setInvTypeCode(String invTypeCode) {
        this.invTypeCode = invTypeCode;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWeds() {
        return weds;
    }

    public void setWeds(String weds) {
        this.weds = weds;
    }

    public String getThur() {
        return thur;
    }

    public void setThur(String thur) {
        this.thur = thur;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public List<String> getDestinationSystemCodes() {
        return destinationSystemCodes;
    }

    public void setDestinationSystemCodes(List<String> destinationSystemCodes) {
        this.destinationSystemCodes = destinationSystemCodes;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
