package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CalculatorController {

    static double num = 0;
    static String opr;
    static boolean isDecimalUsed = false;

    @FXML
    private TextField NumberField;
    @FXML
    private Button oneBtn;
    @FXML
    private Button twoBtn;
    @FXML
    private Button ThreeBtn;
    @FXML
    private Button fourBtn;
    @FXML
    private Button fiveBtn;
    @FXML
    private Button sixBtn;
    @FXML
    private Button sevenBtn;
    @FXML
    private Button eightBtn;
    @FXML
    private Button nineBtn;
    @FXML
    private Button zeroBtn;
    @FXML
    private Button divideBtn;
    @FXML
    private Button plusBtn;
    @FXML
    private Button multiplyBtn;
    @FXML
    private Button minusBtn;
    @FXML
    private Button acBtn;
    @FXML
    private Button equalBtn;
    @FXML
    private Button dotBtn;

    @FXML
    public void handleDigitAction(ActionEvent actionEvent) {
        String number = ((Button)actionEvent.getSource()).getText();
        String text = NumberField.getText();
        text += number;
        NumberField.setText(text);
    }

    @FXML
    public void handleCommand(ActionEvent actionEvent) {
        String command = ((Button)actionEvent.getSource()).getText();
        opr = command;
        String text = NumberField.getText();
        NumberField.clear();
        num = Double.parseDouble(text);
    }

    @FXML
    public void handleEqual(ActionEvent actionEvent) {
        String text = NumberField.getText();
        Double newDouble = Double.parseDouble(text);
        String newText;
        switch (opr) {
            case "+":
                num += newDouble;
                break;
            case "-":
                num -= newDouble;
                break;
            case "/":
                num /= newDouble;
                break;
            case "x":
                num *= newDouble;
        }
        newText = "" + num;
        isDecimalUsed = false;
        NumberField.setText(newText);
    }

    @FXML
    public void handleDecimal(ActionEvent actionEvent) {
        if (!isDecimalUsed) {
            String text = NumberField.getText();
            text += ".";
            NumberField.setText(text);
            isDecimalUsed = true;
        }
    }

    @FXML
    public void handleAC(ActionEvent actionEvent) {
        isDecimalUsed = false;
        num = 0;
        NumberField.clear();
    }

    @FXML
    public void handleKeyboard(KeyEvent keyEvent) {
        String input = keyEvent.getText();
        if (input.length() > 0) {
            char character = input.charAt(0);
            if (!Character.isDigit(character)) {
                keyEvent.consume();
            } else {
                try {
                    num = Double.parseDouble(NumberField.getText() + character);
                } catch (NumberFormatException e) {
                    NumberField.clear();
                    NumberField.setText(((Double)num).toString());
                    keyEvent.consume();
                }
            }
        }
    }
}