package com.jap.marksevaluation;

// import java.util.Arrays;

public class OakBridgeSchool {

    public int[] calculateTotalMarks(int[] math,int[] science,int[] english) {
        if (math.length == 0 || science.length == 0 || english.length == 0) {
            return new int[0];
        }
        int[] totalMarks = new int[math.length];
        for(int i = 0; i < math.length; i++) {
            int total = math[i] + science[i] + english[i];
            totalMarks[i] = total;
        }
        return totalMarks;
    }

    public int[] calculateTotalAverageMarksForEachStudent(int [] totalMarks, int noOfSubjects) {
        if (totalMarks.length == 0 || noOfSubjects == 0) {
            return new int[0];
        }
        int[] averageMarks = new int[totalMarks.length];
        for(int i = 0; i < totalMarks.length; i++) {
            averageMarks[i] = totalMarks[i]/noOfSubjects;
        }
        return averageMarks;
    }

    public double calculateAverageScienceMarks (int[] science,int len)
    {
        double averageScienceMark = 0;
        for(int mark : science) {
            averageScienceMark += mark;
        }
        averageScienceMark /= science.length;
        return averageScienceMark;
    }

    public double calculateAverageEnglishMarks(int[] english, int len)
    {
        double averageEnglishMark = 0;
        for(int mark : english) {
            averageEnglishMark += mark;
        }
        averageEnglishMark /= english.length;
        return averageEnglishMark;
    }

    public double calculateAverageMathMarks (int[] math,int len)
    {
        double averageMathMark = 0;
        for (int mark : math) {
            averageMathMark += mark;
        }
        averageMathMark /= math.length;
        return averageMathMark;
    }

    // Write the logic inside the method to calculate the grade based on the math mark of the student
    public char findGradeInMath(int math){
        if (math >= 90) {
            return 'A';
        } else if (math >= 80) {
            return 'B';
        } else if (math >= 70) {
            return 'C';
        } else if (math >= 60) {
            return 'D';
        }
        return 'F';
    }

    // Write the logic inside the method to calculate the grade based on the science mark of the student
    public char findGradeInScience(int science){
        if (science >= 90) {
            return 'A';
        } else if (science >= 80) {
            return 'B';
        } else if (science >= 70) {
            return 'C';
        } else if (science >= 60) {
            return 'D';
        }
        return 'F';
    }

    // Write the logic inside the method to calculate the grade based on the english mark of the student
    public char findGradeInEnglish(int english){
        if (english >= 90) {
            return 'A';
        } else if (english >= 80) {
            return 'B';
        } else if (english >= 70) {
            return 'C';
        } else if (english >= 60) {
            return 'D';
        }
        return 'F';
    }

    // Write the logic to sort the total marks of the students of the class in ascending order, use insertion-sort
    public int[] sortByTotalMarks(int[] totalMarks){
        for(int i=1; i < totalMarks.length; i++) {
            int key = totalMarks[i];
            int j = i - 1;
            while (j >= 0 && totalMarks[j] > key) {
                totalMarks[j + 1] = totalMarks[j];
                j = j - 1;
            }
            totalMarks[j + 1] = key;
        }
        return totalMarks;
    }

    // Check if any of the studentNames in the array is repeated, if yes return true else false
    public boolean checkIfNamesAreRepeated(String[] studentNames){
        for(int i=0; i < studentNames.length; i++) {
            for(int j=i+1; j < studentNames.length; j++) {
                if(studentNames[i].equals(studentNames[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    //write the logic to find the top score using recursion
    public int findTopScore(int [] totalMarks,int len){
        if(totalMarks.length == 0) {
            return 0;
        }
        if(len == 1) {
            return totalMarks[0];
        }
        return Math.max(totalMarks[len - 1], findTopScore(totalMarks, len - 1));
    }

    //Display the details of the student
    public void displayDetails(int totalMark, int averageMark, char mathGrade, char scienceGrade, char englishGrade,String studentName, int rollNo ){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Grading And Evaluation");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Student Name :: " + studentName + " || Roll Number :: " + rollNo);
        System.out.println("-----------------------------------------------");
        System.out.println("The Total Marks   - " + totalMark + "/300");
        System.out.println("The Average marks - " + averageMark);
        System.out.println("-----------------------------------------------");
        System.out.println("Grade in Math    : " + mathGrade);
        System.out.println("Grade in Science : " + scienceGrade);
        System.out.println("Grade in English : " + englishGrade);
        System.out.println("---------------------------------------------------");
    }

    //write the logic to generate the result message using name and score
    public StringBuilder[] generateResultMessage(String[] studentNames,int[] totalScore) {
        StringBuilder[] messages = new StringBuilder[studentNames.length];
        for (int i = 0; i < studentNames.length; i++) {
            messages[i] = new StringBuilder("Hi " + studentNames[i] + " you have secured " + totalScore[i]);
        }
        return messages;
    }


    public static void main(String[]args) {

        int[] math = {88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        int[] science = {80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        int[] english = {90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        int noOfSubjects = 3;

        String[] studentNames = {"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena","Leo"};

        int[] rollNos = {102,109,101,103,104,108,118,105,106,107};

        OakBridgeSchool oakBridgeSchool = new OakBridgeSchool();

        int[] totalMarks = oakBridgeSchool.calculateTotalMarks(math, science, english);

        int[] totalAverageMarks = oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalMarks, noOfSubjects);

        double averageScienceMark = oakBridgeSchool.calculateAverageScienceMarks(science, science.length);
        double averageMathMark = oakBridgeSchool.calculateAverageMathMarks(math, math.length);
        double averageEnglishMark = oakBridgeSchool.calculateAverageEnglishMarks(english, english.length);

        for (int i = 0; i < studentNames.length; i++) {
            oakBridgeSchool.displayDetails(totalMarks[i], totalAverageMarks[i],
                    oakBridgeSchool.findGradeInMath(math[i]),
                    oakBridgeSchool.findGradeInScience(science[i]),
                    oakBridgeSchool.findGradeInEnglish(english[i]),
                    studentNames[i], rollNos[i]);
            System.out.println();
        }

        System.out.println("Average Science marks scored by the class is : " + averageScienceMark);
        System.out.println("Average Math marks scored by the class is    : " + averageMathMark);
        System.out.println("Average English marks scored by the class is : " + averageEnglishMark);

        boolean isNameRepeated = oakBridgeSchool.checkIfNamesAreRepeated(studentNames);
        if(isNameRepeated) {
            System.out.println("Names are repeated");
        } else {
            System.out.println("Names are not repeated");
        }

        StringBuilder[] resultMessages = oakBridgeSchool.generateResultMessage(studentNames, totalMarks);
        for(StringBuilder messages : resultMessages) {
            System.out.println(messages);
        }

        int[] sortByTotalMarks = oakBridgeSchool.sortByTotalMarks(totalMarks);
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("Report");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        for(int mark : sortByTotalMarks) {
            System.out.println(mark);
        }
        System.out.println("The top score is : " + oakBridgeSchool.findTopScore(sortByTotalMarks, sortByTotalMarks.length));

    }
}
