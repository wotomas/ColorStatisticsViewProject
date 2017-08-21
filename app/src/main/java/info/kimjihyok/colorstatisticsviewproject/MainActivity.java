package info.kimjihyok.colorstatisticsviewproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
