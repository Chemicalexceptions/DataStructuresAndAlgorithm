public class IndirectRecursionEx {

    public static void main(String[] args) {


      // funcA(20);



    }




    static  void funcA (int n){


        if(n>0){

            System.out.println(n);
            funcB(n-1);


        }


    }

    static void funcB(int n) {

        if(n>1){

            System.out.println(n);
            funcA(n/2);

        }

    }

}
