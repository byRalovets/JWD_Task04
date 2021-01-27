package by.ralovets.epamcourse.server.service.command;

import by.ralovets.epamcourse.common.beans.text.Text;

public interface Command {

    String execute(Text text, Object additional);
}
