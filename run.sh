#!/bin/bash

# User_Home varibale = the echoed path.
USER_HOME=$(eval echo ~)

# File_Path varibales in Ascii to read text files in relative directory
FILE_PATH01="$USER_HOME/StudentWork/MiniProject/JavaProject_Team5/A01.txt"
FILE_PATH02="$USER_HOME/StudentWork/MiniProject/JavaProject_Team5/A02.txt"

# Run the java program using the filepath as arguments
java -cp YourClasspath YourClassName "$FILE_PATH01" "$FILE_PATH02"

java -classpath out/production/JavaProject_Team5:"lib/*" io.trivia.client.Main