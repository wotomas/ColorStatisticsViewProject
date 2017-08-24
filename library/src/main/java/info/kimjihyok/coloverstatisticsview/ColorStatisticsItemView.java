package info.kimjihyok.coloverstatisticsview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import info.kimjihyok.coloverstatisticsview.model.StatisticsData;

public class ColorStatisticsItemView extends View {
  private static final String TAG = "ColorStatisticsItemView";
  private static final int STAT_LABEL_TEXT_SIZE = 40;
  private static final int STAT_VALUE_TEXT_SIZE = 80;
  private static final int STAT_CIRCLE_RADIUS = 14;

  private Context context;
  @ColorInt
  private int circleColor;
  private int statisticsCount;
  private String statisticsLabel;

  private Paint circlePaint;
  private Paint statisticsLabelTextPaint;
  private Paint statisticsCountTextPaint;


  public ColorStatisticsItemView(Context context) {
    super(context);
    init(context, null);
  }

  public ColorStatisticsItemView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
  }

  public ColorStatisticsItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attributeSet) {
    this.context = context;

    TypedArray a = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.ColorStatisticsItemView, 0, 0);
    try {
      circleColor = a.getColor(R.styleable.ColorStatisticsItemView_circleColor, Color.BLACK);
      statisticsCount = a.getInt(R.styleable.ColorStatisticsItemView_statisticsCount, 16);
      statisticsLabel = a.getString(R.styleable.ColorStatisticsItemView_statisticsLabel);
      if (statisticsLabel == null) {
        statisticsLabel = "Label";
      }
    } finally {
      a.recycle();
    }

    setupPaint();
  }

  private void setupPaint() {
    circlePaint = new Paint();
    circlePaint.setStyle(Paint.Style.FILL);
    circlePaint.setColor(circleColor);
    circlePaint.setAntiAlias(true);

    statisticsLabelTextPaint = new Paint();
    statisticsLabelTextPaint.setStyle(Paint.Style.FILL);
    statisticsLabelTextPaint.setColor(Color.WHITE);
    statisticsLabelTextPaint.setTextSize(STAT_LABEL_TEXT_SIZE);
    statisticsLabelTextPaint.setTextAlign(Paint.Align.CENTER);

    statisticsCountTextPaint = new Paint();
    statisticsCountTextPaint.setStyle(Paint.Style.FILL);
    statisticsCountTextPaint.setColor(Color.WHITE);
    statisticsCountTextPaint.setTextSize(STAT_VALUE_TEXT_SIZE);
    statisticsCountTextPaint.setTextAlign(Paint.Align.CENTER);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //get half of the width and height as we are working with a circle
    int viewWidthHalf = this.getMeasuredWidth() / 2;
    int viewHeightHalf = this.getMeasuredHeight() / 2;

    canvas.drawCircle(viewWidthHalf, (float) (viewHeightHalf - (STAT_VALUE_TEXT_SIZE * 1.4)), STAT_CIRCLE_RADIUS, circlePaint);
    canvas.drawText(String.valueOf(statisticsCount), viewWidthHalf, viewHeightHalf, statisticsCountTextPaint);
    canvas.drawText(statisticsLabel, viewWidthHalf, viewHeightHalf + STAT_LABEL_TEXT_SIZE + 10, statisticsLabelTextPaint);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int minw =  getPaddingLeft() + getPaddingRight();
    int w = resolveSizeAndState(minw, widthMeasureSpec, 0);

    int minh =  getPaddingBottom() + getPaddingTop();
    int h = resolveSizeAndState(minh, heightMeasureSpec, 0);

    setMeasuredDimension(w, h);
  }

  public int getStatValue() {
    return statisticsCount;
  }

  public void setStatValue(int value) {
    statisticsCount = value;
    invalidate();
    requestLayout();
  }

  public void set(StatisticsData data) {
    circleColor = data.getColor();
    statisticsCount = data.getStatisticsCount();
    statisticsLabel = data.getItemName();

    setupPaint();
    invalidate();
    requestLayout();
  }
}

