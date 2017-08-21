package info.kimjihyok.coloverstatisticsview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class ColorStatisticsView extends RelativeLayout {
  @ColorInt
  private int bgColor;
  @ColorInt
  private int fontColor;
  private int fontSize;
  private String titleText;

  private Context context;

  public ColorStatisticsView(Context context) {
    super(context);
    init(context, null);
    initView();
  }

  public ColorStatisticsView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
    initView();
  }

  public ColorStatisticsView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
    initView();
  }

  private void init(Context context, AttributeSet attrs) {
    this.context = context;

    TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ColorStatisticsView, 0, 0);
    try {
      bgColor = a.getColor(R.styleable.ColorStatisticsView_backgroundColor, Color.BLACK);
      fontColor = a.getColor(R.styleable.ColorStatisticsView_fontColor, Color.WHITE);
      fontSize = a.getInt(R.styleable.ColorStatisticsView_fontSize, 16);
      titleText = a.getString(R.styleable.ColorStatisticsView_title);
    } finally {
      a.recycle();
    }
  }

  private void initView() {
    inflate(context, R.layout.view_color_statistics, this);
  }

  public int getBackgroundColor() {
    return bgColor;
  }

  public void setBackgroundColor(int backgroundColor) {
    this.bgColor = backgroundColor;
    invalidate();
    requestLayout();
  }

  public int getFontColor() {
    return fontColor;
  }

  public void setFontColor(int fontColor) {
    this.fontColor = fontColor;
    invalidate();
    requestLayout();
  }

  public int getFontSize() {
    return fontSize;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
    invalidate();
    requestLayout();
  }

  public String getTitleText() {
    return titleText;
  }

  public void setTitleText(String titleText) {
    this.titleText = titleText;
    invalidate();
    requestLayout();
  }
}
