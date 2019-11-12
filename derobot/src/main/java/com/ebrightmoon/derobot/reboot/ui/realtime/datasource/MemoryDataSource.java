package com.ebrightmoon.derobot.reboot.ui.realtime.datasource;

import com.ebrightmoon.derobot.reboot.kit.common.PerformanceDataManager;
import com.ebrightmoon.derobot.reboot.ui.realtime.widget.LineChart;

public class MemoryDataSource implements IDataSource {
    private float mMaxRam;

    public MemoryDataSource() {
        mMaxRam = (float) (Runtime.getRuntime().maxMemory() * 1.0 / (1024 * 1024));
    }

    @Override
    public LineChart.LineData createData() {
        float info = PerformanceDataManager.getInstance().getLastMemoryInfo();
        return LineChart.LineData.obtain(info / mMaxRam * 100, Math.round(info) + "MB");
    }
}
