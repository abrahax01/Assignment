import java.util.Hashtable;

// Will try to do Machine learning
public class Control 
{
    public static void main(String[] args) 
    {
        ReadData csv = new ReadData("MLdata.csv");
        csv.openFile();
        csv.readFile();
        String[][] dataByRow = csv.getDataByRow();
       
        Hashtable<String, Integer> dataDictionary = new Hashtable<String, Integer>();

        dataDictionary.put("genderMale", csv.getGenderMale());
        dataDictionary.put("genderFemale", csv.getGenderFemale());
        dataDictionary.put("yesOwnBusiness", csv.getYesOwnBusiness());
        dataDictionary.put("noOwnBusiness", csv.getNoOwnBusiness());
        dataDictionary.put("yesJob", csv.getYesJob());
        dataDictionary.put("noJob", csv.getNoJob());
        dataDictionary.put("rural", csv.getRural());
        dataDictionary.put("urban", csv.getUrban());
        dataDictionary.put("yesStudyBusiness", csv.getYesStudyBusiness());
        dataDictionary.put("noStudyBusiness", csv.getNoStudyBusiness());
        dataDictionary.put("yesEntrepreneur", csv.getYesEntrepreneur());
        dataDictionary.put("noEntrepreneur", csv.getNoEntrepreneur());
        dataDictionary.put("totalData", csv.getTotalData());

        System.out.println(csv.getTotalData());

        MachineLearning naiveBayes = new MachineLearning("Male", "Yes", "Yes", "Urban", "Yes", dataDictionary, dataByRow);
    
        // csv.naiveBayes("Male", "Yes", "Yes", "Urban", "Yes");

        // String[][] stored = csv.getDataByRow();
        // for(int i = 0; i < 6; i++)
        // {
        //     System.out.print(stored[3][i] + " ");
            
        // }

        // System.out.println("\n");
        // MachineLearning test = new MachineLearning(stored, "MLdata.csv");
        
        
    }
}
