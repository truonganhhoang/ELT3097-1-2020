package duoihinhbatchu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import nhom6.com.duoihinhbatchu.R;
import nhom6.com.duoihinhbatchu.activity.PlayGameActivity;
import nhom6.com.duoihinhbatchu.utils.Const;
import nhom6.com.duoihinhbatchu.utils.PlayMusic;
import nhom6.com.duoihinhbatchu.utils.SharePreferenceUtils;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_play)
    Button btnPlay;
    @BindView(R.id.btn_game_differ)
    Button btnGameDiffer;
    @BindView(R.id.image)
    KenBurnsView image;
    @BindView(R.id.adView)
    AdView adView;
    @BindView(R.id.img_ruby)
    ImageView imgRuby;
    @BindView(R.id.tv_ruby)
    TextView tvRuby;
    @BindView(R.id.fram_top)
    FrameLayout framTop;
    private int scoreRuby = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        scoreRuby = SharePreferenceUtils.getIntData(MainActivity.this, Const.KEY_SHARE_RUBY);
        tvRuby.setText("" + scoreRuby);
        RandomTransitionGenerator generator = new RandomTransitionGenerator(2000, new AccelerateDecelerateInterpolator());
        image.setTransitionGenerator(generator);
    }

    private void initViews() {
        Animation animation = new TranslateAnimation(-800, 0, 0, 0);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setInterpolator(new BounceInterpolator());
        btnPlay.startAnimation(animation);

        Animation animation1 = new TranslateAnimation(800, 0, 0, 0);
        animation1.setDuration(1000);
        animation1.setFillAfter(true);
        animation1.setInterpolator(new BounceInterpolator());
        btnGameDiffer.startAnimation(animation1);
    }

    @OnClick({R.id.btn_play, R.id.btn_game_differ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                PlayMusic.playClick(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, PlayGameActivity.class);
                intent.putExtra(Const.KEY_RUBY, scoreRuby);
                startActivity(intent);
                break;
            case R.id.btn_game_differ:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.dong.luong.ailatrieuphu"));
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
        scoreRuby = SharePreferenceUtils.getIntData(MainActivity.this, Const.KEY_SHARE_RUBY);
        tvRuby.setText("" + scoreRuby);
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
