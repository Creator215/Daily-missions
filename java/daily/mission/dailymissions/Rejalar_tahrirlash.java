package daily.mission.dailymissions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rejalar_tahrirlash extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    ImageButton back_button;
    LinearLayout item_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_rejalar_tahrirlash, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        frameLayout = view2.findViewById(R.id.frame_layout);
        item_list = view.findViewById(R.id.item_list);

        back_button = view.findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        if(read_file(MainActivity.rejalar).hashCode() != "".hashCode()){
            Big_Data_Reder bigDataReder = new Big_Data_Reder(read_file(MainActivity.rejalar));
            String[][] mass = bigDataReder.getData().clone();

            for(int i = 0;i < bigDataReder.getSize();i ++){
                if(mass[i][0].hashCode() == "true".hashCode()){
                    Reja_edit rejaEdit = new Reja_edit(true,mass[i][1],mass[i][2],mass[i][3],mass[i][4],mass[i][5]);
                    rejaEdit.create(getContext(),item_list,frameLayout);
                }
                else if(mass[i][0].hashCode() == "false".hashCode()){
                    Reja_edit rejaEdit = new Reja_edit(false,mass[i][1],mass[i][2],mass[i][3],mass[i][4],mass[i][5]);
                    rejaEdit.create(getContext(),item_list,frameLayout);
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