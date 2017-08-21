package info.kimjihyok.coloverstatisticsview.model;

import android.support.annotation.ColorInt;

public class StatisticsData {
  @ColorInt
  private int color;
  private int statisticsCount;
  private String itemName;

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public void setCircleColor(int color) {
    this.color = color;
  }

  public void setStatisticsCount(int statisticsCount) {
    this.statisticsCount = statisticsCount;
  }

  public int getColor() {
    return color;
  }

  public int getStatisticsCount() {
    return statisticsCount;
  }

  public String getItemName() {
    return itemName;
  }
}
