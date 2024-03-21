import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class NotacionPolaca_Javierse {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> polska = new ArrayList<String>();
        System.out.println("Escribe la linea a resolver");
        String l = sc.nextLine();
        int start = 0;
        String a = "";
        System.out.println(a);
        for (int i=0; i<l.length(); i++){
            if (l.charAt(i) == ' ') {
                polska.add(l.substring(start, i));
                start = i+1;
            }
            if (i==l.length()-1) {
                polska.add(l.substring(start, i+1));
            }
        }
        start = 0;
        int res = 0;
        for (int i=0; i<polska.size(); i++){
            System.out.println(polska.get(i));
            if (polska.get(i).equals("+")) {
                for (int j = start; j<i; j++){
                    res += Integer.parseInt(polska.get(j));
                    start = i;
                }
            }
            if (polska.get(i).equals("-")) {
                for (int j = start; j<i; j++){
                    res -= Integer.parseInt(polska.get(j));
                    start = i;
                }
            }
            if (polska.get(i).equals("/")) {
                for (int j = start; j<i; j++){
                    res /= Integer.parseInt(polska.get(j));
                    start = i;
                }
            }
            if (polska.get(i).equals("")) {
                for (int j = start; j<i; j++){
                    res += Integer.parseInt(polska.get(j));
                    start = i;
                }
            }
        }
        System.out.println(res);
        
        
        //String nums ="";
        //ArrayList<String> array = new ArrayList<String>();
        //for (int i = 0; i<l.length(); i++){
         //   nums+=Character.toString(l.charAt(i));
        //    if (l.charAt(i) == '+' || l.charAt(i) == '-' || l.charAt(i) == '/' || l.charAt(i) == '*') {
         //       nums = nums.substring(0, nums.length()-1);
          //      array.add(nums);
         //       array.add(Character.toString(l.charAt(i)));
          //      nums ="";
         //   } else if (l.charAt(i) != ' ') {
          //      nums += l.charAt(i);
          //  } else {
           //     nums = nums.substring(0, nums.length()-1);
            //    array.add(nums);
             //   nums ="";
         //   }
       // }
//
  //      for (int i=0; i<array.size(); i++){
    //        System.out.println(array.get(i));
      //  }
    }
}