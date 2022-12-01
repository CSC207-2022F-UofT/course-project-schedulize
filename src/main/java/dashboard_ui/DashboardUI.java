package dashboard_ui;

import UI.CentralWindow;
import entity_factories.CurriculumFactory;
import entity_layer.Curriculum;
import use_cases.display_curriculums.CurriculumsModel;
import use_cases.display_curriculums.DisplayCurriculumsInterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class DashboardUI extends CentralWindow implements DisplayCurriculumsInterface {
    private JTextField curriculumName;
    private JList<String> curriculumList;
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

    @Override
    public void displayCurriculums(CurriculumsModel curriculumsModel) {
        List<String> curriculums = new ArrayList<>();
        Map<Integer, String> curriculumsMap = curriculumsModel.getCurriculums();
        for (Integer id : curriculumsMap.keySet()) {
            curriculums.add(String.format("%s (i.d. %s)", curriculumsMap.get(id), id));
        }
        Vector<String> curriculumsVector = new Vector<>(curriculums);
        this.curriculumList.setListData(curriculumsVector);
    }
}
