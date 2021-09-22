package id.co.myapp.temporalio.client.one.helloworld.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface FormatActivity {

	@ActivityMethod
	String composeGreeting(String name);

}