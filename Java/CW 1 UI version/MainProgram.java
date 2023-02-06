public class MainProgram {
    private static Students[] students = new Students[0];  //  All Students Obj Array


    //  Checking ID numbers-----------------------------------------------------------------
    public boolean checkID(String IDNumber){
        //students[0] = new Students("1234","jdjfh",78,89);
        boolean checkOut = false;
        for(int i=0;i<students.length;i++){
            if(students[i].checkID(IDNumber)){
                checkOut = true;
                break;
            }
        }
        return checkOut;
    }

    //  Checking Total----------------------------------------------------------------------
    public int checkTotal(int position){
        return students[position].getTotal();
    }

    //  Check ID Position-------------------------------------------------------------------
    public int checkIDPositon(String ID){
        int count=0;
        for (int i=0;i< students.length;i++){
            if (ID.toUpperCase().equals(students[i].getID())){
                break;
            }
            count++;
        }
        return count;
    }

    //  Set Marks---------------------------------------------------------------------------
    public void setMarks(int pro,int DBMS,int IDPosition){
        students[IDPosition].setMarks(pro, DBMS);
    }
    public void setName(String name,int position){
        students[position].setName(name);
    }

    // Get Methods-------------------------------------------------------------------------
    public String getID(int position){
        return students[position].getID();
    }

    public String getName(int position){
        return students[position].getName();
    }
    public int getProMarks(int position){
        return students[position].getPFMarks();
    }
    public int getDBMSMarks(int position){
        return students[position].getDBMSMarks();
    }
    public int getTotalMarks(int position){
        return students[position].getTotal();
    }


    //  [1],[2]   Add new Student----------------------------------------------------------------
    public static void addNewStudent(String ID, String name,int pro, int DBMS){
        Students[] temp = new Students[students.length+1];
        for (int i=0;i< students.length;i++){
            temp[i] = students[i];
        }
        temp[temp.length-1] = new Students(ID,name,pro,DBMS);
        students = temp;
    }

    public void deleteStudent(int position){
        Students[] temp = new Students[students.length-1];
        for(int i=0;i<position;i++){
            temp[i] = students[i];
        }
        for(int i=(position+1);i<students.length;i++){
            temp[i-1] = students[i];
        }
        students = temp;
    }
    public int getRank(int total){
        int rank =0;
        int[] temp = new int[students.length];

        for (int i=0;i<students.length;i++){
            temp[i] = students[i].getTotal();
        }
        // Sort
        for(int j=0;j<students.length-1;j++){
            for(int i=0;i<students.length-1;i++){
                if(temp[i] < temp[i+1]){
                    int t = temp[i];
                    temp[i] = temp[i+1];
                    temp[i+1] = t;
                }
            }
        }

        for(int i=0;i<temp.length;i++){
            if(total == temp[i]){
                rank = (i+1);
                break;
            }
        }
        return rank;
    }
    public void value(){
        for(int i=0;i< students.length;i++){
            students[i].value();
            System.out.println();
        }
    }
    public int getAllStudentTotal(){
        return students.length;
    }

}
