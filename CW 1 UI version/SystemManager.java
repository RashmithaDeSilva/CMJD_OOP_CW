public class SystemManager {
    private OptionControler[] OC = new OptionControler[0];

    public void updateOCWindows(OptionControler newWindow){
        OptionControler[] temp = new OptionControler[OC.length+1];
        for(int i=0;i<OC.length;i++){
            temp[i] = OC[i];
        }
        temp[temp.length - 1] = newWindow;
        OC = temp;
    }

    public int getOCLength(){
        return OC.length;
    }
    public  String getName(int position){
        return OC[position].getName();
    }
    public  int getNumber(int position){
        return OC[position].getNumber();
    }
    public void setVisible(int potion){
        OC[potion].setVisible("true");
    }
}
