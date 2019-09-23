package br.com.smartfull;

import org.panda_lang.pandomium.Pandomium;
import org.panda_lang.pandomium.settings.PandomiumSettings;
import org.panda_lang.pandomium.wrapper.PandomiumBrowser;
import org.panda_lang.pandomium.wrapper.PandomiumClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SpringBootApplication
public class SpringApp {

    public static Dimension redimensionarFrameTotal() {
        return (new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
    }

    public static void main(String[] args) {
        PandomiumSettings settings = PandomiumSettings.getDefaultSettingsBuilder().build();
        settings.getCefSettings().log_file = "Pandomium.log";
        Pandomium pandomium = new Pandomium(settings);
        pandomium.initialize();
        PandomiumClient client = pandomium.createClient();
        PandomiumBrowser browser = client.loadURL("http://localhost:9090/index.xhtml");
        final JFrame frame = new JFrame();
        frame.getContentPane().add(browser.toAWTComponent(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
        frame.setTitle("SpringBootJsfPandomium");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension dimension = redimensionarFrameTotal();
        frame.setSize(dimension);
        SpringApplication.run(SpringApp.class, args);
        frame.setVisible(true);
    }
}
