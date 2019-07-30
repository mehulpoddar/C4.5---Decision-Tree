public class SplitInfo
{
double result = 0.0;
double firstF ;
int secondF;
int thirdF;
int fourthF;
    public double getSplitInfo(double first,int second,int third,int fourth){
    result = 0.0;
    try{
    firstF = first;
    secondF = second;
    thirdF = third;
    fourthF = fourth;
    double firstLog = (double)second/first;
    double secondLog = (double)third/first;
    double thirdLog = (double)fourth/first;
  
    double firstLog1 = firstLog*(Math.log((double)firstLog)/Math.log(2));
    double secondLog1 = secondLog*(Math.log((double)secondLog)/Math.log(2));
    double thirdLog1 = thirdLog*(Math.log((double)thirdLog)/Math.log(2));
    
    result = -firstLog1 - secondLog1-thirdLog1;
    
    }catch(Exception e){
        System.out.println(e+ " in entropy side");
    }
    return result;
}
    
}
