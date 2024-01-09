/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
//get string from user, and prints the string with only lower-case letters
	String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String str) {
        // define empty string for updaing it later with lower case letters.
        String lowletters = "";
        for (int i = 0; i < str.length(); i++)
        {
            char convertChar = str.charAt(i);
		//check if the char is upper-case letter and convert it. Then update the new string with the lower-case letters.
            if (convertChar >= 65 && convertChar <=90 )
            {
                convertChar = (char)(convertChar + 32);
            }
                lowletters = lowletters + convertChar;
            }
                    return lowletters;
        }
    
    }

