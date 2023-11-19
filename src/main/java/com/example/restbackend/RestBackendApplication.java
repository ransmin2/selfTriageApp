package com.example.restbackend;

import com.example.restbackend.model.Triage;
import com.example.restbackend.repository.TriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RestBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestBackendApplication.class, args);
	}

	@Component
	public class DataInitializer implements CommandLineRunner {

		@Autowired
		private TriageRepository triageRepository;

		@Override
		public void run(String... args) throws Exception {

			if (triageRepository.count() == 0) {
				String noseBleed = "I had a nosebleed episode which lasted less than 3 minutes. what should I do";
				String nosebleedAdvice = "I'm not a doctor, but if you experience a nosebleed, there are general first-aid measures you can consider:<p>" +
						"1. Stay Calm: Panicking can increase your blood pressure and can make the bleeding worse.<n>" +
						"2. Sit Up: Lean slightly forward to prevent the blood from draining down the back of your throat.<n>" +
						"3. Breathe through Your Mouth: This allows you to keep your nostrils closed for a few minutes.<n>" +
						"4. Avoid Nose Blowing: Avoid blowing your nose for several hours after the nosebleed.<p>" +
						"If you experience frequent nosebleeds, or if they last longer than 20 minutes even after applying pressure, it's a good idea to seek medical advice. <p>" +
						"Remember, always prioritize your health and safety, and consult with healthcare professionals when in doubt.";
				triageRepository.save(new Triage(noseBleed, nosebleedAdvice));
				String chestPain = "I have pain in my chest and its feeling difficult to breathe.I think its acidity. Should I go to hospital?";
				String chestPainAdvice = "I am really sorry you're feeling this way, but it's crucial that you seek emergency medical attention immediately. While I can provide information, I cannot diagnose and provide medical advice.\n" +
						"\n" +
						"Chest pain and difficulty breathing are serious symptoms that can be indicative of life-threatening conditions, including but not limited to cardiac events. Even if you suspect it's related to acidity, it's essential to have a medical professional evaluate you to rule out more severe causes.\n" +
						"\n" +
						"Please call emergency services or have someone take you to the nearest emergency room right away. It's always better to be safe and get a proper evaluation.";
				triageRepository.save(new Triage(chestPain, chestPainAdvice));
				String babySymptom = "My baby, 8 month old, has fever and cough. she is not feeding well and did not have any wet diaper since today morning. my husband is away . can i wait until tomorrow to bring her to gp ?";
				String babyAdvice = "I'm sorry to hear about your baby's condition, but I need to emphasize that I am not a medical professional. Based on the symptoms you've described, it sounds concerning. An 8-month-old baby with a fever, cough, poor feeding, and no wet diapers could be a sign of dehydration or another serious condition.\n" +
						"\n" +
						"You should not wait. It's important to seek medical attention immediately, especially for infants showing such symptoms. Please contact a healthcare professional, pediatrician, or take your baby to the nearest emergency room or urgent care center.\n" +
						"\n" +
						"Always prioritize the health and safety of your child and consult with healthcare professionals in situations like this.";
				triageRepository.save((new Triage(babySymptom, babyAdvice)));
			}
		}
	}
}
