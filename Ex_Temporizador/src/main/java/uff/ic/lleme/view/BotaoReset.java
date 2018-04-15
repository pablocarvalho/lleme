package uff.ic.lleme.view;

import java.awt.event.ActionEvent;

import uff.ic.lleme.model.Temporizador;
import uff.ic.lleme.controller.Command;
import uff.ic.lleme.controller.ResetCommand;

public class BotaoReset extends BotaoTemp {

    private static final long serialVersionUID = -1842445485507380512L;
    private Command tempCommand = null;

    public BotaoReset(Temporizador temporizador) {
        super("Reset", temporizador);
        tempCommand = new ResetCommand(temporizador);
    }

    public void actionPerformed(ActionEvent e) {
        e.getActionCommand();
        tempCommand.execute();
    }

    public void accept(Visitor visitor) {
        visitor.VisitBotaoReset(this);
    }
}
