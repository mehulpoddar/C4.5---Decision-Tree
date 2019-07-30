public class EntropyIndividual {
double result = 0.0;
int firstF ;
int secondF;
int thirdF;

public double getEntroy(int first,int second,int third){
    result = 0.0;
    try{
    firstF = first;
    secondF = second;
    thirdF = third;
  
    double firstLog = (double)firstF/thirdF ;
    double secondLog = (double)secondF/thirdF ;
 
    double firstLog1 = firstLog*(Math.log((double)firstLog)/Math.log(2));
    double secondLog1 = secondLog*(Math.log((double)secondLog)/Math.log(2));
 
    result = -firstLog1 - secondLog1;
    }catch(Exception e){
        System.out.println(e+" in entropy side");
    }
    return result;
}
}
