import java.util.ArrayList;
import java.util.Scanner;

public class PitcherStats {

    PlayerStats stats = new PlayerStats();
    Scanner in = new Scanner(System.in);

    public String warData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("WAR") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("WAR") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("WAR") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s WAR from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s WAR from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " WAR is " + final_data + ".";
    }

    public String winData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("W") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("W") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("W") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Wins from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Wins from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Wins is " + final_data + ".";
    }

    public String lossData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("L") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("L") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("L") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Losses from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Losses from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Total Losses is " + final_data + ".";
    }

    public String eraData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("ERA") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("ERA") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("ERA") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Earned Run Average from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Earned Run Average from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " ERA is " + final_data + ".";
    }

    public String gameData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("G") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("G") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("G") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Games from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Games from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Total Games is " + final_data + ".";
    }

    public String gsData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("GS") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("GS") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("GS") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Games Started from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Games Started from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " GS is " + final_data + ".";
    }

    public String svData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("SV") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("SV") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("SV") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Saves from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Saves from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " SV is " + final_data + ".";
    }

    public String ipData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("IP") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("IP") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("IP") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Innings Pitched from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Innings Pitched from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " IP is " + final_data + ".";
    }

    public String soData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("SO") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("SO") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("SO") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Strikeouts from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Strikeouts from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Total SO is " + final_data + ".";
    }

    public String whipData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";
        boolean is_digit;
        boolean career_switch = false;

        stats.clean(data);
        stat_season_number = data.indexOf("WHIP") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("WHIP") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("WHIP") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s WHIP from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s WHIP from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            if(stat_season.equals(""))
            {
                System.out.println(""+ name + "'s season stats are not available, he did not play this year. ");
                System.out.println("Switching to career stats...");
                career_switch = true;
            }

            else
            {
                final_data = stat_season;
                date = "2021";
            }
        }

        if(season_career.equalsIgnoreCase("Career") || career_switch)
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " WHIP is " + final_data + ".";
    }
}
