import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            URLSorter url = new URLSorter();
            url.run();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            System.out.println("Could not find data on entered player. Please try again.");
        }

    }
}

