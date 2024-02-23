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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parol extends Fragment {
    int qadam = 1;
    FrameLayout frameLayout;
    View view,view2;
    TextView message_text;
    ImageView number_1,number_2,number_3,number_4;
    ImageButton parol_back_button;
    AppCompatButton but_1,but_2,but_3,but_4,but_5,but_6,but_7,but_8,but_9,but_x,but_0,but_ok;
    String num_1 = "",num_2 = "",num_3 = "",num_4 = "";
    String pin = "";
    String pin_d = "";
    AppCompatButton delete_pin;

    RelativeLayout control_panel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_parol, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        frameLayout = view2.findViewById(R.id.frame_layout);
        control_panel = view.findViewById(R.id.control_panel);

        message_text = view.findViewById(R.id.parol_message_text);

        delete_pin = view.findViewById(R.id.delete_pin);

        number_1 = view.findViewById(R.id.number_1);
        number_2 = view.findViewById(R.id.number_2);
        number_3 = view.findViewById(R.id.number_3);
        number_4 = view.findViewById(R.id.number_4);

        if(MainActivity.vaziyat == 0){
            control_panel.setVisibility(View.VISIBLE);
            delete_pin.setVisibility(View.INVISIBLE);
            if(read_file(MainActivity.password).hashCode() != "****".hashCode()){
                message_text.setText("Parolni kiriting");
            }
            else{
                message_text.setText("Ilovaga parol o'rnating");
                qadam = 2;
            }
        }
        else if(MainActivity.vaziyat == 1){
            control_panel.setVisibility(View.INVISIBLE);
            delete_pin.setVisibility(View.INVISIBLE);
            message_text.setText("Parolni kiriting");
        }

        String data = read_file(MainActivity.password);

        if(data.hashCode() != "****".hashCode()){
            qadam = 1;
        }
        else if(data.hashCode() == "****".hashCode()){
            qadam = 2;
        }

        parol_back_button = view.findViewById(R.id.parol_back_button);
        parol_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        but_1 = view.findViewById(R.id.but_1);
        but_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "1";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "1";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "1";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "1";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_2 = view.findViewById(R.id.but_2);
        but_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "2";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "2";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "2";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "2";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_3 = view.findViewById(R.id.but_3);
        but_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "3";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "3";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "3";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "3";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_4 = view.findViewById(R.id.but_4);
        but_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "4";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "4";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "4";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "4";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_5 = view.findViewById(R.id.but_5);
        but_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "5";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "5";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "5";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "5";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_6 = view.findViewById(R.id.but_6);
        but_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "6";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "6";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "6";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "6";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_7 = view.findViewById(R.id.but_7);
        but_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "7";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "7";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "7";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "7";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_8 = view.findViewById(R.id.but_8);
        but_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "8";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "8";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "8";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "8";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_9 = view.findViewById(R.id.but_9);
        but_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "9";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "9";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "9";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "9";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_x = view.findViewById(R.id.but_x);
        but_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_1.setImageResource(R.drawable.p_2);
                number_2.setImageResource(R.drawable.p_2);
                number_3.setImageResource(R.drawable.p_2);
                number_4.setImageResource(R.drawable.p_2);
                num_1 = "";
                num_2 = "";
                num_3 = "";
                num_4 = "";
                pin = "";
            }
        });
        but_0 = view.findViewById(R.id.but_0);
        but_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((num_1.hashCode() == "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_1 = "0";
                    number_1.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() == "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_2 = "0";
                    number_2.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() == "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_3 = "0";
                    number_3.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() == "".hashCode())){
                    num_4 = "0";
                    number_4.setImageResource(R.drawable.p_1);
                }
                else if((num_1.hashCode() != "".hashCode() && num_2.hashCode() != "".hashCode()) && (num_3.hashCode() != "".hashCode() && num_4.hashCode() != "".hashCode())){

                }
            }
        });
        but_ok = view.findViewById(R.id.but_ok);
        but_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((num_1.hashCode() != "".hashCode()) && (num_2.hashCode() != "".hashCode())) && ((num_3.hashCode() != "".hashCode()) && (num_4.hashCode() != "".hashCode()))){
                    if(qadam == 1){
                        pin = num_1 + num_2 + num_3 + num_4;
                        if(read_file(MainActivity.password).hashCode() == pin.hashCode()){
                            if(MainActivity.vaziyat == 1){
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.commit();
                                Toast.makeText(getActivity(), "Parol to'g'ri", Toast.LENGTH_SHORT).show();
                                try {
                                    fragmentTransaction.replace(frameLayout.getId(), Home_fragment.class.newInstance());
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                } catch (java.lang.InstantiationException e) {
                                    throw new RuntimeException(e);
                                }
                            }else {
                                message_text.setText("Yangi parol yarating");
                                number_1.setImageResource(R.drawable.p_2);
                                number_2.setImageResource(R.drawable.p_2);
                                number_3.setImageResource(R.drawable.p_2);
                                number_4.setImageResource(R.drawable.p_2);
                                qadam = 2;
                                num_1 = "";
                                num_2 = "";
                                num_3 = "";
                                num_4 = "";
                                delete_pin.setVisibility(View.VISIBLE);
                            }
                        }
                        else {
                            message_text.setText("Parol xato,qaytadan urinib ko'ring");
                            number_1.setImageResource(R.drawable.p_2);
                            number_2.setImageResource(R.drawable.p_2);
                            number_3.setImageResource(R.drawable.p_2);
                            number_4.setImageResource(R.drawable.p_2);

                            num_1 = "";
                            num_2 = "";
                            num_3 = "";
                            num_4 = "";


                        }
                    }
                    else if(qadam == 2){
                        pin = num_1 + num_2 + num_3 + num_4;
                        message_text.setText("Parolni takrorlang");
                        number_1.setImageResource(R.drawable.p_2);
                        number_2.setImageResource(R.drawable.p_2);
                        number_3.setImageResource(R.drawable.p_2);
                        number_4.setImageResource(R.drawable.p_2);
                        qadam = 3;
                        num_1 = "";
                        num_2 = "";
                        num_3 = "";
                        num_4 = "";
                    }
                    else if(qadam == 3){
                        pin_d = num_1 + num_2 + num_3 + num_4;
                        if(pin.hashCode() == pin_d.hashCode()){
                            write_file(pin,MainActivity.password);
                            Toast.makeText(getActivity(), pin+" paroli o'rnatildi", Toast.LENGTH_SHORT).show();
                            getActivity().onBackPressed();
                        }
                        else {
                            message_text.setText("Takroriy parol xato,yangidan parol yarating");
                            number_1.setImageResource(R.drawable.p_2);
                            number_2.setImageResource(R.drawable.p_2);
                            number_3.setImageResource(R.drawable.p_2);
                            number_4.setImageResource(R.drawable.p_2);
                            qadam = 2;
                            pin = "";
                            pin_d = "";
                            num_1 = "";
                            num_2 = "";
                            num_3 = "";
                            num_4 = "";
                        }
                    }
                }
                else {

                }
            }
        });
        delete_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write_file("****",MainActivity.password);
                Toast.makeText(getActivity(), "Parol olib tashlandi", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        });
        return view;
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