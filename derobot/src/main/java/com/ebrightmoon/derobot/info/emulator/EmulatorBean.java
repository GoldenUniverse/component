package com.ebrightmoon.derobot.info.emulator;

import android.util.Log;

import com.ebrightmoon.derobot.info.base.BaseBean;
import com.ebrightmoon.derobot.info.base.BaseData;

import org.json.JSONObject;

/**
 *
 */
public class EmulatorBean extends BaseBean {
    private static final String TAG = EmulatorBean.class.getSimpleName();

    /**
     * build
     */
    private boolean checkBuild;

    /**
     * 包名修改
     */
    private boolean checkPkg;

    /**
     * 管道检测
     */
    private boolean checkPipes;

    /**
     * 驱动程序检测
     */
    private boolean checkQEmuDriverFile;

    /**
     * 光传感器检测
     */
    private boolean checkHasLightSensorManager;

    /**
     * cpu架构检测
     */
    private boolean checkCpuInfo;

    public boolean isCheckBuild() {
        return checkBuild;
    }

    public void setCheckBuild(boolean checkBuild) {
        this.checkBuild = checkBuild;
    }

    public boolean isCheckPkg() {
        return checkPkg;
    }

    public void setCheckPkg(boolean checkPkg) {
        this.checkPkg = checkPkg;
    }

    public boolean isCheckPipes() {
        return checkPipes;
    }

    public void setCheckPipes(boolean checkPipes) {
        this.checkPipes = checkPipes;
    }

    public boolean isCheckQEmuDriverFile() {
        return checkQEmuDriverFile;
    }

    public void setCheckQEmuDriverFile(boolean checkQEmuDriverFile) {
        this.checkQEmuDriverFile = checkQEmuDriverFile;
    }

    public boolean isCheckHasLightSensorManager() {
        return checkHasLightSensorManager;
    }

    public void setCheckHasLightSensorManager(boolean checkHasLightSensorManager) {
        this.checkHasLightSensorManager = checkHasLightSensorManager;
    }

    public boolean isCheckCpuInfo() {
        return checkCpuInfo;
    }

    public void setCheckCpuInfo(boolean checkCpuInfo) {
        this.checkCpuInfo = checkCpuInfo;
    }

    @Override
    protected JSONObject toJSONObject() {
        try {
            jsonObject.put(BaseData.Emulator.CHECK_BUILD, isEmpty(checkBuild));
            jsonObject.put(BaseData.Emulator.CHECK_PKG, isEmpty(checkPkg));
            jsonObject.put(BaseData.Emulator.CHECK_PIPES, isEmpty(checkPipes));
            jsonObject.put(BaseData.Emulator.CHECK_QEMU_DRIVER_FILE, isEmpty(checkQEmuDriverFile));
            jsonObject.put(BaseData.Emulator.CHECK_HAS_LIGHT_SENSOR_MANAGER, isEmpty(checkHasLightSensorManager));
            jsonObject.put(BaseData.Emulator.CHECK_CPU_INFO, isEmpty(checkCpuInfo));

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return super.toJSONObject();
    }
}
