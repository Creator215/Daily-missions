package daily.mission.dailymissions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kuntartibi_tahrirlash extends Fragment {

    View view,view2;
    FrameLayout frameLayout;
    ImageView back_button;
    LinearLayout item_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_kuntartibi_tahrirlash, container, false);
        view2 = inflater.inflate(R.layout.activity_main,container,false);
        item_list = view.findViewById(R.id.item_list);
        frameLayout = view2.findViewById(R.id.frame_layout);
        back_button = view.findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        List<KunTartib_edit> kunTartibEdits = new ArrayList<KunTartib_edit>();

        if(read_file(MainActivity.kun_tartib).hashCode() != "".hashCode()){
            Data_Reder dataReder = new Data_Reder(read_file(MainActivity.kun_tartib));
            String[][] mass = dataReder.getData().clone();
            for(int i = 0;i < dataReder.getSize();i ++){
                if(mass[i][0].hashCode() == "false".hashCode()){
                    KunTartib_edit kunTartibItem = new KunTartib_edit(false,mass[i][1],mass[i][2],mass[i][3]);
                    kunTartibItem.create(getContext(),item_list,frameLayout);
                    kunTartibEdits.add(kunTartibItem);
                }
                else {
                    KunTartib_edit kunTartibItem = new KunTartib_edit(true,mass[i][1],mass[i][2],mass[i][3]);
                    kunTartibItem.create(getContext(),item_list,frameLayout);
                    kunTartibEdits.add(kunTartibItem);
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