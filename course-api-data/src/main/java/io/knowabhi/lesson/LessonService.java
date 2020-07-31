package io.knowabhi.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> lesson = new ArrayList<>();
		
		lessonRepository.findByCourseId(courseId)
		.forEach(lesson::add);
		
		return lesson;
	}
	
	public Optional<Lesson> getLesson(String id) {
		return lessonRepository.findById(id);
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);	
	}
}
