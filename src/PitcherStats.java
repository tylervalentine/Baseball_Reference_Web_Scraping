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

        stats.clean(data);
        stat_season_number = data.indexOf("WAR") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("WAR") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Wins Above Replacement from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Wins Above Replacement from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
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

        stats.clean(data);
        stat_season_number = data.indexOf("W") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("W") + 2;
        stat_career = data.get(stat_career_number);

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
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Total Wins is " + final_data + ".";
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

        stats.clean(data);
        stat_season_number = data.indexOf("L") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("L") + 2;
        stat_career = data.get(stat_career_number);

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
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
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

        stats.clean(data);
        stat_season_number = data.indexOf("ERA") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("ERA") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Earned-Run Average from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Earned-Run Average from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
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

        stats.clean(data);
        stat_season_number = data.indexOf("G") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("G") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Total Games from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Total Games from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
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

        stats.clean(data);
        stat_season_number = data.indexOf("GS") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("GS") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Total Games Started from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Total Games Started from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Total Games Started is " + final_data + ".";
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

        stats.clean(data);
        stat_season_number = data.indexOf("SV") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("SV") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Total Saves from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Total Saves from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Total Saves is " + final_data + ".";
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

        stats.clean(data);
        stat_season_number = data.indexOf("IP") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("IP") + 2;
        stat_career = data.get(stat_career_number);

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
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
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

        stats.clean(data);
        stat_season_number = data.indexOf("SO") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("SO") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Total Strikeouts from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Total Strikeouts from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " Total SOs is " + final_data + ".";
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

        stats.clean(data);
        stat_season_number = data.indexOf("WHIP") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("WHIP") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Walks and Hits per Inning Pitched from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Walks and Hits per Inning Pitched from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season"))
        {
            final_data = stat_season;
            date = "2021";
        }

        else if(season_career.equalsIgnoreCase("Career"))
        {
            final_data = stat_career;
            date = "career";

        }

        return "" + name + "'s " + date + " WHIP is " + final_data + ".";
    }
}
