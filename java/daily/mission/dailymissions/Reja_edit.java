package daily.mission.dailymissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

public class Reja_edit {
    public Boolean is_okey;
    public String job_title = "";
    public String job_day = "";
    public String job_month = "";
    public String job_clock = "";
    public String job_minut = "";
    public Reja_edit(Boolean is_okey,String job_title,String job_day,String job_month,String job_clock,String job_minut){
        this.is_okey = is_okey;
        this.job_title = job_title;
        this.job_day = job_day;
        this.job_month = job_month;
        this.job_clock = job_clock;
        this.job_minut = job_minut;

    }
    @SuppressLint("ResourceType")
    public void create(Context context, LinearLayout linearLayout, FrameLayout frameLayout){
        RelativeLayout.LayoutParams for_j_layout_params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,201);
        RelativeLayout g_layout = new RelativeLayout(context);
        for_j_layout_params.setMargins(0,0,0,20);
        g_layout.setLayoutParams(for_j_layout_params);
        g_layout.setBackgroundResource(R.drawable.for_reja_item_background);
        g_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = Home_fragment.activity.getSupportFragmentManager();
                MainActivity.is_okey = is_okey;
                MainActivity.job_title_t = job_title;
                MainActivity.job_day_t = job_day;
                MainActivity.job_month_t = job_month;
                MainActivity.job_clock_t = job_clock;
                MainActivity.job_minut_t = job_minut;

                add_new_mission kuntartib = new add_new_mission();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
                MainActivity.is_create = false;
            }
        });

        RelativeLayout.LayoutParams for_job_time_params = new RelativeLayout.LayoutParams(200,100);
        TextView job_time_view = new TextView(context);
        job_time_view.setId(210);
        for_job_time_params.addRule(RelativeLayout.ALIGN_PARENT_END);
        for_job_time_params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        for_job_time_params.setMargins(10,10,15,10);
        job_time_view.setLayoutParams(for_job_time_params);
        job_time_view.setTextColor(Color.BLACK);
        job_time_view.setGravity(Gravity.CENTER);
        job_time_view.setText(this.job_clock+":"+this.job_minut);
        job_time_view.setTextSize(20);

        RelativeLayout.LayoutParams for_job_date_params = new RelativeLayout.LayoutParams(200,100);
        TextView job_date_view = new TextView(context);
        job_date_view.setId(270);
        for_job_date_params.addRule(RelativeLayout.ALIGN_PARENT_END);
        for_job_date_params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        for_job_date_params.setMargins(10,10,15,10);
        job_date_view.setLayoutParams(for_job_date_params);
        job_date_view.setTextColor(Color.BLACK);
        job_date_view.setGravity(Gravity.CENTER);
        job_date_view.setText(this.job_day+"."+this.job_month);
        job_date_view.setTextSize(14);

        RelativeLayout.LayoutParams for_job_title_params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,180);
        TextView job_title_view = new TextView(context);
        for_job_title_params.addRule(RelativeLayout.START_OF,210);
        for_job_title_params.addRule(RelativeLayout.CENTER_VERTICAL);
        job_title_view.setLayoutParams(for_job_title_params);
        job_title_view.setGravity(Gravity.CENTER_VERTICAL);
        job_title_view.setPadding(15,10,10,10);
        job_title_view.setTextSize(14);
        job_title_view.setTextColor(Color.BLACK);
        job_title_view.setText(this.job_title);

        g_layout.addView(job_time_view);
        g_layout.addView(job_date_view);
        g_layout.addView(job_title_view);
        linearLayout.addView(g_layout);
    }
}