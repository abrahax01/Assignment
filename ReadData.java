// Class to Read the CSV file + store totals of features

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData 
{
    private String fileName;
    private File fileExample;
    private String[] dataArray;
    private String[][] dataByRow = {};

    private int totalData = 0;
    private int genderMale = 0, genderFemale = 0;
    private int yesOwnBusiness = 0, noOwnBusiness = 0;
    private int yesJob = 0, noJob = 0;
    private int rural = 0, urban = 0;
    private int yesStudyBusiness = 0, noStudyBusiness = 0;
    private int yesEntrepreneur = 0, noEntrepreneur = 0;

    // GET NAME FROM CONTROL CLASS
    public ReadData(String fileName)
    {
        this.fileName = fileName; 
       
    }

    // OPEN THE FILE
    public void openFile()
    {
        fileExample = new File(this.fileName); 
        System.out.println("FILE OPENED");
    }

    // READ FILE
    public void readFile() 
    {
        String line = "";
        int i = 0;
        dataByRow = new String[291][6];

        try 
        {
            // SCAN(READ) FILE 
            Scanner scanner1 = new Scanner(this.fileExample);
            
            // CHECKS FILE FOR NEXT LINE
            while(scanner1.hasNextLine()) 
            {
                line = scanner1.nextLine();
                dataArray = line.split(",");

                int y = 0;

                // STORE ELEMENTS OF ARRAY INTO 2D ARRAY (EASIER TO READ AND SEND)
                for (String element : dataArray) 
                {  
                    dataByRow[i][y] = element;  
                    y++;

                }  

                i++;
                
                // STORE TOTALS OF EACH FEATURE
                if("Male".equals(dataArray[0]))
                {
                    genderMale++;
                    totalData++;
                }
                else if ("Female".equals(dataArray[0])) 
                {
                    genderFemale++;
                    totalData++;
                } 
                if("Yes".equals(dataArray[1]))
                {
                    yesOwnBusiness++;                        
                }
                else if("No".equals(dataArray[1]))
                {
                    noOwnBusiness++;                        
                }
                if("Yes".equals(dataArray[2]))
                {
                    yesJob++;                        
                }
                else if("No".equals(dataArray[2]))
                {
                    noJob++;                        
                }
                if("Rural".equals(dataArray[3]))
                {
                    rural++;                    
                }
                else if("Urban  ".equals(dataArray[3]) || "Urban".equals(dataArray[3]))
                {
                    urban++;                        
                }
                if("Yes".equals(dataArray[4]))
                {                        
                    yesStudyBusiness++;
                }
                else if("No".equals(dataArray[4]))
                {                        
                    noStudyBusiness++;
                }
                if("Yes".equals(dataArray[5]))
                {                        
                    yesEntrepreneur++;
                }
                else if("No".equals(dataArray[5]))
                {
                    noEntrepreneur++;
                }                               
            }
            
            scanner1.close();

        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File Not found");
        }

    }

    // GETTERS AND SETTERS
    public File getFileExample() {
        return fileExample;
    }

    public void setFileExample(File fileExample) {
        this.fileExample = fileExample;
    }

    public String[][] getDataByRow() {
        return dataByRow;
    }

    public void setDataByRow(String[][] dataByRow) {
        this.dataByRow = dataByRow;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getGenderMale() {
        return genderMale;
    }

    public void setGenderMale(int genderMale) {
        this.genderMale = genderMale;
    }

    public int getGenderFemale() {
        return genderFemale;
    }

    public void setGenderFemale(int genderFemale) {
        this.genderFemale = genderFemale;
    }

    public int getYesOwnBusiness() {
        return yesOwnBusiness;
    }

    public void setYesOwnBusiness(int yesOwnBusiness) {
        this.yesOwnBusiness = yesOwnBusiness;
    }

    public int getNoOwnBusiness() {
        return noOwnBusiness;
    }

    public void setNoOwnBusiness(int noOwnBusiness) {
        this.noOwnBusiness = noOwnBusiness;
    }

    public int getYesJob() {
        return yesJob;
    }

    public void setYesJob(int yesJob) {
        this.yesJob = yesJob;
    }

    public int getNoJob() {
        return noJob;
    }

    public void setNoJob(int noJob) {
        this.noJob = noJob;
    }

    public int getRural() {
        return rural;
    }

    public void setRural(int rural) {
        this.rural = rural;
    }

    public int getUrban() {
        return urban;
    }

    public void setUrban(int urban) {
        this.urban = urban;
    }

    public int getYesStudyBusiness() {
        return yesStudyBusiness;
    }

    public void setYesStudyBusiness(int yesStudyBusiness) {
        this.yesStudyBusiness = yesStudyBusiness;
    }

    public int getNoStudyBusiness() {
        return noStudyBusiness;
    }

    public void setNoStudyBusiness(int noStudyBusiness) {
        this.noStudyBusiness = noStudyBusiness;
    }

    public int getYesEntrepreneur() {
        return yesEntrepreneur;
    }

    public void setYesEntrepreneur(int yesEntrepreneur) {
        this.yesEntrepreneur = yesEntrepreneur;
    }

    public int getNoEntrepreneur() {
        return noEntrepreneur;
    }

    public void setNoEntrepreneur(int noEntrepreneur) {
        this.noEntrepreneur = noEntrepreneur;
    }

}
