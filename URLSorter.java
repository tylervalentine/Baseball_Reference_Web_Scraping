import org.jsoup.Jsoup;

import java.io.FileReader;

import java.io.IOException;
import java.util.*;

public class URLSorter {

    public void run() throws IOException, InterruptedException {
        String player_name;
        String first_name;
        String last_name;
        String first_letter_last_name;
        String short_first_name;
        String short_last_name;
        String data_piece;
        String url;
        String more_data_answer;
        String another_player_answer;

        ArrayList<String> urlNames;
        ArrayList<String> names;
        ArrayList<String> data;

        int season_career;

        Scanner in = new Scanner(System.in);
        PlayerStats stats = new PlayerStats();
        do {
            System.out.print("Enter which player you want data on (Format Example: Justin Verlander)\n" +
                    "(For abbreviated names, make sure to put periods where applicable (Example: J.P. Crawford): ");
            player_name = in.nextLine();
            player_name = player_name.toLowerCase();
            System.out.println();
            System.out.println("Loading player data...");

            names = nameSorter(player_name);

            first_letter_last_name = names.get(0);
            short_first_name = names.get(1);
            short_last_name = names.get(2);

            url = "https://www.baseball-reference.com/players/" + first_letter_last_name + "/" + short_last_name + short_first_name + "";
            urlNames = numberSorter(url, player_name);
            first_name = urlNames.get(0);
            last_name = urlNames.get(1);
            url = duplicateNames(urlNames, first_name, last_name);

            data = sort(url);
            stats.clean(data);
            season_career = stats.writeFile(data, first_name + " " + last_name) ;

            System.out.println();

            do {
                data_piece = stats.dataChoice(new FileReader("data.txt"), first_name + " " + last_name, season_career);
                System.out.println(data_piece);
                System.out.println();
                System.out.print("Would you like more data on " + first_name + " " + last_name + "? ");
                more_data_answer = in.nextLine();
                while (!more_data_answer.equalsIgnoreCase("Yes") && !more_data_answer.equalsIgnoreCase("No")) {
                    System.out.println("Invalid answer. Please try again.");
                    System.out.print("Would you like more data on " + first_name + " " + last_name + "? ");
                    more_data_answer = in.nextLine();
                }
            }while(!more_data_answer.equalsIgnoreCase("No"));

            System.out.print("Would you like data on another player? ");
            another_player_answer = in.nextLine();

            while (!another_player_answer.equalsIgnoreCase("Yes") && !another_player_answer.equalsIgnoreCase("No")) {
                System.out.println("Invalid answer. Please try again.");
                System.out.print("Would you like data on another player? ");
                another_player_answer = in.nextLine();
            }

            System.out.println();
            System.out.println("Rebooting program... ");
            Thread.sleep(4000);
            System.out.println();

        }while(!another_player_answer.equalsIgnoreCase("No"));

        System.out.println("Program terminated. Please come again!");
    }

    public static ArrayList<String> sort(String url) throws IOException
    {
        return new ArrayList<>(List.of(Jsoup.connect(url).get().text().split(" ")));
    }

    public ArrayList<String> nameSorter(String name)
    {
        String first_letter_player_name = "";
        String shortened_last_name = "";
        String shortened_first_name = "";
        String[] player_name_letters;
        ArrayList<String> sorted_names = new ArrayList<>();
        int count = 1;
        boolean whitespace = false;

        player_name_letters = name.split("");

        for (String letter : player_name_letters) {
            if(letter.equals(" ") && whitespace)
            {
                continue;
            }
            if (count > 2 && whitespace)
            {
                if (count == 3)
                {
                    first_letter_player_name = letter;
                    shortened_last_name += letter;
                    shortened_last_name = shortened_last_name.strip();
                    count++;
                }
                else if (count != player_name_letters.length && count <= 7)
                {
                    shortened_last_name += letter;
                    shortened_last_name = shortened_last_name.strip();
                    count++;
                }
            }

            if (count == 1)
            {
                shortened_first_name += letter;
                count++;
            }
            else if (count == 2 && !letter.equals("."))
            {
                shortened_first_name += letter;
                count = 3;
            }

            if (letter.equals(" "))
            {
                whitespace = true;
            }
        }

        sorted_names.add(first_letter_player_name);
        sorted_names.add(shortened_first_name);
        sorted_names.add(shortened_last_name);

        return sorted_names;
    }

    public ArrayList<String> numberSorter(String url, String name)
    {

        String first_name;
        String last_name = "";
        String data_first_name;
        String data_last_name;
        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> data;

        int first_num = 0;
        int second_num = 1;
        int index;
        int count = 2;

        String[] full_name = name.split(" ");
        first_name = full_name[0];
        for(int i = 1; i < full_name.length; i++)
        {
            last_name += full_name[i] + " ";
        }

        last_name = last_name.strip();

         while (second_num != 9) {
             index = 1;
             data_first_name = "";
             data_last_name = "";
             url += "" + first_num + second_num + ".shtml";
             try {
                 data = sort(url);
                 data_first_name = data.get(0);
                 while(!data.get(index).equals("Stats"))
                 {
                     data_last_name += data.get(index) + " ";
                     index++;
                 }
                 data_last_name = data_last_name.strip();
                 second_num++;
             } catch (IOException e) {
                 second_num++;
             }

             if (first_name.equals(data_first_name.toLowerCase()) && last_name.equals(data_last_name.toLowerCase())) {
                 if (count == 2)
                 {
                     result.add(data_first_name);
                     result.add(data_last_name);
                     result.add(url);
                     count++;
                 }

                 else
                 {
                     result.add(url);
                     count++;
                 }
             }

             url = url.substring(0, url.length() - 8);
         }
         while (first_num != 9) {
             index = 1;
             data_first_name = "";
             data_last_name = "";
             url += "" + first_num + second_num + ".shtml";
             try {
                 data = sort(url);
                 data_first_name = data.get(0);
                 while(!data.get(index).equals("Stats"))
                 {
                     data_last_name += data.get(index) + " ";
                     index++;
                 }
                 data_last_name = data_last_name.strip();
                 first_num++;
             } catch (IOException e) {
                 first_num++;
             }
             if (first_name.equals(data_first_name.toLowerCase()) && last_name.equals(data_last_name.toLowerCase())) {
                 if (count == 2)
                 {
                     result.add(data_first_name);
                     result.add(data_last_name);
                     result.add(url);
                     count++;
                 }

                 else
                 {
                     result.add(url);
                     count++;
                 }
             }
             url = url.substring(0, url.length() - 8);
         }
        return result;
    }

    public static String duplicateNames(ArrayList<String> urls, String firstName, String lastName) throws IOException {
        String url = "";
        if(urls.size() == 3)
        {
            return urls.get(2);
        }

        ArrayList<String> urlList = new ArrayList<>();
        ArrayList<String> players = new ArrayList<>();
        ArrayList<String> data;

        for(int i = 2; i < urls.size(); i++)
        {
            String position;
            String yearsPlayed;
            urlList.add(urls.get(i));
            data = sort(urls.get(i));
            position = playerPositionFinder(data);
            yearsPlayed = playerYearsPlayedFinder(data);
            players.add(firstName + " " + lastName + ":" + " " + position + ", " + yearsPlayed);
        }

        url = duplicatePlayerSelector(urlList, players);
        return url;
    }

    public static String playerPositionFinder(ArrayList<String> data)
    {
        String position = "";
        boolean position_found = false;

        for(int i = 0; i < data.size(); i++)
        {
            if(data.get(i).equals("Position:") || data.get(i).equals("Positions:"))
            {
                position += data.get(i + 1);

                if(data.get(i + 1).equals("Designated"))
                {
                    position += " " + data.get(i + 2);
                }
                position_found = true;
            }

            if(position_found)
            {
                break;
            }
        }
        position = position.replaceAll(",", "");
        return position;
    }

    public static String playerYearsPlayedFinder(ArrayList<String> data)
    {
        PlayerStats stats = new PlayerStats();

        String years = "";
        boolean first_year = false, last_year  = false, still_playing = false;

        for(int i = 0; i < data.size(); i++)
        {

            if(data.get(i).equals("Debut:"))
            {
                if(stats.isNumeric(data.get(i + 1)) && data.get(i + 1).length() == 4)
                {
                    years += data.get(i + 1) + "-";
                    first_year = true;
                }
                else
                {
                    years += data.get(i + 3) + "-";
                    first_year = true;
                }
            }

            if(data.get(i).equals("Last") && data.get(i + 1).equals("Game:"))
            {
                years += data.get(i + 4);
                last_year =  true;
            }

            if(data.get(i).equals("SUMMARY") && data.get(i + 1).equals("2021"))
            {
                still_playing = true;
            }

            if(first_year && last_year)
            {
                break;
            }
        }

        stats.clean(data);

        if(first_year && !last_year && still_playing)
        {
            years += "Present";
        }

        else if(first_year && !last_year)
        {
            years += "Unknown";
        }

        return years;
    }

    public static String duplicatePlayerSelector(ArrayList<String> urlList, ArrayList<String> players)
    {
        Scanner in = new Scanner(System.in);

        String selected_player;
        String url;

        System.out.println();
        System.out.println("Here is a list of possible players to select:");
        System.out.println();

        for(String player: players)
        {
            System.out.println(player);
        }

        System.out.println();

        System.out.print("Select which player is the one you're looking for (include all information listed): ");
        selected_player = in.nextLine();

        while(!players.contains(selected_player))
        {
            System.out.println("Invalid Answer");
            System.out.print("Select which player is the one you're looking for (include all information listed): ");
            selected_player = in.nextLine();
        }

        url = urlList.get(players.indexOf(selected_player));
        return url;
    }
}
