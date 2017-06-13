package com.vo;
import com.po.TCSL_PO_ProductActivity;
import com.po.TCSL_PO_RsEqualize;

import java.util.List;
/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
public class TCSL_VO_RSItem {
    //房态生效开始时间
    private String start;
    //房态生效结束时间
    private String end;
    //PMS房型代码
    private String invTypeCode;
    //线下房态方案编码
    private String ratePlanCode;
    //线下房态方案名称
    private String ratePlanName;
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
    /**
     * 房态方案删除标志
     * 0:房态方案删除
     * 1:房态方案不删除
     */
    private String removeFlg;

    public TCSL_VO_RSItem(){};

    public TCSL_VO_RSItem (TCSL_PO_RsEqualize poRsEqualize){
        this.start = poRsEqualize.getDBTIME();
        this.end = poRsEqualize.getDETIME();
        this.invTypeCode = poRsEqualize.getCROOMTYPEID();
        this.ratePlanCode = poRsEqualize.getCACTIVITYID();
        this.ratePlanName = poRsEqualize.getCACTIVITYNAME(); //线上活动方案名称
        this.mon = "1";
        this.tue = "1";
        this.weds = "1";
        this.thur = "1";
        this.fri = "1";
        this.sat = "1";
        this.sun = "1";
        this.restriction = "Master";
        this.status = poRsEqualize.getIROOMSTATUS();
    }
    public TCSL_VO_RSItem(TCSL_VO_RSItem rsItem,TCSL_PO_ProductActivity activity){
        this.start = rsItem.getStart();
        this.end = rsItem.getEnd();
        this.invTypeCode = rsItem.getInvTypeCode();
        this.ratePlanCode = activity.getCACTIVITYID(); //线上活动方案编码
        this.ratePlanName = activity.getCACTIVITYNAME(); //线上活动方案名称
        this.mon = rsItem.getMon();
        this.tue = rsItem.getTue();
        this.weds = rsItem.getWeds();
        this.thur = rsItem.getThur();
        this.fri = rsItem.getFri();
        this.sat = rsItem.getSat();
        this.sun = rsItem.getSun();
        this.destinationSystemCodes = rsItem.getDestinationSystemCodes();
        this.restriction = rsItem.getRestriction();
        this.status = rsItem.getStatus();
        this.removeFlg = rsItem.getRemoveFlg();
    }

    public String getRemoveFlg() {
        return removeFlg;
    }

    public void setRemoveFlg(String removeFlg) {
        this.removeFlg = removeFlg;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
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

    /**
     * 对象相等判断条件
     * 房态生效时间 start
     * 房态结束时间 end
     * 房型 invTypeCode
     * 线上活动方案编码 ratePlanCode
     * 线上活动方案名称 ratePlanName
     * 权限 restriction
     * 房态 status
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TCSL_VO_RSItem)) return false;

        TCSL_VO_RSItem rsItem = (TCSL_VO_RSItem) o;

        if (start != null ? !start.equals(rsItem.start) : rsItem.start != null) return false;
        if (end != null ? !end.equals(rsItem.end) : rsItem.end != null) return false;
        if (invTypeCode != null ? !invTypeCode.equals(rsItem.invTypeCode) : rsItem.invTypeCode != null) return false;
        if (ratePlanCode != null ? !ratePlanCode.equals(rsItem.ratePlanCode) : rsItem.ratePlanCode != null)
            return false;
        if (ratePlanName != null ? !ratePlanName.equals(rsItem.ratePlanName) : rsItem.ratePlanName != null)
            return false;
        if (restriction != null ? !restriction.equals(rsItem.restriction) : rsItem.restriction != null) return false;
        return status != null ? status.equals(rsItem.status) : rsItem.status == null;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (invTypeCode != null ? invTypeCode.hashCode() : 0);
        result = 31 * result + (ratePlanCode != null ? ratePlanCode.hashCode() : 0);
        result = 31 * result + (ratePlanName != null ? ratePlanName.hashCode() : 0);
        result = 31 * result + (restriction != null ? restriction.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
