/** String processing exercise 1. */
public class lowercase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String str) {
        // Replace the following statement with your code
        String lowletters = "";
        for (int i = 0; i < str.length(); i++)
        {
            char convertChar = str.charAt(i);
            if (convertChar >= 65 && convertChar <=90 )
            {
                convertChar = (char)(convertChar + 32);
            }
                lowletters = lowletters + convertChar;
            }
                    return lowletters;
        }
    
    }
