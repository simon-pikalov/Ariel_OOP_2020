package inner;

public interface Opperable {
    /**
     * @return the opp made on a and b
     */
    double opp(double a, double b);

}

class AbsMul implements  Opperable{
    @Override
    public double opp(double a, double b) {
        return Math.abs(a*b);
    }
}


  class Opp{

    public static void main(String[] args) {


        //method 1 regular class
        AbsMul regulaAbsMul = new AbsMul();
        System.out.println("regular class :"+regulaAbsMul.opp(11,-11));

        //method 2 AnonClass class
        Opperable AbsMulAnon = new Opperable() {
            @Override
            public double opp(double a, double b) {
                return Math.abs(a*b);
            }
        };
        System.out.println("AnonClass class :"+AbsMulAnon.opp(11,-11));

        //method3 lamda block
        Opperable regularOppBlock =(a,b)-> {return Math.abs(a*b);};
        System.out.println("lambda block  :"+regularOppBlock.opp(11,-11));

        //method4 lamda Experesion
        Opperable oppLambdaExperesion =(a,b)-> Math.abs(a*b);
        System.out.println("lambda Expression:"+oppLambdaExperesion.opp(11,-11));

    }


}
