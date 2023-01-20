package MacFikstur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();
        System.out.println("Takım isimlerini girin : (Çıkmak için : Q)");
        addTeam(liste);
        addBayTeam(liste);
        ArrayList<String> matchList = match(liste);
        printRound(matchList);
    }

    public static void addTeam(ArrayList<String> arr) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String team = input.nextLine();
            if (team.equals("Q") || team.equals("q")) {
                break;
            }
            arr.add(team);
        }
    }

    public static void addBayTeam(ArrayList<String> arr) {
        if (arr.size() % 2 == 1) {
            arr.add("Bay");
        }
    }

    public static ArrayList<String> match(ArrayList<String> arr) {
        ArrayList<String> teamList = new ArrayList<>();
        Collections.shuffle(arr);
        String s1 = "";
        String s2 = "";
        for (int home = 0; home < arr.size() / 2; home++) {
            for (int away = arr.size() / 2; away < arr.size(); away++) {
                if (home + away >= arr.size()) {
                    int ha = (home + away) % (arr.size() / 2);
                    s1 += arr.get(home) + " vs " + arr.get(ha) + "\n";
                    s2 += arr.get(ha) + " vs " + arr.get(home) + "\n";
                } else {
                    s1 += arr.get(home) + " vs " + arr.get(home + away) + "\n";
                    s2 += arr.get(home + away) + " vs " + arr.get(home) + "\n";
                }
            }
            teamList.add(s1);
            teamList.add(s2);
            s1 = "";
            s2 = "";
        }
        return teamList;
    }

    public static void printRound(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i += 2) {
            System.out.println(arr.get(i));
        }
        for (int i = 1; i < arr.size(); i += 2) {
            System.out.println(arr.get(i));
        }
    }
}
