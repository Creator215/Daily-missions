package daily.mission.dailymissions;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Rejalar extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    LinearLayout menu_layout;
    RelativeLayout item_layout;
    ImageButton rejalar_back_button,add_button,rejalar_menu_button,bajarilganlar_menu,tahrirlash_menu;
    AppCompatButton bajarilganlar_title,tahrirlash_title;
    LinearLayout rejalar_item_layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_rejalar, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        rejalar_item_layout = view.findViewById(R.id.rejalar_item_layout);

        if(read_file(MainActivity.rejalar).hashCode() != "".hashCode()){
            Big_Data_Reder dataReder = new Big_Data_Reder(read_file(MainActivity.rejalar));
            String[][] mass = dataReder.getData().clone();
            for(int i = 0;i < dataReder.getSize();i ++){
                if(mass[i][0].hashCode() == "false".hashCode()){
                    Reja_item rejaItem = new Reja_item(false,mass[i][1],mass[i][2],mass[i][3],mass[i][4],mass[i][5]);
                    rejaItem.create(getContext(),rejalar_item_layout);
                }
            }
        }

        frameLayout = view2.findViewById(R.id.frame_layout);
        bajarilganlar_menu = view.findViewById(R.id.setting_menu);
        bajarilganlar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Rejalar_bajarilganlar kuntartib = new Rejalar_bajarilganlar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        bajarilganlar_title = view.findViewById(R.id.sozlamalar_title);
        bajarilganlar_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Rejalar_bajarilganlar kuntartib = new Rejalar_bajarilganlar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        tahrirlash_menu = view.findViewById(R.id.password_menu);
        tahrirlash_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Rejalar_tahrirlash kuntartib = new Rejalar_tahrirlash();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        tahrirlash_title = view.findViewById(R.id.parol_title);
        tahrirlash_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Rejalar_tahrirlash kuntartib = new Rejalar_tahrirlash();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });

        item_layout = view.findViewById(R.id.item_layout);

        menu_layout = view.findViewById(R.id.menu_layout);


        rejalar_menu_button = view.findViewById(R.id.rejalar_menu_button);
        rejalar_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu_layout.getVisibility() == View.INVISIBLE){
                    menu_layout.setVisibility(View.VISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.menu_panel));
                }
                else {
                    menu_layout.setVisibility(View.INVISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.menu_panel2));
                }
            }
        });

        add_button = view.findViewById(R.id.add_button_reja);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getActivity().getSupportFragmentManager();
                add_new_mission add_new_mission = new add_new_mission();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),add_new_mission)
                        .addToBackStack(null)
                        .commit();
                MainActivity.is_create = true;
            }
        });

        rejalar_back_button = view.findViewById(R.id.rejalar_back_button);
        rejalar_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return view;
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
}