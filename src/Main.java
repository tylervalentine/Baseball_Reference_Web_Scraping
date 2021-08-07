import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        try {
            URLSorter sorter = new URLSorter();

            sorter.run();

        } catch (IOException | InterruptedException e) {
            System.out.println("Could not find data on entered player. Please try again.");
        }
    }
}
