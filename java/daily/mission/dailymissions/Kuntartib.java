package daily.mission.dailymissions;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kuntartib extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    LinearLayout menu_layout,item_list;
    RelativeLayout item_panel;
    ImageButton back_button,kuntartib_menu_button,add_button,bajarilgan_menu,tahrirlash_menu;
    AppCompatButton bajarilgan_title,tahrirlash_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_kuntartib, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        item_list = view.findViewById(R.id.item_list);

        bajarilgan_menu = view.findViewById(R.id.setting_menu);
        bajarilgan_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Kuntartibi_bajarilganlar kuntartib = new Kuntartibi_bajarilganlar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        bajarilgan_title = view.findViewById(R.id.sozlamalar_title);
        bajarilgan_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Kuntartibi_bajarilganlar kuntartib = new Kuntartibi_bajarilganlar();
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
                Kuntartibi_tahrirlash kuntartib = new Kuntartibi_tahrirlash();
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
                Kuntartibi_tahrirlash kuntartib = new Kuntartibi_tahrirlash();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });


        add_button = view.findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                add_item_fragment kuntartib = new add_item_fragment();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
                MainActivity.is_create = true;
            }
        });

        frameLayout = view2.findViewById(R.id.frame_layout);
        item_panel = view.findViewById(R.id.item_panel);
        item_panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu_layout.getVisibility() == View.VISIBLE){
                    menu_layout.setVisibility(View.INVISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.menu_panel2));
                }
            }
        });
        menu_layout = view.findViewById(R.id.menu_layout);

        kuntartib_menu_button = view.findViewById(R.id.kuntartib_menu_button);
        kuntartib_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu_layout.getVisibility() == View.INVISIBLE){
                    menu_layout.setVisibility(View.VISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.menu_panel));
                }else {
                    menu_layout.setVisibility(View.INVISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.menu_panel2));
                }
            }
        });

        back_button = view.findViewById(R.id.kuntartib_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        if(read_file(MainActivity.kun_tartib).hashCode() != "".hashCode()){
            Data_Reder dataReder = new Data_Reder(read_file(MainActivity.kun_tartib));
            String[][] mass = dataReder.getData().clone();
            for(int i = 0;i < dataReder.getSize();i ++){
                if(mass[i][0].hashCode() == "false".hashCode()){
                    KunTartib_item kunTartibItem = new KunTartib_item(false,mass[i][1],mass[i][2],mass[i][3]);
                    kunTartibItem.create(getContext(),item_list);
                }
            }
        }
        

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
}