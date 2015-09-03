package sample.net.sampleproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by jacob on 2015. 8. 14..
 */
public class MenuView extends FrameLayout {
    public MenuView(Context context) {
        super(context);
        init(context);
    }

    public MenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_left_menu, this);
    }
}
