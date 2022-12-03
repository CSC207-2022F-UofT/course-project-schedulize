package dashboard_ui;

import UI.CentralWindow;
import UI.CurriculumDependentWindow;
import UI.WindowManager;
import use_cases.create_curriculum.CreateCurriculumController;
import use_cases.create_curriculum.DashboardUiInterface;
import use_cases.display_curriculums.CurriculumsModel;
import use_cases.display_curriculums.DisplayCurriculumsController;
import use_cases.display_curriculums.DisplayCurriculumsInterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * A class that contains the GUI for the dashboard menu
 * Created: 11/28/2022
 * Last updated: 12/01/2022
 *
 * @author Oswin Gan
 */

public class DashboardUI extends CentralWindow implements DisplayCurriculumsInterface, DashboardUiInterface {
    private JTextField curriculumName;
    private JList<String> curriculumList;
    private JButton createButton;
    private JLabel curriculumLabel;
    private JPanel Dashboard;
    private JTextField curriculumIdField;
    private JButton loadCurriculumButton;
    private final WindowManager programWindows;
    private final DisplayCurriculumsController displayerController;
    private final CreateCurriculumController createCurriculumController;

    /**
     * Default constructor for dashboard UI window
     *
     * @param existingWindows The previously existing WindowManager
     * @param displayerController The controller to set up Curriculum view
     * @param createCurriculumController the controller to create new curriculums
     */
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

    /**
     * Sets default aspects of the Jframe window, like size and title
     */
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

    /**
     * Sets action listeners for this window
     */
    private void setListeners() {
        this.newCurriculumListener();
        this.loadCurriculumListener();
    }

    /**
     * Action listener for button clicked that creates a new curriculum using the name entered into the
     * curriculumName text field
     */
    public void newCurriculumListener() {
        this.createButton.addActionListener(actionEvent -> {
            createCurriculumController.createCurriculum(curriculumName.getText());
            this.displayerController.openDashboard();
        });
    }

    /**
     * Loads the existing curriculum associated with the id entered into the curriculumIdField text field
     */
    public void loadCurriculumListener() {
        this.loadCurriculumButton.addActionListener(actionEvent -> {
            CurriculumDependentWindow taskTreeUI = (CurriculumDependentWindow) this.programWindows.getWindow(WindowManager.TASKTREE_REFERENCE_KEY);
            taskTreeUI.setCurriculumID(Integer.parseInt(curriculumIdField.getText()));
            this.programWindows.closeWindow(WindowManager.DASHBOARD_REFERENCE_KEY);
            this.programWindows.openWindow(WindowManager.TASKTREE_REFERENCE_KEY);
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

    // TODO: Open time block manager UI

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

    @Override
    public void createdCurriculum(String message) {
        return;
        // TODO: Implement a message of successful creation later
    }
}
