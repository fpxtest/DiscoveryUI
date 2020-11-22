package com.nepxion.discovery.console.desktop.workspace.panel;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.nepxion.discovery.console.desktop.common.locale.ConsoleLocaleFactory;
import com.nepxion.swing.label.JBasicLabel;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.textfield.JBasicTextField;

public class PreviewPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    protected static PreviewPanel previewPanel;

    public static PreviewPanel getInstance() {
        if (previewPanel == null) {
            previewPanel = new PreviewPanel();
        }

        return previewPanel;
    }

    protected JBasicTextField keyTextField;
    protected JBasicTextArea configTextArea;

    private PreviewPanel() {
        keyTextField = new JBasicTextField();
        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new BorderLayout(10, 0));
        keyPanel.add(new JBasicLabel(ConsoleLocaleFactory.getString("preview_key_text")), BorderLayout.WEST);
        keyPanel.add(keyTextField, BorderLayout.CENTER);

        configTextArea = new JBasicTextArea();
        JPanel configPanel = new JPanel();
        configPanel.setLayout(new BorderLayout());
        configPanel.add(new JBasicLabel(ConsoleLocaleFactory.getString("preview_config_text")), BorderLayout.NORTH);
        configPanel.add(new JBasicScrollPane(configTextArea), BorderLayout.CENTER);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 400));
        add(keyPanel, BorderLayout.NORTH);
        add(configPanel, BorderLayout.CENTER);
    }

    public void setKey(String key) {
        keyTextField.setText(key);
    }

    public void setConfig(String config) {
        configTextArea.setText(config);
    }

    public String getConfig() {
        return configTextArea.getText().trim();
    }
}