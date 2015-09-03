package sample.net.sampleproject;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jacob on 2015. 8. 13..
 */
public class ActionBarActivity extends FragmentActivity {

    protected static final int BAR_TYPE_MENU = 0x01;
    protected static final int BAR_TYPE_BACK = 0x02;
    protected static final int BAR_TYPE_NONE = 0x03;


    protected DrawerLayout mDrawerLayout;

    /**
     * 상단 바 왼쪽 버튼들에 대한 이벤트
     *
     * @param view
     */
    public void onLeftButton(View view) {
        switch (view.getId()) {
            case R.id.menuButton:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.backButton:
                finish();
                break;
        }
    }

    /**
     * 상단 바 오른쪽 버튼들에 대한 이벤트
     *
     * @param view
     */
    public void onRightButton(View view) {

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_action_bar);

        getLayoutInflater().inflate(layoutResID, ((FrameLayout) findViewById(R.id.contentLayout)));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.rootLayout);

        FrameLayout menuLayout = (FrameLayout) findViewById(R.id.menuLayout);
        MenuView view = new MenuView(this);
        menuLayout.addView(view);
    }

    /**
     * 타이틀 이름 설정 메소드
     *
     * @param title
     */
    public void setActionBarTitle(String title) {
        TextView titleLabel = (TextView) findViewById(R.id.titleLabel);
        titleLabel.setText(title);
    }

    /**
     * 상단 바 배경 색상 설정 메소드
     *
     * @param color
     */
    public void setActionBarBackground(int color) {
        RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionBarLayout);
        actionBarLayout.setBackgroundColor(color);
    }

    public void setActionBarType(int type) {
        ImageButton menuButton = (ImageButton) findViewById(R.id.menuButton);
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);

        menuButton.setVisibility(View.GONE);
        backButton.setVisibility(View.GONE);

        switch (type) {
            case BAR_TYPE_MENU:
                menuButton.setVisibility(View.VISIBLE);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                break;
            case BAR_TYPE_BACK:
                backButton.setVisibility(View.VISIBLE);
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                break;
            case BAR_TYPE_NONE:
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                break;
        }
    }
}
