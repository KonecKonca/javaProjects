package otherOptions.forTests;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import otherOptions.PatternForWindows;

import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputTest extends PatternForWindows implements Separatable{
    private String nameOfTest = "";
    private int countOfQuestion = 1;
    Stage mainStage;
    public void setMainStage(Stage mainStage){
        this.mainStage = mainStage;
    }

    public void start()throws IOException{
        mainStage.close();

        Stage window = new Stage();
        window.setTitle("Создание тестового задания");
        window.initModality(Modality.APPLICATION_MODAL);  // нельзя юзать другие окна
        window.setResizable(false);
        window.setOnCloseRequest(e -> e.consume());

        try{
            nameOfTest = JOptionPane.showInputDialog("Введите название теста(не используйте \\/:*?\"<>|)");
            while(!isCompliencename()){
                nameOfTest = JOptionPane.showInputDialog("НЕ ТУПИ. Введите название теста(не используйте \\/:*?\"<>|)");
            }
        }
        catch(Exception ex){
            mainStage.show();
            return;
        }
        File outTask = new File("forTests\\tasks\\" + nameOfTest + "T.txt");
        File outAnswers = new File("forTests\\answers\\" + nameOfTest + "A.txt");
        File outComment = new File("forTests\\comments\\" + nameOfTest + "C.txt");
        FileWriter outTaskWriter = new FileWriter(outTask);
        FileWriter outAnswersWriter = new FileWriter(outAnswers);
        FileWriter outCommentsWriter = new FileWriter(outComment);

        TextArea textArea = new TextArea();
        TextField answer = new TextField();

        Label hintForQuestion = new Label("Сюда введите вопрос № " + countOfQuestion);
        setCss(hintForQuestion);

        Label hintForAnswer = new Label("Сюда введите ответ, помните что ответ должен быть\n однозначно очевидным" +
                " для человека проходящего тест");
        setCss(hintForAnswer);

        Label statusBar = new Label("Строка состояния");
        setCss(statusBar);

        List<String> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        Button addquestion = new Button("Сохранить вопрос № " + countOfQuestion);
        addquestion.setPrefSize(222, 25);
        addquestion.setOnAction(e ->{
            try {
                createTest(questionList, textArea, answerList, answer, hintForQuestion, addquestion, statusBar,
                        outTaskWriter, outAnswersWriter);
            }
            catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Ошибка при работе с файлом");
            }
        });

        Button end = new Button("Тест готов");
        end.setPrefSize(222, 25);
        end.setOnAction(e ->{
            String str;
            try {
                str = JOptionPane.showInputDialog("Если хотети, то можете указать некоторые пометки,\n " +
                        "касаемо выполнения теста тут");
            }
            catch (Exception ex){
                str = "Автор теста не удосужился ввести какие-либо комментарии\n" +
                        "поэтому я это делаю за него =)";
            }
            try {
                outCommentsWriter.write(str);
            }
            catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Ошибка при работе с файлом");
            }
            closeFilesStreams(outTaskWriter, outAnswersWriter, outCommentsWriter);
            window.close();
            mainStage.show();
        });

        Button reset = new Button("Прекратить создание теста");
        reset.setPrefSize(222, 25);
        reset.setOnAction(e -> {
            closeFilesStreams(outTaskWriter, outAnswersWriter, outCommentsWriter);
            deleteFiles(outTask, outAnswers, outComment);
            window.close();
            mainStage.show();
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);
        vBox.getChildren().addAll(hintForQuestion, textArea, hintForAnswer, answer, addquestion, end, reset, statusBar);

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(vBox);

        Scene scene = new Scene(borderPane, 450, 570);
        window.setScene(scene);
        if(nameOfTest != null){
            window.show();
        }
    }

    private void createTest(List<String> questionList, TextArea textArea, List<String> answerList, TextField answer,
                            Label hintForQuestion, Button addquestion, Label statusBar,
                            FileWriter outTaskWriter,  FileWriter outAnswersWriter) throws IOException {
        final String question = textArea.getText();
        final String ansWer = answer.getText();
        if(question.equals("") || ansWer.equals("")){
            statusBar.setText("Вы ввели некорректные данные");
            return;
        }
        questionList.add(textArea.getText());
        textArea.clear();
        answerList.add(answer.getText());
        answer.clear();
        hintForQuestion.setText("Сюда введите вопрос № " + countOfQuestion);
        addquestion.setText("Сохранить вопрос № " + countOfQuestion);
        statusBar.setText("Добавлен вопрос № " + countOfQuestion);
        countOfQuestion++;

        // Дальше непосредственно запись в файл
        outTaskWriter.write(question + "\n" + SEPARATOR + "\n");
        outAnswersWriter.write(ansWer + "\n" + SEPARATOR + "\n");
    }
    private void closeFilesStreams(FileWriter outTaskWriter, FileWriter outAnswersWriterm, FileWriter outCommentsWriter){
        try{
            outAnswersWriterm.close();
            outTaskWriter.close();
            outCommentsWriter.close();
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Ошибка при работе с файлом");
        }
    }
    private void deleteFiles(File fileTask, File fileAnswer, File fileComments){
        fileTask.delete();
        fileAnswer.delete();
        fileComments.delete();
    }
    private void setCss(Label label){
        label.setStyle("    -fx-font-size: 20;" +
                "    -fx-font-family: \"Monotype Corsiva\" ;");
    }
    private boolean isCompliencename(){
        for(int i = 0; i < nameOfTest.length(); i++){
            if(nameOfTest.charAt(i) == '\\' || nameOfTest.charAt(i) == '/' || nameOfTest.charAt(i) == ':' ||
                    nameOfTest.charAt(i) == '*' || nameOfTest.charAt(i) == '?' || nameOfTest.charAt(i) == '"' ||
                        nameOfTest.charAt(i) == '<' || nameOfTest.charAt(i) == '>' || nameOfTest.charAt(i) == '|')
            {
            return false;
            }
        }
        return true;
    }
}
