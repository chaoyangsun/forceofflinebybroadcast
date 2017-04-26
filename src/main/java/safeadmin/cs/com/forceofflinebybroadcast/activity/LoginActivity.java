package safeadmin.cs.com.forceofflinebybroadcast.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import safeadmin.cs.com.forceofflinebybroadcast.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button idbtn;

    public static void startActivity(Context context){
        Intent intent = new Intent(context , LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.idbtn = (Button) findViewById(R.id.id_btn);
        idbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FirstActivity.startActivity(this);
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
