package otherOptions.forTests;

import com.sun.org.apache.xerces.internal.xs.StringList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import otherOptions.PatternForWindows;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartTest extends PatternForWindows implements Separatable{
    Stage mainStage;
    public void setMainStage(Stage mainStage){
        this.mainStage = mainStage;
    }
    private String nameOfTest;

    public void start() throws IOException{
        mainStage.close();

        Stage window = new Stage();
        window.setTitle("Создание тестового задания");
        window.initModality(Modality.APPLICATION_MODAL);  // нельзя юзать другие окна
        window.setResizable(false);

        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        String[] comment = new String[1];
        comment[0] = "";

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Выбери тест из списка");
        comboBox.getItems().addAll(getTestNames());

        Button start = new Button("Приступить к выполнению");
        start.setPrefSize(165, 45);
        start.setOnAction(e ->{
            nameOfTest = comboBox.getValue();
            readAllInfo(questions, answers, comment);
            if(comment[0] != ""){
                JOptionPane.showMessageDialog(null, comment[0], "Комментарии к заданию", JOptionPane.PLAIN_MESSAGE);
            }
            newScene(window, questions, answers);
        });

        Button end = new Button("На главное меню");
        end.setPrefSize(165, 45);
        end.setOnAction(e ->{
            window.close();
            mainStage.show();
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);
        vBox.getChildren().addAll(comboBox, start, end);

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(vBox);

        Scene scene = new Scene(borderPane, 450, 570);
        window.setScene(scene);
        window.show();
    }

    private void newScene(Stage window, List<String> questions, List<String> answers){
        int[] indexOfTask = new int[1];

        if(questions.size() < 1 || answers.size() < 1 ){
            return;
        }
        List<String> userAnswers = new ArrayList<>();

        Label showQuestion = new Label("Вопрос №" + (indexOfTask[0] + 1) + " " + questions.get(indexOfTask[0]));
        showQuestion.setStyle("    -fx-font-size: 24;" +
                                "    -fx-font-family: \"Monotype Corsiva\" ;");
        TextField getAnswer = new TextField();

        Button button = new Button("Ввести ответ");
        button.setOnAction(e ->{
            userAnswers.add(getAnswer.getText());
            indexOfTask[0]++;
            getAnswer.clear();
            if(indexOfTask[0] < questions.size()){
                showQuestion.setText("Вопрос №" + (indexOfTask[0] + 1) + " " + questions.get(indexOfTask[0]));
            }
            else{
                showQuestion.setText("Нажми на кнопку чтобы увидеть свой результат");
                verify(answers, userAnswers);
                window.close();
                mainStage.show();
            }
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);
        vBox.getChildren().addAll(showQuestion, getAnswer, button);

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(vBox);

        Scene newScene = new Scene(borderPane, 460, 580);
        window.setScene(newScene);
    }

    private void verify(List<String> realAnswers, List<String> userAnswers){
        List<Integer> failledTasks = new ArrayList<>();

        for(int i = 0; i < realAnswers.size(); i++){
            if(!(realAnswers.get(i)).equals(userAnswers.get(i))){
                failledTasks.add(i);
            }
        }

        String mistakes = "";
        if(failledTasks.size() > 0){
            for(int i = 0; i < failledTasks.size(); i++){
                if((i + 1)< failledTasks.size() ){
                    mistakes += (failledTasks.get(i)+1) + ", ";
                }
                else {
                    mistakes += (failledTasks.get(i)+1);
                }
            }
        }

        if(failledTasks.size() == 0){
            JOptionPane.showMessageDialog(null, "Ты сделал все " + realAnswers.size() +
                    " заданий(я) верно", "Результат теста", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Ты сделал " + (realAnswers.size() - failledTasks.size()) +
                    " заданий(я) верно\n Ошибки в номерах (" + mistakes + ")", "Результат теста", JOptionPane.PLAIN_MESSAGE);
        }
    }
    private String[] getTestNames(){
        File folder = new File("forTests\\tasks");
        String[] files = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        String[] filesForReturn = new String[files.length];
        for(int i = 0; i < files.length; i++){
            String str = "";
            for(int j = 0; j < files[i].length() - 5; j++){
                str += files[i].charAt(j);
            }
            filesForReturn[i] = str;
        }

        return filesForReturn;
    }
    private void readAllInfo(List<String> questions, List<String> answers, String[] comment){
        try(FileReader taskReader = new FileReader("forTests\\tasks\\" + nameOfTest + "T.txt");
            FileReader answerReader = new FileReader("forTests\\answers\\" + nameOfTest + "A.txt");
            FileReader commentReader = new FileReader("forTests\\comments\\" + nameOfTest + "C.txt")){
            Scanner vvodTask = new Scanner(taskReader);
            Scanner vvodAnswer = new Scanner(answerReader);
            Scanner vvodComment = new Scanner(commentReader);

            helpForReadAllInfo(vvodTask, questions);
            helpForReadAllInfo(vvodAnswer, answers);
            while(vvodComment.hasNext()){
                comment[0] += vvodComment.nextLine();
            }
        }
        catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Ошибка при работе с файлом");
        }
    }
    private void helpForReadAllInfo(Scanner scanner, List<String> list){
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            if(!str.equals(SEPARATOR)){
                list.add(str);
            }
            str = "";
        }
    }

}













