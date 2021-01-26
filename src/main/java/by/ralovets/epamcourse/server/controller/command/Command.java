package by.ralovets.epamcourse.server.controller.command;

import by.ralovets.epamcourse.text.Text;

public interface Command {

    String perform(Text text, Object additional);
}
