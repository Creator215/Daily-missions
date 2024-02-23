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
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class add_item_fragment extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    ImageButton clock_up,clock_down,minut_up,minut_down;
    int clock = 0,minut = 0;
    AppCompatButton cancel_button,create_button,delete_button;
    TextView clock_t,minut_t,window_title;
    EditText create_job;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_add_item_fragment, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        frameLayout = view2.findViewById(R.id.frame_layout);
        window_title = view.findViewById(R.id.window_title);

        create_job = view.findViewById(R.id.create_job);

        clock_t = view.findViewById(R.id.clock);
        minut_t = view.findViewById(R.id.minut);
        clock_up = view.findViewById(R.id.clock_up);
        clock_down = view.findViewById(R.id.clock_down);
        minut_up = view.findViewById(R.id.minut_up);
        minut_down = view.findViewById(R.id.minut_down);
        create_button = view.findViewById(R.id.create_button);
        delete_button = view.findViewById(R.id.delete_button);

        if(MainActivity.is_create){

            delete_button.setVisibility(View.INVISIBLE);
            clock_up.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(clock >= 23){
                        clock = 0;
                        clock_t.setText(String.valueOf(clock));
                    }
                    else {
                        clock += 1;
                        clock_t.setText(String.valueOf(clock));
                    }
                }
            });
            clock_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clock <= 0){
                        clock = 23;
                        clock_t.setText(String.valueOf(clock));
                    }
                    else {
                        clock -= 1;
                        clock_t.setText(String.valueOf(clock));
                    }
                }
            });
            minut_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(minut >= 59){
                        minut = 0;
                        minut_t.setText(String.valueOf(minut));
                    }
                    else {
                        minut += 1;
                        minut_t.setText(String.valueOf(minut));
                    }
                }
            });
            minut_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(minut <= 0){
                        minut = 59;
                        minut_t.setText(String.valueOf(minut));
                    }
                    else {
                        minut -= 1;
                        minut_t.setText(String.valueOf(minut));
                    }
                }
            });
            create_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(create_job.getText().toString().hashCode() != "".hashCode()){
                        String my_data = "&<false><"+create_job.getText().toString()+"><"+clock+"><"+minut+">";
                        write_file(my_data,MainActivity.kun_tartib,Context.MODE_APPEND);
                        getActivity().onBackPressed();
                    }
                    else {
                        Toast.makeText(getContext(), "Iltimos ish nomini kiriting", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            clock = Integer.valueOf(MainActivity.job_clock_t);
            minut = Integer.valueOf(MainActivity.job_minut_t);
            clock_t.setText(clock+"");
            minut_t.setText(minut+"");
            create_job.setText(MainActivity.job_title_t);
            window_title.setText("Ishni tahrirlash");
            delete_button.setVisibility(View.VISIBLE);
            delete_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(MainActivity.is_okey){
                        String new_data = read_file(MainActivity.kun_tartib).replace("&<true><"+MainActivity.job_title_t+"><"+MainActivity.job_clock_t+"><"+MainActivity.job_minut_t+">","");
                        write_file(new_data,MainActivity.kun_tartib,Context.MODE_PRIVATE);
                        getActivity().onBackPressed();
                    }
                    else {
                        String new_data = read_file(MainActivity.kun_tartib).replace("&<false><"+MainActivity.job_title_t+"><"+MainActivity.job_clock_t+"><"+MainActivity.job_minut_t+">","");
                        write_file(new_data,MainActivity.kun_tartib,Context.MODE_PRIVATE);
                        getActivity().onBackPressed();
                    }
                }
            });
            clock_up.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(clock >= 23){
                        clock = 0;
                        clock_t.setText(String.valueOf(clock));
                    }
                    else {
                        clock += 1;
                        clock_t.setText(String.valueOf(clock));
                    }
                }
            });
            clock_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clock <= 0){
                        clock = 23;
                        clock_t.setText(String.valueOf(clock));
                    }
                    else {
                        clock -= 1;
                        clock_t.setText(String.valueOf(clock));
                    }
                }
            });
            minut_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(minut >= 59){
                        minut = 0;
                        minut_t.setText(String.valueOf(minut));
                    }
                    else {
                        minut += 1;
                        minut_t.setText(String.valueOf(minut));
                    }
                }
            });
            minut_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(minut <= 0){
                        minut = 59;
                        minut_t.setText(String.valueOf(minut));
                    }
                    else {
                        minut -= 1;
                        minut_t.setText(String.valueOf(minut));
                    }
                }
            });
            create_button.setText("Yangilash");
            create_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(MainActivity.is_okey){
                        if(create_job.getText().toString().hashCode() != "".hashCode()){
                            String new_data = read_file(MainActivity.kun_tartib).replace("&<true><"+MainActivity.job_title_t+"><"+MainActivity.job_clock_t+"><"+MainActivity.job_minut_t+">","&<true><"+create_job.getText().toString()+"><"+clock+"><"+minut+">");
                            write_file(new_data,MainActivity.kun_tartib,Context.MODE_PRIVATE);
                            getActivity().onBackPressed();
                        }
                        else {
                            Toast.makeText(getContext(), "Ish nomini kiriting", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        if(create_job.getText().toString().hashCode() != "".hashCode()){
                            String new_data = read_file(MainActivity.kun_tartib).replace("&<false><"+MainActivity.job_title_t+"><"+MainActivity.job_clock_t+"><"+MainActivity.job_minut_t+">","&<false><"+create_job.getText().toString()+"><"+clock+"><"+minut+">");
                            write_file(new_data,MainActivity.kun_tartib,Context.MODE_PRIVATE);
                            getActivity().onBackPressed();
                        }
                        else {
                            Toast.makeText(getContext(), "Ish nomini kiriting", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });


        }

        cancel_button = view.findViewById(R.id.cancel_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
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
    private void write_file(String data,String file_name,int Type){
        FileOutputStream fos = null;

        try {
            fos = MainActivity.application.openFileOutput(file_name, Type);
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