package dashboard_ui;

import UI.CentralWindow;
import UI.WindowManager;
import use_cases.create_curriculum.CreateCurriculumController;
import use_cases.display_curriculums.CurriculumsModel;
import use_cases.display_curriculums.DisplayCurriculumsController;
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
    private JTextField textField1;
    private JButton loadCurriculumButton;
    private final WindowManager programWindows;
    private final DisplayCurriculumsController displayerController;
    private final CreateCurriculumController createCurriculumController;

    public DashboardUI(WindowManager existingWindows, DisplayCurriculumsController displayerController,
                       CreateCurriculumController createCurriculumController) {
        this.displayerController = displayerController;
        this.createCurriculumController = createCurriculumController;
        this.programWindows = existingWindows;
        programWindows.addWindow(WindowManager.DASHBOARD_REFERENCE_KEY, this);
        this.configureFrame();
        this.centreWindow();
        this.setListeners();
    }

    private void configureFrame() {
        // set Frame title
        this.setTitle("Dashboard");
        // set Frame window size
        this.setSize(600, 400);
        // disable resizability
        this.setResizable(false);
        // set close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set content, configured in form file
        this.setContentPane(Dashboard);
        // centres window
        this.centreWindow();
    }

    private void setListeners() {
        this.newCurriculumListener();
    }

    public void newCurriculumListener() {
        this.createButton.addActionListener(actionEvent -> {
            createCurriculumController.createCurriculum(curriculumName.getText());
            this.displayerController.openDashboard();
        });
    }

    public void loadCurriculumListener() {
        this.loadCurriculumButton.addActionListener(actionEvent -> {
            // TODO: Tie this to Aayush's TaskTreeUI
        });
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        this.curriculumName.setText("");
        this.displayerController.openDashboard();
        // recenter the window
        this.centreWindow();
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
