// Will try to do Machine learning
public class Control 
{
    public static void main(String[] args) 
    {
        ReadData csv = new ReadData("MLdata.csv");
        csv.openFile();
        csv.readFile();
    
        csv.naiveBayes("Female", "Yes", "No", "Rural", "Yes");

        // String[][] stored = csv.getDataByRow();
        // for(int i = 0; i < 6; i++)
        // {
        //     System.out.print(stored[3][i] + " ");
            
        // }

        // System.out.println("\n");
        // MachineLearning test = new MachineLearning(stored, "MLdata.csv");
        
        
    }
}
