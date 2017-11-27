package wmz.switchbuttondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AddressUtils.OnWheelViewClick {

    @BindView(R.id.swh_status)
    Switch mSwhStatus;
    @BindView(R.id.tv_peas_num)
    TextView mTvPeasNum;
    @BindView(R.id.peas_num_ll)
    LinearLayout mPeasNumLl;

    private List<Integer> mBeans =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBeans();
        initListener();
    }

    private void initBeans() {
        mBeans.add(1000);
        mBeans.add(2000);
        mBeans.add(3000);
        mBeans.add(4000);
        mBeans.add(5000);
        mBeans.add(6000);
    }

    private void initListener() {
        mSwhStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mPeasNumLl.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
        mTvPeasNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressUtils.alertBottomWheelOption(MainActivity.this, mBeans, MainActivity.this);
            }
        });
    }

    @Override
    public void onClick(View view, int num) {
        mTvPeasNum.setText("" + num);
    }
}
