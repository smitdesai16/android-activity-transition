package me.creatorguy.androidactivitytransition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivMainClock;
    TextView tvMainClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout clMain = findViewById(R.id.clMain);
        ivMainClock = findViewById(R.id.ivMainClock);
        tvMainClock = findViewById(R.id.tvMainClock);
        clMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clMain:
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair(ivMainClock, "ivSecondClock");
                pairs[1] = new Pair(tvMainClock, "tvSecondClock");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
                Intent intent = new Intent(this, SecondaryActivity.class);
                startActivity(intent, activityOptions.toBundle());
                break;
        }
    }
}