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
    private List buttons


    void initialize() {
        buttons = [b11, b12, b13, b21, b22, b23, b31, b32, b33]
        reset()
    }
    void pressButton11(ActionEvent e) {
        b12.isSelected() ? b12.setSelected(false) : b12.setSelected(true)
        b21.isSelected() ? b21.setSelected(false) : b21.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton12(ActionEvent e) {
        b11.isSelected() ? b11.setSelected(false) : b11.setSelected(true)
        b13.isSelected() ? b13.setSelected(false) : b13.setSelected(true)
        b22.isSelected() ? b22.setSelected(false) : b22.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton13(ActionEvent e) {
        b12.isSelected() ? b12.setSelected(false) : b12.setSelected(true)
        b23.isSelected() ? b23.setSelected(false) : b23.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton21(ActionEvent e) {
        b11.isSelected() ? b11.setSelected(false) : b11.setSelected(true)
        b22.isSelected() ? b22.setSelected(false) : b22.setSelected(true)
        b31.isSelected() ? b31.setSelected(false) : b31.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton22(ActionEvent e) {
        b12.isSelected() ? b12.setSelected(false) : b12.setSelected(true)
        b21.isSelected() ? b21.setSelected(false) : b21.setSelected(true)
        b23.isSelected() ? b23.setSelected(false) : b23.setSelected(true)
        b32.isSelected() ? b32.setSelected(false) : b32.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton23(ActionEvent e) {
        b13.isSelected() ? b13.setSelected(false) : b13.setSelected(true)
        b22.isSelected() ? b22.setSelected(false) : b22.setSelected(true)
        b33.isSelected() ? b33.setSelected(false) : b33.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton31(ActionEvent e) {
        b21.isSelected() ? b21.setSelected(false) : b21.setSelected(true)
        b32.isSelected() ? b32.setSelected(false) : b32.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton32(ActionEvent e) {
        b31.isSelected() ? b31.setSelected(false) : b31.setSelected(true)
        b22.isSelected() ? b22.setSelected(false) : b22.setSelected(true)
        b33.isSelected() ? b33.setSelected(false) : b33.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void pressButton33(ActionEvent e) {
        b23.isSelected() ? b23.setSelected(false) : b23.setSelected(true)
        b32.isSelected() ? b32.setSelected(false) : b32.setSelected(true)
        if (checkIfWon(e))
            won(e)
    }
    void won(ActionEvent e) {
        labelWon.setVisible(true)
        buttons.forEach() {ToggleButton btn ->
            btn.setDisable(true)
        }
    }

    boolean checkIfWon(ActionEvent e) {
        boolean isWon = true
        buttons.forEach() {ToggleButton btn ->
            btn.isSelected() ?: (isWon = false)
        }
        return isWon
    }

    void reset(ActionEvent e) {
        buttons.forEach() {ToggleButton btn ->
            btn.setSelected(false)
            btn.setDisable(false)
        }
        labelWon.setVisible(false)
        def rand = new Random()
        def b1 = buttons.get(rand.nextInt(buttons.size()))
        def b2 = buttons.get(rand.nextInt(buttons.size()))
        b1.setSelected(true)
        b2.setSelected(true)
    }
}
