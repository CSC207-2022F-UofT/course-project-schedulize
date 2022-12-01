package dashboard_ui;

import entity_factories.CurriculumFactory;

import javax.swing.*;

public class DashboardUI {
    private JTextField curriculumName;
    private JList curriculumList;
    private JButton createButton;
    private JLabel curriculumLabel;
    private JPanel Dashboard;

    private void setListeners() {
        this.newCurriculumListener();
    }

    public void setCurriculumName(JTextField curriculumName) {
        this.curriculumName = curriculumName;
    }

    public void newCurriculumListener(){
        this.createButton.addActionListener(actionEvent -> {

        });
    }
}
