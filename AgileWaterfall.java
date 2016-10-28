package com.wolfe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Jeremy on 10/28/2016.
 */
public class AgileWaterfall extends JFrame {
    private JPanel rootPanel;
    private JCheckBox checkBoxSchedulesCheckBox;
    private JCheckBox checkBoxTestingCheckBox;
    private JCheckBox checkBoxQCReqsCheckBox;
    private JCheckBox checkBoxIntegrationCheckBox;
    private JCheckBox checkBoxModelsCheckBox;
    private JButton clickToProcessInputButton;
    private JTextField inputNumberTextField;
    private JTextField enterProjectNameHereTextField;
    private JTextField recommendationShownHereTextField;

    private boolean schedulesCB;
    private boolean testingCB;
    private boolean qcRequirementsCB;
    private boolean integrationCB;
    private boolean modelsCB;

    public AgileWaterfall() {

        super("Agile Waterfall Computer");
        setContentPane(rootPanel);
        pack();
        setSize(new Dimension(950, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        checkBoxSchedulesCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                schedulesCB = checkBoxSchedulesCheckBox.isSelected();
            }
        });

        checkBoxTestingCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                testingCB = checkBoxTestingCheckBox.isSelected();
            }
        });

        checkBoxQCReqsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                qcRequirementsCB = checkBoxQCReqsCheckBox.isSelected();
            }
        });

        checkBoxIntegrationCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                integrationCB = checkBoxIntegrationCheckBox.isSelected();
            }
        });

        checkBoxModelsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                modelsCB = checkBoxModelsCheckBox.isSelected();
            }
        });

        clickToProcessInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String projectName = enterProjectNameHereTextField.getText();

                String stringProgs = inputNumberTextField.getText();
                int numProgs = Integer.parseInt(stringProgs);

                String result = agileOrWaterfall(numProgs, schedulesCB, testingCB,
                                                 qcRequirementsCB, integrationCB, modelsCB);

                recommendationShownHereTextField.setText(projectName + ": " + result);

            }
        });
    }


    private static String agileOrWaterfall(int programmers, boolean deadlines,
                                           boolean programmerExperience, boolean qualityControl,
                                           boolean integration, boolean earlyModels) {
        int agile = 0;
        int waterfall = 0;

        if (programmers > 10) {
            waterfall += 1;
        } else {
            agile += 1;
        }

        if (deadlines) {
            waterfall += 1;
        } else {
            agile += 1;
        }

        if (programmerExperience) {
            agile += 1;
        } else {
            waterfall += 1;
        }

        if (qualityControl) {
            waterfall += 1;
        } else {
            agile += 1;
        }

        if (integration) {
            agile += 1;
        } else {
            waterfall += 1;
        }

        if (earlyModels) {
            agile += 1;
        } else {
            waterfall += 1;
        }

        if (waterfall > agile) {
            return "The Waterfall methodology would be best for this project. Waterfall score: " + waterfall;
        } else if (waterfall == agile) {
            return "Either methodology would work for this project. Waterfall/Agile scores: " + waterfall + "/" + agile;
        } else { // waterfall < agile
            return "The Agile methodology would be best for this project. Agile score: " + agile;
        }
    }

}
