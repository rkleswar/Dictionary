package com.aurea.dictionary.constants;

public enum ErrorMessages {
	
	WORD_IS_EMPTY("Please enter atleast 2 character word");
	
	private String value;

    private ErrorMessages(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
}

