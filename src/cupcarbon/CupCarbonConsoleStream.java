package cupcarbon;
import java.io.IOException;
import java.io.OutputStream;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class CupCarbonConsoleStream extends OutputStream {
    
	private TextArea textArea ;
	private int x = 0;
	
	public CupCarbonConsoleStream(TextArea textArea) {
		this.textArea = textArea;
	}
	
    @Override
    public void write(int v) throws IOException {
    	Platform.runLater( () -> {
			if(v=='\n') {
				if(x++ > 1000) {
    				x=0;
    				textArea.clear();
    			}
			}
			textArea.appendText(String.valueOf((char) v));
			}
    	);
    }

}