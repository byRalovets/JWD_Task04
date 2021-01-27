package by.ralovets.epamcourse.common.beans.request;

import by.ralovets.epamcourse.common.beans.text.Text;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private Text text;
    private String commandId;

    private List<String> params;

    public Request() {
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 31 * result + text.hashCode();
        result = 31 * result + commandId.hashCode();
        result = 31 * result + params.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Request)) {
            return false;
        }

        Request request = (Request) obj;

        return request.text.equals(text)
                && request.commandId == commandId
                && request.params.equals(params);
    }

    @Override
    public String toString() {
        return "{"
                + text.toString()
                + "\n}"
                + commandId
                + params.toString();
    }
}
