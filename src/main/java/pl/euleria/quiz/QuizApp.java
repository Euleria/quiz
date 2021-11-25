package pl.euleria.quiz;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) throws IOException {
        //parseQuizFromCSV(new File("quiz.csv"));
        runQuiz(parseQuizFromCSV(new File("quiz.csv")));
    }

    public static Quiz parseQuizFromCSV(File file) throws IOException {
        CSVParser parser = CSVParser.parse(file, Charset.defaultCharset(), CSVFormat.EXCEL);

        Quiz quiz=new Quiz();
        Category category = null;
        Question question = null;
        Answer answer1 = null;
        Answer answer2 = null;
        Answer answer3 = null;

        // Category category; = new Category();
        for (CSVRecord csvRecord : parser) {
            if (csvRecord.getRecordNumber() != 1) {
                if(category==null || !category.getName().equals(csvRecord.toList().get(0))) {
                    category = new Category(csvRecord.toList().get(0));
                    quiz.addCategory(category);
                }
                question = new Question(csvRecord.toList().get(1));
                category.addQuestion(question);

                answer1 = new Answer(csvRecord.toList().get(2), Integer.parseInt(csvRecord.toList().get(3)));
                question.addAnswer(answer1);
                answer2 = new Answer(csvRecord.toList().get(4), Integer.parseInt(csvRecord.toList().get(5)));
                question.addAnswer(answer2);
                answer3 = new Answer(csvRecord.toList().get(6), Integer.parseInt(csvRecord.toList().get(7)));
                question.addAnswer(answer3);
            }
        }

        return quiz;
    }

    public static void runQuiz (Quiz quiz) {
        System.out.println("Wybierz kategorię:");
        for(int i=0; i<quiz.getCategoryList().size(); i++) {
            System.out.println(i+1 + ". " + quiz.getCategoryList().get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int selectedCategory = scanner.nextInt();

        Category category = quiz.getCategoryList().get(selectedCategory-1);

        int points = 0;
        int selectedAnswer;

        for(int i=0; i<category.getQuestionList().size(); i++){
            Question question = category.getQuestionList().get(i);
            System.out.println(i+1 + ". " + question.getContent());

            for (int j=0; j<question.getAnswerList().size(); j++) {
                Answer answer = question.getAnswerList().get(j);
                System.out.println(j+1 + ". " + answer.getContent());
            }

            selectedAnswer = scanner.nextInt();
            points = points + question.getAnswerList().get(selectedAnswer-1).getValue();
        }

        System.out.println("Liczba poprawnych odpowiedzi: " + points + ". Dziękujemy za udział w quizie!");

    }

}
