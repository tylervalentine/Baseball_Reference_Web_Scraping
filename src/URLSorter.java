import org.jsoup.Jsoup;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        String[] urlNames;

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
            url = urlNames[0];
            first_name = urlNames[1];
            last_name = urlNames[2];

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

    public ArrayList<String> sort(String url) throws IOException
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

    public String[] numberSorter(String url, String name)
    {

        String first_name;
        String last_name = "";
        String data_first_name = "";
        String data_last_name = "";
        String[] result = new String[3];

        ArrayList<String> data;

        int first_num = 0;
        int second_num = 1;
        int index = 1;

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
                 result[0] = url;
                 result[1] = data_first_name;
                 result[2] = data_last_name;
                 return result;
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
                 result[0] = url;
                 result[1] = data_first_name;
                 result[2] = data_last_name;
                 return result;
             }
             url = url.substring(0, url.length() - 8);
         }
        result[0] = url + "99.shtml";
        result[1] = first_name;
        result[2] = last_name;
        return result;
    }
}
