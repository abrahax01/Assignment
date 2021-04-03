// Program to predict if a student with features entered by user will become an entrepreneur or not using naive bayes theorem
// Author: Abraham Izarra/ C19340801

import java.util.Hashtable;

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

        new GUI("New Entrepreneur?", dataDictionary, dataByRow);
        
    }
}
