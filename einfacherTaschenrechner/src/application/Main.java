package application;
	
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    // Variabeln
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, comma, plus, equal, minus, divide, multiple, clear, back;
    TextField textField;
    Label oldValueLabel, operandLabel;

   // Zahl speichern
    double num;

    // Antwort speichern
    double answer;

    double oldAnswer;

    int operation;

    boolean isTextChanged = false;

    boolean noClickedOperator = true;

    boolean isEqualClicked = false;

    DecimalFormat format = new DecimalFormat("0.###############");

    Font font = Font.font("Calibri", FontWeight.NORMAL, 20);

    private void calculateOldAnswer() {
        switch (operation) {
            case 1:
                oldAnswer += num;
                break;
            case 2:
                if (!oldValueLabel.getText().isEmpty()) {
                    oldAnswer -= num;
                } else {
                    oldAnswer = num - oldAnswer;
                }
                break;
            case 3:
                oldAnswer *= num;
                break;
            case 4:
                oldAnswer /= num;
                break;
        }
    }

    @Override
    public void start(Stage stage) {

        //  Buttons
        b0 = new Button("0");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        comma = new Button(".");
        plus = new Button("+");
        minus = new Button("-");
        multiple = new Button("×");
        divide = new Button("÷");
        equal = new Button("=");
        clear = new Button("C");
        back = new Button("←");
        textField = new TextField("0");
        oldValueLabel = new Label("");
        operandLabel = new Label("");
        //
        oldValueLabel.setAlignment(Pos.CENTER_RIGHT);
        operandLabel.setAlignment(Pos.CENTER_RIGHT);
        textField.setAlignment(Pos.CENTER_RIGHT);

        textField.setEditable(false);

        // Size und Position
        oldValueLabel.setPrefSize(214, 20);
        oldValueLabel.setTranslateX(11);
        oldValueLabel.setTranslateY(5);
        operandLabel.setPrefSize(15, 20);
        operandLabel.setTranslateX(225);
        operandLabel.setTranslateY(5);
        textField.setPrefSize(234, 47);
        textField.setTranslateX(11);
        textField.setTranslateY(25);
        b7.setPrefSize(45, 42);
        b7.setTranslateX(10);
        b7.setTranslateY(80);
        b8.setPrefSize(45, 42);
        b8.setTranslateX(58);
        b8.setTranslateY(80);
        b9.setPrefSize(45, 42);
        b9.setTranslateX(106);
        b9.setTranslateY(80);
        plus.setPrefSize(45, 42);
        plus.setTranslateX(154);
        plus.setTranslateY(80);
        clear.setPrefSize(45, 42);
        clear.setTranslateX(202);
        clear.setTranslateY(80);
        b4.setPrefSize(45, 42);
        b4.setTranslateX(10);
        b4.setTranslateY(126);
        b5.setPrefSize(45, 42);
        b5.setTranslateX(58);
        b5.setTranslateY(126);
        b6.setPrefSize(45, 42);
        b6.setTranslateX(106);
        b6.setTranslateY(126);
        minus.setPrefSize(45, 42);
        minus.setTranslateX(154);
        minus.setTranslateY(126);
        back.setPrefSize(45, 42);
        back.setTranslateX(202);
        back.setTranslateY(126);
        b1.setPrefSize(45, 42);
        b1.setTranslateX(10);
        b1.setTranslateY(172);
        b2.setPrefSize(45, 42);
        b2.setTranslateX(58);
        b2.setTranslateY(172);
        b3.setPrefSize(45, 42);
        b3.setTranslateX(106);
        b3.setTranslateY(172);
        multiple.setPrefSize(45, 42);
        multiple.setTranslateX(154);
        multiple.setTranslateY(172);
        equal.setPrefSize(45, 88);
        equal.setTranslateX(202);
        equal.setTranslateY(172);
        b0.setPrefSize(93, 42);
        b0.setTranslateX(10);
        b0.setTranslateY(218);
        comma.setPrefSize(45, 42);
        comma.setTranslateX(106);
        comma.setTranslateY(218);
        divide.setPrefSize(45, 42);
        divide.setTranslateX(154);
        divide.setTranslateY(218);

        // Font
        b0.setFont(font);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        b6.setFont(font);
        b7.setFont(font);
        b8.setFont(font);
        b9.setFont(font);
        comma.setFont(font);
        equal.setFont(font);
        plus.setFont(font);
        minus.setFont(font);
        multiple.setFont(font);
        divide.setFont(font);
        clear.setFont(font);
        textField.setFont(Font.font("Monospaced", FontWeight.BOLD, 19));
        oldValueLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 17));
        operandLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 17));
        back.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        
        
        //
        EventHandler eventHandler = (new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
               // 0 von links entfernen
                if (e.getSource() == b0)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("0");
                    else
                        textField.setText(textField.getText() + "0");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
              
                else if (e.getSource() == b1)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("1");
                    else
                        textField.setText(textField.getText() + "1");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
               
                else if (e.getSource() == b2)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("2");
                    else
                        textField.setText(textField.getText() + "2");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
              
                else if (e.getSource() == b3)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("3");
                    else
                        textField.setText(textField.getText() + "3");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
              
                else if (e.getSource() == b4)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("4");
                    else
                        textField.setText(textField.getText() + "4");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
              
                else if (e.getSource() == b5)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("5");
                    else
                        textField.setText(textField.getText() + "5");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
              
                else if (e.getSource() == b6)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("6");
                    else
                        textField.setText(textField.getText() + "6");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
            
                else if (e.getSource() == b7)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("7");
                    else
                        textField.setText(textField.getText() + "7");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
            
                else if (e.getSource() == b8)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("8");
                    else
                        textField.setText(textField.getText() + "8");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
            
                else if (e.getSource() == b9)
                {
                    if (isEqualClicked == true || textField.getText().equals("0"))
                        textField.setText("9");
                    else
                        textField.setText(textField.getText() + "9");

                    isEqualClicked = false;
                    isTextChanged = true;
                    noClickedOperator = true;
                }
         
                else if (e.getSource() == comma)
                {
                    if (isEqualClicked == true || textField.getText().isEmpty())
                        textField.setText("0.");
                    else if (!textField.getText().contains("."))
                        textField.setText(textField.getText() + ".");

                    isEqualClicked = false;
                    isTextChanged = true;
                }
           
                else if (e.getSource() == plus && noClickedOperator == true)
                {
               
                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }
               
                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 0;
                            }
                      
                            else {
                                num = Double.parseDouble(textField.getText());
                            }

         
                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 1;
                                oldAnswer = 0;
                            }
                            
                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }


                            calculateOldAnswer();
                            operandLabel.setText("+");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");

                            operation = 1;
                        }
                        
                        catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }
                    
                    isTextChanged = false;
                    noClickedOperator = false;
                }
                
                else if (e.getSource() == minus && noClickedOperator == true)
                {
                	
                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }
                    
                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 0;
                            }
                            
                            else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 2;
                                oldAnswer = 0;
                            }

                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }


                            calculateOldAnswer();
                            operandLabel.setText("-");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");


                            operation = 2;
                        }
                        catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                }

                else if (e.getSource() == multiple && noClickedOperator == true)
                {

                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }

                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 1;
                            }

                            else {
                                num = Double.parseDouble(textField.getText());
                            }


                            if (oldValueLabel.getText().isEmpty()) {
                                operation = 3;
                                oldAnswer = 1;
                            }

                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                            }


                            calculateOldAnswer();
                            operandLabel.setText("×");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");


                            operation = 3;
                        }
                        catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }

                    isTextChanged = false;
                    noClickedOperator = false;
                }

                else if (e.getSource() == divide && noClickedOperator == true)
                {

                    if (textField.getText().equals("0") && operandLabel.getText().equals("÷"))
                    {
                        textField.setText("cannot divide by 0");
                    }

                    else if (isTextChanged == true || oldValueLabel.getText().isEmpty())
                    {
                        try {

                            if (textField.getText().isEmpty()) {
                                num = 1;
                            }

                            else {
                                num = Double.parseDouble(textField.getText());
                            }

                            if (oldValueLabel.getText().isEmpty()) {
                                oldAnswer = num;
                            }
                            else {
                                oldAnswer = Double.parseDouble(oldValueLabel.getText());
                                calculateOldAnswer();
                            }


                            operandLabel.setText("÷");
                            oldValueLabel.setText(format.format(oldAnswer));
                            textField.setText("");


                            operation = 4;
                        } catch (Exception ex) {
                            textField.setText("Error");
                        }
                    }
                    isTextChanged = false;
                    noClickedOperator = false;
                }
                else if (e.getSource() == equal)
                {
                    if (!textField.getText().isEmpty() && !oldValueLabel.getText().isEmpty() && isEqualClicked == false)
                    {
                        double a = Double.parseDouble(oldValueLabel.getText());
                        double b = Double.parseDouble(textField.getText());
                        char operand = operandLabel.getText().charAt(0);

                        switch (operand) {
                            case '+':
                                answer = a + b;
                                textField.setText(format.format(answer));
                                break;

                            case '-':
                                answer = a - b;
                                textField.setText(format.format(answer));
                                break;

                            case '×':
                                answer = a * b;
                                textField.setText(format.format(answer));
                                break;

                            case '÷':
                                if (b == 0) {
                                    textField.setText("cannot divide by 0");
                                } else {
                                    answer = a / b;
                                    textField.setText(format.format(answer));
                                }
                                break;
                        }
                    }
                    else if (textField.getText().isEmpty() && !oldValueLabel.getText().isEmpty()) {
                        textField.setText(oldValueLabel.getText());
                    }

                    oldValueLabel.setText("");
                    operandLabel.setText("");

                    isEqualClicked = true;
                    noClickedOperator = true;
                }
                else if (e.getSource() == back)
                {
                    if (textField.getText().equals("Error") || textField.getText().equals("cannot divide by 0"))
                    {
                        textField.setText("");
                    }
                    else if (!textField.getText().isEmpty())
                    {
                        textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                    }
                }
                
                else if (e.getSource() == clear)
                {
                    oldValueLabel.setText("");
                    textField.setText("");
                    operandLabel.setText("");
                    oldAnswer = 0;
                    num = 0;
                    noClickedOperator = true;
                }
            }
        });

        b0.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b2.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b3.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b4.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b5.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b6.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b7.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b8.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        b9.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        comma.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        plus.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        multiple.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        divide.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        minus.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        equal.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        clear.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        
        
        Pane root = new Pane();
        
        root.setStyle("-fx-background-color: #222;");

        root.getChildren().add(b0);
        root.getChildren().add(b1);
        root.getChildren().add(b2);
        root.getChildren().add(b3);
        root.getChildren().add(b4);
        root.getChildren().add(b5);
        root.getChildren().add(b6);
        root.getChildren().add(b7);
        root.getChildren().add(b8);
        root.getChildren().add(b9);
        root.getChildren().add(comma);
        root.getChildren().add(equal);
        root.getChildren().add(plus);
        root.getChildren().add(multiple);
        root.getChildren().add(minus);
        root.getChildren().add(divide);
        root.getChildren().add(clear);
        root.getChildren().add(back);
        root.getChildren().add(textField);
        root.getChildren().add(oldValueLabel);
        root.getChildren().add(operandLabel);

        Scene scene = new Scene(root, 257, 270);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
