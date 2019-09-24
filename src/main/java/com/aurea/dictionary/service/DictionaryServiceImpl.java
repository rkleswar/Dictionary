package com.aurea.dictionary.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.aurea.dictionary.constants.ErrorMessages;
import com.aurea.dictionary.exception.RequestViolationException;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	List<String> dictionaryList = Arrays.asList(new String[] { "TOP", "POTA" });
	Set<String> allPermititaions = null;

	public List<String> getSimilarWods(String word) {
		if (word != null && word.length() > 1) {
			allPermititaions = new HashSet<>();
			synchronized (allPermititaions) {
				permute(word, 0, word.length() - 1);
				return findDictionaryWords(allPermititaions);
			}
		} else {
			throw new RequestViolationException(ErrorMessages.WORD_IS_EMPTY.getValue());
		}
	}

	private List<String> findDictionaryWords(Set<String> allPermititaions) {
		ArrayList<String> machedWords = new ArrayList<String>();
		for (String word : allPermititaions) {
//			if (dictionaryList.contains(word)) {
//				machedWords.add(word);
//			}
			for (String dictionaryWord : dictionaryList) {
				if (dictionaryWord.indexOf(word) == 0) {
					machedWords.add(dictionaryWord);
				}
			}
		}
		return machedWords;
	}

	private void permute(String word, int l, int r) {
		if (l == r) {
			allPermititaions.add(word);
		} else {
			for (int i = l; i <= r; i++) {
				word = swap(word, l, i);
				permute(word, l + 1, r);
				word = swap(word, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
