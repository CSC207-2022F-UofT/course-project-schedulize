package tasktree_UI;

import UI.CentralWindow;
import UI.TaskDependentWindow;

import javax.swing.*;

public class TaskTreeUI extends CentralWindow implements TaskDependentWindow {
 private JTree taskTree;
 private JPanel mainPanel;
 private int displayId;

 public TaskTreeUI() {
  this.configureFrame();
  this.treeSetUp(displayId);
  this.centreWindow();
 }

 private void configureFrame() {
  // set Frame title
  this.setTitle("Schedulize Login");
  // set Frame window size
  this.setSize(350, 300);
  // disable resizability
  this.setResizable(false);
  // set content, configured in form file
  this.setContentPane(mainPanel);
 }

 private void treeSetUp(int displayId) {

 }

 @Override
 public void setVisible(boolean b) {
  this.treeSetUp(this.displayId);
 }

 @Override
 public void setWindowID(int id) {
  this.displayId = id;
 }

 public static void main(String[] args){
  JFrame ui = new TaskTreeUI();
  ui.setVisible(true);
//       JFrame frame = new JFrame("Curriculum Tasks");
//       frame.setSize (500, 500);
//
//       //Making a root node
//
//        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Curriculum");
//
//        DefaultMutableTreeNode X = new DefaultMutableTreeNode("X");
//        DefaultMutableTreeNode Y = new DefaultMutableTreeNode("Y");
//
//        DefaultMutableTreeNode X1 = new DefaultMutableTreeNode("X1");
//        DefaultMutableTreeNode X2 = new DefaultMutableTreeNode("X2");
//
//        DefaultMutableTreeNode Y1 = new DefaultMutableTreeNode("Y1");
//        DefaultMutableTreeNode Y2 = new DefaultMutableTreeNode("Y2");
//        DefaultMutableTreeNode Y3 = new DefaultMutableTreeNode("Y3");
//
//        X.add(X1);
//        X.add(X2);
//
//        Y.add(Y1);
//        Y.add(Y2);
//        Y.add(Y3);
//
//        //State the root nodes
//        rootNode.add(X);
//        rootNode.add(Y);
//
//        JTree tree = new JTree (rootNode);
//        frame.add(tree);
//        frame.setVisible(true);
    }
}

