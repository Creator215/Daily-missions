package daily.mission.dailymissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class KunTartib_item {
    public Boolean is_okey = false;
    public String job_title = "";
    public String job_clock = "";
    public String job_minut = "";
    public KunTartib_item(Boolean is_okey,String job_title,String job_clock,String job_minut){
        this.is_okey = is_okey;
        this.job_title = job_title;
        this.job_clock = job_clock;
        this.job_minut = job_minut;

    }
    @SuppressLint("ResourceType")
    public void create(Context context, LinearLayout linearLayout){
        RelativeLayout.LayoutParams for_j_layout_params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,161);
        RelativeLayout g_layout = new RelativeLayout(context);
        for_j_layout_params.setMargins(0,0,0,20);
        g_layout.setLayoutParams(for_j_layout_params);
        g_layout.setBackgroundResource(R.drawable.for_reja_item_background);
        RelativeLayout.LayoutParams for_image_button_params = new RelativeLayout.LayoutParams(130,130);

        ImageView imageView = new ImageView(context);
        imageView.setId(200);
        for_image_button_params.addRule(RelativeLayout.ALIGN_PARENT_START);
        for_image_button_params.addRule(RelativeLayout.CENTER_VERTICAL);
        for_image_button_params.setMargins(10,10,10,10);
        imageView.setLayoutParams(for_image_button_params);

        if(is_okey){
            imageView.setBackgroundResource(R.drawable.onnn);
        }else {
            imageView.setBackgroundResource(R.drawable.offf);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_okey){
                    imageView.setBackgroundResource(R.drawable.offf);
                    String ddata = read_file(MainActivity.kun_tartib).replace("&<true><"+job_title+"><"+job_clock+"><"+job_minut+">","&<false><"+job_title+"><"+job_clock+"><"+job_minut+">");
                    write_file(ddata,MainActivity.kun_tartib);
                    g_layout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.menu_panel2));
                    linearLayout.removeView(g_layout);
                    is_okey = false;
                }else {
                    imageView.setBackgroundResource(R.drawable.onnn);
                    String ddata = read_file(MainActivity.kun_tartib).replace("&<false><"+job_title+"><"+job_clock+"><"+job_minut+">","&<true><"+job_title+"><"+job_clock+"><"+job_minut+">");
                    write_file(ddata,MainActivity.kun_tartib);
                    g_layout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.menu_panel2));
                    linearLayout.removeView(g_layout);
                    is_okey = true;
                }
            }
        });

        RelativeLayout.LayoutParams for_job_time_params = new RelativeLayout.LayoutParams(180,130);
        TextView job_time_view = new TextView(context);
        job_time_view.setId(210);
        for_job_time_params.addRule(RelativeLayout.ALIGN_PARENT_END);
        for_job_time_params.setMargins(10,10,15,10);
        for_job_time_params.addRule(RelativeLayout.CENTER_VERTICAL);
        job_time_view.setLayoutParams(for_job_time_params);
        job_time_view.setTextColor(Color.BLACK);
        job_time_view.setGravity(Gravity.CENTER);
        job_time_view.setText(this.job_clock+":"+this.job_minut);
        job_time_view.setTextSize(20);

        RelativeLayout.LayoutParams for_job_title_params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,130);
        TextView job_title_view = new TextView(context);
        for_job_title_params.addRule(RelativeLayout.END_OF,200);
        for_job_title_params.addRule(RelativeLayout.START_OF,210);
        for_job_title_params.addRule(RelativeLayout.CENTER_VERTICAL);
        job_title_view.setLayoutParams(for_job_title_params);
        job_title_view.setGravity(Gravity.CENTER_VERTICAL);
        job_title_view.setPadding(10,10,10,10);
        job_title_view.setTextSize(14);
        job_title_view.setTextColor(Color.BLACK);
        job_title_view.setText(this.job_title);

        g_layout.addView(imageView);
        g_layout.addView(job_time_view);
        g_layout.addView(job_title_view);
        linearLayout.addView(g_layout);
    }
    private void write_file(String data,String file_name){
        FileOutputStream fos = null;

        try {
            fos = MainActivity.application.openFileOutput(file_name, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private String read_file(String file_name){
        FileInputStream fis = null;
        String data = "";

        try {
            fis = MainActivity.application.openFileInput(file_name);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb  = new StringBuilder();

            String text = "";

            while((text = br.readLine()) != null){
                sb.append(text);
            }
            data = sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return data;
    }
}