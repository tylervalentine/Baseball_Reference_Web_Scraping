import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class URLSorter {

    public void run() throws IOException, InterruptedException {
        String player_name;
        String proper_player_name;
        String first_letter_last_name;
        String short_first_name;
        String short_last_name;
        String player_position;
        String data_piece;
        String url;
        String more_data_answer;
        String another_player_answer;

        ArrayList<String> names;
        ArrayList<String> data;

        Scanner in = new Scanner(System.in);
        PlayerStats stats = new PlayerStats();
        do {
            System.out.print("Enter which player you want data on (Format Example: Justin Verlander)\n" +
                    "(For abbreviated names, make sure to put periods where applicable (Example: J.P. Crawford): ");
            player_name = in.nextLine();
            player_name = player_name.toLowerCase();
            proper_player_name = stats.title(player_name);
            System.out.print("Is this player a batter or a pitcher? ");
            player_position = in.nextLine();

            while (!player_position.equalsIgnoreCase("Batter")
                    && !player_position.equalsIgnoreCase("Pitcher")) {
                System.out.println("Invalid answer. Please try again.");
                System.out.print("Is this player a batter or a pitcher? ");
                player_position = in.nextLine();
            }

            System.out.println();
            System.out.println("Loading player data...");

            names = nameSorter(player_name);

            first_letter_last_name = names.get(0);
            short_first_name = names.get(1);
            short_last_name = names.get(2);

            url = "https://www.baseball-reference.com/players/" + first_letter_last_name + "/" + short_last_name + short_first_name + "";
            url = numberSorter(url, player_name);

            data = sort(url);
            stats.clean(data);

            if (!stats.isBatter(data) && player_position.equalsIgnoreCase("Batter")) {
                System.out.println("This player is actually a pitcher. Switching data choices...");
                player_position = "Pitcher";
            }

            if (!stats.isPitcher(data) && player_position.equalsIgnoreCase("Pitcher")) {
                System.out.println("This player is actually a batter. Switching data choices...");
                player_position = "Batter";
            }

            System.out.println();

            if (player_position.equalsIgnoreCase("Batter")) {
                do {
                    data_piece = stats.dataChoiceBatter(data, proper_player_name);
                    System.out.println(data_piece);
                    System.out.println();
                    System.out.print("Would you like more data on " + proper_player_name + "? ");
                    more_data_answer = in.nextLine();
                    while (!more_data_answer.equalsIgnoreCase("Yes") && !more_data_answer.equalsIgnoreCase("No")) {
                        System.out.println("Invalid answer. Please try again.");
                        System.out.print("Would you like more data on " + proper_player_name + "? ");
                        more_data_answer = in.nextLine();
                    }
                }while(!more_data_answer.equalsIgnoreCase("No"));
            }

            else if (player_position.equalsIgnoreCase("Pitcher")) {
                do {
                    data_piece = stats.dataChoicePitcher(data, proper_player_name);
                    System.out.println(data_piece);
                    System.out.println();
                    System.out.print("Would you like more data information on " + proper_player_name + "? ");
                    more_data_answer = in.nextLine();
                    while (!more_data_answer.equalsIgnoreCase("Yes") && !more_data_answer.equalsIgnoreCase("No")) {
                        System.out.println("Invalid answer. Please try again.");
                        System.out.print("Would you like more data information on " + proper_player_name + "? ");
                        more_data_answer = in.nextLine();
                    }
                    System.out.println();
                }while(!more_data_answer.equalsIgnoreCase("No"));
            }

            System.out.print("Would you like data information on another player? ");
            another_player_answer = in.nextLine();

            while (!another_player_answer.equalsIgnoreCase("Yes") && !another_player_answer.equalsIgnoreCase("No")) {
                System.out.println("Invalid answer. Please try again.");
                System.out.print("Would you like data information on another player? ");
                another_player_answer = in.nextLine();
            }

            System.out.println();
            System.out.println("Rebooting program... ");
            Thread.sleep(4000);
            System.out.println();

        }while(!another_player_answer.equalsIgnoreCase("No"));

        System.out.println("Program terminated. Please come again!");
    }

    public ArrayList<String> sort(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        String info = doc.text();
        ArrayList<String> data = new ArrayList<>(Arrays.asList(info.split(" ")));

        return data;
    }

    public ArrayList<String> nameSorter(String name) {
        String first_letter_player_name = "";
        String shortened_last_name = "";
        String shortened_first_name = "";
        String[] player_name_letters;
        ArrayList<String> sorted_names = new ArrayList<>();
        int count = 1;
        boolean whitespace = false;

        player_name_letters = name.split("");

        for (String letter : player_name_letters) {
            if (count > 2 && whitespace) {
                if (count == 3) {
                    first_letter_player_name = letter;
                    shortened_last_name += letter;
                    count++;
                } else if (count != player_name_letters.length && count <= 7) {
                    shortened_last_name += letter;
                    count++;
                }
            }

            if (count == 1) {
                shortened_first_name += letter;
                count++;
            } else if (count == 2) {
                shortened_first_name += letter;
                count = 3;
            }

            if (letter.equals(" ")) {
                whitespace = true;
            }
        }

        sorted_names.add(first_letter_player_name);
        sorted_names.add(shortened_first_name);
        sorted_names.add(shortened_last_name);

        return sorted_names;
    }

    public String numberSorter(String url, String name) throws IOException {

        String first_name;
        String last_name;
        String data_first_name = "";
        String data_last_name = "";

        ArrayList<String> data;

        int first_num = 0;
        int second_num = 1;

        String[] full_name = name.split(" ");
        first_name = full_name[0];
        last_name = full_name[1];

        if (!first_name.equals(data_first_name) || !last_name.equals(data_last_name)) {

            while (second_num != 9) {
                url += "" + first_num + second_num + ".shtml";
                try {
                    data = sort(url);
                    data_first_name = data.get(0);
                    data_last_name = data.get(1);
                    second_num++;
                } catch (IOException e) {
                    second_num++;
                }

                data_first_name = data_first_name.toLowerCase();
                data_last_name = data_last_name.toLowerCase();

                if (first_name.equals(data_first_name) && last_name.equals(data_last_name)) {
                    return url;
                }
                url = url.substring(0, 52);
            }

            while (first_num != 9) {
                url += "" + first_num + second_num + ".shtml";

                try {
                    data = sort(url);
                    data_first_name = data.get(0);
                    data_last_name = data.get(1);
                    first_num++;

                } catch (IOException e) {
                    first_num++;
                }

                data_first_name = data_first_name.toLowerCase();
                data_last_name = data_last_name.toLowerCase();

                if (first_name.equals(data_first_name) && last_name.equals(data_last_name)) {
                    return url;
                }

                url = url.substring(0, 52);
            }
        }
        return url + "99.shtml";
    }
}
