// Class to Read the CSV file
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData 
{
    String file = "MLdata.csv";
    String line = "";
    String[] values;
    
    int gender = 0, genderMale = 0, genderFemale = 0;
    int pOwnBusiness = 0, yesOwnBusiness = 0, noOwnBusiness = 0;
    int partTimeJob = 0, yesJob = 0, noJob = 0;
    int address = 0, rural = 0, urban = 0;
    int studyBusiness = 0, yesStudyBusiness = 0, noStudyBusiness = 0;
    int entrepreneur = 0, yesEntrepreneur = 0, noEntrepreneur = 0;
    
    // CONSTRUCTOR
    public ReadData()
    {
        // READ DATA AND STORES DATA TOTALS (EG: THERE IS 149 FEMALES IN MLdata.csv)
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            {
                while((line = br.readLine()) != null)
                {
                    this.values = line.split(",");
                    if("Male".equals(this.values[0]) )
                    {

                        genderMale++;
                        gender++;
                    }
                    else if ("Female".equals(this.values[0])) 
                    {
                        genderFemale++;
                        gender++;
                    } 
                    if("Yes".equals(this.values[1]))
                    {
                        yesOwnBusiness++;
                        pOwnBusiness++;
                    }
                    else if("No".equals(this.values[1]))
                    {
                        noOwnBusiness++;
                        pOwnBusiness++;
                    }
                    if("Yes".equals(this.values[2]))
                    {
                        yesJob++;
                        partTimeJob++;
                    }
                    else if("No".equals(this.values[2]))
                    {
                        noJob++;
                        partTimeJob++;
                    }
                    if("Rural".equals(this.values[3]))
                    {
                        rural++;
                        address++;
                    }
                    else if("Urban  ".equals(this.values[3]) || "Urban".equals(this.values[3]))
                    {
                        urban++;
                        address++;
                    }
                    if("Yes".equals(this.values[4]))
                    {
                        studyBusiness++;
                        yesStudyBusiness++;
                    }
                    else if("No".equals(this.values[4]))
                    {
                        studyBusiness++;
                        noStudyBusiness++;
                    }
                    if("Yes".equals(this.values[5]))
                    {
                        entrepreneur++;
                        yesEntrepreneur++;
                    }
                    else if("No".equals(this.values[5]))
                    {
                        entrepreneur++;
                        noEntrepreneur++;
                    }

                    
                    // System.out.println(gender + " Male: " + genderMale + " Female: " + genderFemale);
                    // System.out.println(pOwnBusiness + " yes: " + yesOwnBusiness + " no: " + noOwnBusiness);
                    // System.out.println(partTimeJob + " yes: " + yesJob + " no: " + noJob);
                    // System.out.println(address + " Rural: " + rural + " Urban: " + urban);
                    // System.out.println(studyBusiness + " Yes: " + yesStudyBusiness + " No: " + noStudyBusiness);
                    // System.out.println(entrepreneur + " Yes: " + yesEntrepreneur + " No: " + noEntrepreneur);
                    // System.out.println(values[0] + "  " + values[1] + "  " + 
                    //                    values[2] + "  " + values[3] + "  " +
                    //                    values[4] + "  " + values[5]
                    //                    );
    
                }
                br.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IOException e)
        {
            System.out.println("No more lines"); 
        }
    }

    // PRINT 
    public String toString()
    {
        return ("Line: " + gender + " Male: " + genderMale + " Female: " + genderFemale +
        " Yes: " + yesOwnBusiness + " No: " + noOwnBusiness );
    }

    // GETTERS AND SETTERS
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public int getpOwnBusiness() {
        return pOwnBusiness;
    }

    public void setpOwnBusiness(int pOwnBusiness) {
        this.pOwnBusiness = pOwnBusiness;
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

    public int getPartTimeJob() {
        return partTimeJob;
    }

    public void setPartTimeJob(int partTimeJob) {
        this.partTimeJob = partTimeJob;
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

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
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

    public int getStudyBusiness() {
        return studyBusiness;
    }

    public void setStudyBusiness(int studyBusiness) {
        this.studyBusiness = studyBusiness;
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

    public int getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(int entrepreneur) {
        this.entrepreneur = entrepreneur;
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
