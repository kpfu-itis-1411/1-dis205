package model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Master {
    private Long id;

    private String masterlogin;

    private String password;
    private String name;
    private String characterisation;
    private String workexperience;
    private int valuation;
    private String phoneNumber;

   public Master(long id,String masterlogin,String password, String name, String characterisation, String workexperience, int valuation, String phoneNumber) {
       this.id = id;
       this.masterlogin = masterlogin;
       this.password = password;
       this.name = name;
       this.characterisation = characterisation;
       this.workexperience = workexperience;
       this.valuation = valuation;
       this.phoneNumber = phoneNumber;
   }

    public Master() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Master master = (Master) o;

        if (!id.equals(master.id)) return false;
        if (!masterlogin.equals(master.masterlogin)) return false;
        if (!password.equals(master.password)) return false;
        if (!name.equals(master.name)) return false;
        if (!characterisation.equals(master.characterisation)) return false;
        if (!workexperience.equals(master.workexperience)) return false;
        if (valuation != master.valuation) return false;
        return phoneNumber.equals(master.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + masterlogin.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + characterisation.hashCode();
        result = 31 * result + workexperience.hashCode();
        result = 31 * result + Integer.hashCode(valuation);
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }
}
