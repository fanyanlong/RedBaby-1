package com.team3.baby.module.fragments_classify.fragment.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.team3.baby.R;
import com.team3.baby.module.fragments_classify.adapter.LeftRvAdapter;
import com.team3.baby.module.fragments_classify.adapter.RightRvAdapter;
import com.team3.baby.module.fragments_classify.bean.ClassifyBean;
import com.team3.baby.module.fragments_classify.bean.LeftClassifyBean;
import com.team3.baby.module.fragments_classify.bean.RightClassifyBean;
import com.team3.baby.module.fragments_classify.fragment.ClassifyGoodsListFragment;
import com.team3.baby.module.fragments_classify.util.RecyclerViewDivider;
import com.team3.baby.module.fragments_classify.util.UrlClassify;
import com.team3.baby.utils.GsonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 类的用途：
 *
 * @author jinhu
 * @date 2017/5/17 16:08
 */


public class ClassifyFragment extends Fragment {
    @BindView(R.id.recycler_left_classify)
    RecyclerView mRecyclerLeftClassify;
    @BindView(R.id.recycler_right_classify)
    RecyclerView mRecyclerRightClassify;
    Unbinder unbinder;
    @BindView(R.id.progress_classify)
    ProgressBar mProgressClassify;
    private LeftRvAdapter mAdapterLeft;
    private List<LeftClassifyBean> mLeftList = new ArrayList<>();
    private List<RightClassifyBean> mRightList = new ArrayList<>();
    private TranceInfo mTranceInfo;
    private RightRvAdapter mRightAdapter;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = inflater.inflate(R.layout.fragment_classify, null);
        unbinder = ButterKnife.bind(this, rootView);
        mContext = getActivity();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getServerData();
    }

    private void getServerData() {
        OkGo.get(UrlClassify.ADD_CLASSIFY)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ClassifyBean classifyBean = GsonUtils.gsonToBean(s, ClassifyBean.class);
                        final List<ClassifyBean.RsBean> rsBeanList = classifyBean.getRs();
                        for (int i = 0; i < rsBeanList.size(); i++) {
                            //为左边的数据适配
                            LeftClassifyBean bean = new LeftClassifyBean();
                            bean.setText(rsBeanList.get(i).getDirName());
                            mLeftList.add(bean);
                        }
                        initLeftRecyclerView(mLeftList);
                        mAdapterLeft.setmOnItemClickListener(new LeftRvAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
                                mTranceInfo.onTranceInfo(position);
                            }
                        });
                        //为右边的数据适配
                        List<ClassifyBean.RsBean.ChildrenBeanX> childrenBeanXList = rsBeanList.get(0).getChildren();
                        for (int i = 0; i < childrenBeanXList.size(); i++) {
                            RightClassifyBean rightClassifyBean = new RightClassifyBean();
                            rightClassifyBean.setText(childrenBeanXList.get(i).getDirName());
                            mRightList.add(rightClassifyBean);
                            for (int j = 0; j < childrenBeanXList.get(i).getChildren().size(); j++) {
                                RightClassifyBean rightClassifyBean_02 = new RightClassifyBean();
                                rightClassifyBean_02.setText(childrenBeanXList.get(i).getChildren().get(j).getDirName());
                                rightClassifyBean_02.setImage(childrenBeanXList.get(i).getChildren().get(j).getImgApp());
                                mRightList.add(rightClassifyBean_02);
                            }
                        }
                        initRightRv(mRightList);
                        setTraceInfo(new TranceInfo() {
                            @Override
                            public void onTranceInfo(int info) {
                                mRightList.clear();
                                List<ClassifyBean.RsBean.ChildrenBeanX> childrenBeanXList = rsBeanList.get(info).getChildren();
                                for (int i = 0; i < childrenBeanXList.size(); i++) {
                                    RightClassifyBean rightClassifyBean = new RightClassifyBean();
                                    rightClassifyBean.setText(childrenBeanXList.get(i).getDirName());
                                    mRightList.add(rightClassifyBean);
                                    for (int j = 0; j < childrenBeanXList.get(i).getChildren().size(); j++) {
                                        RightClassifyBean rightClassifyBean_02 = new RightClassifyBean();
                                        rightClassifyBean_02.setText(childrenBeanXList.get(i).getChildren().get(j).getDirName());
                                        rightClassifyBean_02.setImage(childrenBeanXList.get(i).getChildren().get(j).getImgApp());
                                        rightClassifyBean_02.setPcci(childrenBeanXList.get(i).getChildren().get(j).getPcCi());
                                        mRightList.add(rightClassifyBean_02);
                                    }
                                }
                                initRightRv(mRightList);
                            }
                        });
                        //
                        mRightAdapter.setmOnItemClickListener(new RightRvAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(mContext, ClassifyGoodsListFragment.class);
//                                intent.putExtra("pcci", mRightList.get(position).getPcci());
                                startActivity(intent);
                            }
                        });
                        mProgressClassify.setVisibility(View.GONE);
                    }
                });

    }

    private void initRightRv(final List<RightClassifyBean> list) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        //显示标题栏的grid
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (null == list.get(position).getImage()) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        mRecyclerRightClassify.setLayoutManager(gridLayoutManager);
        if (mRightAdapter == null) {
            mRightAdapter = new RightRvAdapter(list, mContext);
            mRecyclerRightClassify.setAdapter(mRightAdapter);
        } else {
            mRightAdapter.notifyDataSetChanged();
        }
    }

    private void initLeftRecyclerView(List<LeftClassifyBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerLeftClassify.setLayoutManager(layoutManager);
        //分割线
        mRecyclerLeftClassify.addItemDecoration(new RecyclerViewDivider(mContext, layoutManager.HORIZONTAL));
        mAdapterLeft = new LeftRvAdapter(list, mContext);
        mRecyclerLeftClassify.setAdapter(mAdapterLeft);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //传值接口
    public interface TranceInfo {
        void onTranceInfo(int info);
    }

    public void setTraceInfo(TranceInfo tranceInfo) {
        this.mTranceInfo = tranceInfo;
    }
}
