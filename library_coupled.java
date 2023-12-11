/*     
 *    
 *  Author     : Dev Dipak Patel & Vamsi Krishna Satyanarayana Vasa
 *  Version    : DEVSJAVA 2.7 
 *  Date       : 11-16-2023
 */
package Component.BasicProcessor;

import java.awt.*;

import GenCol.*;


import model.modeling.*;
import model.simulation.*;

import view.modeling.ViewableAtomic;
import view.modeling.ViewableComponent;
import view.modeling.ViewableDigraph;
import view.simView.*;



public class library_coupled extends ViewableDigraph{


public library_coupled(){
    super("Library");

    ViewableAtomic cr1_lv1 = new Classroom1_lv1("Classroom1_lv1",10);
    ViewableAtomic cr2_lv1 = new Classroom2_lv1("Classroom2_lv1",10);
    ViewableAtomic cr3_lv1 = new Classroom3_lv1("Classroom3_lv1",10);
    ViewableAtomic cr1_lv2 = new Classroom1_lv2("Classroom1_lv2",10);
    ViewableAtomic cr2_lv2 = new Classroom2_lv2("Classroom2_lv2",10);
    ViewableAtomic cr3_lv2 = new Classroom3_lv2("Classroom3_lv2",10);
    ViewableAtomic cr1_lv3 = new Classroom1_lv3("Classroom1_lv3",10);
    ViewableAtomic cr2_lv3 = new Classroom2_lv3("Classroom2_lv3",10);
    ViewableAtomic cr3_lv3 = new Classroom3_lv3("Classroom3_lv3",10);
    ViewableAtomic cr1_lv4 = new Classroom1_lv4("Classroom1_lv4",10);
    ViewableAtomic cr2_lv4 = new Classroom2_lv4("Classroom2_lv4",10);
    ViewableAtomic cr3_lv4 = new Classroom3_lv4("Classroom3_lv4",10);
    ViewableAtomic s = new staircase("staircase",5);
    ViewableAtomic g = new libraryGenerator("generator",1);
    ViewableAtomic t = new libraryTransducer("transducer",1);

     add(cr1_lv1);
     add(cr2_lv1);
     add(cr3_lv1);
     add(cr1_lv2);
     add(cr2_lv2);
     add(cr3_lv2);
     add(cr1_lv3);
     add(cr2_lv3);
     add(cr3_lv3);
     add(cr1_lv4);
     add(cr2_lv4);
     add(cr3_lv4);
     add(s);
     add(g);
     add(t);

//    addInport("in");
    addInport("start");
    addInport("fire");
    
    
    addOutport("evac_lv1_out");
    addOutport("evac_lv2_out");
    addOutport("evac_lv3_out");
    addOutport("evac_lv4_out");
    addOutport("evac_total_out");
 //   addOutport("evac_rate_out");
    


    addTestInput("start", new entity(""));
    addTestInput("fire", new entity(""));

     
     
     
     addCoupling(this,"start",g,"start");
     
     addCoupling(this,"fire",g,"fire_in");
     addCoupling(this,"fire",s,"fire_in");
     addCoupling(this,"fire",t,"fire_in");
     addCoupling(this,"fire",cr1_lv1,"fire_in");
     addCoupling(this,"fire",cr2_lv1,"fire_in");
     addCoupling(this,"fire",cr3_lv1,"fire_in");
     addCoupling(this,"fire",cr1_lv2,"fire_in");
     addCoupling(this,"fire",cr2_lv2,"fire_in");
     addCoupling(this,"fire",cr3_lv2,"fire_in");
     addCoupling(this,"fire",cr1_lv3,"fire_in");
     addCoupling(this,"fire",cr2_lv3,"fire_in");
     addCoupling(this,"fire",cr3_lv3,"fire_in");
     addCoupling(this,"fire",cr1_lv4,"fire_in");
     addCoupling(this,"fire",cr2_lv4,"fire_in");
     addCoupling(this,"fire",cr3_lv4,"fire_in");
     
     addCoupling(g,"people_out_generator",cr1_lv1,"people_in");
     addCoupling(g,"people_out_generator",cr2_lv1,"people_in");
     addCoupling(g,"people_out_generator",cr3_lv1,"people_in");
     addCoupling(g,"people_out_generator",cr1_lv2,"people_in");
     addCoupling(g,"people_out_generator",cr2_lv2,"people_in");
     addCoupling(g,"people_out_generator",cr3_lv2,"people_in");
     addCoupling(g,"people_out_generator",cr1_lv3,"people_in");
     addCoupling(g,"people_out_generator",cr2_lv3,"people_in");
     addCoupling(g,"people_out_generator",cr3_lv3,"people_in");
     addCoupling(g,"people_out_generator",cr1_lv4,"people_in");
     addCoupling(g,"people_out_generator",cr2_lv4,"people_in");
     addCoupling(g,"people_out_generator",cr3_lv4,"people_in");
//     addCoupling(g,"start",t,"start");
     
     addCoupling(cr1_lv1,"people_out",s,"people_in_level1_cr1");
     addCoupling(cr2_lv1,"people_out",s,"people_in_level1_cr2");
     addCoupling(cr3_lv1,"people_out",s,"people_in_level1_cr3");
     addCoupling(cr1_lv2,"people_out",s,"people_in_level2_cr1");
     addCoupling(cr2_lv2,"people_out",s,"people_in_level2_cr2");
     addCoupling(cr3_lv2,"people_out",s,"people_in_level2_cr3");
     addCoupling(cr1_lv3,"people_out",s,"people_in_level3_cr1");
     addCoupling(cr2_lv3,"people_out",s,"people_in_level3_cr2");
     addCoupling(cr3_lv3,"people_out",s,"people_in_level3_cr3");
     addCoupling(cr1_lv4,"people_out",s,"people_in_level4_cr1");
     addCoupling(cr2_lv4,"people_out",s,"people_in_level4_cr2");
     addCoupling(cr3_lv4,"people_out",s,"people_in_level4_cr3");
     
     addCoupling(s,"evacuated_lv1",t,"evac_lv1_in");
     addCoupling(s,"evacuated_lv2",t,"evac_lv2_in");
     addCoupling(s,"evacuated_lv3",t,"evac_lv3_in");
     addCoupling(s,"evacuated_lv4",t,"evac_lv4_in");
     addCoupling(s,"evacuated_total",t,"evac_total_in");
     addCoupling(s,"evac_pop_out",t,"evac_pop_in");
     
     
     
     addCoupling(t,"evac_lv1_out",this,"evac_lv1_out");
     addCoupling(t,"evac_lv2_out",this,"evac_lv2_out");
     addCoupling(t,"evac_lv3_out",this,"evac_lv3_out");
     addCoupling(t,"evac_lv4_out",this,"evac_lv4_out");
     addCoupling(t,"evac_total_out",this,"evac_total_out");
  //   addCoupling(t,"evac_rate_out",this,"evac_rate_out");
    
     
//     addCoupling(g,"stop",s,"stop");
//     addCoupling(g,"stop",t,"stop");
     
//     addCoupling(g,"desired_speed_out",s,"in");
//     addCoupling(g,"desired_speed_out",t,"desired_speed_in");
//
//     addCoupling(s,"out",t,"actual_speed_in");
//
//     addCoupling(t,"ActualSpeed",g,"ActualSpeed");
//     addCoupling(t,"DesiredSpeed",g,"DesiredSpeed");
//     addCoupling(t,"Avgtime",g,"Avgtime");

}
   
    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    @Override
    public void layoutForSimView()
    {
        preferredSize = new Dimension(1241, 751);
        ((ViewableComponent)withName("Classroom1_lv4")).setPreferredLocation(new Point(244, 24));
        ((ViewableComponent)withName("transducer")).setPreferredLocation(new Point(803, 293));
        ((ViewableComponent)withName("Classroom1_lv3")).setPreferredLocation(new Point(125, 262));
        ((ViewableComponent)withName("generator")).setPreferredLocation(new Point(-59, 232));
        ((ViewableComponent)withName("Classroom1_lv2")).setPreferredLocation(new Point(241, 333));
        ((ViewableComponent)withName("Classroom3_lv4")).setPreferredLocation(new Point(198, 123));
        ((ViewableComponent)withName("Classroom1_lv1")).setPreferredLocation(new Point(75, 473));
        ((ViewableComponent)withName("Classroom3_lv3")).setPreferredLocation(new Point(-78, 110));
        ((ViewableComponent)withName("Classroom3_lv2")).setPreferredLocation(new Point(248, 64));
        ((ViewableComponent)withName("Classroom3_lv1")).setPreferredLocation(new Point(231, 201));
        ((ViewableComponent)withName("Classroom2_lv3")).setPreferredLocation(new Point(315, 176));
        ((ViewableComponent)withName("Classroom2_lv2")).setPreferredLocation(new Point(78, 66));
        ((ViewableComponent)withName("Classroom2_lv4")).setPreferredLocation(new Point(50, 50));
        ((ViewableComponent)withName("staircase")).setPreferredLocation(new Point(429, 255));
        ((ViewableComponent)withName("Classroom2_lv1")).setPreferredLocation(new Point(416, 47));
    }
}
