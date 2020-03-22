
public class Invoker {

	private ICommand command; 
	
	
	public void setCommand(ICommand command) {
		this.command = command;
	}
	
	
	public void executeCommand () {
		command.execute();
	}
	
	public void undoCommand () {
		command.undo(); 
	}
	
	public void redoCommand () {
		command.redo();
	}
	
}
