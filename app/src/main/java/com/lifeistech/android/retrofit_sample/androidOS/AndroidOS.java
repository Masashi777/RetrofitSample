package com.lifeistech.android.retrofit_sample.androidOS;

/**
 * Created by Masashi Hamaguchi on 2017/02/07.
 */

public class AndroidOS {

    public AndroidOS() {

    }

    public void create(AndroidOSConnect connect, AndroidOSConnect.AndroidListener listener) {
        createAndroidOS(connect, "11.0", "bbb", "aaa", listener);
    }

    public void createAndroidOS(AndroidOSConnect connect, String version, String codename, String reference, final AndroidOSConnect.AndroidListener listener) {
        connect.request(version, codename, reference, listener);
    }

    public void delete(AndroidOSConnect connect, String id,final AndroidOSConnect.AndroidDeleteListener listener) {
        connect.delete(id,listener);
    }

    public void showall(AndroidOSConnect connect, final AndroidOSConnect.AndroidListener listener) {
        connect.showall(listener);
    }

}
