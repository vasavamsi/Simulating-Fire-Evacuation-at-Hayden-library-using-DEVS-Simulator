## Simulating-Fire-Evacuation-at-Hayden-library-using-DEVS-Simulator
This project is completed as a part of Course project in CSE-561 Modelling, Simulation and Theory of applications. This work leverages the state-of-the-art DEVS simulator to develop the model for the Hayden library building layout.

# ABSTRACT

With this project, we are aiming to simulate the evacuation of patrons from the Hayden Library in an unfortunate event of fire. Our model will predict the estimated time to evacuate everyone safely with zero casualties. The patron’s safety is assumed once he/she exits the Hayden library through the nearest exit points. Our system (Hayden Library) consists of four levels with a designated layout and seating capacity abiding by fire regulations. We initiate the simulation by triggering the fire alarm. We are aiming to cover scenarios such as uniform/non-uniform distribution of patrons across the facilities along with partial or complete functionality of the library. We will adapt the Parallel DEVS specification for atomic components (Ex. Classroom, Discussion rooms, etc.) for each level which will direct the flow to staircase model and ultimately towards the exit. Our model is customizable for different building layouts and can be highly beneficial for builders and architects to abide by the fire regulations.

# Model description

The classroom (or discussion rooms, common sitting area, etc.) component is a basic parallel atomic component. It is used to model a certain facility at any level in Hayden Library and can be extended to model any other type of facility in the system. This kind of component keeps track of the number of people in that facility. As shown in Figure, with no fire trigger, people can enter or exit the facility, which is controlled by the generator. This count can go from 0 to the maximum capacity of that facility. We define this phase as good in all the components. 

![image](https://github.com/vasavamsi/Simulating-Fire-Evacuation-at-Hayden-library-using-DEVS-Simulator/assets/58003228/d96afbd4-ac77-4eae-ac79-026b89be51c4)

The population control can be a user defined input, which is coded in the generator model script. Once, the fire alarm is triggered from the generator all components (including staircase and transducer) will change their phases to the fire. During the fire phase, the generator will stop controlling the population and model will try to evacuate the current population. Which is analogous to restricting the entry to library. The Transducer will also start tracking the time from the fire trigger. The same is shown pictorially, in the below figure.

![image](https://github.com/vasavamsi/Simulating-Fire-Evacuation-at-Hayden-library-using-DEVS-Simulator/assets/58003228/b8aae50d-cb12-4c41-a08b-568c2933cc4e)

We have provided certain limitations on the flow of patrons and stairway capacity to keep the simulation realistic (these restrictions are discussed in Simulation Experiments and Evaluation sections). Once the patrons are evacuated from the components (classrooms, discussion rooms, etc.) the phase will change to safe. We maintain the population count at each level in the staircase model and will signal the transducer as we complete the evacuation of each level. By obtaining these signals, the transducer will note the time taken to evacuate each level, with the given conditions. The staircase model will go into phase safe once the complete building is evacuated. The next section will provide detailed specification tables for each model component. The image below shows the Simview of the model from DEVS Simulator.

![image](https://github.com/vasavamsi/Simulating-Fire-Evacuation-at-Hayden-library-using-DEVS-Simulator/assets/58003228/060ef17b-dd91-4159-9555-3f4096476a9e)
