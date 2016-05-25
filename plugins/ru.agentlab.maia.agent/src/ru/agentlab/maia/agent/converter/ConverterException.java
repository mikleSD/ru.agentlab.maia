package ru.agentlab.maia.agent.converter;

public class ConverterException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConverterException() {
		super();
	}

	public ConverterException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConverterException(String message) {
		super(message);
	}

	public ConverterException(Throwable cause) {
		super(cause);
	}

}
