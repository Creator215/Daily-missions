package daily.mission.dailymissions;

import android.content.Context;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kuntartibi_bajarilganlar extends Fragment {
    View view,view2;
    FrameLayout frameLayout;
    ImageButton back_button;
    LinearLayout item_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_kuntartibi_bajarilganlar, container, false);
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

        if(read_file(MainActivity.kun_tartib).hashCode() != "".hashCode()){
            Data_Reder dataReder = new Data_Reder(read_file(MainActivity.kun_tartib));
            String[][] mass = dataReder.getData().clone();
            for(int i = 0;i < dataReder.getSize();i ++){
                if(mass[i][0].hashCode() == "true".hashCode()){
                    KunTartib_item rejaItem = new KunTartib_item(true,mass[i][1],mass[i][2],mass[i][3]);
                    rejaItem.create(getContext(),item_list);
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