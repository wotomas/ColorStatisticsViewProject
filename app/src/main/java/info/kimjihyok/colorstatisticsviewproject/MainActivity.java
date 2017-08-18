package info.kimjihyok.colorstatisticsviewproject;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import info.kimjihyok.coloverstatisticsview.ColorStatisticsView;

public class MainActivity extends AppCompatActivity {
  private ColorStatisticsView colorStatsView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    colorStatsView = (ColorStatisticsView) findViewById(R.id.colorStatsView);
  }


}
