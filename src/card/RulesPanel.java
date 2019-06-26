package card;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class RulesPanel extends JPanel {
//	private String rules;
	private JTextPane jtp;
	
	private String wrapString(String s, String deliminator, int length) {
	    String result = "";
	    int lastdelimPos = 0;
	    for (String token : s.split(" ", -1)) {
	        if (result.length() - lastdelimPos + token.length() > length) {
	            result = result + deliminator + token;
	            lastdelimPos = result.length() + 1;
	        }
	        else {
	            result += (result.isEmpty() ? "" : " ") + token;
	        }
	    }
	    return result;
	}
	
	public RulesPanel(String rules, String flavor, CardColor color, boolean land) {
		super();
//		String rulesWrapped = wrapString(rules.replace("|", " <br>"), "<br>", 40);
//		String flavorWrapped = wrapString(flavor.replace("|", " <br>"), "<br>", 40);
		String rulesWrapped;
		if (land) {
			rulesWrapped = "{BIG ASS SKULL}";
		} else {
			rulesWrapped = wrapString(rules.replace("|", "\n"), "\n", 40).replace("\n", "<br>");
		}
		String flavorWrapped = wrapString(flavor.replace("|", "\n"), "\n", 40).replace("\n", "<br>");
		
		JTextPane jtp = new JTextPane();
		jtp.setSize(new Dimension(7,10));
		jtp.setContentType("text/html");
		jtp.setText(("<html>" + rulesWrapped + "<i><br><br>" + flavorWrapped + "</i></html>").replace("(", "<i>(").replace(")", ")</i>"));
		jtp.setEditable(false);
		jtp.setOpaque(true);
		
		Color backing = color.mutedHue();
		jtp.setBackground(backing);
		
		JScrollPane jsp = new JScrollPane(jtp);
		
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setPreferredSize(new Dimension(300, 150));
		
		add(jsp);
	}
}
