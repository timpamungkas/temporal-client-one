package id.co.myapp.temporalio.client.one.helloworld.activity;

import java.time.LocalDateTime;

public class ThankYouActivityImpl implements ThankYouActivity {

	@Override
	public String thankYou(String name) {
		return "Hi " + name + ", now is " + LocalDateTime.now();
	}

}