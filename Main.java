import java.io.IOException;

public class Main {
    pubic static void main(String[] args) {
        try {
            URLSorter url = new URLSorter();
            url.run();
        } catch (InterruptedException | IOException e) {
            System.out.println("Could not find data on entered player. Please try again.");
        }

    }
}

