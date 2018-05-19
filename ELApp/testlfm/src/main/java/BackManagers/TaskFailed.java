package BackManagers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TaskFailed extends BroadcastReceiver {
    private volatile boolean IsFailed = false;

    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
