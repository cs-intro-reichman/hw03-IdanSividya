/** String processing exercise 2. */
public class uniquechars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String str) {
        // Replace the following statement with your code
		String UniqueChars = "";
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (c!=32)
			{
				if (str.indexOf(c) == i)
				{
				UniqueChars = UniqueChars + c;
				}
			}
			else 
			UniqueChars = UniqueChars + c;
		}
        return UniqueChars;
    }
}

