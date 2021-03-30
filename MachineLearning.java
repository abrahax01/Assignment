// NAIVE BAYES ALGORITHM
public class MachineLearning extends ReadData
{
    private String gender, ownBusiness, partTimeJob, area, studyBusiness, entrepreneur;

    public MachineLearning(String[][] stored, String fileName) 
    {   
        super(fileName);  
        ReadData data = new ReadData(fileName);
        data.openFile();
        data.readFile();
        int totalData = data.getTotalData();
        int genderMale = data.getGenderMale();
        int genderFemale = data.getGenderFemale();
         
        // PROBABILITY 
        System.out.println("Test " +  stored[3][0] + " " + totalData + " " + genderMale + " " + genderFemale);


    }
    
}
