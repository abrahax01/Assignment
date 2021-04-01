// Class to Read the CSV file
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

        int currentDataWithSameFeaturesAndYesEntrepreneur = 0, currentDataWithSameFeaturesAndNoEntrepreneur = 0;

        // VARIABLES FOR FEATURES OF MALES AND FEMALES WHEN THEY BECAME ENTREPRENEURS (1 IN THE NAME MEANS THEY ARE ENTREPRENEURS)
        int male_Y_Entrepreneur1 = 0;
        int male_Y_OwnBusiness1 = 0, male_N_OwnBusiness1 = 0;
        int male_Y_PartTimeJob1 = 0, male_N_PartTimeJob1 = 0;
        int maleUrban1 = 0, maleRural1 = 0;
        int male_Y_StudyBusiness1 = 0, male_N_StudyBusiness1 = 0;

        int female_Y_Entrepreneur1 = 0;
        int female_Y_OwnBusiness1 = 0, female_N_OwnBusiness1 = 0;
        int female_Y_PartTimeJob1 = 0, female_N_PartTimeJob1 = 0;
        int femaleUrban1 = 0, femaleRural1 = 0;
        int female_Y_StudyBusiness1 = 0, female_N_StudyBusiness1 = 0;
        
        // VARIABLES FOR FEATURES OF MALES AND FEMALES WHEN THEY DID NOT BECOME ENTREPRENEURS (0 IN THE NAME MEANS THEY ARE NOT ENTREPRENEURS)
        int male_N_Entrepreneur0 = 0;
        int male_Y_OwnBusiness0 = 0, male_N_OwnBusiness0 = 0;
        int male_Y_PartTimeJob0 = 0, male_N_PartTimeJob0 = 0;
        int maleUrban0 = 0, maleRural0 = 0;
        int male_Y_StudyBusiness0 = 0, male_N_StudyBusiness0 = 0;

        int female_N_Entrepreneur0 = 0;
        int female_Y_OwnBusiness0 = 0, female_N_OwnBusiness0 = 0;
        int female_Y_PartTimeJob0 = 0, female_N_PartTimeJob0 = 0;
        int femaleUrban0 = 0, femaleRural0 = 0;
        int female_Y_StudyBusiness0 = 0, female_N_StudyBusiness0 = 0;

        int j = 0, k = 0;
        boolean check = true;
        // GET TOTALS FOR PROBABILITY OF LIKELIHOOD 
        for (String[] element: dataByRow)
        {
            while(check)
            {
                int i = 0;
                // FEATURES TOTALS FOR YES ENTREPRENEUR
                for(String[] element2: dataByRow)
                {
                    if(element2[k].equals(dataByRow[i][j]) && "Yes".equals(element2[5]))
                    {
                        if("Male".equals(element2[k]))
                        {
                            male_Y_Entrepreneur1++;

                            if("Yes".equals(element2[1]))
                            {
                                male_Y_OwnBusiness1++;
                            }
                            else if("No".equals(element2[1]))
                            {
                                male_N_OwnBusiness1++;
                            }
                            if("Yes".equals(element2[2]))
                            {
                                male_Y_PartTimeJob1++;
                            }
                            else if("No".equals(element2[2]))
                            {
                                male_N_PartTimeJob1++;
                            }
                            if("Urban".equals(element2[3]) || "Urban  ".equals(element2[3]))
                            {
                                maleUrban1++;
                            }
                            else if("Rural".equals(element2[3]))
                            {
                                maleRural1++;
                            }
                            if("Yes".equals(element2[4]))
                            {
                                male_Y_StudyBusiness1++;
                            }
                            else if("No".equals(element2[4]))
                            {
                                male_N_StudyBusiness1++;
                            }
                            
                        } // END INNER IF STATEMENT FOR MALE

                        else if("Female".equals(element2[k]))
                        {
                            female_Y_Entrepreneur1++;

                            if("Yes".equals(element2[1]))
                            {
                                female_Y_OwnBusiness1++;
                            }
                            else if("No".equals(element2[1]))
                            {
                                female_N_OwnBusiness1++;
                            }
                            if("Yes".equals(element2[2]))
                            {
                                female_Y_PartTimeJob1++;
                            }
                            else if("No".equals(element2[2]))
                            {
                                female_N_PartTimeJob1++;
                            }
                            if("Urban".equals(element2[3]) || "Urban  ".equals(element2[3]))
                            {
                                femaleUrban1++;
                            }
                            else if("Rural".equals(element2[3]))
                            {
                                femaleRural1++;
                            }
                            if("Yes".equals(element2[4]))
                            {
                                female_Y_StudyBusiness1++;
                            }
                            else if("No".equals(element2[4]))
                            {
                                female_N_StudyBusiness1++;
                            }
                            
                        } // END INNER ELSE STATEMENT FEMALE
                        
                    } // END OUTER IF STATEMENT 

                   // FEATURES TOTALS FOR NO ENTREPRENEUR 
                   else if(element2[k].equals(dataByRow[i][j]) && "No".equals(element2[5]))
                    {
                        if("Male".equals(element2[k]))
                        { 
                            male_N_Entrepreneur0++;

                            if("Yes".equals(element2[1]))
                            {
                                male_Y_OwnBusiness0++;
                            }
                            else if("No".equals(element2[1]))
                            {
                                male_N_OwnBusiness0++;
                            }
                            if("Yes".equals(element2[2]))
                            {
                                male_Y_PartTimeJob0++;
                            }
                            else if("No".equals(element2[2]))
                            {
                                male_N_PartTimeJob0++;
                            }
                            if("Urban".equals(element2[3]) || "Urban  ".equals(element2[3]))
                            {
                                maleUrban0++;
                            }
                            else if("Rural".equals(element2[3]))
                            {
                                maleRural0++;
                            }
                            if("Yes".equals(element2[4]))
                            {
                                male_Y_StudyBusiness0++;
                            }
                            else if("No".equals(element2[4]))
                            {
                                male_N_StudyBusiness0++;
                            }
                            
                        } // END INNER IF STATEMENT FOR MALE 
                        else if("Female".equals(element2[k]))
                        {
                            female_N_Entrepreneur0++;

                            if("Yes".equals(element2[1]))
                            {
                                female_Y_OwnBusiness0++;
                            }
                            else if("No".equals(element2[1]))
                            {
                                female_N_OwnBusiness0++;
                            }
                            if("Yes".equals(element2[2]))
                            {
                                female_Y_PartTimeJob0++;
                            }
                            else if("No".equals(element2[2]))
                            {
                                female_N_PartTimeJob0++;
                            }
                            if("Urban".equals(element2[3]) || "Urban  ".equals(element2[3]))
                            {
                                femaleUrban0++;
                            }
                            else if("Rural".equals(element2[3]))
                            {
                                femaleRural0++;
                            }
                            if("Yes".equals(element2[4]))
                            {
                                female_Y_StudyBusiness0++;
                            }
                            else if("No".equals(element2[4]))
                            {
                                female_N_StudyBusiness0++;
                            }

                        } // END INNER IF STATEMENT FOR FEMALE

                    } // END OUTER ELSE IF STATEMENT 

                    i++;

                } // END INNER FOR LOOP

                j++;
                k++;

                if(j > 5)
                {
                    check = false;
                }

            } // END INNER WHILE LOOP
            
            // COMPARE DATA SENT WITH CURRENT DATA
            if(gender.equals(element[0]) && ownBusiness.equals(element[1]) && partTimeJob.equals(element[2]) && area.equals(element[3]) && studyBusiness.equals(element[4]) && "Yes".equals(element[5]))
            {
                currentDataWithSameFeaturesAndYesEntrepreneur++;
            }
            else if(gender.equals(element[0]) && ownBusiness.equals(element[1]) && partTimeJob.equals(element[2]) && area.equals(element[3]) && studyBusiness.equals(element[4]) && "No".equals(element[5]))
            {
                currentDataWithSameFeaturesAndNoEntrepreneur++;
            }
            
        } // END OUTER FOR LOOP
        
        // PROBABILITY OF LIKELIHOOD FOR YES ENTREPRENEUR
        //162 YESES OF 290 -3
        
        double P_X1_Male = (double) male_Y_Entrepreneur1 / (double) yesEntrepreneur; // 0.23
        double P_X1_Female = (double) female_Y_Entrepreneur1 / (double) yesEntrepreneur; // 0.77 

        double P_X2_MaleYesOwnBusiness = (double) male_Y_OwnBusiness1 / (double) yesEntrepreneur; // 0.06
        double P_X2_MaleNoOwnBusiness = (double) male_N_OwnBusiness1 / (double) yesEntrepreneur; // 0.17
        double P_X2_FemaleYesOwnBusiness = (double) female_Y_OwnBusiness1 / (double) yesEntrepreneur; // 0.57
        double P_X2_FemaleNoOwnBusiness = (double) female_N_OwnBusiness1 / (double) yesEntrepreneur; // 0.20

        double P_X3_MaleYesJob = (double) male_Y_PartTimeJob1 / (double) yesEntrepreneur; // 0.07
        double P_X3_MaleNoJob = (double) male_N_PartTimeJob1 / (double) yesEntrepreneur; // 0.17 
        double P_X3_FemaleYesJob = (double) female_Y_PartTimeJob1 / (double) yesEntrepreneur; // 0.39
        double P_X3_FemaleNoJob = (double) female_N_PartTimeJob1 / (double) yesEntrepreneur; // 0.38 

        double P_X4_MaleUrban = (double) maleUrban1 / (double) yesEntrepreneur; // 0.17
        double P_X4_MaleRural = (double) maleRural1 / (double) yesEntrepreneur; // 0.06
        double P_X4_FemaleUrban = (double) femaleUrban1 / (double) yesEntrepreneur; // 0.37
        double P_X4_FemaleRural = (double) femaleRural1 / (double) yesEntrepreneur; // 0.40

        double P_X5_MaleYesStudyBusiness = (double) male_Y_StudyBusiness1 / (double) yesEntrepreneur; // 0.08
        double P_X5_MaleNoStudyBusiness = (double) male_N_StudyBusiness1 / (double) yesEntrepreneur; // 0.15
        double P_X5_FemaleYesStudyBusiness = (double) female_Y_StudyBusiness1 / (double) yesEntrepreneur; // 0.44
        double P_X5_FemaleNoStudyBusiness = (double) female_N_StudyBusiness1 / (double) yesEntrepreneur; // 0.32


        // PROBABILITY OF LIKELIHOOD FOR NO ENTREPRENEUR
        double P_X6_Male = (double) male_N_Entrepreneur0 / (double) noEntrepreneur; // 0.80
        double P_X6_Female = (double) female_N_Entrepreneur0 / (double) noEntrepreneur; // 0.20 

        double P_X7_MaleYesOwnBusiness = (double) male_Y_OwnBusiness0 / (double) noEntrepreneur; // 0.15
        double P_X7_MaleNoOwnBusiness = (double) male_N_OwnBusiness0 / (double) noEntrepreneur; // 0.65
        double P_X7_FemaleYesOwnBusiness = (double) female_Y_OwnBusiness0 / (double) noEntrepreneur; // 0.04
        double P_X7_FemaleNoOwnBusiness = (double) female_N_OwnBusiness0 / (double) noEntrepreneur; // 0.16

        double P_X8_MaleYesJob = (double) male_Y_PartTimeJob0 / (double) noEntrepreneur; // 0.52
        double P_X8_MaleNoJob = (double) male_N_PartTimeJob0 / (double) noEntrepreneur; // 0.29
        double P_X8_FemaleYesJob = (double) female_Y_PartTimeJob0 / (double) noEntrepreneur; // 0.02
        double P_X8_FemaleNoJob = (double) female_N_PartTimeJob0 / (double) noEntrepreneur; // 0.17

        double P_X9_MaleUrban = (double) maleUrban0 / (double) noEntrepreneur; // 0.40
        double P_X9_MaleRural = (double) maleRural0 / (double) noEntrepreneur; // 0.40
        double P_X9_FemaleUrban = (double) femaleUrban0 / (double) noEntrepreneur; // 0.04
        double P_X9_FemaleRural = (double) femaleRural0 / (double) noEntrepreneur; // 0.16

        double P_X10_MaleYesStudyBusiness = (double) male_Y_StudyBusiness0 / (double) noEntrepreneur; // 0.40
        double P_X10_MaleNoStudyBusiness = (double) male_N_StudyBusiness0 / (double) noEntrepreneur; // 0.40
        double P_X10_FemaleYesStudyBusiness = (double) female_Y_StudyBusiness0 / (double) noEntrepreneur; // 0.05
        double P_X10_FemaleNoStudyBusiness = (double) female_N_StudyBusiness0 / (double) noEntrepreneur; // 0.15

        // PRINT TESTS 
        System.out.printf("%.2f \n", P_X10_FemaleNoStudyBusiness);
        // System.out.println("Current data YES: " + currentDataWithSameFeaturesAndYesEntrepreneur + "\nCurrent data NO: " + currentDataWithSameFeaturesAndNoEntrepreneur);
        System.out.println("BIG TEST OF DATA: \n" + "No ENTRE:" + noEntrepreneur +
        " NOENT:" + male_N_Entrepreneur0 +" YESBUS:"+
        male_Y_OwnBusiness0 +" NOBUS:"+ male_N_OwnBusiness0 +" YESJOB:"+
        male_Y_PartTimeJob0 +" NOJOB:"+ male_N_PartTimeJob0 +" URB:"+
        maleUrban0 +" RUR:"+ maleRural0 + " YESBUSI:"+
        male_Y_StudyBusiness0 +" NOBUSI:"+ male_N_StudyBusiness0
        );

        // System.out.println("MALE YES ENT: " + male_Y_Entrepreneur + " " + "FEMALE YES ENT: " + female_Y_Entrepreneur);
        // System.out.println("MALE YES COMP : " + male_Y_OwnBusiness + " " + "FEMALE YES COMP : " + female_Y_OwnBusiness);

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
