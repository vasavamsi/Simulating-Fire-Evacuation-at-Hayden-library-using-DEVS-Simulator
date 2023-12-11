/*     
 *    
 *  Author     : Dev Dipak Patel & Vamsi Krishna Satyanarayana Vasa
 *  Version    : DEVSJAVA 2.7 
 *  Date       : 11-16-2023
 */
package Component.BasicProcessor;

import java.awt.Color;

import GenCol.doubleEnt;
import GenCol.entity;
import model.modeling.message;
import view.modeling.ViewableAtomic;

public class staircase extends ViewableAtomic {// ViewableAtomic is used instead
	// of atomic due to its
	// graphics capability
	protected doubleEnt job;
	protected double processing_time;
	
	double people_count_lv1;
	double people_count_lv2;
	double people_count_lv3;
	double people_count_lv4;
	double people_count_total;
	double evac_pop;
	double steptime;
	double temp;
	
	public staircase() {
		this("staircase", 10);
	}

	public staircase(String name, double Processing_time) {
		super(name);
		addInport("people_in_level1_cr1");
		addInport("people_in_level1_cr2");
		addInport("people_in_level1_cr3");
		addInport("people_in_level2_cr1");
		addInport("people_in_level2_cr2");
		addInport("people_in_level2_cr3");
		addInport("people_in_level3_cr1");
		addInport("people_in_level3_cr2");
		addInport("people_in_level3_cr3");
		addInport("people_in_level4_cr1");
		addInport("people_in_level4_cr2");
		addInport("people_in_level4_cr3");
		addInport("fire_in");
	
		addOutport("evac_pop_out");
		addOutport("evacuated_total");
		addOutport("evacuated_lv1");
		addOutport("evacuated_lv2");
		addOutport("evacuated_lv3");
		addOutport("evacuated_lv4");
	 
		processing_time = Processing_time;
	
		addTestInput("fire_in", new entity(""));
		addTestInput("people_in_level1_cr1",new doubleEnt((double)1));
		addTestInput("people_in_level1_cr2",new doubleEnt((double)1));
		addTestInput("people_in_level1_cr3",new doubleEnt((double)1));
		addTestInput("people_in_level2_cr1",new doubleEnt((double)1));
		addTestInput("people_in_level2_cr2",new doubleEnt((double)1));
		addTestInput("people_in_level2_cr3",new doubleEnt((double)1));
		addTestInput("people_in_level3_cr1",new doubleEnt((double)1));
		addTestInput("people_in_level3_cr2",new doubleEnt((double)1));
		addTestInput("people_in_level3_cr3",new doubleEnt((double)1));
		addTestInput("people_in_level4_cr1",new doubleEnt((double)1));
		addTestInput("people_in_level4_cr2",new doubleEnt((double)1));
		addTestInput("people_in_level4_cr3",new doubleEnt((double)1));
	
		
		setBackgroundColor(Color.cyan);
	}

	public void initialize() {
		phase = "good";
		sigma = INFINITY;
		
		steptime = 1;
		people_count_lv1=10;
		people_count_lv2=0;
		people_count_lv3=0;
		people_count_lv4=10;
		people_count_total=10;
		evac_pop=people_count_lv1 + people_count_lv2 + people_count_lv3 + people_count_lv4;
		//job = new entity("job");
		super.initialize();
	}

	public void deltext(double e, message x) {
		Continue(e);

//		System.out.println("The elapsed time of the processor is" + e);
//		System.out.println("*****************************************");
//		System.out.println("external-Phase before: "+phase);
		
		if (phaseIs("fire"))
			{for (int i = 0; i < x.getLength(); i++)
				if (messageOnPort(x, "people_in_level1_cr1", i)) {
					job = (doubleEnt) x.getValOnPort("people_in_level1_cr1", i);
					temp = job.getv();
					
					if(temp > 0 )
						{	people_count_lv1++;
							evac_pop++;
							holdIn("fire", steptime);
						}
				}
			}
		
		
		if (phaseIs("fire"))
			{for (int i = 0; i < x.getLength(); i++)
				if (messageOnPort(x, "people_in_level1_cr2", i)) {
					job = (doubleEnt) x.getValOnPort("people_in_level1_cr2", i);
					temp = job.getv();
					
					if(temp > 0 )
						{	people_count_lv1++;
							evac_pop++;
							holdIn("fire", steptime);
						}
				}
			}
		
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level1_cr3", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level1_cr3", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv1++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level2_cr1", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level2_cr1", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv2++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level2_cr2", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level2_cr2", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv2++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level2_cr3", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level2_cr3", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv2++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		
		
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level3_cr1", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level3_cr1", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv3++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level3_cr2", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level3_cr2", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv3++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level3_cr3", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level3_cr3", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv3++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
		
		
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level4_cr1", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level4_cr1", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv4++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level4_cr2", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level4_cr2", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv4++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
	
		if (phaseIs("fire"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in_level4_cr3", i)) {
				job = (doubleEnt) x.getValOnPort("people_in_level4_cr3", i);
				temp = job.getv();
				
				if(temp > 0 )
					{	people_count_lv4++;
						evac_pop++;
						holdIn("fire", steptime);
					}
			}
		}
		
		if (phaseIs("good"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "fire_in", i)) {
				holdIn("fire", steptime);
			}
		}
	}

	public void deltint() {

		if (phaseIs("fire")) {
				
			people_count_total=people_count_lv1+people_count_lv2+people_count_lv3+people_count_lv4;
			
				if(people_count_total > 0)
				{	people_count_lv1 -= min(5,(int)people_count_lv1);
					people_count_lv1 +=min(5,(int)people_count_lv2);
					people_count_lv2 -= min(5,(int)people_count_lv2); 
					people_count_lv2 +=min(5,(int)people_count_lv3);
					people_count_lv3 -= min(5,(int)people_count_lv3); 
					people_count_lv3 +=min(5,(int)people_count_lv4);
					people_count_lv4 -= min(5,(int)people_count_lv4); 
					
					holdIn("fire", steptime);
					
				}
				else if(people_count_total == 0)
				{ 
					
					holdIn("safe", INFINITY);
				}
			}
	}
	
	private double min(int i, int j) {
		// TODO Auto-generated method stub
		return i<j ? i : j;
	}

	public void deltcon(double e, message x) {
		deltint();
		deltext(0, x);
	}

	public message out() {
		message m = new message();
		people_count_total=people_count_lv1+people_count_lv2+people_count_lv3+people_count_lv4;
		if (phaseIs("fire") && people_count_total == 0) {
			m.add(makeContent("evacuated_total", new entity("")));  
			m.add(makeContent("evac_pop_out", new doubleEnt(evac_pop)));  
		}
		if (phaseIs("fire") && people_count_lv4 == 0) {
			m.add(makeContent("evacuated_lv4", new entity("")));   
		}
		if (phaseIs("fire") && people_count_lv3 == 0 && people_count_lv4 == 0) {
			m.add(makeContent("evacuated_lv3", new entity("")));  
		}
		if (phaseIs("fire") && people_count_lv2 ==0 && people_count_lv3 == 0 && people_count_lv4 == 0) {
			m.add(makeContent("evacuated_lv2", new entity("")));  
		}
		if (phaseIs("fire") && people_count_lv1 ==0 && people_count_lv2 ==0 && people_count_lv3 == 0 && people_count_lv4 == 0) {
			m.add(makeContent("evacuated_lv1", new entity("")));  
		}
		return m;
	}

}
