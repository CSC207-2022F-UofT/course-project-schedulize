package tasktree_UI;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
public class TaskTreeUI  {
    public static void main(String[] args){
       JFrame frame = new JFrame("Curriculum Tasks");
       frame.setSize (500, 500);

       //Making a root node

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Curriculum");

        DefaultMutableTreeNode X = new DefaultMutableTreeNode("X");
        DefaultMutableTreeNode Y = new DefaultMutableTreeNode("Y");

        DefaultMutableTreeNode X1 = new DefaultMutableTreeNode("X1");
        DefaultMutableTreeNode X2 = new DefaultMutableTreeNode("X2");

        DefaultMutableTreeNode Y1 = new DefaultMutableTreeNode("Y1");
        DefaultMutableTreeNode Y2 = new DefaultMutableTreeNode("Y2");
        DefaultMutableTreeNode Y3 = new DefaultMutableTreeNode("Y3");

        X.add(X1);
        X.add(X2);

        Y.add(Y1);
        Y.add(Y2);
        Y.add(Y3);

        //State the root nodes
        rootNode.add(X);
        rootNode.add(Y);

        JTree tree = new JTree (rootNode);
        frame.add(tree);
        frame.setVisible(true);
    }
}

