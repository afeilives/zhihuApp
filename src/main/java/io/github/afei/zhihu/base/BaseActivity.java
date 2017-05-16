package io.github.afei.zhihu.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import io.github.afei.zhihu.constant.Constant;
import io.github.afei.zhihu.db.DBManager;

/**
 * Created by afei on 2016/10/1.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected DBManager mDBManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
        setContentView(setLayout());
        // 须在setContentView之后调用
        ButterKnife.bind(this);
        initViews(savedInstanceState);
        loadData();
    }

    protected void initVariables() {
        mDBManager = DBManager.getInstance(getApplicationContext());
        Bmob.initialize(getApplicationContext(), Constant.APPLICATION_ID);
    }

    protected abstract int setLayout();

    protected abstract void initViews(Bundle savedInstanceState);

    protected void loadData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDBManager != null) {
            mDBManager.release();
        }
    }
}
