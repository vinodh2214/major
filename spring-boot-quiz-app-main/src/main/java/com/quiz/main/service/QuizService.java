package com.quiz.main.service;


import com.quiz.main.model.Question;
import com.quiz.main.model.QuestionForm;
import com.quiz.main.model.Result;
import com.quiz.main.repository.QuestionRepo;
import com.quiz.main.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

	@Autowired
	private QuestionRepo qRepo;
	@Autowired
	private ResultRepo rRepo;

	public QuestionForm getQuestion() {
		List<Question> allQues = qRepo.findAll();
		QuestionForm qForm = new QuestionForm();
		qForm.setQuestion(allQues);
		return qForm;
	}

	public int getResult(QuestionForm qForm) {
		int correct = 0;
		for (Question q : qForm.getQuestion()) {
			if (q.getAns() == q.getChose()) {
				correct++;
			}
		}
		return correct;
	}

	public void saveScore(Result result) {
		rRepo.save(result);
	}

	public List<Result> getTopScore() {
		return rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
	}
}
