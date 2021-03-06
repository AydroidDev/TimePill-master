package com.dante.diary.base;


import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dante.diary.R;
import com.dante.diary.utils.SpUtil;

import butterknife.BindView;


public abstract class RecyclerFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    public static final int SMOOTH_SCROLL_POSITION = 10;
    private static final String TAG = "RecyclerFragment";
    @BindView(R.id.list)
    public RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    public SwipeRefreshLayout swipeRefresh;
    public RecyclerView.LayoutManager layoutManager;
    public boolean firstEnter = true;   //whether is first time to enter fragment
    @BindView(R.id.fab)
    public FloatingActionButton fab;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_recycler;
    }

//    @Override
//    protected void setAnimations() {
//        setReturnTransition(initTransitions());
//        setReenterTransition(new Slide(Gravity.RIGHT));
//        setEnterTransition(new Slide(Gravity.RIGHT));
//        setExitTransition(initTransitions());
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @CallSuper
    @Override
    protected void initViews() {
        recyclerView.setHasFixedSize(true);
        swipeRefresh.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorPrimary),
                ContextCompat.getColor(getContext(), R.color.colorAccent), ContextCompat.getColor(getContext(), R.color.indigo_500));
        swipeRefresh.setOnRefreshListener(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 5) {
                    if (barActivity != null) {
                        barActivity.hideBottomBar();
                    }
                }
                if (dy < -30) {
                    if (getStackCount() == 0 && barActivity != null) {
                        barActivity.showBottomBar();
                    }
                }
            }
        });
    }

    protected abstract boolean hasFab();

    @Override
    protected void initData() {

    }

    protected abstract void fetch();

    @Override
    public void onResume() {
        super.onResume();
        int viewPosition = SpUtil.getInt(Constants.VIEW_POSITION);
        if (viewPosition > 0) {
            recyclerView.scrollToPosition(viewPosition);
            SpUtil.remove(Constants.VIEW_POSITION);
        }
    }


    public void changeRefresh(final boolean refreshState) {
        if (null != swipeRefresh) {
            swipeRefresh.setRefreshing(refreshState);
            if (!refreshState && firstEnter) {
                startPostponedEnterTransition();
                firstEnter = false;
            }
        }
    }

    public void scrollToTop() {
        if (layoutManager instanceof LinearLayoutManager) {
            int index = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            scrollToTop(index);
        } else {
            recyclerView.scrollToPosition(0);
        }
    }

    public void scrollToTop(int index) {
        if (index > SMOOTH_SCROLL_POSITION) {
            recyclerView.scrollToPosition(0);
        } else {
            new Handler().postDelayed(() -> recyclerView.smoothScrollToPosition(0), 200);
        }
    }

}
