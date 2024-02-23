package daily.mission.dailymissions;

public class Data_Reder{
    public String data;
    public Data_Reder(String data){
        this.data = data;
    }



    public String[][] getData(){

        int data_size = 0;
        for(int i = 0;i < this.data.length();i ++){
            if(this.data.charAt(i) == (char) '&'){
                data_size += 1;
            }
        }

        String[][] filter_data = new String[data_size][4];

        int index = 0;
        int index2 = -1;

        for(int i = 0;i < this.data.length();i ++){
            if(this.data.charAt(i) == (char) '<'){

                int begin = i+1;
                String mini_data = "";

                while (true) {

                    if(this.data.charAt(begin) != (char) '>'){
                        mini_data += this.data.charAt(begin);
                        begin++;
                    }
                    else{
                        if(index == 3){
                            filter_data[index2][index] = mini_data;
                            index = 0;
                            break;
                        }
                        else{
                            filter_data[index2][index] = mini_data;
                            index += 1;
                            break;
                        }

                    }
                }
            }
            if(this.data.charAt(i) == (char) '&'){
                index2 += 1;
            }
        }

        return filter_data;

    }

    public int getSize(){

        int data_size = 0;
        for(int i = 0;i < this.data.length();i ++){
            if(this.data.charAt(i) == (char) '&'){
                data_size += 1;
            }
        }
        return data_size;
    }
}