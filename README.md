[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)
# 3500 PA05 Project Repo


Navigate through your week at a glance, with a beautifully designed and easy-to-read layout that puts the focus on your tasks and events. 
Whether you're scheduling a meeting, planning a workout, or jotting down a quick reminder, you can create tasks and events effortlessly.
Stay on top of your workload with customized commitment limits. Set a max number of tasks and events to prevent yourself from getting
overworked. Don't be a flake; Keep your plans solid with the save feature, so you can always come back to your journal.
The sleek, intuitive menu bar helps you navigate through the app with ease, making organization a breeze. Each feature also
has a corresponding keyboard shortcut, so you can journal with the click of a button. Customize your bullet journal experience with 
a wide array of pre-set and custom themes. Choose one that resonates with your mood, personality, or the season. Want a focused look at 
your day? The mini-view feature offers a compact yet comprehensive look at your task or event. Keep your tasks and events organized the way you 
want! Sort your tasks by name or duration for your convenience. Plans changed? Modify any commitment with ease with just a double click.
Plans fell through? Removing a commitment is as easy as the click of a button. Start your app experience with our engaging and visually appealing
splash screen. Don't want to re-do your settings next week? Start the new week effortlessly by loading in a template. Happy Journaling!
![2023-06-21 (3)](https://github.com/CS-3500-OOD/pa05-alyssa-ebrahim-nicole/assets/63073676/82fa70c2-c421-434a-afe1-cf9e15d38b15)

Application Screeshots:

![2023-06-21](https://github.com/CS-3500![2023-06-21 (4![2023-06-21 (3)](https://github.com/CS-3500-OOD/pa05-alyssa-ebrahim-nicole/assets/63073676/1c490af9-2571-440b-a553-6c07509861be)cole/assets/63073676/796ed9c5-c7c6-4536-9eab-3b93ea21858b)-OOD/pa05-alyssa-ebrahim-nicole/assets/63073676/c44f52e5-866a-45c0-bbe1add947b14b04)
![2023-06-21 (1)](https://github.com/CS-3500-OOD/pa05-alyssa-ebrahim-nicole/assets/63073676/c5768205-c9a8-4a8a-bf21-9f62d7fb45e1)


![2023-06-21 (5)](https://github.com/CS-3500-OOD/pa05-alyssa-ebrahim-nicole/assets/63073676/8aeba2c8-cffb-4ba1-acd8-a7e8cae81bc9)

Solid Principles:
S: To adhere to the single responsibility principle, we were careful to make sure that each class was only responsible
for one aspect of the program. For example, we have different handler classes for handling menu events and handling shortcuts.
We also separated our classes into MVC format for better readability and responsibility separation.
O: In accordance with the open/closed principle, we made use of abstract classes to reduce code reuse. For example, the AddPopUp 
super class and its subclasses, EventAddPopUp, TaskAddPopUp, and CustomThemePopUp. As the open/closed principle dictates, 
we were able to extend and add to these super classes, but not modify them from the subclasses.
L: We followed the Liskov substitution principle by being careful that our abstract class' subclasses did not modify any
method signatures or return types. Subclasses do not throw exceptions that their superclasses do not
I: To maintain interface segregation, we did not have any classes inherit methods from interfaces that they did not need.
D: We maintained dependency inversion by passing objects of different classes in via constructors. For example, we store
information for .bujo files in a BujoFileInformation object so that it can be accessed by multiple sources.

Ways to extend the program:
We could implement a vertical layout by adding a Menu bar option to "Swap Layout", and switching the tabs to be vertical. 
This feature is pre-built into JavaFx as a TabPane property, so it would be easy to swap to a vertical layout

Additionally, we could add a task search feature by adding a search bar at the bottom of the task menu, and comparing the user's input to
results in controller's tasksMap field.
