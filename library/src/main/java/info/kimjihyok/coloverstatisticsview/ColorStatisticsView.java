package info.kimjihyok.coloverstatisticsview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ColorStatisticsView extends View {
  public ColorStatisticsView(Context context) {
    super(context);
    init(context, null, -1);
  }

  public ColorStatisticsView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, -1);
  }

  public ColorStatisticsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {


    if (attrs != null) {

    }
  }
}
