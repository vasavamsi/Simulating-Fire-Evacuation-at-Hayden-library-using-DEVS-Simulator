## Simulating-Fire-Evacuation-at-Hayden-library-using-DEVS-Simulator
This project is completed as a part of Course project in CSE-561 Modelling, Simulation and Theory of applications. This work leverages the state-of-the-art DEVS simulator to develop the model for the Hayden library building layout.

# ABSTRACT

With this project, we are aiming to simulate the evacuation of patrons from the Hayden Library in an unfortunate event of fire. Our model will predict the estimated time to evacuate everyone safely with zero casualties. The patron’s safety is assumed once he/she exits the Hayden library through the nearest exit points. Our system (Hayden Library) consists of four levels with a designated layout and seating capacity abiding by fire regulations. We initiate the simulation by triggering the fire alarm. We are aiming to cover scenarios such as uniform/non-uniform distribution of patrons across the facilities along with partial or complete functionality of the library. We will adapt the Parallel DEVS specification for atomic components (Ex. Classroom, Discussion rooms, etc.) for each level which will direct the flow to staircase model and ultimately towards the exit. Our model is customizable for different building layouts and can be highly beneficial for builders and architects to abide by the fire regulations.

# Model description

The classroom (or discussion rooms, common sitting area, etc.) component is a basic parallel atomic component. It is used to model a certain facility at any level in Hayden Library and can be extended to model any other type of facility in the system. This kind of component keeps track of the number of people in that facility. As shown in Figure, with no fire trigger, people can enter or exit the facility, which is controlled by the generator. This count can go from 0 to the maximum capacity of that facility. We define this phase as good in all the components. 

![image](https://github.com/vasavamsi/Simulating-Fire-Evacuation-at-Hayden-library-using-DEVS-Simulator/assets/58003228/d96afbd4-ac77-4eae-ac79-026b89be51c4)
*image_caption*
