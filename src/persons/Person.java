package persons;

public class Person {
    public String personNAME, personDuty;
    private int personAge;

    public Person(String name, int age) {
        personNAME = name;
        personAge = age;
    }

    public String getPersonNAME() {
        return personNAME;
    }
    public void setPersonNAME(String personNAME) {
        this.personNAME = personNAME;
    }
    public String getPersonDuty() {
        return personDuty;
    }
    public void setPersonDuty(String personDuty) {
        this.personDuty = personDuty;
    }
    public int getPersonAge() {
        return personAge;
    }
    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }
}
