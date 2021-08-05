package sample

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.ToggleButton

class Controller {
    @FXML
    private ToggleButton b11
    @FXML
    private ToggleButton b12
    @FXML
    private ToggleButton b13
    @FXML
    private ToggleButton b21
    @FXML
    private ToggleButton b22
    @FXML
    private ToggleButton b23
    @FXML
    private ToggleButton b31
    @FXML
    private ToggleButton b32
    @FXML
    private ToggleButton b33
    @FXML
    private Label labelWon
    @FXML
    int counter
    @FXML
    private HashMap buttons


    void initialize() {
        buttons = //[b11, b12, b13, b21, b22, b23, b31, b32, b33]
        ["11" : b11,
         "12" : b12,
         "13" : b13,
         "21" : b21,
         "22" : b22,
         "23" : b23,
         "31" : b31,
         "32" : b32,
         "33" : b33]
        counter = 0
        reset()
    }
    void pressButton(ActionEvent e) {
        String buttonNumber = e.source.id.substring(1)
        int x = Character.getNumericValue(buttonNumber.charAt(0))
        int y = Character.getNumericValue(buttonNumber.charAt(1))
        String btnNum = "$x${y-1}"
        changeButton(btnNum)
        btnNum = "$x${y+1}"
        changeButton(btnNum)
        btnNum = "${x-1}$y"
        changeButton(btnNum)
        btnNum = "${x+1}$y"
        changeButton(btnNum)
        counter++
        if (checkIfWon(e))
            won(e)
    }

    void changeButton(String btnNum) {
        if (!btnNum.contains("0") && !btnNum.contains("4")) {
            def btn = buttons.get(btnNum)
            btn.isSelected() ? btn.setSelected(false) : btn.setSelected(true)
        }
    }

    void won(ActionEvent e) {
        labelWon.setText("You won! Clicks: $counter")
        labelWon.setVisible(true)
        buttons.each { k, v ->
            v.setDisable(true)
        }
    }

    boolean checkIfWon(ActionEvent e) {
        boolean isWon = true
        buttons.each { k, v ->
            v.isSelected() ?: (isWon = false)
        }
        return isWon
    }

    void reset(ActionEvent e) {
        reactivateButtons()
        labelWon.setVisible(false)
        setStartedButtons()
        counter = 0
    }

    void reactivateButtons() {
        buttons.each { k, v ->
            v.setSelected(false)
            v.setDisable(false)
        }
    }

    void setStartedButtons() {
        List keys = new ArrayList(buttons.keySet())
        keys.shuffle()
        buttons.get(keys.get(0)).setSelected(true)
        buttons.get(keys.get(1)).setSelected(true)
    }
}
