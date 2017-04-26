package safeadmin.cs.com.forceofflinebybroadcast.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import safeadmin.cs.com.forceofflinebybroadcast.R;
import safeadmin.cs.com.forceofflinebybroadcast.util.RCode;

public class FirstActivity extends BaseActivity implements View.OnClickListener {

    private android.widget.TextView tvtext;
    private android.widget.Button offline;

    public static void startActivity(Context context){
        Intent intent = new Intent(context , FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }

    private void init() {
        this.offline = (Button) findViewById(R.id.offline);
        this.tvtext = (TextView) findViewById(R.id.tv_text);

        offline.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendBroadcast(new Intent(RCode.customAction));
    }
}
