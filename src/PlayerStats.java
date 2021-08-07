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
                        "1", "WAR", "Wins Above Replacement", "WAR Stats",
                        "2", "At Bat", "At-Bat", "At Bat Stats", "At-Bat Stats", "AB",
                        "3", "Hits", "H", "Hits Stats", "Hit Stats",
                        "4", "Home Run", "Home-Run", "HR", "Home Run Stats",
                        "5", "Batting Average", "BA", "Batting Average Stats",
                        "6", "Runs", "R", "Runs Stats",
                        "7", "Runs Batted In", "RBI", "RBI Stats", "Runs Batted In Stats",
                        "8", "Stolen Base", "SB", "SB Stats", "Stolen Base Stats",
                        "9", "On Base Percentage", "On-Base Percentage", "OBP", "OBP Stats", "On Base Percentage Stats",
                        "10", "Slugging Percentage", "SLG", "SLG Stats", "Slugging Stats", "Slugging Percentage Stats",
                        "11", "On Base Plus Slugging", "On-Base Plus Slugging", "OPS", "OPS Stats", "On Base Plus Slugging Stats",
                        "12", "On Base Plus Slugging Plus", "On-Base Plus Slugging Plus", "OPS+", "OPS+ Stats", "On-Base Plus Slugging Plus Stats"
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
                        "1", "WAR", "Wins Above Replacement", "WAR Stats",
                        "2", "Win", "W", "Win Stats",
                        "3", "Loss", "L", "Loss Stats",
                        "4", "ERA", "Earned Run Average", "Earned-Run Average", "ERA Stats", "Earned Run Average Stats", "Earned-Run Average Stats",
                        "5", "Games", "G", "Games Stats",
                        "6", "Games Started", "GS", "Games Started Stats",
                        "7", "Save", "SV", "Save Stats",
                        "8", "Innings Pitched", "IP", "IP Stats", "Innings Pitched Stats",
                        "9", "Strikeout", "SO", "Strikeout Stats",
                        "10", "Walks and Hits per Inning Pitched", "WHIP", "WHIP Stats", "Walks and Hits per Inning Pitched Stats"
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
        if(data_name.equalsIgnoreCase("1") ||
                data_name.equalsIgnoreCase("WAR") ||
                data_name.equalsIgnoreCase("Wins Above Replacement") ||
                data_name.equalsIgnoreCase("Wins Above Replacement Stats"))
        {
            final_data = hitter.warData(data, name);
        }

        else if(data_name.equalsIgnoreCase("2") ||
                data_name.equalsIgnoreCase("AB") ||
                data_name.equalsIgnoreCase("At Bat") ||
                data_name.equalsIgnoreCase("At-Bat") ||
                data_name.equalsIgnoreCase("At Bat Stats") ||
                data_name.equalsIgnoreCase("At-Bat Stats"))
        {
            final_data = hitter.abData(data, name);
        }

        else if(data_name.equalsIgnoreCase("3") ||
                data_name.equalsIgnoreCase("H") ||
                data_name.equalsIgnoreCase("Hits") ||
                data_name.equalsIgnoreCase("Hits Stats") ||
                data_name.equalsIgnoreCase("Hit Stats"))
        {
            final_data = hitter.hitData(data, name);
        }

        else if(data_name.equalsIgnoreCase("4") ||
                data_name.equalsIgnoreCase("HR") ||
                data_name.equalsIgnoreCase("Home Run") ||
                data_name.equalsIgnoreCase("Home-Run") ||
                data_name.equalsIgnoreCase("Home Run Stats"))
        {
            final_data = hitter.hrData(data, name);
        }

        else if(data_name.equalsIgnoreCase("5") ||
                data_name.equalsIgnoreCase("BA") ||
                data_name.equalsIgnoreCase("Batting Average") ||
                data_name.equalsIgnoreCase("Batting Average Stats"))
        {
            final_data = hitter.baData(data, name);
        }

        else if(data_name.equalsIgnoreCase("6") ||
                data_name.equalsIgnoreCase("R") ||
                data_name.equalsIgnoreCase("Runs") ||
                data_name.equalsIgnoreCase("Runs Stats"))
        {
            final_data = hitter.runData(data, name);
        }

        else if(data_name.equalsIgnoreCase("7") ||
                data_name.equalsIgnoreCase("RBI") ||
                data_name.equalsIgnoreCase("Runs Batted In") ||
                data_name.equalsIgnoreCase("RBI Stats") ||
                data_name.equalsIgnoreCase("Runs Batted In Stats"))
        {
            final_data = hitter.rbiData(data, name);
        }

        else if(data_name.equalsIgnoreCase("8") ||
                data_name.equalsIgnoreCase("SB") ||
                data_name.equalsIgnoreCase("Stolen Base") ||
                data_name.equalsIgnoreCase("SB Stats") ||
                data_name.equalsIgnoreCase("Stolen Base Stats"))
        {
            final_data = hitter.sbData(data, name);
        }

        else if(data_name.equalsIgnoreCase("9") ||
                data_name.equalsIgnoreCase("OBP") ||
                data_name.equalsIgnoreCase("On Base Percentage") ||
                data_name.equalsIgnoreCase("On-Base Percentage") ||
                data_name.equalsIgnoreCase("OBP Stats") ||
                data_name.equalsIgnoreCase("On Base Percentage Stats"))
        {
            final_data = hitter.obpData(data, name);
        }

        else if(data_name.equalsIgnoreCase("10") ||
                data_name.equalsIgnoreCase("SLG") ||
                data_name.equalsIgnoreCase("Slugging Percentage") ||
                data_name.equalsIgnoreCase("SLG Stats") ||
                data_name.equalsIgnoreCase("Slugging Stats") ||
                data_name.equalsIgnoreCase("Slugging Percentage Stats"))
        {
            final_data = hitter.slgData(data, name);
        }

        else if(data_name.equalsIgnoreCase("11") ||
                data_name.equalsIgnoreCase("OPS") ||
                data_name.equalsIgnoreCase("On Base Plus Slugging") ||
                data_name.equalsIgnoreCase("On-Base Plus Slugging") ||
                data_name.equalsIgnoreCase("OPS Stats") ||
                data_name.equalsIgnoreCase("On-Base Plus Slugging Stats"))
        {
            final_data = hitter.opsData(data, name);
        }

        else if(data_name.equalsIgnoreCase("12") ||
                data_name.equalsIgnoreCase("OPS+") ||
                data_name.equalsIgnoreCase("On Base Plus Slugging Plus") ||
                data_name.equalsIgnoreCase("On-Base Plus Slugging Plus") ||
                data_name.equalsIgnoreCase("OPS+ Stats") ||
                data_name.equalsIgnoreCase("On-Base Plus Slugging Plus Stats"))
        {
            final_data = hitter.opsPlusData(data, name);
        }

        return final_data;
    }

    public String statMethodPitcher(String data_name, String name, ArrayList<String> data)
    {
        PitcherStats pitcher = new PitcherStats();

        String final_data = "";
        if(data_name.equalsIgnoreCase("1") ||
                data_name.equalsIgnoreCase("WAR") ||
                data_name.equalsIgnoreCase("Wins Above Replacement") ||
                data_name.equalsIgnoreCase("Wins Above Replacement Stats"))
        {
            final_data = pitcher.warData(data, name);
        }

        else if(data_name.equalsIgnoreCase("2") ||
                data_name.equalsIgnoreCase("W") ||
                data_name.equalsIgnoreCase("Win") ||
                data_name.equalsIgnoreCase("Win Stats"))
        {
            final_data = pitcher.winData(data, name);
        }

        else if(data_name.equalsIgnoreCase("3") ||
                data_name.equalsIgnoreCase("L") ||
                data_name.equalsIgnoreCase("Loss") ||
                data_name.equalsIgnoreCase("Loss Stats"))
        {
            final_data = pitcher.lossData(data, name);
        }

        else if(data_name.equalsIgnoreCase("4") ||
                data_name.equalsIgnoreCase("ERA") ||
                data_name.equalsIgnoreCase("Earned Run Average") ||
                data_name.equalsIgnoreCase("Earned-Run Average") ||
                data_name.equalsIgnoreCase("ERA Stats") ||
                data_name.equalsIgnoreCase("Earned Run Average Stats"))
        {
            final_data = pitcher.eraData(data, name);
        }

        else if(data_name.equalsIgnoreCase("5") ||
                data_name.equalsIgnoreCase("G") ||
                data_name.equalsIgnoreCase("Games") ||
                data_name.equalsIgnoreCase("Games Stats"))
        {
            final_data = pitcher.gameData(data, name);
        }

        else if(data_name.equalsIgnoreCase("6") ||
                data_name.equalsIgnoreCase("GS") ||
                data_name.equalsIgnoreCase("Games Started") ||
                data_name.equalsIgnoreCase("Games Started Stats"))
        {
            final_data = pitcher.gsData(data, name);
        }


        else if(data_name.equalsIgnoreCase("7") ||
                data_name.equalsIgnoreCase("SV") ||
                data_name.equalsIgnoreCase("Save") ||
                data_name.equalsIgnoreCase("Save Stats"))
        {
            final_data = pitcher.svData(data, name);
        }

        else if(data_name.equalsIgnoreCase("8") ||
                data_name.equalsIgnoreCase("IP") ||
                data_name.equalsIgnoreCase("Innings Pitched") ||
                data_name.equalsIgnoreCase("IP Stats") ||
                data_name.equalsIgnoreCase("Innings Pitched Stats"))
        {
            final_data = pitcher.ipData(data, name);
        }

        else if(data_name.equalsIgnoreCase("9") ||
                data_name.equalsIgnoreCase("SO") ||
                data_name.equalsIgnoreCase("Strikeout") ||
                data_name.equalsIgnoreCase("Strikeout Stats"))
        {
            final_data = pitcher.soData(data, name);
        }

        else if(data_name.equalsIgnoreCase("10") ||
                data_name.equalsIgnoreCase("WHIP") ||
                data_name.equalsIgnoreCase("Walks and Hits per Inning Pitched") ||
                data_name.equalsIgnoreCase("WHIP Stats") ||
                data_name.equalsIgnoreCase("Walks and Hits per Inning Pitched Stats"))
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
