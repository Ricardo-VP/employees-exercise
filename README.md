Employees Schedules App
============================

## Table of contents
* [About the exercise of the app](#about)
* [Technologies](#technologies)
* [Methodology](#methodology)
* [Architecture](#architecture)
* [Folder Structure](#folder-structure)
* [Prerrequisites](#prerrequisites)
* [How to run the app](#how-to-run-the-app)
* [Examples](#examples)

## About the exercise of the app

The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.

Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our examples below:

## Methodology

For the development of this application, as I mentioned before, the object-oriented programming paradigm, in addition to using the functional paradigm, 
that is, the use of functions to improve the structure of the code.

## Architecture

### Model View Controller
For this project I used MVC architecture. But since it is a console application, I have chosen to omit the "View" part.

### Object Oriented Programming
For this project, the object-oriented programming paradigm has been used. Therefore, you will find the use of classes, objects, getters and setters, etc.

## Technologies
* [Azul Zulu - Version 18](https://www.azul.com/downloads/?package=jdk#download-openjdk)
* [IntelliJ Idea](https://www.jetbrains.com/es-es/idea/download/#section=windows)
* Java Docs
* JUnit

## Folder Structure

    .
    ├── .idea                   # IntelliJ Idea (IDE) files
    ├── docs                    # Documentation files 
    ├── lib                     # Library files
    ├── src                     # Source files
    
## Prerrequisites
* Integrated Development Environment for Java (IDE) - I recommend IntelliJ Idea or Eclipse
* Java Development Kit (JDK) - I recommend Azul Zulu (Version 18)

## How to run the app
As I mentioned in the prerequisites section, to run this application you need an IDE for Java and a JDK for version 18 of Java.
<br/>
<b>Once you have cloned the project and opened your IDE all that remains is to run the App.java file located in the "/src/main/" folder.</b>

![image](https://user-images.githubusercontent.com/71697096/161493794-bf12b104-6c85-426f-87d4-9c021e6feeb4.png)


## Examples
### Example 1:
#### INPUT
```
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00- 21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```
#### OUTPUT:
```
ASTRID-RENE: 2
ASTRID-ANDRES: 3
RENE-ANDRES: 2
```
### Example 2:
#### INPUT:
```
RENE=MO10:15-12:00,TU10:00-12:00,TH13:00-13:15,SA14:00-18:00,SU20:00-21:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```
#### OUTPUT:
```
RENE-ASTRID: 3
```
