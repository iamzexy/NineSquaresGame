package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

import java.awt.*;

class Controller {
    @FXML
    private ToggleButton b11;
    @FXML
    private Button b12;
    @FXML
    private Button b13;
    @FXML
    private Button b21;
    @FXML
    private Button b22;
    @FXML
    private Button b23;
    @FXML
    private Button b31;
    @FXML
    private Button b32;
    @FXML
    private Button b33;
    @FXML
    private Label labelWon;

    private Background defaultBg
    private Background litBg

    {
        defaultBg = new Background(new BackgroundFill(Paint.valueOf("0x039ed322"), null, null))
        litBg = new Background(new BackgroundFill(Paint.valueOf("BLUE"), null, null))
    }

    void pressButton(ActionEvent e) {
        changeColor(b11);
        changeColor(b12);
        changeColor(b21);
//        b11.setBackground(new Background(new BackgroundFill(Paint.valueOf("BLUE"), null, null)));
//        b12.setBackground(new Background(new BackgroundFill(Paint.valueOf("BLUE"), null, null)));
//        b21.setBackground(new Background(new BackgroundFill(Paint.valueOf("BLUE"), null, null)));
    }
    void won(ActionEvent e) {
        labelWon.setVisible(true);
    }
    void changeColor(Button b) {
        if (b.getBackground().getFills().size()>1) {
            b.setBackground(litBg)
        } else {
            b.setBackground(defaultBg)
        }
    }
}
