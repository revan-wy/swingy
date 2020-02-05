# swingy

WeThinkCode Java Project

Goal for this project:
Develop a text based RPG using OOP. Persist the game state on program termination.

Run make.sh to precompile the project. 
Run console.sh or gui.sh to launch the program. 
Type "exit" at any time to quit the program.

Requires Maven to be installed.

If the following error is encountered when running gui.sh on Linux:
Exception in thread "main" java.awt.AWTError: Assistive Technology not found: org.GNOME.Accessibility.AtkWrapper

please follow these steps:
1. sudo vim /etc/java-8-openjdk/accessibility.properties
2. Comment out the following line: #assistive_technologies=org.GNOME.Accessibility.AtkWrapper
