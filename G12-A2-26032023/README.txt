Anthony Miranda, Matt Miranda, Jenna Morrill
26 MAR 2023
README.txt file

This folder should contain folder the questions for assignment 2. Questions are labeled as is across files/folders. All of the
1-5 will be found under the others folder and should be assigned each to their own folder labeled according to their question number.
Number 6 will be in the scheduling folder along with all the code needed to run it. 

To compile and run questions 2 and 5, the gcc compiler will be utilized. This is used by the command "gcc <file name> -o <executable name>". In terms of the files for this assignment, the command will be "gcc qX.c -o qX" where X is the question number. After compiling, the executable will be ran using the command "./qX", where X is the question number

To compile and run questions 3 and 4, JVM will be utilized. This is done by running the command "javac q3.java" for question 3 and "javac q4.java && javac DateClient.java" for question 4. Then the command "java <question that needs to be ran>.java" can be ran. For question 4, the q4.java file needs to be ran first, then the DateClient file can be ran.

In order to compile 6 the terminal should be used for java compiling. vscode was used to open the folder and files and then windows command
prompt was used to compile the Driver file with the command. Directory should be set to the scheduling folder that contains all of the java classes and files
as well as the input file labeled sched.txt (scheduling > scheduling). In order to run the Driver file which allows the user to choose a specific scheduling algorithm and input file the user
should use the command "java Driver <algorithm name> <input file>" where algorithm names can be found within the switch statements of the driver file and the input file is the
sched.txt.