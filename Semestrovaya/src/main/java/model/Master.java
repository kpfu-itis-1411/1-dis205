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
}
