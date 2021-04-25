package org.bsuir.view;

import org.bsuir.view.border.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class PageComponentsBuilder {
    public static final int DEFAULT_AMOUNT_OF_NOTES_ON_THE_TABLE = 10;
    public static final String ICON_LOCATION = "src/main/resources/icons/";
    public static final String ICON_EXPANSION = ".png";
    public static final int AMOUNT_OF_LABELS = 4;
    public static final int AMOUNT_OF_BUTTONS = 4;

    private final JLabel[] labelItems;
    private final JButton[] buttonItems;
    private final JSpinner pageSpinner;

    public PageComponentsBuilder(){
        labelItems = new JLabel[AMOUNT_OF_LABELS];
        buttonItems = new JButton[AMOUNT_OF_BUTTONS];

        addJLabels();
        addJButtons();

        SpinnerModel value = new SpinnerNumberModel(DEFAULT_AMOUNT_OF_NOTES_ON_THE_TABLE, 1, 100, 1);
        pageSpinner = new JSpinner(value);
        pageSpinner.setMaximumSize(new Dimension(30, 30));
    }

    private void addJButtons() {
        JButton firstPageButton = new JButton("First page");
        JButton lastPageButton = new JButton("Last page");
        JButton previousPageButton = new JButton();
        JButton nextPageButton = new JButton();

        firstPageButton.setForeground(Color.BLACK);
        firstPageButton.setBackground(Color.WHITE);

        lastPageButton.setForeground(Color.BLACK);
        lastPageButton.setBackground(Color.WHITE);

        previousPageButton.setForeground(Color.BLACK);
        previousPageButton.setBackground(Color.WHITE);

        nextPageButton.setForeground(Color.BLACK);
        nextPageButton.setBackground(Color.WHITE);



        firstPageButton.setBorder(new RoundedBorder(5));
        lastPageButton.setBorder(new RoundedBorder(5));
        previousPageButton.setBorder(new RoundedBorder(5));
        nextPageButton.setBorder(new RoundedBorder(5));


        previousPageButton.setIcon(new ImageIcon(ICON_LOCATION + "arrow_0" + ICON_EXPANSION));
        nextPageButton.setIcon(new ImageIcon(ICON_LOCATION + "arrow_1" + ICON_EXPANSION));

        nextPageButton.setMargin(new Insets(0, 0, 0, 0));
        previousPageButton.setMargin(new Insets(0, 0, 0, 0));

        buttonItems[0] = firstPageButton;
        buttonItems[1] = previousPageButton;
        buttonItems[2] = nextPageButton;
        buttonItems[3] = lastPageButton;
    }

    private void addJLabels() {
        JLabel chooseAmountOfNotesOnTable = new JLabel("Choose record count");
        JLabel pageCountLabel = new JLabel("Page count: 1");
        JLabel AmountOfPatientsLabel = new JLabel("Total record counter: 0");
        JLabel currentPageLabel = new JLabel("1");

        labelItems[0] = chooseAmountOfNotesOnTable;
        labelItems[1] = pageCountLabel;
        labelItems[2] = AmountOfPatientsLabel;
        labelItems[3] = currentPageLabel;
    }
    /**
     * <br>[0] first page button</br>
     * <br>[1] previous page button</br>
     * <br>[2] next page button</br>
     * <br>[3] last page button</br>
     */
    public JButton[] getButtonItems() {
        return buttonItems;
    }

    /**
     * <br>[0] amount of notes on the table</br>
     * <br>[1] amount of pages</br>
     * <br>[2] amount of patients</br>
     * <br>[3] current page</br>
     */
    public JLabel[] getLabelItems() {
        return labelItems;
    }

    public JSpinner getPageSpinner() {
        return pageSpinner;
    }
}
