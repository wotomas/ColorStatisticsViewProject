package info.kimjihyok.coloverstatisticsview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.kimjihyok.coloverstatisticsview.model.StatisticsData;

public class ColorStatisticsView extends RelativeLayout {
  @ColorInt
  private int bgColor;
  @ColorInt
  private int fontColor;
  private int fontSize;
  private String titleText;

  private RelativeLayout panel;
  private TextView titleTextView;
  private LinearLayout colorItemPanel;
  private ColorStatisticsItemView firstItemView;
  private ColorStatisticsItemView secondItemView;
  private ColorStatisticsItemView thirdItemView;


  private List<StatisticsData> statisticsItems;

  private Context context;

  public ColorStatisticsView(Context context) {
    super(context);
    init(context, null);
  }

  public ColorStatisticsView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
  }

  public ColorStatisticsView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    this.context = context;
    statisticsItems = new ArrayList<>();

    TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ColorStatisticsView, 0, 0);
    try {
      bgColor = a.getColor(R.styleable.ColorStatisticsView_backgroundColor, Color.BLACK);
      fontColor = a.getColor(R.styleable.ColorStatisticsView_fontColor, Color.WHITE);
      fontSize = a.getInt(R.styleable.ColorStatisticsView_fontSize, 16);
      titleText = a.getString(R.styleable.ColorStatisticsView_title);
    } finally {
      a.recycle();
    }

    initView();

    panel = (RelativeLayout) findViewById(R.id.panel_background);
    titleTextView = (TextView) findViewById(R.id.title_text_view);
    colorItemPanel = (LinearLayout) findViewById(R.id.color_panel);
    firstItemView = (ColorStatisticsItemView) findViewById(R.id.first_stat_item);
    secondItemView = (ColorStatisticsItemView) findViewById(R.id.second_stat_item);
    thirdItemView = (ColorStatisticsItemView) findViewById(R.id.third_stat_item);

    panel.setBackgroundColor(bgColor);
    titleTextView.setText(titleText);
    titleTextView.setTextSize(fontSize);
    titleTextView.setTextColor(fontColor);
  }

  private void initView() {
    inflate(context, R.layout.view_color_statistics, this);
  }

  public int getBackgroundColor() {
    return bgColor;
  }

  public void setBackgroundColor(@ColorInt int backgroundColor) {
    this.bgColor = backgroundColor;
    panel.setBackgroundColor(bgColor);

    invalidate();
    requestLayout();
  }

  public int getFontColor() {
    return fontColor;
  }

  public void setFontColor(int fontColor) {
    this.fontColor = fontColor;
    titleTextView.setTextColor(fontColor);
    invalidate();
    requestLayout();
  }

  public int getFontSize() {
    return fontSize;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
    titleTextView.setTextSize(fontSize);
    invalidate();
    requestLayout();
  }

  public String getTitleText() {
    return titleText;
  }

  public void setTitleText(String titleText) {
    this.titleText = titleText;
    titleTextView.setText(titleText);
    invalidate();
    requestLayout();
  }

  public void setStatisticsItems(List<StatisticsData> statisticsItems) {
    if (statisticsItems.size() != 3) {
      throw new IllegalStateException("Currently supported itemSize is 3");
    }

    this.statisticsItems = statisticsItems;
    firstItemView.set(statisticsItems.get(0));
    secondItemView.set(statisticsItems.get(1));
    thirdItemView.set(statisticsItems.get(2));

    invalidate();
    requestLayout();
  }
}
