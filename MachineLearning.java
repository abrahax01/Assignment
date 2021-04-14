// Class to do probabilty of becoming entrepreneur or not

import java.util.Hashtable;

// NAIVE BAYES ALGORITHM
public class MachineLearning
{
    Hashtable<String, Double> probabilitiesYesEntrepreneur = new Hashtable<String, Double>(20);
    Hashtable<String, Double> probabilitiesNoEntrepreneur = new Hashtable<String, Double>(20); 
    double probabilityYesEntrepreneur = 0, probabilityNoEntrepreneur = 0;
    double numerator1 = 0, numerator0 = 0, denominator = 0;
    String answer;

    // NAIVE BAYES 
    public MachineLearning(String gender, String ownBusiness, String partTimeJob, String area, String studyBusiness, Hashtable<String, Integer> dataDictonary, String[][] dataByRow) 
    {
        // PROBABILITY OF PRIOR PROBABILITIES (ENTREPRENEUR)
        double P_Y_Entrepreneur = (double)dataDictonary.get("yesEntrepreneur") / (double)dataDictonary.get("totalData"); //.56
        double P_N_Entrepreneur = (double)dataDictonary.get("noEntrepreneur") / (double)dataDictonary.get("totalData"); //.44
        
        // // PROBABILITY OF EVIDENCE DENOMINATOR 
        double PX_Male = (double)dataDictonary.get("genderMale") / (double)dataDictonary.get("totalData"); //.48
        double PX_Female = (double)dataDictonary.get("genderFemale") / (double)dataDictonary.get("totalData"); //.52

        double PX_Y_OwnBusiness = (double)dataDictonary.get("yesOwnBusiness") / (double)dataDictonary.get("totalData"); //.44
        double PX_N_OwnBusiness = (double)dataDictonary.get("noOwnBusiness") / (double)dataDictonary.get("totalData"); //.56

        double PX_Y_PartTimeJob = (double)dataDictonary.get("yesJob") / (double)dataDictonary.get("totalData"); //.49
        double PX_N_PartTimeJob = (double)dataDictonary.get("noJob") / (double)dataDictonary.get("totalData");//.51

        double PX_Rural = (double)dataDictonary.get("rural") / (double)dataDictonary.get("totalData"); //.50
        double PX_Urban = (double)dataDictonary.get("urban") / (double)dataDictonary.get("totalData"); //.50

        double PX_Y_StudyBusiness = (double)dataDictonary.get("yesStudyBusiness") / (double)dataDictonary.get("totalData");//.49
        double PX_N_StudyBusiness = (double)dataDictonary.get("noStudyBusiness") / (double)dataDictonary.get("totalData");//.51

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

        // PROBABILITY OF ENTREPENEUR 
        probabilitiesYesEntrepreneur.put("maleProbability1", (male1 / (double)dataDictonary.get("yesEntrepreneur"))); //.23
        probabilitiesYesEntrepreneur.put("femaleProbability1", (female1 / (double)dataDictonary.get("yesEntrepreneur"))); // .77
        probabilitiesYesEntrepreneur.put("yesOwnBusinessProbability1", (yesOwnBusiness1 / (double)dataDictonary.get("yesEntrepreneur"))); //.63 
        probabilitiesYesEntrepreneur.put("noOwnBusinessProbability1", (noOwnBusiness1 / (double)dataDictonary.get("yesEntrepreneur"))); //.37
        probabilitiesYesEntrepreneur.put("yesPartTimeJob1", (yesPartTimeJob1 / (double)dataDictonary.get("yesEntrepreneur"))); //.46 
        probabilitiesYesEntrepreneur.put("noPartTimeJob1", (noPartTimeJob1 / (double)dataDictonary.get("yesEntrepreneur")));  //.54
        probabilitiesYesEntrepreneur.put("urban1", (urban1 / (double)dataDictonary.get("yesEntrepreneur")));  //.54
        probabilitiesYesEntrepreneur.put("rural1", (rural1 / (double)dataDictonary.get("yesEntrepreneur")));   //.46
        probabilitiesYesEntrepreneur.put("yesStudyBusiness1", (yesStudyBusiness1 / (double)dataDictonary.get("yesEntrepreneur")));  //.52 
        probabilitiesYesEntrepreneur.put("noStudyBusiness1", (noStudyBusiness1 / (double)dataDictonary.get("yesEntrepreneur")));  //.48

        // PROBABILITY OF NO ENTREPENEUR  
        probabilitiesNoEntrepreneur.put("maleProbability0", (male0 / (double)dataDictonary.get("noEntrepreneur"))); //.80
        probabilitiesNoEntrepreneur.put("femaleProbability0", (female0 / (double)dataDictonary.get("noEntrepreneur"))); //.20
        probabilitiesNoEntrepreneur.put("yesOwnBusinessProbability0", (yesOwnBusiness0 / (double)dataDictonary.get("noEntrepreneur"))); //.19
        probabilitiesNoEntrepreneur.put("noOwnBusinessProbability0", (noOwnBusiness0 / (double)dataDictonary.get("noEntrepreneur"))); //.81
        probabilitiesNoEntrepreneur.put("yesPartTimeJob0", (yesPartTimeJob0 / (double)dataDictonary.get("noEntrepreneur"))); //.54 
        probabilitiesNoEntrepreneur.put("noPartTimeJob0", (noPartTimeJob0 / (double)dataDictonary.get("noEntrepreneur")));  //.46
        probabilitiesNoEntrepreneur.put("urban0", (urban0 / (double)dataDictonary.get("noEntrepreneur")));  //.44
        probabilitiesNoEntrepreneur.put("rural0", (rural0 / (double)dataDictonary.get("noEntrepreneur")));   //.56
        probabilitiesNoEntrepreneur.put("yesStudyBusiness0", (yesStudyBusiness0 / (double)dataDictonary.get("noEntrepreneur")));   //.44
        probabilitiesNoEntrepreneur.put("noStudyBusiness0", (noStudyBusiness0 / (double)dataDictonary.get("noEntrepreneur")));  //.56

        // GETTING NUMERATOR FOR ENTREPRENEUR AND NO ENTREPRENEUR + DENOMINATOR 
        // (1 IN THE VARIABLE NAME MEANS ENTREPRENEUR)
        // (0 IN THE VARIABLE NAME MEANS NO ENTREPRENEUR)
        if("Male".equals(gender))
        {
            numerator1 = (double) probabilitiesYesEntrepreneur.get("maleProbability1");
            numerator0 = (double) probabilitiesNoEntrepreneur.get("maleProbability0");
            denominator = PX_Male;
        }
        else if("Female".equals(gender))
        {
            numerator1 = (double) probabilitiesYesEntrepreneur.get("femaleProbability1");
            numerator0 = (double) probabilitiesNoEntrepreneur.get("femaleProbability0");
            denominator = PX_Female;
        }
            
        if("Yes".equals(ownBusiness))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("yesOwnBusinessProbability1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("yesOwnBusinessProbability0");
            denominator *= PX_Y_OwnBusiness;
        }
        else if("No".equals(ownBusiness))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("noOwnBusinessProbability1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("noOwnBusinessProbability0");
            denominator *= PX_N_OwnBusiness; 
        }

        if("Yes".equals(partTimeJob))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("yesPartTimeJob1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("yesPartTimeJob0");
            denominator *= PX_Y_PartTimeJob;
        }
        else if("No".equals(partTimeJob))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("noPartTimeJob1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("noPartTimeJob0");
            denominator *= PX_N_PartTimeJob; 
        }

        if("Rural".equals(area))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("rural1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("rural0");
            denominator *= PX_Rural;
        }
        else if("Urban".equals(area))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("urban1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("urban0");
            denominator *= PX_Urban; 
        }

        if("Yes".equals(studyBusiness))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("yesStudyBusiness1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("yesStudyBusiness0");
            denominator *= PX_Y_StudyBusiness;
        }
        else if("No".equals(studyBusiness))
        {
            numerator1 *= (double) probabilitiesYesEntrepreneur.get("noStudyBusiness1");
            numerator0 *= (double) probabilitiesNoEntrepreneur.get("noStudyBusiness0");
            denominator *= PX_N_StudyBusiness; 
        }

        numerator1 *= P_Y_Entrepreneur;
        numerator0 *= P_N_Entrepreneur;

        // SUBSTITUTE VALUES TO NAIVE BAYES FORMULA
        probabilityYesEntrepreneur = numerator1 / denominator;
        probabilityNoEntrepreneur = numerator0 / denominator;

        // ANSWERS
        if(probabilityYesEntrepreneur > probabilityNoEntrepreneur)
        {
            answer = "Entrepreneur, their probabilities of becoming an entrepreneur are great";
        }
        else
        {
            answer = "No Entrepreneur, their probabilities of becoming an entrepreneur are not great";
        }

    } 

    public String toString() 
    {
        return (answer);
    }
        
}
