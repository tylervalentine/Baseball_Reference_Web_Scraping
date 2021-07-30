import java.util.ArrayList;
import java.util.Scanner;

public class HitterStats {

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

    public String abData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("AB") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("AB") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("AB") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s At Bats from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s At Bats from this season or his career? ");
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

        return "" + name + "'s " + date + " total ABs is " + final_data + ".";
    }

    public String hitData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("H") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("H") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("H") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Hits from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Hits from this season or his career? ");
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

        return "" + name + "'s " + date + " total Hits is " + final_data + ".";
    }

    public String hrData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("HR") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("HR") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("HR") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s HRs from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s HRs from this season or his career? ");
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

        return "" + name + "'s " + date + " total HRs is " + final_data + ".";
    }

    public String baData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("BA") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("BA") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("BA") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Batting Average from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Batting Average from this season or his career? ");
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

        return "" + name + "'s " + date + " BA is " + final_data + ".";
    }

    public String runData(ArrayList<String> data, String name)
    {
        String season_career;
        int stat_season_number;
        int stat_career_number;
        String stat_season;
        String stat_career;
        String date = "";
        String final_data = "";

        stats.clean(data);
        stat_season_number = data.indexOf("R") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("R") + 2;
        stat_career = data.get(stat_career_number);

        System.out.print("Would you like " + name + "'s Runs from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Runs from this season or his career? ");
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

        return "" + name + "'s " + date + " Total Runs is " + final_data + ".";
    }

    public String rbiData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("RBI") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("RBI") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("RBI") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s RBIs from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s RBIs from this season or his career? ");
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

        return "" + name + "'s " + date + " Total RBIs is " + final_data + ".";
    }

    public String sbData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("SB") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("SB") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("SB") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Stolen Bases from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Stolen Bases from this season or his career? ");
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

        return "" + name + "'s " + date + " Total SBs is " + final_data + ".";
    }

    public String obpData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("OBP") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("OBP") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("OBP") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s On Base Percentage from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s On Base Percentage from this season or his career? ");
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

        return "" + name + "'s " + date + " OBP is " + final_data + ".";
    }

    public String slgData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("SLG") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("SLG") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("SLG") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s Slugging Percentage from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s Slugging Percentage from this season or his career? ");
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

        return "" + name + "'s " + date + " SLG is " + final_data + ".";
    }

    public String opsData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("OPS") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("OPS") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("OPS") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s On Base Plus Slugging from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s On Base Plus Slugging from this season or his career? ");
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

        return "" + name + "'s " + date + " OPS is " + final_data + ".";
    }

    public String opsPlusData(ArrayList<String> data, String name)
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
        stat_season_number = data.indexOf("OPS+") + 1;
        stat_season = data.get(stat_season_number);
        stat_career_number = data.indexOf("OPS+") + 2;
        stat_career = data.get(stat_career_number);

        is_digit = stats.isNumeric(stat_career);

        if(!is_digit)
        {
            stat_career_number = data.indexOf("OPS+") + 1;
            stat_career = data.get(stat_career_number);
            stat_season = "";
        }

        System.out.print("Would you like " + name + "'s OPS+ from this season or his career? ");
        season_career = in.nextLine();

        while(!season_career.equalsIgnoreCase("season") && !season_career.equalsIgnoreCase("career"))
        {
            System.out.println("Invalid answer. Please try again.");
            System.out.print("Would you like " + name + "'s OPS+ from this season or his career? ");
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

        return "" + name + "'s " + date + " OPS+ is " + final_data + ".";
    }
}
