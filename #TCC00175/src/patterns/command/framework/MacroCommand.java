package patterns.command.framework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MacroCommand extends Command {

    public List<Command> commands = new LinkedList<Command>();
    private Stack<Command> clones = null;

    @Override
    public void execute() {
        clones = new Stack<Command>();
        Iterator<Command> lc = commands.iterator();

        while (lc.hasNext())
            lc.next().execute();

        for (Command ct : commands) {
            ct.execute();
            try {
                clones.push((Command) ct.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(MacroCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void desfazer() {
        while (!clones.isEmpty())
            clones.pop().desfazer();
    }
}
