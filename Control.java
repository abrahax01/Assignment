// Will try to do Machine learning
public class Control 
{
    public static void main(String[] args) 
    {
        ReadData csv = new ReadData("MLdata.csv");
        csv.openFile();
        csv.readFile();
        
        String[][] stored = csv.getDataByRow();
        int urban = csv.getUrban();

        for(int i = 0; i < 6; i++)
        {
            System.out.print(stored[3][i] + " ");
            
        }
        System.out.println("\n" + urban);
    }
}
