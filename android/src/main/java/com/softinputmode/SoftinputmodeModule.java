package com.softinputmode;

import androidx.annotation.NonNull;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = SoftinputmodeModule.NAME)
public class SoftinputmodeModule extends ReactContextBaseJavaModule {
  public static final String NAME = "Softinputmode";

  public SoftinputmodeModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  private static final String ADJUST_PAN = "ADJUST_PAN";
  private static final String ADJUST_RESIZE = "ADJUST_RESIZE";

  private Handler handler = new Handler(getReactApplicationContext().getMainLooper()){
      
      @Override
      public void handleMessage(Message message) {
        Activity activity = getCurrentActivity();
        if (activity != null) {
            activity.getWindow().setSoftInputMode(message.what);
        }
      }

  };

  @Nullable
  @Override
  public Map<String, Object> getConstants() {
      final Map<String, Object> constants = new HashMap<>();
      constants.put(ADJUST_PAN, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
      constants.put(ADJUST_RESIZE, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
      return constants;
  }

  @ReactMethod
  public void set(int type) {
      Message msg = Message.obtain();
      msg.what = type;
      handler.sendMessageDelayed(msg, 0);
  }
}
