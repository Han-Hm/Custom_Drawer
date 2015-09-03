package sample.net.sampleproject;


import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBarTitle("타이틀");
        setActionBarBackground(Color.RED);
        setActionBarType(BAR_TYPE_MENU);
    }
}
