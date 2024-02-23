/**
 * StarWars of BCIT
 *
 * @author Andres Arevalo
 * @version 1.0
 */
public class StarWars
{
    public static final int NUMBER_OF_WORDS = 4;
    public static void main(final String[] args)
    {

        final String[] splitInput;
        final String input;
        final String firstName;
        final String lastName;
        final String motherMaidenName;
        final String birthCity;
        final String firstNameStarWars;
        final String lastNameStarWars;

        if(args.length == 0)
        {
            throw new IllegalArgumentException("missing data input");
        }

        input = args[0];
        splitInput = input.split("\\|");

        if(splitInput.length != NUMBER_OF_WORDS)
        {
            System.out.println("Error: incorrect number of words provided");
        }
        else
        {
            firstName = splitInput[0].trim();
            lastName = splitInput[1].trim();
            motherMaidenName = splitInput[2].trim();
            birthCity = splitInput[3].trim();

            firstNameStarWars = firstName.substring(0, 3) + lastName.substring(0, 2);
            lastNameStarWars = motherMaidenName.substring(0, 2) + birthCity.substring(0, 3);

            System.out.format("Your Star Wars name is: %s %s", getStringTitleCase(firstNameStarWars), getStringTitleCase(lastNameStarWars));
        }
    }

    /**
     * Converts a given string to title case, capitalizing the first letter of each word.
     * Whitespace characters are preserved.
     *
     * @param string The input string to be converted to title case.
     * @return The string in title case, or null if the input string is null or empty.
     */
    public static String getStringTitleCase(final String string)
    {
        if(string == null || string.isEmpty())
        {
            return null;
        }

        boolean capitalizeNext = true;
        StringBuilder titleCase = new StringBuilder();
        for(final char c : string.toCharArray())
        {
            if(Character.isWhitespace(c))
            {
                titleCase.append(c);
                capitalizeNext = true;
            } else if(capitalizeNext)
            {
                titleCase.append(Character.toTitleCase(c));
                capitalizeNext = false;
            } else
            {
                titleCase.append(Character.toLowerCase(c));
            }
        }

        return titleCase.toString();
    }
}
