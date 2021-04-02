import java.util.Hashtable;

// NAIVE BAYES ALGORITHM
public class MachineLearning
{
    Hashtable<String, Integer> probabilityYesEntrepreneur = new Hashtable<String, Integer>(20);
    Hashtable<String, Integer> probabilityNoEntrepreneur = new Hashtable<String, Integer>(20); 

    // NAIVE BAYES 
    public MachineLearning(String gender, String ownBusiness, String partTimeJob, String area, String studyBusiness, Hashtable<String, Integer> dataDictonary, String[][] dataByRow) 
    {
        // PRINT TESTS
        System.out.println("Value at key = totalData: " + dataDictonary.get("totalData"));

        // for(int i = 0; i < 10; i++)
        // {
        //     for(int j = 0; j < 6; j++)
        //     {
        //         System.out.print(dataByRow[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("Male");

        // PROBABILITY OF PRIOR PROBABILITIES (ENTREPRENEUR)
        double P_Y_Entrepreneur = (double)dataDictonary.get("yesEntrepreneur") / (double)dataDictonary.get("totalData"); // 0.56
        double P_N_Entrepreneur = (double)dataDictonary.get("noEntrepreneur") / (double)dataDictonary.get("totalData");// 0.44
        

        // // PROBABILITY OF EVIDENCE DENOMINATOR 
        // double PX_Male = (double)dataDictonary.get("genderMale") / (double)dataDictonary.get("totalData"); // 0.48
        // double PX_Female = (double)dataDictonary.get("genderFemale") / (double)dataDictonary.get("totalData"); // 0.52

        // double PX_Y_OwnBusiness = (double)dataDictonary.get("yesOwnBusiness") / (double)dataDictonary.get("totalData"); // 0.44
        // double PX_N_OwnBusiness = (double)dataDictonary.get("noOwnBusiness") / (double)dataDictonary.get("totalData"); // 0.56

        // double PX_Y_PartTimeJob = (double)dataDictonary.get("yesJob") / (double)dataDictonary.get("totalData"); // 0.49 
        // double PX_N_PartTimeJob = (double)dataDictonary.get("noJob") / (double)dataDictonary.get("totalData"); // 0.51

        // double PX_Rural = (double)dataDictonary.get("rural") / (double)dataDictonary.get("totalData"); // 0.50 
        // double PX_Urban = (double)dataDictonary.get("urban") / (double)dataDictonary.get("totalData"); // 0.50

        // double PX_Y_StudyBusiness = (double)dataDictonary.get("yesStudyBusiness") / (double)dataDictonary.get("totalData"); // 0.49 
        // double PX_N_StudyBusiness = (double)dataDictonary.get("noStudyBusiness") / (double)dataDictonary.get("totalData"); // 0.51 

        // int currentDataWithSameFeaturesAndYesEntrepreneur = 0, currentDataWithSameFeaturesAndNoEntrepreneur = 0;

        // TOTALS FOR FEATURES WHEN THEY BECAME ENTREPRENEURS (1 IN THE NAME MEANS THEY ARE ENTREPRENEURS)
        int male1 = 0, female1 = 0;
        int yesOwnBusiness1 = 0, noOwnBusiness1 = 0;
        int yesPartTimeJob1 = 0, noPartTimeJob1 = 0;
        int urban1 = 0, rural1 = 0;
        int yesStudyBusiness1 = 0, noStudyBusiness1 = 0;
        
        // TOTALS FOR FEATURES WHEN THEY DO NOT BECOME ENTREPRENEURS (0 IN THE NAME MEANS THEY ARE NOT ENTREPRENEURS)
        int male0 = 0, female0 = 0;
        int yesOwnBusiness0 = 0, noOwnBusiness0 = 0;
        int yesPartTimeJob0 = 0, noPartTimeJob0 = 0;
        int urban0 = 0, rural0 = 0;
        int yesStudyBusiness0 = 0, noStudyBusiness0 = 0;

        // FEATURES TOTALS FOR YES ENTREPRENEUR
        for(String[] element: dataByRow)
        {
            if("Yes".equals(element[5]))
            {
                if("Male".equals(element[0]))
                {
                    male1++;
                } 
                else if("Female".equals(element[0]))
                {
                    female1++;
                }
                if("Yes".equals(element[1]))
                {
                    yesOwnBusiness1++;
                }
                else if("No".equals(element[1]))
                {
                    noOwnBusiness1++;
                }
                if("Yes".equals(element[2]))
                {
                    yesPartTimeJob1++;
                }
                else if("No".equals(element[2]))
                {
                    noPartTimeJob1++;
                }
                if("Urban".equals(element[3]) || "Urban  ".equals(element[3]))
                {
                    urban1++;
                }
                else if("Rural".equals(element[3]))
                {
                    rural1++;
                }
                if("Yes".equals(element[4]))
                {
                    yesStudyBusiness1++;
                }
                else if("No".equals(element[4]))
                {
                    noStudyBusiness1++;
                }

            } // END INNER IF STATEMENT

            // FEATURES TOTALS FOR NO ENTREPRENEUR
            else if("No".equals(element[5]))
            {
                if("Male".equals(element[0]))
                {
                    male0++;
                } 
                else if("Female".equals(element[0]))
                {
                    female0++;
                }
                if("Yes".equals(element[1]))
                {
                    yesOwnBusiness0++;
                }
                else if("No".equals(element[1]))
                {
                    noOwnBusiness0++;
                }
                if("Yes".equals(element[2]))
                {
                    yesPartTimeJob0++;
                }
                else if("No".equals(element[2]))
                {
                    noPartTimeJob0++;
                }
                if("Urban".equals(element[3]) || "Urban  ".equals(element[3]))
                {
                    urban0++;
                }
                else if("Rural".equals(element[3]))
                {
                    rural0++;
                }
                if("Yes".equals(element[4]))
                {
                    yesStudyBusiness0++;
                }
                else if("No".equals(element[4]))
                {
                    noStudyBusiness0++;
                } 

            } // END INNER ELSE IF STATEMENT

        } // END INNER FOR LOOP

        // COMPARE DATA SENT WITH CURRENT DATA
        // if(gender.equals(element[0]) && ownBusiness.equals(element[1]) && partTimeJob.equals(element[2]) && area.equals(element[3]) && studyBusiness.equals(element[4]) && "Yes".equals(element[5]))
        // {
        //     currentDataWithSameFeaturesAndYesEntrepreneur++;
        // }
        // else if(gender.equals(element[0]) && ownBusiness.equals(element[1]) && partTimeJob.equals(element[2]) && area.equals(element[3]) && studyBusiness.equals(element[4]) && "No".equals(element[5]))
        // {
        //     currentDataWithSameFeaturesAndNoEntrepreneur++;
        // }

        // PROBABILITY OF LIKELIHOOD FOR YES ENTREPRENEUR
        //162 YESES OF 290 -3
        
        // double P_X1_Male = (double) male_Y_Entrepreneur1 / (double) yesEntrepreneur; // 0.23
        // double P_X1_Female = (double) female_Y_Entrepreneur1 / (double) yesEntrepreneur; // 0.77 

        // double P_X2_MaleYesOwnBusiness = (double) male_Y_OwnBusiness1 / (double) yesEntrepreneur; // 0.06
        // double P_X2_MaleNoOwnBusiness = (double) male_N_OwnBusiness1 / (double) yesEntrepreneur; // 0.17
        // double P_X2_FemaleYesOwnBusiness = (double) female_Y_OwnBusiness1 / (double) yesEntrepreneur; // 0.57
        // double P_X2_FemaleNoOwnBusiness = (double) female_N_OwnBusiness1 / (double) yesEntrepreneur; // 0.20

        // double P_X3_MaleYesJob = (double) male_Y_PartTimeJob1 / (double) yesEntrepreneur; // 0.07
        // double P_X3_MaleNoJob = (double) male_N_PartTimeJob1 / (double) yesEntrepreneur; // 0.17 
        // double P_X3_FemaleYesJob = (double) female_Y_PartTimeJob1 / (double) yesEntrepreneur; // 0.39
        // double P_X3_FemaleNoJob = (double) female_N_PartTimeJob1 / (double) yesEntrepreneur; // 0.38 

        // double P_X4_MaleUrban = (double) maleUrban1 / (double) yesEntrepreneur; // 0.17
        // double P_X4_MaleRural = (double) maleRural1 / (double) yesEntrepreneur; // 0.06
        // double P_X4_FemaleUrban = (double) femaleUrban1 / (double) yesEntrepreneur; // 0.37
        // double P_X4_FemaleRural = (double) femaleRural1 / (double) yesEntrepreneur; // 0.40

        // double P_X5_MaleYesStudyBusiness = (double) male_Y_StudyBusiness1 / (double) yesEntrepreneur; // 0.08
        // double P_X5_MaleNoStudyBusiness = (double) male_N_StudyBusiness1 / (double) yesEntrepreneur; // 0.15
        // double P_X5_FemaleYesStudyBusiness = (double) female_Y_StudyBusiness1 / (double) yesEntrepreneur; // 0.44
        // double P_X5_FemaleNoStudyBusiness = (double) female_N_StudyBusiness1 / (double) yesEntrepreneur; // 0.32


        // // PROBABILITY OF LIKELIHOOD FOR NO ENTREPRENEUR
        // double P_X6_Male = (double) male_N_Entrepreneur0 / (double) noEntrepreneur; // 0.80
        // double P_X6_Female = (double) female_N_Entrepreneur0 / (double) noEntrepreneur; // 0.20 

        // double P_X7_MaleYesOwnBusiness = (double) male_Y_OwnBusiness0 / (double) noEntrepreneur; // 0.15
        // double P_X7_MaleNoOwnBusiness = (double) male_N_OwnBusiness0 / (double) noEntrepreneur; // 0.65
        // double P_X7_FemaleYesOwnBusiness = (double) female_Y_OwnBusiness0 / (double) noEntrepreneur; // 0.04
        // double P_X7_FemaleNoOwnBusiness = (double) female_N_OwnBusiness0 / (double) noEntrepreneur; // 0.16

        // double P_X8_MaleYesJob = (double) male_Y_PartTimeJob0 / (double) noEntrepreneur; // 0.52
        // double P_X8_MaleNoJob = (double) male_N_PartTimeJob0 / (double) noEntrepreneur; // 0.29
        // double P_X8_FemaleYesJob = (double) female_Y_PartTimeJob0 / (double) noEntrepreneur; // 0.02
        // double P_X8_FemaleNoJob = (double) female_N_PartTimeJob0 / (double) noEntrepreneur; // 0.17

        // double P_X9_MaleUrban = (double) maleUrban0 / (double) noEntrepreneur; // 0.40
        // double P_X9_MaleRural = (double) maleRural0 / (double) noEntrepreneur; // 0.40
        // double P_X9_FemaleUrban = (double) femaleUrban0 / (double) noEntrepreneur; // 0.04
        // double P_X9_FemaleRural = (double) femaleRural0 / (double) noEntrepreneur; // 0.16

        // double P_X10_MaleYesStudyBusiness = (double) male_Y_StudyBusiness0 / (double) noEntrepreneur; // 0.40
        // double P_X10_MaleNoStudyBusiness = (double) male_N_StudyBusiness0 / (double) noEntrepreneur; // 0.40
        // double P_X10_FemaleYesStudyBusiness = (double) female_Y_StudyBusiness0 / (double) noEntrepreneur; // 0.05
        // double P_X10_FemaleNoStudyBusiness = (double) female_N_StudyBusiness0 / (double) noEntrepreneur; // 0.15

        // // SUBSTITUTE VALUES INTO NAIVE BAYES FORMULA
        // double entrepreneurWithFeatures = 0;
        // double denominator = PX_Male * PX_Y_OwnBusiness * PX_Y_PartTimeJob * PX_Urban * PX_N_StudyBusiness;

        // if(gender == "Male")
        // {
        //     if(ownBusiness == "Yes")
        //     {
        //         if(partTimeJob == "Yes")
        //         {
        //             if(area == "Urban" || area == "Urban  ")
        //             {
        //                 if(studyBusiness == "Yes")
        //                 {
        //                     entrepreneurWithFeatures = (P_X1_Male * P_X2_MaleYesOwnBusiness * P_X3_MaleYesJob * P_X4_MaleUrban * P_X5_MaleYesStudyBusiness) / denominator; 
        //                 }
        //                 else if(studyBusiness == "No")
        //                 {
        //                     entrepreneurWithFeatures = (P_X1_Male * P_X2_MaleYesOwnBusiness * P_X3_MaleYesJob * P_X4_MaleUrban * P_X5_MaleYesStudyBusiness) / denominator;  
        //                 }
        //             }
        //             else if(area == "Rural")
        //             {

        //             }
        //         }
        //     }
            
        // }
        

        // // PRINT TESTS 
        // System.out.println(male1 + " " + female1 + " " + yesOwnBusiness1 + " " + noOwnBusiness1 + " " + yesPartTimeJob1 + " " + 
        //                    noPartTimeJob1 + " " + urban1 + " " + rural1 + " " + yesStudyBusiness1 + " " + noStudyBusiness1);

        System.out.println(male0 + " " + female0 + " " + yesOwnBusiness0 + " " + noOwnBusiness0 + " " + yesPartTimeJob0 + " " + 
        noPartTimeJob0 + " " + urban0 + " " + rural0 + " " + yesStudyBusiness0 + " " + noStudyBusiness0);
        // System.out.println(male_Y_Entrepreneur1);
        // System.out.printf("%.10f \n", entrepreneurWithFeatures);
        // // System.out.printf("%.2f \n", P_X10_FemaleNoStudyBusiness);
        // // System.out.println("Current data YES: " + currentDataWithSameFeaturesAndYesEntrepreneur + "\nCurrent data NO: " + currentDataWithSameFeaturesAndNoEntrepreneur);
        // System.out.println("BIG TEST OF DATA: \n" + "No ENTRE:" + noEntrepreneur +
        // " NOENT:" + male_N_Entrepreneur0 +" YESBUS:"+
        // male_Y_OwnBusiness0 +" NOBUS:"+ male_N_OwnBusiness0 +" YESJOB:"+
        // male_Y_PartTimeJob0 +" NOJOB:"+ male_N_PartTimeJob0 +" URB:"+
        // maleUrban0 +" RUR:"+ maleRural0 + " YESBUSI:"+
        // male_Y_StudyBusiness0 +" NOBUSI:"+ male_N_StudyBusiness0
        // );

        // // System.out.println("MALE YES ENT: " + male_Y_Entrepreneur + " " + "FEMALE YES ENT: " + female_Y_Entrepreneur);
        // // System.out.println("MALE YES COMP : " + male_Y_OwnBusiness + " " + "FEMALE YES COMP : " + female_Y_OwnBusiness);

        // // System.out.printf("%.2f", PX_N_StudyBusiness);
        
    } 
        
}
