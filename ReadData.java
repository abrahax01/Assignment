// Class to Read the CSV file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.lang.model.element.Element;

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
        dataByRow = new String[500][6];

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
                if("Male".equals(dataArray[0]) )
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

    // NAIVE BAYES 
    public double naiveBayes(String gender, String ownBusiness, String partTimeJob, String area, String studyBusiness)
    {
        double probOfEntrepreneur = 0;

        // PROBABILITY OF ENTREPRENEUR
        double P_Y_Entrepreneur = (double)yesEntrepreneur / (double)totalData; // 0.56
        double P_N_Entrepreneur = (double)noEntrepreneur / (double)totalData; // 0.44
        
        // PROBABILITY OF EVIDENCE
        double PX_Male = (double)genderMale / (double)totalData; // 0.48
        double PX_Female = (double)genderFemale / (double)totalData; // 0.52

        double PX_Y_OwnBusiness = (double)yesOwnBusiness / (double)totalData; // 0.44
        double PX_N_OwnBusiness = (double)noOwnBusiness / (double)totalData; // 0.56

        double PX_Y_PartTimeJob = (double)yesJob / (double)totalData; // 0.49 
        double PX_N_PartTimeJob = (double)noJob / (double)totalData; // 0.51

        double PX_Rural = (double)rural / (double)totalData; // 0.50 
        double PX_Urban = (double)urban / (double)totalData; // 0.50

        double PX_Y_StudyBusiness = (double)yesStudyBusiness / (double)totalData; // 0.49
        double PX_N_StudyBusiness = (double)noStudyBusiness / (double)totalData; // 0.51  

        // PROBABILITY OF LIKELIHOOD FOR YES 
        int currentDataWithSameFeaturesAndYesEntrepreneur = 0, currentDataWithSameFeaturesAndNoEntrepreneur = 0;
        int male_Y_Entrepreneur = 0, male_N_Entrepreneur = 0;
        // int Male_Y_OwnBusiness = 0, Male_N_OwnBusiness = 0;
        int female_Y_Entrepreneur = 0, female_N_Entrepreneur = 0;

        for (String[] element: dataByRow)
        {   
            // COMPARE DATA SENT WITH CURRENT DATA
            if(gender.equals(element[0]) && ownBusiness.equals(element[1]) && partTimeJob.equals(element[2]) && area.equals(element[3]) && studyBusiness.equals(element[4]) && "Yes".equals(element[5]))
            {
                currentDataWithSameFeaturesAndYesEntrepreneur++;
            }
            else if(gender.equals(element[0]) && ownBusiness.equals(element[1]) && partTimeJob.equals(element[2]) && area.equals(element[3]) && studyBusiness.equals(element[4]) && "No".equals(element[5]))
            {
                currentDataWithSameFeaturesAndNoEntrepreneur++;
            }

            // MALE ENTREPRENEUR
            if("Male".equals(element[0]) && "Yes".equals(element[5]))
            {
                male_Y_Entrepreneur++;
            }
            else if("Male".equals(element[0]) && "No".equals(element[5]))
            {
                male_N_Entrepreneur++;
            }

            // FEMALE ENTREPRENEUR
            else if("Female".equals(element[0]) && "Yes".equals(element[5]))
            {
                female_Y_Entrepreneur++;
            }
            else if("Female".equals(element[0]) && "No".equals(element[5]))
            {
                female_N_Entrepreneur++;
            }
            
        }
        
        System.out.println("Current data YES: " + currentDataWithSameFeaturesAndYesEntrepreneur + "\nCurrent data NO: " + currentDataWithSameFeaturesAndNoEntrepreneur);
        System.out.println("MALE YES ENT: " + male_Y_Entrepreneur + " " + "FEMALE YES ENT: " + female_Y_Entrepreneur);
        System.out.println("MALE NO ENT : " + male_N_Entrepreneur + " " + "FEMALE NO ENT : " + female_N_Entrepreneur);

        // System.out.printf("%.2f", PX_N_StudyBusiness);
        return probOfEntrepreneur;
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
