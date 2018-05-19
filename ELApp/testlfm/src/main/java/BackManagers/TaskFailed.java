package BackManagers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//public class TaskFailed extends AppCompatActivity {
//    private volatile boolean IsFailed = false;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toast.makeText(this, "asassa", Toast.LENGTH_SHORT).show();
//    }
//}
public class TaskFailed extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "任务时吧不不不不", Toast.LENGTH_SHORT).show();

    }
}