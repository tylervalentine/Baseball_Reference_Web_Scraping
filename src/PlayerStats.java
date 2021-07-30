import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerStats {

    public boolean isBatter(ArrayList<String> data)
    {
        return data.contains("AB");
    }

    public boolean isPitcher(ArrayList<String> data)
    {
        return data.contains("W");
    }

    public void clean(ArrayList<String> data)
    {
        for(int i =  0; i < data.size();)

            if(!data.get(i).equals("SUMMARY"))
            {
                data.remove(data.get(i));
            }
            else
            {
                break;
            }
    }

    public String dataChoiceBatter(ArrayList<String> data, String name)
    {
        Scanner in = new Scanner(System.in);

        String data_category;
        String data_piece;
        ArrayList<String> correct_answers = new ArrayList<>
                (Arrays.asList(
                        "WAR", "Wins Above Replacement", "At Bat", "At-Bat", "AB",
                        "Hits", "H", "Home Run", "Home-Run", "HR",
                        "Batting Average", "BA", "Runs", "R",
                        "Runs Batted In", "RBI", "Stolen Base", "SB",
                        "On Base Percentage", "On-Base Percentage", "OBP",
                        "Slugging Percentage", "SLG", "On Base Plus Slugging", "On-Base Plus Slugging", "OPS",
                        "On Base Plus Slugging Plus", "On-Base Plus Slugging Plus", "OPS+"
                ));



        System.out.println("Here are Data Choices for " + name + ":");
        System.out.println("-------------------------------------------------");
        System.out.println("1. WAR Stats");
        System.out.println("2. At-Bat Stats");
        System.out.println("3. Hits Stats");
        System.out.println("4. Home Run Stats");
        System.out.println("5. Batting Average Stats");
        System.out.println("6. Runs Stats");
        System.out.println("7. RBI (Runs Batted In) Stats");
        System.out.println("8. Stolen Base Stats");
        System.out.println("9. OBP (On-Base Percentage) Stats");
        System.out.println("10. SLG (Slugging Percentage) Stats");
        System.out.println("11. OPS (On-Base Plus Slugging) Stats");
        System.out.println("12. OPS+ (On-Base Plus Slugging Plus) Stats");
        System.out.println("-------------------------------------------------");
        System.out.println();
        System.out.print("Enter which category you want data on from " + name + ": ");
        data_category = in.nextLine();

        while(!correct_answers.contains(data_category))
        {
            System.out.println("Invalid answer. Please try again");
            System.out.print("Enter which category you want data on from " + name + ": ");
            data_category = in.nextLine();
        }

        data_piece = statMethodBatter(data_category, name, data);

        return data_piece;


    }

    public String dataChoicePitcher(ArrayList<String> data, String name)
    {
        Scanner in = new Scanner(System.in);

        String data_category;
        String data_piece;
        ArrayList<String> correct_answers = new ArrayList<String>
                (Arrays.asList(
                        "WAR", "Wins Above Replacement", "Win", "W", "Loss", "L",
                        "ERA", "Earned Run Average", "Earned-Run Average",
                        "Games", "G", "Games Started", "GS", "Save", "SV",
                        "Innings Pitched", "IP", "Strikeout", "SO",
                        "Walks and Hits per Inning Pitched", "WHIP"
        ));


        System.out.println("Here are Data Choices for " + name + ":");
        System.out.println("--------------------------------------------------");
        System.out.println("1. WAR Stats");
        System.out.println("2. Win Stats");
        System.out.println("3. Loss Stats");
        System.out.println("4. ERA (Earned-Run Average) Stats");
        System.out.println("5. Games Stats");
        System.out.println("6. Games Started Stats");
        System.out.println("7. Save Stats");
        System.out.println("8. IP (Innings Pitched) Stats");
        System.out.println("9. Strikeout Stats");
        System.out.println("10. WHIP (Walks and Hits per Inning Pitched) Stats");
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.print("Enter which category you want data on from " + name + ": ");
        data_category = in.nextLine();

        while(!correct_answers.contains(data_category))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Enter which category you want data on from " + name + ": ");
            data_category = in.nextLine();
        }

        data_piece = statMethodPitcher(data_category, name, data);

        return data_piece;
    }

    public String statMethodBatter(String data_name, String name, ArrayList<String> data)
    {
        HitterStats hitter = new HitterStats();

        String final_data = "";
        if(data_name.equalsIgnoreCase("WAR") ||
                data_name.equalsIgnoreCase("Wins Above Replacement"))
        {
            final_data = hitter.warData(data, name);
        }

        else if(data_name.equalsIgnoreCase("AB") ||
                data_name.equalsIgnoreCase("At Bat") ||
                data_name.equalsIgnoreCase("At-Bat"))
        {
            final_data = hitter.abData(data, name);
        }

        else if(data_name.equalsIgnoreCase("H") ||
                data_name.equalsIgnoreCase("Hits"))
        {
            final_data = hitter.hitData(data, name);
        }

        else if(data_name.equalsIgnoreCase("HR") ||
                data_name.equalsIgnoreCase("Home Run") ||
                data_name.equalsIgnoreCase("Home-Run"))
        {
            final_data = hitter.hrData(data, name);
        }

        else if(data_name.equalsIgnoreCase("BA") ||
                data_name.equalsIgnoreCase("Batting Average"))
        {
            final_data = hitter.baData(data, name);
        }

        else if(data_name.equalsIgnoreCase("R") ||
                data_name.equalsIgnoreCase("Runs"))
        {
            final_data = hitter.runData(data, name);
        }

        else if(data_name.equalsIgnoreCase("RBI") ||
                data_name.equalsIgnoreCase("Runs Batted In"))
        {
            final_data = hitter.rbiData(data, name);
        }

        else if(data_name.equalsIgnoreCase("SB") ||
                data_name.equalsIgnoreCase("Stolen Base"))
        {
            final_data = hitter.sbData(data, name);
        }

        else if(data_name.equalsIgnoreCase("OBP") ||
                data_name.equalsIgnoreCase("On Base Percentage") ||
                data_name.equalsIgnoreCase("On-Base Percentage"))
        {
            final_data = hitter.obpData(data, name);
        }

        else if(data_name.equalsIgnoreCase("SLG") ||
                data_name.equalsIgnoreCase("Slugging Percentage"))
        {
            final_data = hitter.slgData(data, name);
        }

        else if(data_name.equalsIgnoreCase("OPS") ||
                data_name.equalsIgnoreCase("On Base Plus Slugging") ||
                data_name.equalsIgnoreCase("On-Base Plus Slugging"))
        {
            final_data = hitter.opsData(data, name);
        }

        else if(data_name.equalsIgnoreCase("OPS+") ||
                data_name.equalsIgnoreCase("On Base Plus Slugging Plus") ||
                data_name.equalsIgnoreCase("On-Base Plus Slugging Plus"))
        {
            final_data = hitter.opsPlusData(data, name);
        }

        return final_data;
    }

    public String statMethodPitcher(String data_name, String name, ArrayList<String> data)
    {
        PitcherStats pitcher = new PitcherStats();

        String final_data = "";
        if(data_name.equalsIgnoreCase("WAR") ||
                data_name.equalsIgnoreCase("Wins Above Replacement"))
        {
            final_data = pitcher.warData(data, name);
        }

        else if(data_name.equalsIgnoreCase("W") ||
                data_name.equalsIgnoreCase("Win"))
        {
            final_data = pitcher.winData(data, name);
        }

        else if(data_name.equalsIgnoreCase("L") ||
                data_name.equalsIgnoreCase("Loss"))
        {
            final_data = pitcher.lossData(data, name);
        }

        else if(data_name.equalsIgnoreCase("ERA") ||
                data_name.equalsIgnoreCase("Earned Run Average") ||
                data_name.equalsIgnoreCase("Earned-Run Average"))
        {
            final_data = pitcher.eraData(data, name);
        }

        else if(data_name.equalsIgnoreCase("GS") ||
                data_name.equalsIgnoreCase("Games Started"))
        {
            final_data = pitcher.gameData(data, name);
        }


        else if(data_name.equalsIgnoreCase("SV") ||
                data_name.equalsIgnoreCase("Save"))
        {
            final_data = pitcher.svData(data, name);
        }

        else if(data_name.equalsIgnoreCase("IP") ||
                data_name.equalsIgnoreCase("Innings Pitched"))
        {
            final_data = pitcher.ipData(data, name);
        }

        else if(data_name.equalsIgnoreCase("SO") ||
                data_name.equalsIgnoreCase("Strikeout"))
        {
            final_data = pitcher.soData(data, name);
        }

        else if(data_name.equalsIgnoreCase("WHIP") ||
                data_name.equalsIgnoreCase("Walks and Hits per Inning Pitched"))
        {
            final_data = pitcher.whipData(data, name);
        }

        return final_data;
    }


    public String title(String name)
    {
        String [] full_name;
        String player_first_name;
        String player_last_name;
        String proper_player_letter_one;
        String proper_player_letter_two;
        String rest_of_first_name;
        String rest_of_last_name;
        String final_name;

        full_name = name.split(" ");
        player_first_name = full_name[0];
        player_last_name = full_name[1];
        proper_player_letter_one = player_first_name.substring(0,1).toUpperCase();
        proper_player_letter_two = player_last_name.substring(0,1).toUpperCase();
        rest_of_first_name = player_first_name.substring(1);
        rest_of_last_name =  player_last_name.substring(1);
        final_name = "" + proper_player_letter_one + rest_of_first_name + " " + proper_player_letter_two + rest_of_last_name;

        return final_name;
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null)
        {
            return false;
        }

        try {
            double d = Double.parseDouble(strNum);

        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
