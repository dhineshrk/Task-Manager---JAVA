// Memento Class
class Memento {
    private String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator Class
class TextEditor {
    private String text;

    public void write(String text) {
        this.text = text;
        System.out.println("TextEditor: Writing text: " + text);
    }

    public String getText() {
        return text;
    }

    // Create a Memento containing the current state of the text
    public Memento save() {
        System.out.println("TextEditor: Saving state...");
        return new Memento(text);
    }

    // Restore the state from the Memento
    public void restore(Memento memento) {
        text = memento.getText();
        System.out.println("TextEditor: Restoring state: " + text);
    }
}

// Caretaker Class
class Caretaker {
    private Memento memento;

    public void saveMemento(Memento memento) {
        this.memento = memento;
        System.out.println("Caretaker: Memento saved.");
    }

    public Memento getMemento() {
        return memento;
    }
}

// Client Code
public class MementoPattern {
    public static void main(String[] args) {
        // Create a TextEditor instance
        TextEditor editor = new TextEditor();
        
        // Write text and save the state
        editor.write("Hello, world!");
        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(editor.save()); // Save current state
        
        // Write more text and save again
        editor.write("Hello, Memento Pattern!");
        caretaker.saveMemento(editor.save()); // Save the new state
        
        // Restore the previous state
        editor.restore(caretaker.getMemento()); // Restore the first saved state
    }
}
