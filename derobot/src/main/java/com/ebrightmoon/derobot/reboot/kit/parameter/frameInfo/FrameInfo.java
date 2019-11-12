package com.ebrightmoon.derobot.reboot.kit.parameter.frameInfo;

import android.content.Context;
import android.content.Intent;

import com.ebrightmoon.derobot.R;
import com.ebrightmoon.derobot.reboot.constant.BundleKey;
import com.ebrightmoon.derobot.reboot.constant.FragmentIndex;
import com.ebrightmoon.derobot.reboot.kit.Category;
import com.ebrightmoon.derobot.reboot.kit.IKit;
import com.ebrightmoon.derobot.reboot.ui.UniversalActivity;

/**
 *  on 2018/9/13.
 */

public class FrameInfo implements IKit {

    @Override
    public int getCategory() {
        return Category.PERFORMANCE;
    }

    @Override
    public int getName() {
        return R.string.dk_kit_frame_info;
    }

    @Override
    public int getIcon() {
        return R.drawable.dk_frame_hist;
    }

    @Override
    public void onClick(Context context) {
        Intent intent = new Intent(context, UniversalActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(BundleKey.FRAGMENT_INDEX, FragmentIndex.FRAGMENT_FRAME_INFO);
        context.startActivity(intent);
    }

    @Override
    public void onAppInit(Context context) {

    }

}
