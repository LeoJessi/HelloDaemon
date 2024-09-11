package top.jessi.daemonsimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


import top.jessi.hellodaemon.DaemonEnv;
import top.jessi.hellodaemon.IntentWrapper;

public class MainActivity extends Activity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        int vId = v.getId();
        if (vId == R.id.btn_start) {
            TraceServiceImpl.sShouldStopService = false;
            DaemonEnv.startServiceMayBind(TraceServiceImpl.class);
        } else if (vId == R.id.btn_white) {
            IntentWrapper.whiteListMatters(this, "轨迹跟踪服务的持续运行");
        } else if (vId == R.id.btn_stop) {
            TraceServiceImpl.stopService();
        }
    }

    // 防止华为机型未加入白名单时按返回键回到桌面再锁屏后几秒钟进程被杀
    public void onBackPressed() {
        IntentWrapper.onBackPressed(this);
    }
}
