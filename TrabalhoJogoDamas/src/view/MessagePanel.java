package view;

import javax.swing.*;

@SuppressWarnings("serial")
public class MessagePanel extends JPanel{
  protected JTextArea textArea;
  JScrollPane scrollPane;
  
  public MessagePanel() {
    this.textArea = new JTextArea(5, 20);
    this.textArea.setEditable(false);
    this.scrollPane = new JScrollPane(textArea);

    add(scrollPane);  
  }
  public void addMensagem(String msg) {
    this.textArea.append(msg+"\n");
    textArea.setCaretPosition(textArea.getDocument().getLength());
  }
}
