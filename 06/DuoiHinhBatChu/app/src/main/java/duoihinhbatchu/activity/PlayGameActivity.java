package nhom6.com.duoihinhbatchu.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import duoihinhbatchu.MainActivity;
import nhom6.com.duoihinhbatchu.R;
import nhom6.com.duoihinhbatchu.model.Question;
import nhom6.com.duoihinhbatchu.utils.Const;
import nhom6.com.duoihinhbatchu.utils.DatabaseManager;
import nhom6.com.duoihinhbatchu.utils.PlayMusic;
import nhom6.com.duoihinhbatchu.utils.SharePreferenceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PlayGameActivity extends AppCompatActivity implements RewardedVideoAdListener {

    @BindView(R.id.btn_back)
    RelativeLayout btnBack;
    @BindView(R.id.btn_help)
    RelativeLayout btnHelp;
    @BindView(R.id.btn_score)
    RelativeLayout btnScore;
    @BindView(R.id.btn_share)
    RelativeLayout btnShare;
    @BindView(R.id.img_ruby)
    ImageView imgRuby;
    @BindView(R.id.tv_ruby)
    TextView tvRuby;
    @BindView(R.id.linear_top)
    LinearLayout linearTop;
    @BindView(R.id.txt_dapan_1)
    TextView txtDapan1;
    @BindView(R.id.dapan_1)
    LinearLayout dapan1;
    @BindView(R.id.txt_dapan_2)
    TextView txtDapan2;
    @BindView(R.id.dapan_2)
    LinearLayout dapan2;
    @BindView(R.id.txt_dapan_3)
    TextView txtDapan3;
    @BindView(R.id.dapan_3)
    LinearLayout dapan3;
    @BindView(R.id.txt_dapan_4)
    TextView txtDapan4;
    @BindView(R.id.dapan_4)
    LinearLayout dapan4;
    @BindView(R.id.txt_dapan_5)
    TextView txtDapan5;
    @BindView(R.id.dapan_5)
    LinearLayout dapan5;
    @BindView(R.id.txt_dapan_6)
    TextView txtDapan6;
    @BindView(R.id.dapan_6)
    LinearLayout dapan6;
    @BindView(R.id.txt_dapan_7)
    TextView txtDapan7;
    @BindView(R.id.dapan_7)
    LinearLayout dapan7;
    @BindView(R.id.txt_dapan_8)
    TextView txtDapan8;
    @BindView(R.id.dapan_8)
    LinearLayout dapan8;
    @BindView(R.id.txt_dapan_9)
    TextView txtDapan9;
    @BindView(R.id.dapan_9)
    LinearLayout dapan9;
    @BindView(R.id.txt_dapan_10)
    TextView txtDapan10;
    @BindView(R.id.dapan_10)
    LinearLayout dapan10;
    @BindView(R.id.txt_dapan_11)
    TextView txtDapan11;
    @BindView(R.id.dapan_11)
    LinearLayout dapan11;
    @BindView(R.id.txt_dapan_12)
    TextView txtDapan12;
    @BindView(R.id.dapan_12)
    LinearLayout dapan12;
    @BindView(R.id.txt_dapan_13)
    TextView txtDapan13;
    @BindView(R.id.dapan_13)
    LinearLayout dapan13;
    @BindView(R.id.txt_dapan_14)
    TextView txtDapan14;
    @BindView(R.id.dapan_14)
    LinearLayout dapan14;
    @BindView(R.id.layout_dapan)
    LinearLayout layoutDapan;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.txt_goiy_1)
    TextView txtGoiy1;
    @BindView(R.id.goiy_1)
    LinearLayout goiy1;
    @BindView(R.id.txt_goiy_2)
    TextView txtGoiy2;
    @BindView(R.id.goiy_2)
    LinearLayout goiy2;
    @BindView(R.id.txt_goiy_3)
    TextView txtGoiy3;
    @BindView(R.id.goiy_3)
    LinearLayout goiy3;
    @BindView(R.id.txt_goiy_4)
    TextView txtGoiy4;
    @BindView(R.id.goiy_4)
    LinearLayout goiy4;
    @BindView(R.id.txt_goiy_5)
    TextView txtGoiy5;
    @BindView(R.id.goiy_5)
    LinearLayout goiy5;
    @BindView(R.id.txt_goiy_6)
    TextView txtGoiy6;
    @BindView(R.id.goiy_6)
    LinearLayout goiy6;
    @BindView(R.id.txt_goiy_7)
    TextView txtGoiy7;
    @BindView(R.id.goiy_7)
    LinearLayout goiy7;
    @BindView(R.id.txt_goiy_8)
    TextView txtGoiy8;
    @BindView(R.id.goiy_8)
    LinearLayout goiy8;
    @BindView(R.id.txt_goiy_9)
    TextView txtGoiy9;
    @BindView(R.id.goiy_9)
    LinearLayout goiy9;
    @BindView(R.id.txt_goiy_10)
    TextView txtGoiy10;
    @BindView(R.id.goiy_10)
    LinearLayout goiy10;
    @BindView(R.id.txt_goiy_11)
    TextView txtGoiy11;
    @BindView(R.id.goiy_11)
    LinearLayout goiy11;
    @BindView(R.id.txt_goiy_12)
    TextView txtGoiy12;
    @BindView(R.id.goiy_12)
    LinearLayout goiy12;
    @BindView(R.id.txt_goiy_13)
    TextView txtGoiy13;
    @BindView(R.id.goiy_13)
    LinearLayout goiy13;
    @BindView(R.id.txt_goiy_14)
    TextView txtGoiy14;
    @BindView(R.id.goiy_14)
    LinearLayout goiy14;
    @BindView(R.id.img_question)
    ImageView imgQuestion;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.adView)
    AdView adView;
    private String dapAn;
    private String ketQua;
    private DatabaseManager databaseManager;
    private Question question;
    private String filename;
    private String goiY;
    List<View> listViewDapAn = new ArrayList<>();
    List<View> listViewGoiY = new ArrayList<>();
    List<TextView> textViewsDapAn = new ArrayList<>();
    List<TextView> textViewsGoiY = new ArrayList<>();
    private int position = 0;
    private boolean canClickGoiY = false;
    private int countDapAn = 0;
    private int countHelp = 0;
    private int scoreRuby = 0;
    private int questionCount = 1;
    private RewardedVideoAd mRewardedVideoAd;
    private boolean isHelp = false;