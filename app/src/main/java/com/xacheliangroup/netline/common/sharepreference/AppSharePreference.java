package com.xacheliangroup.netline.common.sharepreference;


import com.xacheliangroup.netline.common.base.BaseSharePreference;
import com.xacheliangroup.netline.common.flag.Flag;

/**
 * Created by Afra55 on 2017/10/19.
 * Smile is the best name card.
 */

public class AppSharePreference extends BaseSharePreference {

    private static AppSharePreference instance = null;

    public static AppSharePreference getInstance() {
        if (instance == null) {
            synchronized (AppSharePreference.class) {
                instance = new AppSharePreference();
            }
        }
        return instance;
    }

    private AppSharePreference() {
        super();
    }
    public void setUserId(String userId){
        setValue(Flag.SHAREPREFERENCE.APP_USER_ID,userId);
    }
    public String getUserId(){
        return getStringValue(Flag.SHAREPREFERENCE.APP_USER_ID);
    }

    public void setTest(String Content){
        setValue(Flag.SHAREPREFERENCE.TEST,Content);
    }
    public String getTest(){
        return getStringValue(Flag.SHAREPREFERENCE.TEST);
    }

    public void setUserName(String userName){
        setValue(Flag.SHAREPREFERENCE.APP_USER_NAME,userName);
    }
    public String getUserName(){
        return getStringValue(Flag.SHAREPREFERENCE.APP_USER_NAME);
    }

    public void setUserSign(String userSign){
        setValue(Flag.SHAREPREFERENCE.APP_USER_SIGN,userSign);
    }
    public String getUserSign(){
        return getStringValue(Flag.SHAREPREFERENCE.APP_USER_SIGN);
    }

    public void setUserIcon(String userIcon){
        setValue(Flag.SHAREPREFERENCE.APP_USER_ICON,userIcon);
    }
    public String getUserIcon(){
        return getStringValue(Flag.SHAREPREFERENCE.APP_USER_ICON);
    }

    public boolean isAPKAlreadyOpen(String path) {
        return getBooleanValue("APK_ALREADY_OPED" + path, false);
    }

    public void setAPKAlreadyOpen(String path, boolean value) {
        setValue("APK_ALREADY_OPED" + path, value);
    }

    public void setAppHttpURl(String type){
        setValue(Flag.SHAREPREFERENCE.APP_HTTP_RUL,type);
    }

    public String getAppHttpURl(){
        return getStringValue(Flag.SHAREPREFERENCE.APP_HTTP_RUL);
    }

    public void setNetLineLocation(String latlng){
        setValue("NETLINE_LOCATION", latlng);
    }

    public String getNetLineLocation(){
        return getStringValue("NETLINE_LOCATION");
    }

    public void setNetLinePhoneNumber(String phoneNumber){
        setValue("NETLINE_PHONE_NUMBER", phoneNumber);
    }

    public String getNetLinePhoneNumber(){
        return getStringValue("NETLINE_PHONE_NUMBER");
    }

    public void setRId(String rid){
        setValue("RID_CHECK_ADD", rid);
    }
    public String getRId(){
        return getStringValue("RID_CHECK_ADD");
    }

    public int getNetLineUserListSize(){
        return  getIntValue("USER_LIST_SIZE",0);
    }
    public void setNetLineUserListSize(int size){
        setValue("USER_LIST_SIZE",size);
    }

    public boolean getNetLineIsLogin(){
        return getBooleanValue("NET_LINE_IS_LOGIN",false);
    }
    public void setNetLineIsLogin(boolean isLogin){
        setValue("NET_LINE_IS_LOGIN",isLogin);
    }
    public void  setNetLinePassWord(String ps){
        setValue("NET_LINE_PS",ps);

    }
    public String getNetLinePassWord(){
        return getStringValue("NET_LINE_PS");
    }

    public void setNetLineName(String lineName){
        setValue("NET_LINE_NAME",lineName);
    }
    public String getNetLineName(){
        return getStringValue("NET_LINE_NAME");
    }


}
