package daily.mission.dailymissions;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sozlamalar extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    ImageButton settings_back_button;
    ShapeableImageView setting_avatar_image;
    RelativeLayout avatar_list;
    RelativeLayout image_list;
    RelativeLayout g_lyt;
    AppCompatButton change_back_image;
    AppCompatButton ok_button;
    EditText edit_user_name;
    ImageView avatar_0,avatar_1,avatar_2,avatar_3,avatar_4,avatar_5,avatar_6,avatar_7,avatar_8,avatar_9,avatar_10,avatar_11,avatar_12,avatar_13,avatar_14,avatar_15,avatar_16,avatar_17,avatar_18,avatar_19,avatar_20,avatar_21,avatar_22,avatar_23,avatar_24,avatar_25,avatar_26,avatar_27,avatar_28,avatar_29;
    ImageView back_img_0,back_img_1,back_img_2,back_img_3,back_img_4,back_img_5,back_img_6,back_img_7,back_img_8;

    ImageButton ettings_user_name_edit_button;
    TextView user_name_editor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sozlamalar, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        user_name_editor = view.findViewById(R.id.user_name_editor);
        user_name_editor.setText(read_file(MainActivity.user_name));
        g_lyt = view.findViewById(R.id.g_lyt);

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

        edit_user_name = view.findViewById(R.id.edit_user_name);
        change_back_image = view.findViewById(R.id.change_back_image);
        change_back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_list.setVisibility(View.VISIBLE);
            }
        });
        ettings_user_name_edit_button = view.findViewById(R.id.settings_user_name_edit_button);
        ettings_user_name_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_user_name.setVisibility(View.VISIBLE);
                edit_user_name.setText(user_name_editor.getText().toString());
                ok_button.setVisibility(View.VISIBLE);
                user_name_editor.setText("");
            }
        });
        avatar_list = view.findViewById(R.id.avatar_list);
        frameLayout = view2.findViewById(R.id.frame_layout);
        image_list = view.findViewById(R.id.background_list);

        ok_button = view.findViewById(R.id.ok_button);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_user_name.setVisibility(View.INVISIBLE);
                user_name_editor.setText(edit_user_name.getText().toString());
                ok_button.setVisibility(View.INVISIBLE);
                write_file(edit_user_name.getText().toString(),MainActivity.user_name);
            }
        });


        back_img_0 = view.findViewById(R.id.back_img_0);
        back_img_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_0);
                image_list.setVisibility(View.INVISIBLE);
                write_file("1",MainActivity.background);

            }
        });
        back_img_1 = view.findViewById(R.id.back_img_1);
        back_img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_1);
                image_list.setVisibility(View.INVISIBLE);
                write_file("2",MainActivity.background);

            }
        });
        back_img_2 = view.findViewById(R.id.back_img_2);
        back_img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_2);
                image_list.setVisibility(View.INVISIBLE);
                write_file("3",MainActivity.background);

            }
        });
        back_img_3 = view.findViewById(R.id.back_img_3);
        back_img_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_3);
                image_list.setVisibility(View.INVISIBLE);
                write_file("4",MainActivity.background);

            }
        });
        back_img_4 = view.findViewById(R.id.back_img_4);
        back_img_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_4);
                image_list.setVisibility(View.INVISIBLE);
                write_file("5",MainActivity.background);

            }
        });
        back_img_5 = view.findViewById(R.id.back_img_5);
        back_img_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_5);
                image_list.setVisibility(View.INVISIBLE);
                write_file("6",MainActivity.background);

            }
        });
        back_img_6 = view.findViewById(R.id.back_img_6);
        back_img_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_6);
                image_list.setVisibility(View.INVISIBLE);
                write_file("7",MainActivity.background);

            }
        });
        back_img_7 = view.findViewById(R.id.back_img_7);
        back_img_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_7);
                image_list.setVisibility(View.INVISIBLE);
                write_file("8",MainActivity.background);

            }
        });
        back_img_8 = view.findViewById(R.id.back_img_8);
        back_img_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.g_layout.setBackgroundResource(R.drawable.back_8);
                image_list.setVisibility(View.INVISIBLE);
                write_file("9",MainActivity.background);

            }
        });

        setting_avatar_image = view.findViewById(R.id.settins_edit_image);

        String awatar_index = read_file(MainActivity.avatar);

        switch (awatar_index){
            case "1":
                setting_avatar_image.setImageResource(R.drawable.avatar_0);
                break;
            case "2":
                setting_avatar_image.setImageResource(R.drawable.avatar_1);
                break;
            case "3":
                setting_avatar_image.setImageResource(R.drawable.avatar_2);
                break;
            case "4":
                setting_avatar_image.setImageResource(R.drawable.avatar_3);
                break;
            case "5":
                setting_avatar_image.setImageResource(R.drawable.avatar_4);
                break;
            case "6":
                setting_avatar_image.setImageResource(R.drawable.avatar_5);
                break;
            case "7":
                setting_avatar_image.setImageResource(R.drawable.avatar_6);
                break;
            case "8":
                setting_avatar_image.setImageResource(R.drawable.avatar_7);
                break;
            case "9":
                setting_avatar_image.setImageResource(R.drawable.avatar_8);
                break;
            case "10":
                setting_avatar_image.setImageResource(R.drawable.avatar_9);
                break;
            case "11":
                setting_avatar_image.setImageResource(R.drawable.avatar_10);
                break;
            case "12":
                setting_avatar_image.setImageResource(R.drawable.avatar_11);
                break;
            case "13":
                setting_avatar_image.setImageResource(R.drawable.avatar_12);
                break;
            case "14":
                setting_avatar_image.setImageResource(R.drawable.avatar_13);
                break;
            case "15":
                setting_avatar_image.setImageResource(R.drawable.avatar_14);
                break;
            case "16":
                setting_avatar_image.setImageResource(R.drawable.avatar_15);
                break;
            case "17":
                setting_avatar_image.setImageResource(R.drawable.avatar_16);
                break;
            case "18":
                setting_avatar_image.setImageResource(R.drawable.avatar_17);
                break;
            case "19":
                setting_avatar_image.setImageResource(R.drawable.avatar_18);
                break;
            case "20":
                setting_avatar_image.setImageResource(R.drawable.avatar_19);
                break;
            case "21":
                setting_avatar_image.setImageResource(R.drawable.avatar_20);
                break;
            case "22":
                setting_avatar_image.setImageResource(R.drawable.avatar_21);
                break;
            case "23":
                setting_avatar_image.setImageResource(R.drawable.avatar_22);
                break;
            case "24":
                setting_avatar_image.setImageResource(R.drawable.avatar_23);
                break;
            case "25":
                setting_avatar_image.setImageResource(R.drawable.avatar_24);
                break;
            case "26":
                setting_avatar_image.setImageResource(R.drawable.avatar_25);
                break;
            case "27":
                setting_avatar_image.setImageResource(R.drawable.avatar_26);
                break;
            case "28":
                setting_avatar_image.setImageResource(R.drawable.avatar_27);
                break;
            case "29":
                setting_avatar_image.setImageResource(R.drawable.avatar_28);
                break;
            case "30":
                setting_avatar_image.setImageResource(R.drawable.avatar_29);
                break;

        }

        setting_avatar_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatar_list.setVisibility(View.VISIBLE);
            }
        });

        settings_back_button = view.findViewById(R.id.settings_back_button);
        settings_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        avatar_0 = view.findViewById(R.id.avatar_0);
        avatar_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_0);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("1",MainActivity.avatar);
            }
        });
        avatar_1 = view.findViewById(R.id.avatar_1);
        avatar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_1);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("2",MainActivity.avatar);
            }
        });
        avatar_2 = view.findViewById(R.id.avatar_2);
        avatar_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_2);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("3",MainActivity.avatar);
            }
        });
        avatar_3 = view.findViewById(R.id.avatar_3);
        avatar_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_3);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("4",MainActivity.avatar);
            }
        });
        avatar_4 = view.findViewById(R.id.avatar_4);
        avatar_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_4);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("5",MainActivity.avatar);
            }
        });
        avatar_5 = view.findViewById(R.id.avatar_5);
        avatar_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_5);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("6",MainActivity.avatar);
            }
        });
        avatar_6 = view.findViewById(R.id.avatar_6);
        avatar_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_6);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("7",MainActivity.avatar);
            }
        });
        avatar_7 = view.findViewById(R.id.avatar_7);
        avatar_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_7);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("8",MainActivity.avatar);
            }
        });
        avatar_8 = view.findViewById(R.id.avatar_8);
        avatar_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_8);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("9",MainActivity.avatar);
            }
        });
        avatar_9 = view.findViewById(R.id.avatar_9);
        avatar_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_9);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("10",MainActivity.avatar);
            }
        });
        avatar_10 = view.findViewById(R.id.avatar_10);
        avatar_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_10);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("11",MainActivity.avatar);
            }
        });
        avatar_11 = view.findViewById(R.id.avatar_11);
        avatar_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_11);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("12",MainActivity.avatar);
            }
        });
        avatar_12 = view.findViewById(R.id.avatar_12);
        avatar_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_12);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("13",MainActivity.avatar);
            }
        });
        avatar_13 = view.findViewById(R.id.avatar_13);
        avatar_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_13);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("14",MainActivity.avatar);
            }
        });
        avatar_14 = view.findViewById(R.id.avatar_14);
        avatar_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_14);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("15",MainActivity.avatar);
            }
        });
        avatar_15 = view.findViewById(R.id.avatar_15);
        avatar_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_15);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("16",MainActivity.avatar);
            }
        });
        avatar_16 = view.findViewById(R.id.avatar_16);
        avatar_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_16);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("17",MainActivity.avatar);
            }
        });
        avatar_17 = view.findViewById(R.id.avatar_17);
        avatar_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_17);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("18",MainActivity.avatar);
            }
        });
        avatar_18 = view.findViewById(R.id.avatar_18);
        avatar_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_18);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("19",MainActivity.avatar);
            }
        });
        avatar_19 = view.findViewById(R.id.avatar_19);
        avatar_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_19);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("20",MainActivity.avatar);
            }
        });
        avatar_20 = view.findViewById(R.id.avatar_20);
        avatar_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_20);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("21",MainActivity.avatar);
            }
        });
        avatar_21 = view.findViewById(R.id.avatar_21);
        avatar_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_21);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("22",MainActivity.avatar);
            }
        });
        avatar_22 = view.findViewById(R.id.avatar_22);
        avatar_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_22);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("23",MainActivity.avatar);
            }
        });
        avatar_23 = view.findViewById(R.id.avatar_23);
        avatar_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_23);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("24",MainActivity.avatar);
            }
        });
        avatar_24 = view.findViewById(R.id.avatar_24);
        avatar_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_24);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("25",MainActivity.avatar);
            }
        });
        avatar_25 = view.findViewById(R.id.avatar_25);
        avatar_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_25);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("26",MainActivity.avatar);
            }
        });
        avatar_26 = view.findViewById(R.id.avatar_26);
        avatar_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_26);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("27",MainActivity.avatar);
            }
        });
        avatar_27 = view.findViewById(R.id.avatar_27);
        avatar_27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_27);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("28",MainActivity.avatar);
            }
        });
        avatar_28 = view.findViewById(R.id.avatar_28);
        avatar_28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_28);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("29",MainActivity.avatar);
            }
        });
        avatar_29 = view.findViewById(R.id.avatar_29);
        avatar_29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting_avatar_image.setImageResource(R.drawable.avatar_29);
                avatar_list.setVisibility(View.INVISIBLE);
                write_file("30",MainActivity.avatar);
            }
        });

        g_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatar_list.setVisibility(View.INVISIBLE);
                image_list.setVisibility(View.INVISIBLE);
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