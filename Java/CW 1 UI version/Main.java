public class Main {
    public static void main(String[] args) {
        SystemManager SM = new SystemManager();
        SM.updateOCWindows(new AddNewStudent());
        SM.updateOCWindows(new AddNewStudentWithMarks());
        SM.updateOCWindows(new AddMarks());
        SM.updateOCWindows(new UpdateStudentDetails());
        SM.updateOCWindows(new UpdateMarks());
        SM.updateOCWindows(new DeleteStudent());
        SM.updateOCWindows(new PrintStudentDetails());
        SM.updateOCWindows(new PrintStudentRanks());
        SM.updateOCWindows(new BestInProgrammingFundamentals());
        SM.updateOCWindows(new BestInDatabaseManagementSystem());

        HomePage home = new HomePage(SM);
        home.setVisible(true);
    }
}