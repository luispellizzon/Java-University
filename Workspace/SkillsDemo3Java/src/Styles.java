
public class Styles {
	/*ASCII COLORS AND STYLES*/
	public static final String BLACK_BOLD = "\033[1;30m";
	public static final String UNDERLINE = "\033[4;30m";
	public static final String ERROR_MESSAGE_COLOR = "\u001B[31m";
	public static final String PURPLE_BOLD = "\033[1;35m";
	
	/*AFTER USING AN STYLE TO CHANGE THE OUTPUT
	 * IN THE CONSOLE, WE MUST USE A RESET ASCII CODE
	 * TO RESET BACK TO DEFAULT, OTHERWISE THE WHOLE OUTPUT
	 * WILL HAVE THE SAME COLOR, FONT OR ANY LAST STYLE USED*/
	public static final String RESET_STYLE = "\u001B[0m";
}
