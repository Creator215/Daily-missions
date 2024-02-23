package daily.mission.dailymissions;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Statistika_item {
    public String date = "";
    public String prosent = "";

    public Statistika_item(String date,String prosent){
        this.date = date;
        this.prosent = prosent;
    }
    public void create(Context context, LinearLayout linearLayout){
        RelativeLayout.LayoutParams for_j_layout_params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,161);
        RelativeLayout g_layout = new RelativeLayout(context);
        for_j_layout_params.setMargins(5,0,5,15);
        g_layout.setLayoutParams(for_j_layout_params);
        g_layout.setBackgroundResource(R.drawable.for_reja_item_background);

        RelativeLayout.LayoutParams for_date_view_params = new RelativeLayout.LayoutParams(250,150);
        TextView date_view = new TextView(context);
        for_date_view_params.addRule(RelativeLayout.ALIGN_PARENT_START);
        for_date_view_params.addRule(RelativeLayout.CENTER_VERTICAL);
        for_date_view_params.setMargins(20,0,20,0);
        date_view.setLayoutParams(for_date_view_params);
        date_view.setText(this.date);
        date_view.setTextColor(Color.BLACK);
        date_view.setTextSize(14);
        date_view.setGravity(Gravity.CENTER);
        date_view.setTypeface(date_view.getTypeface(), Typeface.NORMAL);

        RelativeLayout.LayoutParams for_prosent_view_params = new RelativeLayout.LayoutParams(200,150);
        TextView prosent_view = new TextView(context);
        for_prosent_view_params.addRule(RelativeLayout.ALIGN_PARENT_END);
        for_prosent_view_params.addRule(RelativeLayout.CENTER_VERTICAL);
        for_prosent_view_params.setMargins(20,0,20,0);
        prosent_view.setLayoutParams(for_prosent_view_params);
        prosent_view.setText(this.prosent);
        prosent_view.setTextColor(Color.BLACK);
        prosent_view.setTextSize(20);
        prosent_view.setGravity(Gravity.CENTER);
        prosent_view.setTypeface(date_view.getTypeface(), Typeface.BOLD);

        g_layout.addView(date_view);
        g_layout.addView(prosent_view);
        linearLayout.addView(g_layout);
    }
}
