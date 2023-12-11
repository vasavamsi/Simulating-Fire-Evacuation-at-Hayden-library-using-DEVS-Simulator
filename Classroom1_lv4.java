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

public class Classroom1_lv4 extends ViewableAtomic {// ViewableAtomic is used instead
	// of atomic due to its
	// graphics capability
	protected doubleEnt job;
	protected double processing_time;
	
	double people_count;
	double max_capacity;
	
	double steptime;
	double temp;
	
	public Classroom1_lv4() {
		this("classroom1_lv4", 10);
	}

	public Classroom1_lv4(String name, double Processing_time) {
		super(name);
		addInport("people_in");
		addInport("fire_in");
		addOutport("out"); // this port is used for debugging and serves no purpose for overall project
		addOutport("people_out");
	 
		processing_time = Processing_time;
		addTestInput("fire_in", new entity(""));
		addTestInput("people_in",new doubleEnt((double)-1));
		addTestInput("people_in",new doubleEnt((double)1));
	
		
		setBackgroundColor(Color.cyan);
	}

	public void initialize() {
		phase = "good";
		sigma = INFINITY;
		
		steptime = 1;
		people_count=40;
		max_capacity=95;
	
		//job = new entity("job");
		super.initialize();
	}

	public void deltext(double e, message x) {
		Continue(e);

//		System.out.println("The elapsed time of the processor is" + e);
//		System.out.println("*****************************************");
//		System.out.println("external-Phase before: "+phase);
		
		if (phaseIs("good"))
			{for (int i = 0; i < x.getLength(); i++)
				if (messageOnPort(x, "people_in", i)) {
					job = (doubleEnt) x.getValOnPort("people_in", i);
					temp = job.getv();
					
					if(temp > 0 && people_count < max_capacity)
						{	people_count++;
							holdIn("good", INFINITY);
						}

				}
			}
		
		if (phaseIs("good"))
		{for (int i = 0; i < x.getLength(); i++)
			if (messageOnPort(x, "people_in", i)) {
				job = (doubleEnt) x.getValOnPort("people_in", i);
				temp = job.getv();
				
				if(temp < 0 && people_count > 0)
					{	people_count--;
						holdIn("good", INFINITY);
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
			
				if(people_count > 0)
				{	people_count--;
					holdIn("fire", steptime);
				}
				else if(people_count == 0)
				{
					
					holdIn("safe", INFINITY);
				}
				
			
			}
	}
	
	public void deltcon(double e, message x) {
		deltint();
		deltext(0, x);
	}

	public message out() {
		message m = new message();
		if (phaseIs("fire") && people_count == 0) {
			m.add(makeContent("out", new doubleEnt(100)));
		}
		if (phaseIs("fire") && people_count != 0) {
			m.add(makeContent("people_out", new doubleEnt(1)));
		}
		return m;
	}

}
