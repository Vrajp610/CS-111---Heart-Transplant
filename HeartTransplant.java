import java.sql.ClientInfoStatus;

/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author: Vraj Patel, vpp36@scarletmail.rutgers.edu, vpp36
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        this.listOfPatients = null;
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;
       
        // WRITE YOUR CODE HERE
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {
        if (arrayIndex <= listOfPatients.length - 1){
            listOfPatients[arrayIndex] = p;
            return 0;
        } 
        return -1;
    
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        int totalCount = 0;
        int counter = 0;
        listOfPatients = new Person[numberOfLines];
        Person p = null;
        for (int i = 0; i < numberOfLines; i++){
            p = new Person(StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            addPerson(p, counter);
            counter++;
            totalCount++;
        }
        return totalCount;
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge[numberOfLines];
        int survivabilityCounter = 0;
        int counter = 0;
        for (int i = 0; i < numberOfLines; i++){
            SurvivabilityByAge p = new SurvivabilityByAge(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
            survivabilityByAge[counter] = p;
            survivabilityCounter++;
            counter++;
        }
        return survivabilityCounter;
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        int counter = 0;
        int survivabilityCounter = 0;
        for (int i = 0; i < numberOfLines; i++){
            SurvivabilityByCause p = new SurvivabilityByCause(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
            survivabilityByCause[counter] = p;
            survivabilityCounter++;
            counter++;
        }
        return survivabilityCounter;
        // WRITE YOUR CODE HERE
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {
        int totalCount = 0;
        for (int i = 0; i < listOfPatients.length; i++){
            int ageOfPatients = listOfPatients[i].getAge();
            if (ageOfPatients > age){
                totalCount++;
            }
        }

        if (totalCount == 0) return null; 
        else {
            int counter = 0;
            Person[] outcome = new Person[totalCount];
            for (int i = 0; i< listOfPatients.length; i++){
                int ageOfPatients = listOfPatients[i].getAge();
                if (ageOfPatients > age){
                    outcome[counter] = listOfPatients[i];
                    counter++;
                }
            }
            return outcome;
        }
        // WRITE YOUR CODE HERE
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {
        int totalCount = 0;
        for (int i = 0; i<listOfPatients.length; i++){
            int patientsHealth = listOfPatients[i].getStateOfHealth();
            if (patientsHealth == state){
                totalCount++;
            }
        }

        if (totalCount == 0)
        return null;
        else {
            Person[] outcome = new Person[totalCount];
            int counter = 0;
            for (int i = 0; i < listOfPatients.length; i++){
                int patientsHealth = listOfPatients[i].getStateOfHealth();
                if (patientsHealth == state){
                    outcome[counter] = listOfPatients[i];
                    counter++;
                }
            }
            return outcome;
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {
        int totalCount=0;
        for(int i = 0; i < listOfPatients.length; i++){
            int patientsHealthHeart = listOfPatients[i].getCause();
            if(patientsHealthHeart == cause){
                totalCount++;
            }
        }

        if(totalCount == 0)return null;
        else{
            Person[] outcome = new Person[totalCount];
            int counter = 0;
            for(int i = 0; i < listOfPatients.length; i++){
                int patientsHealthHeart = listOfPatients[i].getCause();
                if(patientsHealthHeart == cause){
                    outcome[counter] = listOfPatients[i];
                    counter++;
            }

        }
        return outcome;
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {
        Person[] outcome = new Person[numberOfHearts];

        if(numberOfHearts >= listOfPatients.length){
            return listOfPatients;
        }else{
            double counter[] = new double[numberOfHearts];
            for(int i = 0; i < numberOfHearts; i++){
                double rRate = (survivabilityByAge[i].getRate() + survivabilityByCause[i].getRate()) / 2;
                counter[i] = rRate;
            }
            double totalMax = counter[0];
            int h = 0;
            for(int i = 0; i < numberOfHearts; i++){
                totalMax=counter[h];
                for(int j = 0; j < numberOfHearts; j++){
                    if(totalMax < counter[j]){
                        totalMax = counter[j];
                        h = j;
                    }
                }
                outcome[i] = listOfPatients[h];
                counter[h] = 0;
            }
            return outcome;
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }

    }
}
