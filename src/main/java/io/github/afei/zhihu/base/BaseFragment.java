package io.github.afei.zhihu.base;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import io.github.afei.zhihu.db.DBManager;

/**
 * Created by afei on 2016/10/1.
 */
public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;
    protected DBManager mDBManger;
    protected boolean isColorTheme = true;
    protected boolean isFirstLoad = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        initVariables();
        View view = inflater.inflate(setLayout(),container,false);
        ButterKnife.bind(this,view);
        initViews(inflater,container,savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    public abstract int setLayout();
    public abstract void initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    public void loadData(){
    }
    public void initVariables(){
        mDBManger = DBManager.getInstance(mActivity.getApplicationContext());
    }

    public void updateTheme(boolean isColorTheme, BitmapDrawable background) {
        this.isColorTheme = isColorTheme;
    }
}
