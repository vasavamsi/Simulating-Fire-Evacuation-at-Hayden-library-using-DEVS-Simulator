/*     
 *    
 *  Author     : Dev Dipak Patel & Vamsi Krishna Satyanarayana Vasa
 *  Version    : DEVSJAVA 2.7 
 *  Date       : 11-16-2023 
 */

package Component.BasicProcessor;


import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import GenCol.doubleEnt;
import GenCol.entity;


import model.modeling.content;
import model.modeling.message;

import view.modeling.ViewableAtomic;



public class libraryTransducer extends  ViewableAtomic{

 protected doubleEnt job;
 protected double clock,steptime;
 protected double lv1_evac_time,lv2_evac_time,lv3_evac_time,lv4_evac_time, total_evac_time,evac_rate;
 public Double count,temp;
  


 public libraryTransducer(String  name,double Observation_time){
  super(name);
   addInport("fire_in");
   addInport("evac_lv1_in");
   addInport("evac_lv2_in");
   addInport("evac_lv3_in");
   addInport("evac_lv4_in");
   addInport("evac_total_in");
   addInport("evac_pop_in");
  
   
   addOutport("evac_lv1_out");
   addOutport("evac_lv2_out");
   addOutport("evac_lv3_out");
   addOutport("evac_lv4_out");
   addOutport("evac_total_out");
   //addOutport("evac_rate_out");
   
  
  
   addTestInput("fire_in", new entity(""));
   addTestInput("evac_lv1_in", new entity(""));
   addTestInput("evac_lv2_in", new entity(""));
   addTestInput("evac_lv3_in", new entity(""));
   addTestInput("evac_lv4_in", new entity(""));
   addTestInput("evac_total_in", new entity(""));
  

 
   
  initialize();
  
  setBackgroundColor(Color.green);
 }

 public libraryTransducer() {this("SkateboardTransducer", 200);}

 public void initialize() {
		phase = "idle";
		sigma = INFINITY;
		clock = 0;
		lv1_evac_time=INFINITY;
		lv2_evac_time=INFINITY;
		lv3_evac_time=INFINITY;
		lv4_evac_time=INFINITY;
		
		count=0.0;
		steptime=1;
		
		super.initialize();
	}
 
 public void  deltext(double e,message  x){
//	 System.out.println("--------Transduceer elapsed time ="+e);
//	 System.out.println("-------------------------------------");
  clock = clock + e;
  Continue(e);
  
  if (phaseIs("idle"))
	{for (int i = 0; i < x.getLength(); i++)
		if (messageOnPort(x, "fire_in", i)) {
			
			holdIn("fire", steptime);
			
		}
	}
  
  if (phaseIs("fire"))
 	{for (int i = 0; i < x.getLength(); i++)
 		if (messageOnPort(x, "evac_total_in", i)) {
 			total_evac_time = count;
 			lv1_evac_time = count;
 			holdIn("respond", steptime);
 			
 		}
 	}
  
  if (phaseIs("fire"))
 	{for (int i = 0; i < x.getLength(); i++)
 		if (messageOnPort(x, "evac_pop_in", i)) {
 			job = (doubleEnt) x.getValOnPort("people_in", i);
			temp = job.getv();
			
			
 			total_evac_time = count;
 			lv1_evac_time = count;
 			
 			evac_rate=total_evac_time / temp;
 			holdIn("respond", steptime);
 			
 		}
 	}
  
  if (phaseIs("fire"))
	{for (int i = 0; i < x.getLength(); i++)
		if (messageOnPort(x, "evac_lv1_in", i)) {
			if(lv1_evac_time > count) {
				lv1_evac_time = count;
				total_evac_time = count;
			}
			
		}
	}
 
  if (phaseIs("fire"))
	{for (int i = 0; i < x.getLength(); i++)
		if (messageOnPort(x, "evac_lv2_in", i)) {
			if(lv2_evac_time > count)
			lv2_evac_time = count;
			
			
		}
	}
  
  
  if (phaseIs("fire"))
	{for (int i = 0; i < x.getLength(); i++)
		if (messageOnPort(x, "evac_lv3_in", i)) {
			if(lv3_evac_time > count)
			lv3_evac_time = count;
			
			
		}
	} 
  
  if (phaseIs("fire"))
	{for (int i = 0; i < x.getLength(); i++)
		if (messageOnPort(x, "evac_lv4_in", i)) {
			
			if(lv4_evac_time > count)
			lv4_evac_time = count;
			
			
		}
	}
  

    }


 public void  deltint(){
  clock = clock + sigma;
  
//  int index=(int) (clock)  ;
  
  if (phaseIs("fire")) {
	  count++;
	  holdIn("fire", steptime);
  }
 }

 public  message    out(){
  message  m = new message();
  
  
  if(phase=="respond") {
	  
  
  content  con1 = makeContent("evac_total_out",new doubleEnt(total_evac_time));
  content  con2 = makeContent("evac_lv1_out",new doubleEnt(lv1_evac_time));
  content  con3 = makeContent("evac_lv2_out",new doubleEnt(lv2_evac_time));
  content  con4 = makeContent("evac_lv3_out",new doubleEnt(lv3_evac_time));
  content  con5 = makeContent("evac_lv4_out",new doubleEnt(lv4_evac_time));
  //content  con6 = makeContent("evac_rate_out",new doubleEnt(evac_rate));
  
  m.add(con1);
  m.add(con2);
  m.add(con3);
  m.add(con4);
  m.add(con5);
  //m.add(con6);
  
  holdIn("safe", INFINITY);
  }
 
  return m;
 }
 
}

