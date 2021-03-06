# ColorStatisticsViewProject
![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat) ![Download](https://api.bintray.com/packages/wotomas/maven/color-statistics-view/images/download.svg)

# About
Color Statistics for Android based on a Material Up showcase designed by [Someone](#Notes)

# Demo
## Adding counters to statistics values

[<img src="media/statisticsViewSample.gif" width="600" />]()

## Original showcase image from [Someone](https://github.com/wotomas/ColorStatisticsViewProject#note-1)

[<img src="media/screenshot.png" width="600" />]()


# Implement
```gradle
dependencies {
  compile 'info.kimjihyok:color-statistics-view:0.1.0'
}
```

```XML
<info.kimjihyok.coloverstatisticsview.ColorStatisticsView
    android:id="@+id/colorStatsView"
    android:layout_width="match_parent"
    android:layout_height="200dp">
</info.kimjihyok.coloverstatisticsview.ColorStatisticsView>
```

```java
colorStatsView = (ColorStatisticsView) findViewById(R.id.colorStatsView);
colorStatsView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
colorStatsView.setTitleText("Diary Topics");
colorStatsView.setFontColor(ContextCompat.getColor(this, R.color.white));
colorStatsView.setFontSize(22);
colorStatsView.setStatisticsItems(getDummyData());

// to update values
colorStatsView/.setStatValue(position, value);
```

## Statistic Item
```java
private List<StatisticsData> getTestData() {
  List<StatisticsData> resultData = new ArrayList<>();
    
  StatisticsData dataOne = new StatisticsData();
  dataOne.setItemName("Reading");
  dataOne.setCircleColor(ContextCompat.getColor(this, R.color.readingColor));
  dataOne.setStatisticsCount(4);    
  ...

  resultData.add(dataOne);
  ...
    
  return resultData;
}
```



# Notes
 - Please help me update this link. I saw it on Material Up, but lost the link and can't find him!
