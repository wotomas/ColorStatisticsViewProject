package info.kimjihyok.colorstatisticsviewproject;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import info.kimjihyok.coloverstatisticsview.ColorStatisticsView;
import info.kimjihyok.coloverstatisticsview.model.StatisticsData;

public class MainActivity extends AppCompatActivity {
  private ColorStatisticsView colorStatsView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    colorStatsView = (ColorStatisticsView) findViewById(R.id.colorStatsView);
    colorStatsView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
    colorStatsView.setTitleText("Diary Topics");
    colorStatsView.setFontColor(ContextCompat.getColor(this, R.color.white));
    colorStatsView.setFontSize(22);
    colorStatsView.setStatisticsItems(getTestData());
  }

  private List<StatisticsData> getTestData() {
    List<StatisticsData> resultData = new ArrayList<>();
    StatisticsData dataOne = new StatisticsData();
    dataOne.setItemName("Reading");
    dataOne.setCircleColor(ContextCompat.getColor(this, R.color.readingColor));
    dataOne.setStatisticsCount(23);

    StatisticsData dataTwo = new StatisticsData();
    dataTwo.setItemName("Sleeping");
    dataTwo.setCircleColor(ContextCompat.getColor(this, R.color.sleepingColor));
    dataTwo.setStatisticsCount(17);

    StatisticsData dataThree = new StatisticsData();
    dataThree.setItemName("Traveling");
    dataThree.setCircleColor(ContextCompat.getColor(this, R.color.travelingColor));
    dataThree.setStatisticsCount(2);

    resultData.add(dataOne);
    resultData.add(dataTwo);
    resultData.add(dataThree);

    return resultData;
  }


}
