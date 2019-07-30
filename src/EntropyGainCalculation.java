public class EntropyGainCalculation {
    
    double result = 0.0d;
    double firstD = 0.0d;
    double secondD = 0.0d;
    double thirdD = 0.0d;
    double fourthD = 0.0d;
    double fifthD = 0.0d;
    double sixthD = 0.0d;
    double seventhD = 0.0d;
    public double getEntropyGain(double first,double second,double third,double fourth,double fifth,double sixth,double seventh){
        result = 0.0d;
        firstD = first;
        secondD = second;
        thirdD = third;
        fourthD = fourth;
        fifthD = fifth;
        sixthD = sixth;
        seventhD = seventh;
        
        result = (firstD - (fifth*secondD) - (sixth*thirdD) - (seventh*fourthD));
        return result;
    }
    
}