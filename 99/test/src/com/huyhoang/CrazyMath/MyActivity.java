package com.huyhoang.CrazyMath;

import org.apache.http.client.methods.HttpGet;

import com.huyhoang.CrazyMath.R;
import com.huyhoang.CrazyMath.R.id;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity implements View.OnClickListener {
	public static final String FONT_PATH = "fonts/UVNBanhMi.TTF";
	private Fragment playFragment;
	private TextView tvBest;
	private TextView tvScore;
	private TextView tvCzary;
	private Button btPlay;
	private Button btRate;
	private SharedPreferences pref;
	private int bestScore;
	private int score;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}

	private void initView() {
		score = 0;
		tvBest = (TextView) findViewById(R.id.tv_best_start);
		tvScore = (TextView) findViewById(R.id.tv_score_start);
		tvCzary = (TextView) findViewById(R.id.tv_czary_math);
		Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				FONT_PATH);
		tvScore.setTypeface(typeface);
		tvBest.setTypeface(typeface);
		tvCzary.setTypeface(typeface);
		btPlay = (Button) findViewById(R.id.bt_play);
		btPlay.setOnClickListener(this);
		btRate = (Button) findViewById(R.id.bt_rate);
		btRate.setOnClickListener(this);
		playFragment = new PlayFragment();
	}

	@Override
	public void onStart() {
		super.onStart();
		String strScore = getString(R.string.score, score);
		tvScore.setText(strScore);
		pref = this.getSharedPreferences(PlayFragment.SCORE,
				Context.MODE_PRIVATE);
		bestScore = pref.getInt(PlayFragment.SCORE, 0);
		String strBest = getString(R.string.best, bestScore);
		tvBest.setText(strBest);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_play:
			Intent intent = new Intent(MyActivity.this, PlayActivity.class);
			startActivity(intent);
			break;
		case R.id.bt_rate:
			rateApp();
		default:
			break;
		}
	}

	public void rateApp() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		// Try Google play
		intent.setData(Uri.parse("market://details?id=com.huyhoang.CrazyMath"));
		if (!MyStartActivity(intent)) {
			intent.setData(Uri
					.parse("https://play.google.com/store/apps/details?id=com.huyhoang.CrazyMath"));
			if (!MyStartActivity(intent)) {
				Toast.makeText(
						this,
						"Could not open Android market, please install the market app.",
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	private boolean MyStartActivity(Intent aIntent) {
		try {
			startActivity(aIntent);
			return true;
		} catch (ActivityNotFoundException e) {
			return false;
		}
	}
}
