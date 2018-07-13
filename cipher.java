import java.util.*;

class cipher
{
   public static void main(String []args)
   {
      Scanner in = new Scanner(System.in);
      Hashtable <Character, Integer> letToInt = new Hashtable<Character,Integer>();
      Hashtable <Integer, Character> intToLet = new Hashtable<Integer, Character>();
      String key = "CRYPT";     
      for(int i = 0; i < 26; i++){
         letToInt.put((char)(65+i), i);
         intToLet.put(i,(char)(65+i));
      }
   
      letToInt.put(' ',26);
      intToLet.put(26,' ');

      String message = in.nextLine().toUpperCase();
      System.out.println("Encode or Decode?");
      if (in.nextLine().equals("E")){
      String encoded = "";   
      for (int i = 0; i < message.length(); i++){
         int shiftValue = letToInt.get(key.charAt(i%key.length()));
         int letterValue = letToInt.get(message.charAt(i));
         encoded = encoded + intToLet.get((letterValue + shiftValue)%27);
      }
               System.out.println(encoded);
      }
      
      else{
      String encoded = "";  
       for (int i = 0; i < message.length(); i++){
         int shiftValue = letToInt.get(key.charAt(i%key.length()));
         int letterValue = letToInt.get(message.charAt(i));
         encoded = encoded + intToLet.get(((letterValue-shiftValue)+27)%27);
         }
                System.out.println(encoded);
      }

   }
}     