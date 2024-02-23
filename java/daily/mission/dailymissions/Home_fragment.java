package daily.mission.dailymissions;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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

import com.google.android.material.imageview.ShapeableImageView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Home_fragment extends Fragment {
    View view,view2;
    LinearLayout menu_layout;
    ImageButton menu_button;
    FrameLayout frameLayout;
    RelativeLayout kun_tartibi_layout,rejalar_layout;
    ImageButton kun_tartibi_button,rejalar_button;
    TextView kun_tartibi_title,rejalar_title;
    ShapeableImageView user_avatar;
    public static FragmentActivity activity;
    ImageButton about_menu,statistika_menu,password_menu,setting_menu;
    AppCompatButton dastur_haqida_title,statistika_title,parol_title,sozlamalar_title;

    LinearLayout menu_panel;
    TextView user_name_title;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        user_name_title = view.findViewById(R.id.user_name_title);
        user_avatar = view.findViewById(R.id.user_avatar);
        MainActivity.vaziyat = 0;
        activity = getActivity();

        String txt = read_file(MainActivity.user_name);
        String awatar_index = read_file(MainActivity.avatar);

        switch (awatar_index){
            case "1":
                user_avatar.setImageResource(R.drawable.avatar_0);
                break;
            case "2":
                user_avatar.setImageResource(R.drawable.avatar_1);
                break;
            case "3":
                user_avatar.setImageResource(R.drawable.avatar_2);
                break;
            case "4":
                user_avatar.setImageResource(R.drawable.avatar_3);
                break;
            case "5":
                user_avatar.setImageResource(R.drawable.avatar_4);
                break;
            case "6":
                user_avatar.setImageResource(R.drawable.avatar_5);
                break;
            case "7":
                user_avatar.setImageResource(R.drawable.avatar_6);
                break;
            case "8":
                user_avatar.setImageResource(R.drawable.avatar_7);
                break;
            case "9":
                user_avatar.setImageResource(R.drawable.avatar_8);
                break;
            case "10":
                user_avatar.setImageResource(R.drawable.avatar_9);
                break;
            case "11":
                user_avatar.setImageResource(R.drawable.avatar_10);
                break;
            case "12":
                user_avatar.setImageResource(R.drawable.avatar_11);
                break;
            case "13":
                user_avatar.setImageResource(R.drawable.avatar_12);
                break;
            case "14":
                user_avatar.setImageResource(R.drawable.avatar_13);
                break;
            case "15":
                user_avatar.setImageResource(R.drawable.avatar_14);
                break;
            case "16":
                user_avatar.setImageResource(R.drawable.avatar_15);
                break;
            case "17":
                user_avatar.setImageResource(R.drawable.avatar_16);
                break;
            case "18":
                user_avatar.setImageResource(R.drawable.avatar_17);
                break;
            case "19":
                user_avatar.setImageResource(R.drawable.avatar_18);
                break;
            case "20":
                user_avatar.setImageResource(R.drawable.avatar_19);
                break;
            case "21":
                user_avatar.setImageResource(R.drawable.avatar_20);
                break;
            case "22":
                user_avatar.setImageResource(R.drawable.avatar_21);
                break;
            case "23":
                user_avatar.setImageResource(R.drawable.avatar_22);
                break;
            case "24":
                user_avatar.setImageResource(R.drawable.avatar_23);
                break;
            case "25":
                user_avatar.setImageResource(R.drawable.avatar_24);
                break;
            case "26":
                user_avatar.setImageResource(R.drawable.avatar_25);
                break;
            case "27":
                user_avatar.setImageResource(R.drawable.avatar_26);
                break;
            case "28":
                user_avatar.setImageResource(R.drawable.avatar_27);
                break;
            case "29":
                user_avatar.setImageResource(R.drawable.avatar_28);
                break;
            case "30":
                user_avatar.setImageResource(R.drawable.avatar_29);
                break;

        }

        String back = read_file(MainActivity.background);
        switch (back){
            case "1":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_0);
                break;
            case "2":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_1);
                break;
            case "3":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_2);
                break;
            case "4":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_3);
                break;
            case "5":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_4);
                break;
            case "6":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_5);
                break;
            case "7":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_6);
                break;
            case "8":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_7);
                break;
            case "9":
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_8);
                break;
        }

        user_name_title.setText(txt);



        menu_panel = view.findViewById(R.id.menu_panel);

        frameLayout = view2.findViewById(R.id.frame_layout);

        menu_layout = view.findViewById(R.id.menu_layout);
        menu_button = view.findViewById(R.id.menu_button);

        kun_tartibi_layout = view.findViewById(R.id.kun_tartibi_layout);
        kun_tartibi_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Kuntartib kuntartib = new Kuntartib();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        kun_tartibi_button = view.findViewById(R.id.kun_tartibi_button);
        kun_tartibi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Kuntartib kuntartib = new Kuntartib();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        kun_tartibi_title = view.findViewById(R.id.kun_tartib_title);
        kun_tartibi_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Kuntartib kuntartib = new Kuntartib();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });

        rejalar_layout = view.findViewById(R.id.rejalar_layout);
        rejalar_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Rejalar kuntartib = new Rejalar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        rejalar_button = view.findViewById(R.id.rejalar_button);
        rejalar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Rejalar kuntartib = new Rejalar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });
        rejalar_title = view.findViewById(R.id.rejalar_title);
        rejalar_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Rejalar kuntartib = new Rejalar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),kuntartib)
                        .addToBackStack(null)
                        .commit();
            }
        });

        menu_panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu_layout.getVisibility() == View.VISIBLE) {
                    menu_layout.setVisibility(View.INVISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.menu_panel2));
                    kun_tartibi_layout.setEnabled(true);
                    kun_tartibi_button.setEnabled(true);
                    kun_tartibi_title.setEnabled(true);
                    rejalar_layout.setEnabled(true);
                    rejalar_button.setEnabled(true);
                    rejalar_title.setEnabled(true);
                }
            }
        });

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menu_layout.getVisibility() == View.INVISIBLE){
                    menu_layout.setVisibility(View.VISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.menu_panel));
                    kun_tartibi_layout.setEnabled(false);
                    kun_tartibi_button.setEnabled(false);
                    kun_tartibi_title.setEnabled(false);
                    rejalar_layout.setEnabled(false);
                    rejalar_button.setEnabled(false);
                    rejalar_title.setEnabled(false);
                }else if(menu_layout.getVisibility() == View.VISIBLE){
                    menu_layout.setVisibility(View.INVISIBLE);
                    menu_layout.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.menu_panel2));
                    kun_tartibi_layout.setEnabled(true);
                    kun_tartibi_button.setEnabled(true);
                    kun_tartibi_title.setEnabled(true);
                    rejalar_layout.setEnabled(true);
                    rejalar_button.setEnabled(true);
                    rejalar_title.setEnabled(true);
                }
            }
        });

        about_menu = view.findViewById(R.id.abouut_menu);
        about_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Dastur_haqida dasturHaqida = new Dastur_haqida();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),dasturHaqida)
                        .addToBackStack(null)
                        .commit();
            }
        });
        dastur_haqida_title = view.findViewById(R.id.dastur_haqida_title);
        dastur_haqida_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Dastur_haqida dasturHaqida = new Dastur_haqida();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),dasturHaqida)
                        .addToBackStack(null)
                        .commit();
            }
        });
        statistika_menu = view.findViewById(R.id.statistika_menu);
        statistika_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Statistika statistika = new Statistika();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),statistika)
                        .addToBackStack(null)
                        .commit();
            }
        });
        statistika_title = view.findViewById(R.id.statistika_title);
        statistika_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Statistika statistika = new Statistika();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),statistika)
                        .addToBackStack(null)
                        .commit();
            }
        });
        password_menu = view.findViewById(R.id.password_menu);
        password_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Parol parol = new Parol();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),parol)
                        .addToBackStack(null)
                        .commit();
            }
        });
        parol_title = view.findViewById(R.id.parol_title);
        parol_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Parol parol = new Parol();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),parol)
                        .addToBackStack(null)
                        .commit();
            }
        });
        setting_menu = view.findViewById(R.id.setting_menu);
        setting_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Sozlamalar sozlamalar = new Sozlamalar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),sozlamalar)
                        .addToBackStack(null)
                        .commit();
            }
        });
        sozlamalar_title = view.findViewById(R.id.sozlamalar_title);
        sozlamalar_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Sozlamalar sozlamalar = new Sozlamalar();
                manager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(frameLayout.getId(),sozlamalar)
                        .addToBackStack(null)
                        .commit();
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
}