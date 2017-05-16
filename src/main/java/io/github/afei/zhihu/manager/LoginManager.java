package io.github.afei.zhihu.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by afei on 2016/10/3.
 */
public class LoginManager {
    public interface OnLoginListener {
        void login();

        void logout();
    }

    public static List<OnLoginListener> listeners = new ArrayList<>();

    public static void addOnLoginListener(OnLoginListener listener) {
        listeners.add(listener);
    }

    public static void login() {
        for (OnLoginListener listener : listeners) {
            listener.login();
        }
    }
    public static void logout(){
        for (OnLoginListener listener : listeners){
            listener.logout();
        }
    }
    public static void removeOnLoginListener(OnLoginListener listener){
        listeners.remove(listener);
    }
}
