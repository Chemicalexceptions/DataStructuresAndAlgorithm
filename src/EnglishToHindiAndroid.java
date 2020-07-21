import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EnglishToHindiAndroid {


    public static final String PATH = "/Users/jhumpi/IdeaProjects/DataStructuresAndAlgorithm/src/english.txt";
    public static final String PATH1 = "/Users/jhumpi/IdeaProjects/DataStructuresAndAlgorithm/src/english1.txt";

    public static void main(String[] args) {

         Map<String,String> englishMap;
         Map<String,String> hindiMap;

        EnglishToHindiAndroid convert = new EnglishToHindiAndroid();
        englishMap =  convert.readLanguageFile(PATH);

        /*englishMap.entrySet().forEach(entry->{
            System.out.println("key ->"+entry.getKey() + " " + "value ->"+entry.getValue());
         });
*/


        hindiMap  =convert.convertEnglishToHindi(englishMap);
       /* hindiMap.entrySet().forEach(entry->{
        System.out.println("key ->"+entry.getKey() + " " + "value ->"+entry.getValue());
        });
       */  convert.generateHindiFile(hindiMap,PATH);


        try {
            Files.writeString(Paths.get(PATH1), "Chalu ho gaya");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void generateHindiFile(Map<String,String> map,String file){

        try {


            String  fileString = new String(Files.readAllBytes(Paths.get(file)));
            StringBuilder newString = new StringBuilder();
            // System.out.println(fileString);

            String[] lineString = fileString.split("\\r?\\n");;
            // System.out.println(lineString[0]);

            for (String a :
                    lineString) {

               // newString.append(a).append("\n");



                if(a.trim().startsWith("<string")){

                    // System.out.println(a);
//
                    String key = a.substring(a.indexOf("name=")+6,a.indexOf(">")-1);

//                    System.out.println(key);

                    map.forEach((key1, value1) -> {
                        //  System.out.println("key ->"+entry.getKey() + " " + "value ->"+entry.getValue());

                        if (key.equals(key1)) {

                           // System.out.println("String key->"+key + "   "+"Map key ->"+key1);
                            String value = a.substring(a.indexOf(">") + 1, a.indexOf("</string>"));
                           // System.out.println("value->"+value +" new --> "+value1);
                            String b =  a.replace(value, value1);

                           // System.out.println("replaced ->"+b);
                          // newString.append(txt).append("\n");

                        }
                    });


                }
                else{
                   // newString.append(a).append("\n");
                }
            }

          //System.out.println("modified : "+lineString);

            for (String txt:
                 lineString) {

                System.out.println(txt);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private  Map<String,String> convertEnglishToHindi(Map<String,String> map){

        Map<String ,String> hindiMap = new HashMap<String,String>();

        map.entrySet().forEach(entry->{
//            System.out.println("key ->"+entry.getKey() + " " + "value ->"+entry.getValue());

            hindiMap.put(entry.getKey(),"null");


        });

        return hindiMap;

    }


    private Map<String,String> readLanguageFile(String file){

        Map<String ,String> map = new HashMap<String,String>();

        try {


            String  fileString = new String(Files.readAllBytes(Paths.get(file)));
           // System.out.println(fileString);

            String[] lineString = fileString.split("\\r?\\n");;
           // System.out.println(lineString[0]);

            for (String a :
                 lineString) {

                if(a.trim().startsWith("<string")){

                   // System.out.println(a);

                    String key = a.substring(a.indexOf("name=")+6,a.indexOf(">")-1);
                   // System.out.println("key->"+key);

                    String value = a.substring(a.indexOf(">")+1,a.indexOf("</string>"));
                    //System.out.println("value->"+value);


                    map.put(key,value);

                }
                else{

                   // System.out.println("new -> "+a);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            FileReader reader = new FileReader(file);
//            int i;
//            while((i=reader.read())!=-1){
//
//                System.out.println((char)i);
//
//            }
//            reader.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        return map;



    }



}
