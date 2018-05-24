package Story;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.bean.DateType;
import com.example.lenovo.elapp.R;

import Activitys.MainActivity;
import Tmp_lib.myDatePickDialog;
import cn.iwgang.countdownview.CountdownView;

/**
 * Do task(time Countdown)
 * button(Next!)-->The second shot
 * */
public class storySecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_activity_second);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        Button button = (Button)findViewById(R.id.toCount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatePickDialog dialog = new myDatePickDialog(storySecondActivity.this);
                //设置上下年分限制
                dialog.setYearLimt(5);
                //设置标题
                dialog.setTitle("请设置你的任务时间吧~~");
                //设置类型
                dialog.setType(DateType.TYPE_HM);
                //设置消息体的显示格式，日期格式
                dialog.setMessageFormat("yyyy-MM-dd E hh:mm");
                //设置选择回调
                dialog.setOnChangeLisener(null);
                //设置点击确定按钮回调
                dialog.setOnSureLisener(null);
                dialog.show();
            }
        });
    }


    /**Called when the user clicks the Send button*/
    public void sendMessage(View view){
        Intent intent =  new Intent(this,storyThirdActivity.class);
        startActivity(intent);
    }


}
