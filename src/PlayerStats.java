import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerStats {

    public void clean(ArrayList<String> data) {
        for (int i = 0; i < data.size(); )

            if (!data.get(i).equals("SUMMARY")) {
                data.remove(data.get(i));
            } else {
                break;
            }
    }

    public int writeFile(ArrayList<String> data, String name) throws IOException {

        FileWriter data_writer = new FileWriter("data.txt");
        data_writer.write("***" + name + " Statistics***  \n");

        boolean mod_three = false;
        boolean mod_two = false;

        if(data.get(0).equals("SUMMARY") && data.get(1).equals("Career"))
        {
            mod_two = true;
        }

        else if(data.get(0).equals("SUMMARY") && data.get(1).equals("2021"))
        {
            mod_three = true;
        }

        int count = 0;
        int delete_number = Integer.MIN_VALUE;

        if(mod_three)
        {
            for (String word : data) {
                if (word.equalsIgnoreCase("OPS+") || word.equalsIgnoreCase("WHIP"))
                {
                    delete_number = 0;
                }
                if (delete_number == 3)
                {
                    break;
                }
                else
                {
                    if (count % 3 == 0 && count != 0)
                    {
                        data_writer.write("\n");
                    }
                    data_writer.write(word + " ");
                    count++;
                }
                delete_number++;
            }
            data_writer.close();
        }

        else if(mod_two)
        {
            for (String word : data) {
                if (word.equalsIgnoreCase("OPS+") || word.equalsIgnoreCase("WHIP"))
                {
                    delete_number = 0;
                }
                if (delete_number == 2)
                {
                    break;
                }
                else
                {
                    if (count % 2 == 0 && count != 0)
                    {
                        data_writer.write("\n");
                    }
                    data_writer.write(word + " ");
                    count++;
                }
                delete_number++;
            }
            data_writer.close();
        }

        if(mod_three)
            return 3;

        return 2;
    }

    public String dataChoice(FileReader data, String name, int career_season) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader data_reader = new BufferedReader(data);
        ArrayList<String> words;
        ArrayList<String> data_words;
        ArrayList<String> data_choices = new ArrayList<>();

        String data_category;
        String data_number = "";
        String season_career;
        String line = data_reader.readLine();

        int data_category_count = -2;

        System.out.println("Here are Data Choices for " + name + ":");
        System.out.println("-------------------------------------------------");

        while (line != null) {
            while (data_category_count <= -1)
            {
                data_category_count++;
                line = data_reader.readLine();
            }
            data_category_count++;
            words = new ArrayList<>(Arrays.asList(line.split(" ")));
            if(!isNumeric(words.get(0)))
            {
                data_choices.add(words.get(0));
                System.out.println("" + words.get(0) + " Stats");
                line = data_reader.readLine();
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println();
        System.out.print("Enter which category you want data on from " + name + " (do not include 'Stats' in your answer): ");
        data_category = in.nextLine();


        while (!data_choices.contains(data_category)) {
            System.out.println("Invalid Answer.");
            System.out.print("Enter which category you want data on from " + name + ": ");
            data_category = in.nextLine();
        }

        System.out.print("Would you like " + name + "'s " + data_category + " from this season or his career? ");
        season_career = in.nextLine();

        while (!season_career.equalsIgnoreCase("Season") && !season_career.equalsIgnoreCase("Career")) {
            System.out.println("Invalid Answer.");
            System.out.print("Would you like " + name + "'s " + data_category + " from this season or his career? ");
            season_career = in.nextLine();
        }

        if(season_career.equalsIgnoreCase("Season") && career_season == 2)
        {
            System.out.println("" + name + " did not play this season. Switching to career statistic...");
            season_career = "Career";
        }

        BufferedReader data_finder = new BufferedReader(new FileReader("data.txt"));
        String data_line = data_finder.readLine();

        if (season_career.equalsIgnoreCase("Season") &&  career_season == 3)
        {
            while (data_line != null) {
                data_words = new ArrayList<>(Arrays.asList(data_line.split(" ")));
                if (data_words.get(0).equals(data_category)) {
                    data_number = data_words.get(1);
                    break;
                }
                data_line = data_finder.readLine();
            }
        }
        else if (season_career.equalsIgnoreCase("Career") && career_season == 3) {
            while (data_line != null) {
                data_words = new ArrayList<>(Arrays.asList(data_line.split(" ")));
                if (data_words.get(0).equals(data_category)) {
                    data_number = data_words.get(2);
                    break;
                }
                data_line = data_finder.readLine();
            }
        }

        else if (season_career.equalsIgnoreCase("Career") && career_season == 2) {
            while (data_line != null) {
                data_words = new ArrayList<>(Arrays.asList(data_line.split(" ")));
                if (data_words.get(0).equals(data_category)) {
                    data_number = data_words.get(1);
                    break;
                }
                data_line = data_finder.readLine();
            }
        }

        return "" + name + "'s " + season_career + " " + data_category + " is " + data_number + ".";
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
