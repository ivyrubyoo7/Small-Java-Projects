import javax.swing.*;
import java.awt.event.*;

public class TaskUI {

    TaskService service = new TaskService();

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> taskList = new JList<>(listModel);

    public TaskUI() {

        JFrame frame = new JFrame("Task Manager");

        JTextField titleField = new JTextField();
        titleField.setBounds(50, 30, 200, 30);

        String[] priorities = {"High", "Medium", "Low"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);
        priorityBox.setBounds(260, 30, 100, 30);

        JButton addBtn = new JButton("Add Task");
        addBtn.setBounds(50, 80, 120, 30);

        JButton completeBtn = new JButton("Mark Complete");
        completeBtn.setBounds(180, 80, 150, 30);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(50, 130, 310, 150);

        JLabel message = new JLabel("");
        message.setBounds(50, 300, 300, 30);

        // Add Task
        addBtn.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String priority = (String) priorityBox.getSelectedItem();

                service.addTask(title, priority);
                updateList();
                titleField.setText("");

            } catch (Exception ex) {
                message.setText("Error: " + ex.getMessage());
            }
        });

        // Mark Complete
        completeBtn.addActionListener(e -> {
            try {
                int index = taskList.getSelectedIndex();
                service.markComplete(index);
                updateList();
            } catch (Exception ex) {
                message.setText("Error: " + ex.getMessage());
            }
        });

        frame.add(titleField);
        frame.add(priorityBox);
        frame.add(addBtn);
        frame.add(completeBtn);
        frame.add(scrollPane);
        frame.add(message);

        frame.setSize(420, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void updateList() {
        listModel.clear();
        for (Task t : service.getTasks()) {
            listModel.addElement(t.toString());
        }
    }
}