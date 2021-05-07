package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        whatGame();
    }

    static void playGameOne() {
        System.out.println("Игра угадайка.");
        int answerByRandom = random.nextInt(10);
        int userAnswer;
        int count = 0;
        do {
            count++;
            if (count == 4) {
                System.out.println("Попытки закончились:(\nПравильный ответ: " + answerByRandom + "\n");
                break;
            }
            System.out.println("Введите число от 0 до 9");
            userAnswer = scanner.nextInt();
            if (userAnswer == answerByRandom) {
                System.out.println("ПОБЕДА!\nПравильный ответ: " + answerByRandom + "\n");
                break;
            }
            if (userAnswer > answerByRandom) {
                System.out.println("Бери меньше, чем " + userAnswer + "\nОсталось попыток: " + (3 - count) + "\n");
            }
            if (userAnswer < answerByRandom) {
                System.out.println("Бери больше, чем " + userAnswer + "\nОсталось попыток: " + (3 - count) + "\n");
            }
        } while (true);
        isQuit(1);
    }

    static void playGameTwo() {
        String userAnswer = "";
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        char[] showCorrectLetters = new char[15];
        for (int i = 0; i < showCorrectLetters.length; i++) {
            showCorrectLetters[i] = '#';
        }
        int randomWordNumber = random.nextInt(24);
        char[] randomWordToCharArr = words[randomWordNumber].toCharArray();
        do {
            System.out.println("Какое слово из представленных загадала машина?\napple, orange, lemon, banana, apricot, avocado, broccoli, carrot, cherry, garlic\ngrape, melon, leak, kiwi, mango, mushroom, nut, olive, pea, peanut\npear, pepper, pineapple, pumpkin, potato");
            userAnswer = scanner.next();
            char[] userAnswerToCharArr = userAnswer.toCharArray();
            int length = randomWordToCharArr.length;
            if (userAnswerToCharArr.length < randomWordToCharArr.length) length = userAnswerToCharArr.length;
            for (int i = 0; i < length; i++) {
                if (userAnswerToCharArr[i] == randomWordToCharArr[i]) {
                    showCorrectLetters[i] = userAnswerToCharArr[i];
                }
            }
            System.out.println("Вот совпавшие буквы:");
            System.out.println(showCorrectLetters);
            if (userAnswer.equals(words[randomWordNumber])) {
                System.out.println("Это победа! Загаданное слово: " + words[randomWordNumber]);
            }

        } while (!userAnswer.equals(words[randomWordNumber]));
        isQuit(2);
    }

    static void isQuit(int numGame) {
        int userAnswerQ;
        do {
            System.out.println("Повторим? 1 – да / 0 – нет");
            userAnswerQ = scanner.nextInt();

            if (userAnswerQ == 1 && numGame == 1) playGameOne();
            else if (userAnswerQ == 1 && numGame == 2) playGameTwo();
            else if (userAnswerQ == 0) System.out.println("ЧАО!");

        } while (userAnswerQ != 0);
    }

    static void whatGame() {
        int userAnswer = 0;
        do {
            System.out.println("В какую игру будем играть?\n1 - игра, где надо угадать число от 0 до 9.\n2 - игра, где надо угадать слово.\n0 - выход.");
            userAnswer = scanner.nextInt();
            if (userAnswer == 1) playGameOne();
            else if (userAnswer == 2) playGameTwo();
            else if (userAnswer == 0) System.out.println("ЧАО!");

        } while (userAnswer != 0);
    }
}
