/** String processing exercise 2. */
public class UniqueChars {
	public static void main(String[] args) {
	//get string from user, and prints the string without the duplicate characters. 	
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String str) {
        // define empty string for updaing it later with unique chars.
		String UniqueChars = "";
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
		// Define that the program removed duplicates except space characters.
			if (c!=32)
			{
			// check if the char letter apprears the first time, then add it to the return string.
				if (str.indexOf(c) == i)
				{
				UniqueChars = UniqueChars + c;
				}
			}
			else 
			// if the character is space, add it.
			UniqueChars = UniqueChars + c;
		}
        return UniqueChars;
    }
}

