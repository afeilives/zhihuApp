package io.github.afei.zhihu.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by afei on 2016/10/3.
 */
public class UpdateInfoManager {
    public static List<OnUpdateInfoListener> listeners = new ArrayList<>();

    public interface OnUpdateInfoListener {
        void updateName();

        void updateAvatar();
    }

    public static void addOnUpdateInfoListener(OnUpdateInfoListener listener) {
        listeners.add(listener);
    }

    public static void updateInfo() {
        for (OnUpdateInfoListener listener : listeners) {
            listener.updateName();
            listener.updateAvatar();
        }
    }
}
