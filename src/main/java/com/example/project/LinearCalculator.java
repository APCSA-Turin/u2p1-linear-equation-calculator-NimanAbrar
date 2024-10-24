package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;



    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String firstCoordinate, String secondCoordinate){ // <--add 2 string parameters to this constructor
        int firstComma = firstCoordinate.indexOf(",");
        int secondComma = secondCoordinate.indexOf(",");
        this.x1 = Integer.parseInt(firstCoordinate.substring(1,firstComma));
        this.x2 = Integer.parseInt(secondCoordinate.substring(1,secondComma));
        this.y1 = Integer.parseInt(firstCoordinate.substring(firstComma + 1,firstCoordinate.length() - 1));
        this.y2 = Integer.parseInt(secondCoordinate.substring(secondComma + 1,secondCoordinate.length() - 1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX){x1 = newX;}
    public void setY1(int newY){y1 = newY;}
    public void setX2(int newX){x2 = newX;}
    public void setY2(int newY){y2 = newY;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt(((Math.pow(getX2()-getX1(),2))) + (Math.pow(getY2()-getY1(), 2)));
        return roundedToHundredth(distance);
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (x2 == x1) {
            return -999.99;
        } else {
            return roundedToHundredth(y1 - (slope() * x1));
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double slope = ((double) ((y2)-(y1))/(double) ((x2)-(x1)));
        if (x2 == x1) {
        return -999.99;
        } else {
            return roundedToHundredth(slope);
        }
        
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation() {
        if (x1 == x2) {
            return "undefined";
        }
        double slope = slope();
        double yInt = yInt();
        
        String equation = "y=";
        
        if (slope == 0) {
            equation += roundedToHundredth(yInt);  
        } else {
            equation += slope + "x";
            if (yInt > 0) {
                equation += "+" + yInt;
            } else if (yInt < 0) {
                equation += yInt;
            }
        }
        return equation;
    }

    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double round = Math.round(x*100)/100.0;
        return round;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation() ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}