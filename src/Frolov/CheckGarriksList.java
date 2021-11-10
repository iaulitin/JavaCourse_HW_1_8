package Frolov;

import java.util.ArrayList;
import java.util.List;

public class CheckGarriksList {

    private static void endTime(double start, String funcName) {
        System.out.printf("%-20s %-30s %.0f %s", "Время работы", funcName, (System.currentTimeMillis() - start), "мс\n\n");
    }

    public static void main(String[] args) {
        List garriksList = new GarriksArrayList();
        List originalList = new ArrayList();


        double start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            garriksList.add(i);
        }
        endTime(start, "garriksList.add ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            originalList.add(i);
        }
        endTime(start, "originalList.add ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            garriksList.size();
        }
        endTime(start, "garriksList.size ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            originalList.size();
        }
        endTime(start, "originalList.size ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            garriksList.isEmpty();
        }
        endTime(start, "garriksList.isEmpty ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            originalList.isEmpty();
        }
        endTime(start, "originalList.isEmpty ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            garriksList.contains(49998);
        }
        endTime(start, "garriksList.contains ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            originalList.contains(49998);
        }
        endTime(start, "originalList.contains ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            garriksList.toArray();
        }
        endTime(start, "garriksList.toArray ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            originalList.toArray();
        }
        endTime(start, "originalList.toArray ");


        List newGarriksList = garriksList.subList(0, 49999);
        List newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 49998; i++) {
            newGarriksList.remove(newGarriksList.size() - 1);
        }
        endTime(start, "garriksList.remove ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 49998; i++) {
            newOriginalList.remove(newOriginalList.size() - 1);
        }
        endTime(start, "originalList.remove ");


        newGarriksList = garriksList.subList(0, 49999);
        newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 49998; i++) {
            newGarriksList.clear();
        }
        endTime(start, "garriksList.clear ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 49998; i++) {
            newOriginalList.clear();
        }
        endTime(start, "originalList.clear ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            garriksList.get(i);
        }
        endTime(start, "garriksList.get ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            originalList.get(i);
        }
        endTime(start, "originalList.get ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            garriksList.set(i, i);
        }
        endTime(start, "garriksList.set ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            originalList.set(i, i);
        }
        endTime(start, "originalList.set ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            garriksList.add(i, i);
        }
        endTime(start, "garriksList.add ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            originalList.add(i, i);
        }
        endTime(start, "originalList.add ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            garriksList.indexOf(i);
        }
        endTime(start, "garriksList.indexOf ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            originalList.indexOf(i);
        }
        endTime(start, "originalList.indexOf ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            garriksList.lastIndexOf(i);
        }
        endTime(start, "garriksList.lastIndexOf ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 49999; i++) {
            originalList.lastIndexOf(i);
        }
        endTime(start, "originalList.lastIndexOf ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 48999; i++) {
            garriksList.subList(i, i + 100);
        }
        endTime(start, "garriksList.subList ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 48999; i++) {
            originalList.subList(i, i + 100);
        }
        endTime(start, "originalList.subList ");


        newGarriksList = garriksList.subList(0, 4999);
        newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            newGarriksList.retainAll(newOriginalList);
        }
        endTime(start, "garriksList.retainAll ");

        newGarriksList = garriksList.subList(0, 4999);
        newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            newOriginalList.retainAll(newGarriksList);
        }
        endTime(start, "originalList.retainAll ");


        newGarriksList = garriksList.subList(0, 4999);
        newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            newGarriksList.removeAll(newOriginalList);
        }
        endTime(start, "garriksList.removeAll ");

        newGarriksList = garriksList.subList(0, 4999);
        newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            newOriginalList.removeAll(newGarriksList);
        }
        endTime(start, "originalList.removeAll ");


        newGarriksList = garriksList.subList(0, 4999);
        newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            newGarriksList.containsAll(newOriginalList);
        }
        endTime(start, "garriksList.containsAll ");

        newGarriksList = garriksList.subList(0, 4999);
        newOriginalList = new ArrayList(originalList);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            newOriginalList.containsAll(newGarriksList);
        }
        endTime(start, "originalList.containsAll ");


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            garriksList.toString();
        }
        endTime(start, "garriksList.toString ");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            originalList.toString();
        }
        endTime(start, "originalList.toString ");


    }
}
