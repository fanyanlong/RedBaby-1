package com.team3.baby.module.fragments_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.team3.baby.R;
import com.team3.baby.module.fragments_home.bean.SixTitleBean;
import com.team3.baby.module.fragments_home.bean.TitleBean;
import com.team3.baby.module.fragments_home.url.Url;

import java.util.List;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/21 20:26.
 */

public class MyRecyclerTitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SixTitleBean.DataBean> list;
    private Context context;

    public MyRecyclerTitleAdapter(Context context, List<SixTitleBean.DataBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_one, parent, false);
                holder = new ViewHolder1(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_three, parent, false);
                holder = new ViewHolder2(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_four, parent, false);
                holder = new ViewHolder3(view);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_five, parent, false);
                holder = new ViewHolder4(view);
                break;
            case 4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_six, parent, false);
                holder = new ViewHolder5(view);
                break;
            case 5:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_seven, parent, false);
                holder = new ViewHolder6(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                ViewHolder1 holder_one = (ViewHolder1) holder;
                Glide.with(context).load(Url.IMAGE + list.get(0).get_$88001().getTag().get(0).getPicUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder_one.item_home_one_image);
                break;

            case 1:
                ViewHolder2 holder_three = (ViewHolder2) holder;
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image0);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image1);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(2).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image2);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(3).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image3);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(4).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image4);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image5);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(2).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image6);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(3).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image7);
                Glide.with(context).load(Url.IMAGE + list.get(1).get_$88003()
                        .getTag().get(4).getPicUrl()).placeholder(R.mipmap.ic_launcher)
                        .into(holder_three.image8);
                break;



           /* case 2:*/
           /*     ViewHolder3 holder_four = (ViewHolder3) holder;*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(5).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_four.item_home_four_activity_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(6).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_four.item_home_four_big_poly_hui_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(6).getTag()*/
           /*             .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_four.item_home_four_tesco_image);*/
           /*     break;*/
           /* case 3:*/
           /*     ViewHolder4 holder_five = (ViewHolder4) holder;*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(8).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_five.item_home_five_knowledge_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(9).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_five.item_home_five_newborn_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(9).getTag()*/
           /*             .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_five.item_home_five_infant_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(10).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_five.item_home_five_infant_prefecture_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(10).getTag()*/
           /*             .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_five.item_home_five_preschool_prefecture_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(11).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_five.item_home_five_ready_prefecture_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(11).getTag()*/
           /*             .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_five.item_home_five_gestation_prefecture_image);*/
           /*     break;*/
           /* case 4:*/
           /*     ViewHolder5 holder_Six = (ViewHolder5) holder;*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(13).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_trademark_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(14).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_trademark_hui_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(15).getTag()*/
           /*             .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_image1);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(15).getTag()*/
           /*             .get(2).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_image2);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(15).getTag()*/
           /*             .get(3).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_image3);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(15).getTag()*/
           /*             .get(4).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_image4);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(15).getTag()*/
           /*             .get(5).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_image5);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(15).getTag()*/
           /*             .get(6).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_image6);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(15).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_Six.item_home_six_image7);*/
           /*     holder_Six.item_home_six_name1.setText(list.get(15).getTag().get(1).getElementName());*/
           /*     holder_Six.item_home_six_name2.setText(list.get(15).getTag().get(2).getElementName());*/
           /*     holder_Six.item_home_six_name3.setText(list.get(15).getTag().get(3).getElementName());*/
           /*     holder_Six.item_home_six_name4.setText(list.get(15).getTag().get(4).getElementName());*/
           /*     holder_Six.item_home_six_name5.setText(list.get(15).getTag().get(5).getElementName());*/
           /*     holder_Six.item_home_six_name6.setText(list.get(15).getTag().get(6).getElementName());*/
           /*     //holder_Six.item_home_six_name7.setText(list.get(15).getTag().get(0).getElementName());*/
           /*     break;*/
           /* case 5:*/
           /*     ViewHolder6 holder_seven = (ViewHolder6) holder;*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(16).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_good_method_image);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(17).getTag()*/
           /*             .get(1).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_image1);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(17).getTag()*/
           /*             .get(2).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_image2);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(17).getTag()*/
           /*             .get(3).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_image3);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(17).getTag()*/
           /*             .get(4).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_image4);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(17).getTag()*/
           /*             .get(5).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_image5);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(17).getTag()*/
           /*             .get(6).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_image6);*/
           /*     Glide.with(context).load(Url.IMAGE + list.get(17).getTag()*/
           /*             .get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher)*/
           /*             .into(holder_seven.item_home_seven_image7);*/
           /*     holder_seven.item_home_seven_name1.setText(list.get(17).getTag().get(1).getElementName());*/
           /*     holder_seven.item_home_seven_name2.setText(list.get(17).getTag().get(2).getElementName());*/
           /*     holder_seven.item_home_seven_name3.setText(list.get(17).getTag().get(3).getElementName());*/
           /*     holder_seven.item_home_seven_name4.setText(list.get(17).getTag().get(4).getElementName());*/
           /*     holder_seven.item_home_seven_name5.setText(list.get(17).getTag().get(5).getElementName());*/
           /*     holder_seven.item_home_seven_name6.setText(list.get(17).getTag().get(6).getElementName());*/
               // break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        int i = position % 6;
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
        }
        return 0;

    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView item_home_one_image;

        public ViewHolder1(View itemView) {
            super(itemView);
            item_home_one_image = (ImageView) itemView.findViewById(R.id.item_home_one_image);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView image0;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;
        ImageView image6;
        ImageView image7;
        ImageView image8;

        public ViewHolder2(View itemView) {
            super(itemView);
            image0 = (ImageView) itemView.findViewById(R.id.item_home_three_headline_image);
            image1 = (ImageView) itemView.findViewById(R.id.item_home_three_image1);
            image2 = (ImageView) itemView.findViewById(R.id.item_home_three_image2);
            image3 = (ImageView) itemView.findViewById(R.id.item_home_three_image3);
            image4 = (ImageView) itemView.findViewById(R.id.item_home_three_image4);
            image5 = (ImageView) itemView.findViewById(R.id.item_home_three_image5);
            image6 = (ImageView) itemView.findViewById(R.id.item_home_three_image6);
            image7 = (ImageView) itemView.findViewById(R.id.item_home_three_image7);
            image8 = (ImageView) itemView.findViewById(R.id.item_home_three_image8);
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView item_home_four_activity_image;
        ImageView item_home_four_big_poly_hui_image;
        ImageView item_home_four_tesco_image;

        public ViewHolder3(View itemView) {
            super(itemView);
            item_home_four_activity_image = (ImageView) itemView.findViewById(R.id.item_home_four_activity_image);
            item_home_four_big_poly_hui_image = (ImageView) itemView.findViewById(R.id.item_home_four_big_poly_hui_image);
            item_home_four_tesco_image = (ImageView) itemView.findViewById(R.id.item_home_four_tesco_image);
        }
    }

    public class ViewHolder4 extends RecyclerView.ViewHolder {
        ImageView item_home_five_knowledge_image;
        ImageView item_home_five_newborn_image;
        ImageView item_home_five_infant_image;
        ImageView item_home_five_infant_prefecture_image;
        ImageView item_home_five_preschool_prefecture_image;
        ImageView item_home_five_ready_prefecture_image;
        ImageView item_home_five_gestation_prefecture_image;


        public ViewHolder4(View itemView) {
            super(itemView);
            item_home_five_knowledge_image = (ImageView) itemView.findViewById(R.id.item_home_five_knowledge_image);
            item_home_five_newborn_image = (ImageView) itemView.findViewById(R.id.item_home_five_newborn_image);
            item_home_five_infant_image = (ImageView) itemView.findViewById(R.id.item_home_five_infant_image);
            item_home_five_infant_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_infant_prefecture_image);
            item_home_five_preschool_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_preschool_prefecture_image);
            item_home_five_ready_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_ready_prefecture_image);
            item_home_five_gestation_prefecture_image = (ImageView) itemView.findViewById(R.id.item_home_five_gestation_prefecture_image);

        }
    }

    public class ViewHolder5 extends RecyclerView.ViewHolder {
        ImageView item_home_six_trademark_image;
        ImageView item_home_six_trademark_hui_image;
        ImageView item_home_six_image1;
        ImageView item_home_six_image2;
        ImageView item_home_six_image3;
        ImageView item_home_six_image4;
        ImageView item_home_six_image5;
        ImageView item_home_six_image6;
        ImageView item_home_six_image7;
        TextView item_home_six_name1;
        TextView item_home_six_name2;
        TextView item_home_six_name3;
        TextView item_home_six_name4;
        TextView item_home_six_name5;
        TextView item_home_six_name6;
       // TextView item_home_six_name7;

        public ViewHolder5(View itemView) {
            super(itemView);
            item_home_six_trademark_image = (ImageView) itemView.findViewById(R.id.item_home_six_trademark_image);
            item_home_six_trademark_hui_image = (ImageView) itemView.findViewById(R.id.item_home_six_trademark_hui_image);
            item_home_six_image1 = (ImageView) itemView.findViewById(R.id.item_home_six_image1);
            item_home_six_image2 = (ImageView) itemView.findViewById(R.id.item_home_six_image2);
            item_home_six_image3 = (ImageView) itemView.findViewById(R.id.item_home_six_image3);
            item_home_six_image4 = (ImageView) itemView.findViewById(R.id.item_home_six_image4);
            item_home_six_image5 = (ImageView) itemView.findViewById(R.id.item_home_six_image5);
            item_home_six_image6 = (ImageView) itemView.findViewById(R.id.item_home_six_image6);
            item_home_six_image7 = (ImageView) itemView.findViewById(R.id.item_home_six_image7);
            item_home_six_name1 = (TextView) itemView.findViewById(R.id.item_home_six_name1);
            item_home_six_name2 = (TextView) itemView.findViewById(R.id.item_home_six_name2);
            item_home_six_name3 = (TextView) itemView.findViewById(R.id.item_home_six_name3);
            item_home_six_name4 = (TextView) itemView.findViewById(R.id.item_home_six_name4);
            item_home_six_name5 = (TextView) itemView.findViewById(R.id.item_home_six_name5);
            item_home_six_name6 = (TextView) itemView.findViewById(R.id.item_home_six_name6);
            //item_home_six_name7 = (TextView) itemView.findViewById(R.id.item_home_six_name7);

        }
    }

    public class ViewHolder6 extends RecyclerView.ViewHolder {
        ImageView item_home_seven_good_method_image;
        ImageView item_home_seven_image1;
        ImageView item_home_seven_image2;
        ImageView item_home_seven_image3;
        ImageView item_home_seven_image4;
        ImageView item_home_seven_image5;
        ImageView item_home_seven_image6;
        ImageView item_home_seven_image7;
        TextView item_home_seven_name1;
        TextView item_home_seven_name2;
        TextView item_home_seven_name3;
        TextView item_home_seven_name4;
        TextView item_home_seven_name5;
        TextView item_home_seven_name6;
        //TextView item_home_seven_name7;

        public ViewHolder6(View itemView) {
            super(itemView);
            item_home_seven_good_method_image = (ImageView) itemView.findViewById(R.id.item_home_seven_good_method_image);
            item_home_seven_image1 = (ImageView) itemView.findViewById(R.id.item_home_seven_image1);
            item_home_seven_image2 = (ImageView) itemView.findViewById(R.id.item_home_seven_image2);
            item_home_seven_image3 = (ImageView) itemView.findViewById(R.id.item_home_seven_image3);
            item_home_seven_image4 = (ImageView) itemView.findViewById(R.id.item_home_seven_image4);
            item_home_seven_image5 = (ImageView) itemView.findViewById(R.id.item_home_seven_image5);
            item_home_seven_image6 = (ImageView) itemView.findViewById(R.id.item_home_seven_image6);
            item_home_seven_image7 = (ImageView) itemView.findViewById(R.id.item_home_seven_image7);
            item_home_seven_name1 = (TextView) itemView.findViewById(R.id.item_home_seven_name1);
            item_home_seven_name2 = (TextView) itemView.findViewById(R.id.item_home_seven_name2);
            item_home_seven_name3 = (TextView) itemView.findViewById(R.id.item_home_seven_name3);
            item_home_seven_name4 = (TextView) itemView.findViewById(R.id.item_home_seven_name4);
            item_home_seven_name5 = (TextView) itemView.findViewById(R.id.item_home_seven_name5);
            item_home_seven_name6 = (TextView) itemView.findViewById(R.id.item_home_seven_name6);
            //item_home_seven_name7 = (TextView) itemView.findViewById(R.id.item_home_seven_name7);
        }
    }
}
