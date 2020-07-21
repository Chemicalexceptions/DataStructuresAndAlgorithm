public class NestedRecursionEx {

    public static void main(String[] args) {


      int x = funcA(95);

        System.out.println(x);


    }




    static  int funcA (int n){


        if(n>100){

           // System.out.println(n);
            return  n-10;


        }

        else{

            return  funcA(funcA(n+11));
        }


    }



}
