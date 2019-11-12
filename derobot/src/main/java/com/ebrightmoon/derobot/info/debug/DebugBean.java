package com.ebrightmoon.derobot.info.debug;

import android.util.Log;

import com.ebrightmoon.derobot.info.base.BaseBean;
import com.ebrightmoon.derobot.info.base.BaseData;

import org.json.JSONObject;

/**
 *
 */
public class DebugBean extends BaseBean {
    private static final String TAG = DebugBean.class.getSimpleName();

    /**
     * 是否开启了调试模式
     */
    private boolean isOpenDebug;

    /**
     * 是否是Debug版本
     */
    private boolean isDebugVersion;

    /**
     * 是否正在调试
     */
    private boolean isDebugging;

    /**
     * 读取id判断是否在调试
     */
    private boolean isReadProcStatus;

    /**
     * 是否可以打开位置模拟
     */
    private boolean isAllowMockLocation;

    public boolean isOpenDebug() {
        return isOpenDebug;
    }

    public void setOpenDebug(boolean openDebug) {
        isOpenDebug = openDebug;
    }

    public boolean isDebugVersion() {
        return isDebugVersion;
    }

    public void setDebugVersion(boolean debugVersion) {
        isDebugVersion = debugVersion;
    }

    public boolean isDebugging() {
        return isDebugging;
    }

    public void setDebugging(boolean debugging) {
        isDebugging = debugging;
    }

    public boolean isReadProcStatus() {
        return isReadProcStatus;
    }

    public void setReadProcStatus(boolean readProcStatus) {
        isReadProcStatus = readProcStatus;
    }

    public boolean isAllowMockLocation() {
        return isAllowMockLocation;
    }

    public void setAllowMockLocation(boolean allowMockLocation) {
        isAllowMockLocation = allowMockLocation;
    }

    @Override
    protected JSONObject toJSONObject() {
        try {
            jsonObject.put(BaseData.Debug.IS_OPEN_DEBUG, isEmpty(isOpenDebug));
            jsonObject.put(BaseData.Debug.IS_DEBUG_VERSION, isEmpty(isDebugVersion));
            jsonObject.put(BaseData.Debug.IS_DEBUGGING, isEmpty(isDebugging));
            jsonObject.put(BaseData.Debug.IS_READ_PROC_STATUS, isEmpty(isReadProcStatus));
            jsonObject.put(BaseData.Debug.IS_ALLOW_MOCK_LOCATION, isEmpty(isAllowMockLocation));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return super.toJSONObject();
    }
}
