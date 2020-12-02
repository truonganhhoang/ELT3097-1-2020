package nhom6.com.duoihinhbatchu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import nhom6.com.duoihinhbatchu.R;
import nhom6.com.duoihinhbatchu.utils.Const;
import nhom6.com.duoihinhbatchu.utils.SharePreferenceUtils;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.adView)
    AdView adView;
    private int countQuestion;
    private int scoreRuby = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        initAdmob();
        initViews();
        initData();
    }

    private void initAdmob() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);
    }

    private void initData() {

    }

    private void initViews() {
        String result = getIntent().getStringExtra(Const.KEY_RESULT);
        countQuestion = getIntent().getIntExtra(Const.KEY_QUESTION, 1);
        scoreRuby = getIntent().getIntExtra(Const.KEY_RUBY, 0);
        tvResult.setText(result);
    }


    @OnClick({R.id.tv_result, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_result:
                break;
            case R.id.btn_next:
                Intent intent = new Intent(ResultActivity.this, PlayGameActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|
//                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
//                        Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Const.KEY_QUESTION, countQuestion);
                intent.putExtra(Const.KEY_RUBY, scoreRuby);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        SharePreferenceUtils.insertIntData(ResultActivity.this, Const.KEY_SHARE_RUBY, scoreRuby);
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }

        super.onDestroy();
    }
}
