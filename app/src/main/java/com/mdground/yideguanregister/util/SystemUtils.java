package com.mdground.yideguanregister.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by yoghourt on 12/8/15.
 */
public class SystemUtils {
    public static void dialPhone(Activity activity, String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri
                .parse("tel:" + phoneNum));
        activity.startActivity(intent);
    }
}
